
package export_file;
import DAO.QuanHangDAO;
import DTO.CTHOADON;
import DTO.LICHSUBAN;
import DTO.MonAnBan;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
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
    LICHSUBAN lsb = new LICHSUBAN();

    public void XuatPDFBan(String mahd) {
        cthd = qh.LayCTHDBH(mahd);
        hdb = qh.LayHD(mahd);
        try {
            // Tạo thư mục mặc định
            File defaultDir = new File(System.getProperty("user.home") + "\\pdfXuatHoaDonBan");
            if (!defaultDir.exists()) {
                defaultDir.mkdirs();
            }

            // Tự động tăng số thứ tự
            int nextNum = getNextPDFNumber(defaultDir);

            // Mở hộp thoại lưu file
            JFileChooser fileChooser = new JFileChooser(defaultDir);
            fileChooser.setDialogTitle("Chon noi luu file PDF");
            fileChooser.setSelectedFile(new File("hoadonban_" + nextNum + ".pdf"));

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
            Paragraph title = new Paragraph("HOA DON BAN HANG", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));

            document.add(new Paragraph("Ma Hoa Don : " + hdb.getMaHoaDon()));
            document.add(new Paragraph("Khach Hang : " + hdb.getMaKH()));
            document.add(new Paragraph("Ngay Nhap : " + hdb.getThoiGian()));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            Font titleFontCell = new Font(Font.FontFamily.HELVETICA, 14);
            table.addCell(new PdfPCell(new Phrase("Ten mon : ", titleFontCell)));
            table.addCell(new PdfPCell(new Phrase("So Luong : ", titleFontCell)));
            table.addCell(new PdfPCell(new Phrase("Gia : ", titleFontCell)));

            for (MonAnBan a : cthd.getDsma()) {
                table.addCell(new PdfPCell(new Phrase(a.getTenMA())));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getSoluong()))));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getGia()))));
            }

            document.add(table);
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
            String tongtien = df.format(hdb.getThanhTien());
            document.add(new Paragraph("Tong Tien : " + tongtien + "đ"));

            document.close();

            JOptionPane.showMessageDialog(null, "Xuat file PDF thanh cong!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Loi khi xuat PDF: " + e.getMessage());
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
