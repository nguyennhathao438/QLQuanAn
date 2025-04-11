    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package DTO;

    import java.util.Date;

    /**
     *
     * @author kiman
     */
    public class ChamCongDTO {
        private int maBCC;
        private int maNV;
        private int thangChamCong;
        private int namChamCong;
        private int soNgayLamViec;
        private int soNgayNghi;
        private int soNgayTre;
        private int soGioLamThem;
        private String chiTiet;
        private String trangThai;

        // Constructor không tham số
        public ChamCongDTO() {}

        // Constructor đầy đủ (trừ các thuộc tính đã loại bỏ)
        public ChamCongDTO(int maBCC, int maNV, int thangChamCong, int namChamCong, int soNgayLamViec,
                           int soNgayNghi, int soNgayTre, int soGioLamThem, String chiTiet, String trangThai) {
            this.maBCC = maBCC;
            this.maNV = maNV;
            this.thangChamCong = thangChamCong;
            this.namChamCong = namChamCong;
            this.soNgayLamViec = soNgayLamViec;
            this.soNgayNghi = soNgayNghi;
            this.soNgayTre = soNgayTre;
            this.soGioLamThem = soGioLamThem;
            this.chiTiet = chiTiet;
            this.trangThai = trangThai;
        }
        public ChamCongDTO( int maNV, int thangChamCong, int namChamCong, int soNgayLamViec,
                           int soNgayNghi, int soNgayTre, int soGioLamThem, String chiTiet, String trangThai) {
            this.maNV = maNV;
            this.thangChamCong = thangChamCong;
            this.namChamCong = namChamCong;
            this.soNgayLamViec = soNgayLamViec;
            this.soNgayNghi = soNgayNghi;
            this.soNgayTre = soNgayTre;
            this.soGioLamThem = soGioLamThem;
            this.chiTiet = chiTiet;
            this.trangThai = trangThai;
        }
        public ChamCongDTO(int maNV, int thangChamCong, int namChamCong) {
            this.maNV = maNV;
            this.thangChamCong = thangChamCong;
            this.namChamCong=namChamCong;
        }
        // Getters và Setters
        public int getMaBCC() {
            return maBCC;
        }

        public void setMaBCC(int maBCC) {
            this.maBCC = maBCC;
        }

        public int getMaNV() {
            return maNV;
        }

        public void setMaNV(int maNV) {
            this.maNV = maNV;
        }

        public int getThangChamCong() {
            return thangChamCong;
        }

        public void setThangChamCong(int thangChamCong) {
            this.thangChamCong = thangChamCong;
        }

        public int getNamChamCong() {
            return namChamCong;
        }

        public void setNamChamCong(int namChamCong) {
            this.namChamCong = namChamCong;
        }

        public int getSoNgayLamViec() {
            return soNgayLamViec;
        }

        public void setSoNgayLamViec(int soNgayLamViec) {
            this.soNgayLamViec = soNgayLamViec;
        }

        public int getSoNgayNghi() {
            return soNgayNghi;
        }

        public void setSoNgayNghi(int soNgayNghi) {
            this.soNgayNghi = soNgayNghi;
        }

        public int getSoNgayTre() {
            return soNgayTre;
        }

        public void setSoNgayTre(int soNgayTre) {
            this.soNgayTre = soNgayTre;
        }

        public int getSoGioLamThem() {
            return soGioLamThem;
        }

        public void setSoGioLamThem(int soGioLamThem) {
            this.soGioLamThem = soGioLamThem;
        }

        public String getChiTiet() {
            return chiTiet;
        }

        public void setChiTiet(String chiTiet) {
            this.chiTiet = chiTiet;
        }

        public String getTrangThai() {
            return trangThai;
        }

        public void setTrangThai(String trangThai) {
            this.trangThai = trangThai;
        }
    }
