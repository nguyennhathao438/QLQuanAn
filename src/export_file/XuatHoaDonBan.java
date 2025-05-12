
package export_file;
import DAO.QuanHangDAO;
import DAO.UserDAO;
import DTO.CTHOADON;
import DTO.LICHSUBAN;
import DTO.MonAnBan;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class XuatHoaDonBan {

    QuanHangDAO qh = new QuanHangDAO();
    CTHOADON cthd = new CTHOADON();
    CTHOADON hdb = new CTHOADON();
    UserDAO userDao = new UserDAO();

    public void XuatPDFBan(String mahd) {
        cthd = qh.LayCTHDBH(mahd);
        hdb = qh.LayHD(mahd);

        try {
            File defaultDir = new File("C:\\pdf_HoaDonBan");
            if (!defaultDir.exists()) {
                defaultDir.mkdirs();
            }

            int nextNum = getNextPDFNumber(defaultDir);
            JFileChooser fileChooser = new JFileChooser(defaultDir);
            fileChooser.setDialogTitle("Chọn nơi lưu file PDF");
            fileChooser.setSelectedFile(new File("hoadonban_" + nextNum + ".pdf"));

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
            Paragraph title = new Paragraph("HÓA ĐƠN BÁN HÀNG", fontHeader);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(15);
            document.add(title);

            // Thông tin chung
            System.out.println("Mã USER xuất hóa đơn bán là : "+hdb.getTenUser());
            String nguoiTaoDon = userDao.getTenUserByID(hdb.getTenUser());
            String tenKH = qh.getTenKhachHangByMaKH(hdb.getMaKH());
            Paragraph thongtin = new Paragraph(String.format(
                    "Mã Hóa Đơn: %s\nKhách Hàng: %s\nNgười Tạo Đơn: %s\nThời gian: %s\n\n",
                    hdb.getMaHoaDon(), tenKH, nguoiTaoDon, hdb.getThoiGian()
            ), fontNormal);
            thongtin.setSpacingAfter(10);
            document.add(thongtin);

            // Bảng món ăn
            PdfPTable table = new PdfPTable(3);
            table.setWidths(new float[]{5f, 2f, 3f});
            table.setWidthPercentage(100);
            String[] headers = {"Tên món", "Số lượng", "Giá (VNĐ)"};
            for (String col : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(col, fontTitle));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            double tong = 0;
            for (MonAnBan a : cthd.getDsma()) {
                double gia = a.getGia();
                tong += gia;

                PdfPCell tenCell = new PdfPCell(new Phrase(a.getTenMA(), fontNormal));
                tenCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tenCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell slCell = new PdfPCell(new Phrase(String.valueOf(a.getSoluong()), fontNormal));
                slCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                slCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell giaCell = new PdfPCell(new Phrase(String.format("%,.0f", gia), fontNormal));
                giaCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                giaCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table.addCell(tenCell);
                table.addCell(slCell);
                table.addCell(giaCell);
            }

            document.add(table);

            // Tổng cộng
            Paragraph total = new Paragraph("\nTổng thành tiền: " + String.format("%,.0f", tong) + " VNĐ", fontTitle);
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);
            document.add(new Paragraph("\n\n\n", fontNormal));

            // Chữ ký
            PdfPTable tableKy = new PdfPTable(3);
            tableKy.setWidthPercentage(100f);
            String[] labels = {"Người lập hóa đơn", "Người giao", "Khách hàng"};
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
        File[] files = folder.listFiles((dir, name) -> name.matches("hoadonban_\\d+\\.pdf"));
        if (files != null) {
            for (File f : files) {
                Matcher matcher = Pattern.compile("hoadonban_(\\d+)\\.pdf").matcher(f.getName());
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
