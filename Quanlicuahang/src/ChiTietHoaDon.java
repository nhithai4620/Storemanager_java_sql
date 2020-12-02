/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class ChiTietHoaDon {
    String SoHoaDon;
    String MaHang;
    int SoLuong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String SoHoaDon, String MaHang, int SoLuong) {
        this.SoHoaDon = SoHoaDon;
        this.MaHang = MaHang;
        this.SoLuong = SoLuong;
    }

    public String getSoHoaDon() {
        return SoHoaDon;
    }

    public void setSoHoaDon(String SoHoaDon) {
        this.SoHoaDon = SoHoaDon;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}
