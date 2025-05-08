
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
    QuanKhoDAO kn=new QuanKhoDAO();
    CTHOADONNH cthd=new CTHOADONNH();
    public void XuatPDF(String mahd) {
        cthd = kn.chitietHDNH(mahd);
        try {
            // Tạo thư mục mặc định
            File defaultDir = new File(System.getProperty("user.home") + "\\pdfXuatHoaDon");
            if (!defaultDir.exists()) {
                defaultDir.mkdirs();
            }

            // Tự động tăng số thứ tự
            int nextNum = getNextPDFNumber(defaultDir);

            // Mở hộp thoại lưu file
            JFileChooser fileChooser = new JFileChooser(defaultDir);
            fileChooser.setDialogTitle("Chon noi luu file PDF");
            fileChooser.setSelectedFile(new File("pdfXuatHoaDon_" + nextNum + ".pdf"));

            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return; // Người dùng hủy
            }

            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }

            // Tạo tài liệu PDF
            DecimalFormat df = new DecimalFormat("#,###.##");
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("HOA DON NHAP HANG", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));

            document.add(new Paragraph("Ma hoa don : " + cthd.getMaHDNH()));
            document.add(new Paragraph("Nha cung cap : " + cthd.getTenNCC()));
            document.add(new Paragraph("Ngay nhap : " + cthd.getNgayNhap()));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            Font headerFont = new Font(Font.FontFamily.HELVETICA, 14);
            table.addCell(new PdfPCell(new Phrase("Ten Nguyen Lieu", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Han Su Dung", headerFont)));
            table.addCell(new PdfPCell(new Phrase("So Luong", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Don Gia", headerFont)));

            for (NLNhap a : cthd.getDsnlnhap()) {
                String gia = df.format(a.getGia());
                table.addCell(new PdfPCell(new Phrase(a.getMaNL())));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getHsd()))));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getSoLuong()))));
                table.addCell(new PdfPCell(new Phrase(gia)));
            }

            document.add(table);
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));

            String thanhtien = df.format(cthd.getThanhTien());
            document.add(new Paragraph("Thanh tien : " + thanhtien + "đ"));

            document.close();

            JOptionPane.showMessageDialog(null, "Xuat file PDF thanh cong!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Loi khi xuat PDF: " + e.getMessage());
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
