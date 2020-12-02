/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class HoaDon {
    String SoHoaDon;
    String MaNv;
    String ThoiGian;
    float GiaTri;
    String MaKhachHang;

    public HoaDon() {
    }

    public HoaDon(String SoHoaDon, String MaNv, String ThoiGian, float GiaTri, String MaKhachHang) {
        this.SoHoaDon = SoHoaDon;
        this.MaNv = MaNv;
        this.ThoiGian = ThoiGian;
        this.GiaTri = GiaTri;
        this.MaKhachHang = MaKhachHang;
    }

    public String getSoHoaDon() {
        return SoHoaDon;
    }

    public void setSoHoaDon(String SoHoaDon) {
        this.SoHoaDon = SoHoaDon;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public float getGiaTri() {
        return GiaTri;
    }

    public void setGiaTri(float GiaTri) {
        this.GiaTri = GiaTri;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }
    
    
    
    
}
