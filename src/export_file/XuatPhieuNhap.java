
package export_file;
import DTO.NLNhap;
import DAO.QuanKhoDAO;
import DTO.CTHOADONNH;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class XuatPhieuNhap {
    QuanKhoDAO kn = new QuanKhoDAO();
    CTHOADONNH cthd = new CTHOADONNH();
    public void XuatPDF(String mahd) {
        cthd = kn.chitietHDNH(mahd);
        try {
            File defaultDir = new File("C:\\pdf_HoaDonNhap");
            if (!defaultDir.exists()) {
                defaultDir.mkdirs();
            }
            int nextNum = getNextPDFNumber(defaultDir);
            JFileChooser fileChooser = new JFileChooser(defaultDir);
            fileChooser.setDialogTitle("Chọn nơi lưu file PDF");
            fileChooser.setSelectedFile(new File("hoadonnhap_" + nextNum + ".pdf"));
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            BaseFont bf = BaseFont.createFont("resources/fonts/times.ttf", BaseFont.IDENTITY_H, true);
            Font fontHeader = new Font(bf, 25, Font.BOLD);
            Font fontTitle = new Font(bf, 14, Font.BOLD);
            Font fontNormal = new Font(bf, 12);
            Font fontBoldItalic = new Font(bf, 12, Font.BOLDITALIC);
            // Header
            PdfPTable titleRow = new PdfPTable(2);
            titleRow.setWidthPercentage(100);
            titleRow.setWidths(new float[]{6f, 4f});
            PdfPCell leftTitle = new PdfPCell(new Phrase("HỆ THỐNG QUẢN LÝ QUÁN ĂN NHÓM 15", fontTitle));
            leftTitle.setBorder(Rectangle.NO_BORDER);
            leftTitle.setHorizontalAlignment(Element.ALIGN_LEFT);
            String tgHienTai = java.time.LocalDateTime.now()
                    .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            PdfPCell rightTime = new PdfPCell(new Phrase("Thời gian in hóa đơn: " + tgHienTai, fontNormal));
            rightTime.setBorder(Rectangle.NO_BORDER);
            rightTime.setHorizontalAlignment(Element.ALIGN_RIGHT);
            titleRow.addCell(leftTitle);
            titleRow.addCell(rightTime);
            document.add(titleRow);
            document.add(new Paragraph("\n", fontNormal));
            // Tiêu đề
            Paragraph title = new Paragraph("HÓA ĐƠN NHẬP HÀNG", fontHeader);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(15);
            document.add(title);
            // Thông tin chung
            Paragraph thongtin = new Paragraph(String.format(
                    "Mã Hóa Đơn: %s\nNhà Cung Cấp: %s\nNgày Nhập: %s\n\n",
                    cthd.getMaHDNH(), cthd.getTenNCC(), cthd.getNgayNhap()
            ), fontNormal);
            thongtin.setSpacingAfter(10);
            document.add(thongtin);
            // Bảng nguyên liệu
            PdfPTable table = new PdfPTable(4);
            table.setWidths(new float[]{4f, 3f, 2f, 3f});
            table.setWidthPercentage(100);
            String[] headers = {"Nguyên Liệu", "Hạn Sử Dụng", "Số Lượng", "Đơn Giá (VNĐ)"};
            for (String col : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(col, fontTitle));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
            double tong = 0;
            DecimalFormat df = new DecimalFormat("#,###");

            for (NLNhap a : cthd.getDsnlnhap()) {
                double gia = a.getGia();
                tong += gia;

                table.addCell(new PdfPCell(new Phrase(a.getMaNL(), fontNormal)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getHsd()), fontNormal)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getSoLuong()), fontNormal)));
                table.addCell(new PdfPCell(new Phrase(df.format(gia), fontNormal)));
            }

            document.add(table);

            // Tổng cộng
            Paragraph total = new Paragraph("\nTổng thành tiền: " + df.format(tong) + " VNĐ", fontTitle);
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);
            document.add(new Paragraph("\n\n\n", fontNormal));

            // Chữ ký
            PdfPTable tableKy = new PdfPTable(3);
            tableKy.setWidthPercentage(100f);
            String[] labels = {"Người lập phiếu", "Người giao", "Nhà cung cấp"};
            String[] subs = {"(Ký và ghi rõ họ tên)", "(Ký và ghi rõ họ tên)", "(Ký và ghi rõ họ tên)"};

            for (String label : labels) {
                PdfPCell cell = new PdfPCell(new Phrase(label, fontBoldItalic));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tableKy.addCell(cell);
            }
            for (String sub : subs) {
                PdfPCell cell = new PdfPCell(new Phrase(sub, fontNormal));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tableKy.addCell(cell);
            }

            document.add(tableKy);
            document.close();

            JOptionPane.showMessageDialog(null, "Xuất file PDF thành công!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xuất PDF: " + e.getMessage());
        }
    }

    private int getNextPDFNumber(File folder) {
        int max = 0;
        File[] files = folder.listFiles((dir, name) -> name.matches("phieuxuat_\\d+\\.pdf"));
        if (files != null) {
            for (File f : files) {
                Matcher matcher = Pattern.compile("phieuxuat_(\\d+)\\.pdf").matcher(f.getName());
                if (matcher.matches()) {
                    try {
                        int num = Integer.parseInt(matcher.group(1));
                        if (num > max) {
                            max = num;
                        }
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }
        return max + 1;
    }
}
