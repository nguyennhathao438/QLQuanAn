
package export_file;
import DTO.NLNhap;
import DAO.QuanKhoDAO;
import DTO.CTHOADONNH;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
public class XuatPhieuNhap {
    QuanKhoDAO kn=new QuanKhoDAO();
    CTHOADONNH cthd=new CTHOADONNH();
    public void XuatPDF(String mahd){ 
        cthd=kn.chitietHDNH(mahd);
        try{
            String path="C:\\Users\\ADMIN\\Documents\\oop\\QLQuanAn\\exportfile\\phieunhap.pdf";
            DecimalFormat df = new DecimalFormat("#,###.##");
            Document document =new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            
             Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("HOA DON NHAP HANG", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
            
            document.add(new Paragraph("Ma Hoa Don : "+cthd.getMaHDNH()));
            document.add(new Paragraph("Nha Cung Cap : "+cthd.getTenNCC()));
            document.add(new Paragraph("Ngay Nhap : "+cthd.getNgayNhap()));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
            
             PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            titleFont = new Font(Font.FontFamily.HELVETICA, 14);
            table.addCell(new PdfPCell(new Phrase("Ten Nguyen Lieu", titleFont)));
            table.addCell(new PdfPCell(new Phrase("Han Su Dung ", titleFont)));
            table.addCell(new PdfPCell(new Phrase("So Luong", titleFont)));
            table.addCell(new PdfPCell(new Phrase("Don Gia", titleFont)));
            
            for (NLNhap a:cthd.getDsnlnhap()) {
                String gia =df.format(a.getGia());
                table.addCell(new PdfPCell(new Phrase(a.getMaNL())));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getHsd()))));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(a.getSoLuong()))));
                table.addCell(new PdfPCell(new Phrase(gia)));
            }
            document.add(table);
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
            String thanhtien = df.format(cthd.getThanhTien());
            document.add(new Paragraph("Thanh Tien:"+thanhtien+"đ"));
            document.close();
        }
        catch(Exception e){ 
            e.printStackTrace();
        }
    }
}
