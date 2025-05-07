
package export_file;
import DAO.QuanHangDAO;
import DTO.CTHOADON;
import DTO.LICHSUBAN;
import DTO.MonAnBan;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class XuatHoaDonBan {
    QuanHangDAO qh=new QuanHangDAO();
    CTHOADON cthd=new CTHOADON();
    CTHOADON hdb = new CTHOADON();
    LICHSUBAN lsb = new LICHSUBAN();
    public void XuatPDFBan(String mahd){ 
        cthd=qh.LayCTHDBH(mahd);
        hdb = qh.LayHD(mahd);
        try{
            String path="\"C:\\Users\\kiman\\OneDrive\\Máy tính\\defgiaodien\\QLQuanAn\\exportfile\\hoadon.pdf\"";
            DecimalFormat df = new DecimalFormat("#,###.##");
            Document document =new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            
             Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("HOA DON BAN HANG", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
            
            document.add(new Paragraph("Ma Hoa Don : "+hdb.getMaHoaDon()));
            document.add(new Paragraph("Khach Hang : "+hdb.getMaKH()));
            document.add(new Paragraph("Ngay Nhap : "+hdb.getThoiGian()));
//            document.add(new Paragraph("Tổng Tiền : "+cthd.getThanhTien()));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
            
             PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            titleFont = new Font(Font.FontFamily.HELVETICA, 14);
            table.addCell(new PdfPCell(new Phrase("Ten mon : ", titleFont)));
            table.addCell(new PdfPCell(new Phrase("So Luong : ", titleFont)));
            table.addCell(new PdfPCell(new Phrase("Gia : ", titleFont)));
            
            for (MonAnBan a:cthd.getDsma()) {
//                String gia =df.format(a.getGia());
                table.addCell(new PdfPCell(new Phrase(a.getTenMA())));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getSoluong()))));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getGia()))));
            }
            document.add(table);
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
            String tongtien = df.format(hdb.getThanhTien());
            document.add(new Paragraph("Tong Tien :"+tongtien+"đ"));
            document.close();
        }
        catch(Exception e){ 
            e.printStackTrace();
        }
    }
}
