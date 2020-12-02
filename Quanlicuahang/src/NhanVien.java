/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class NhanVien {
    String MaNv;
    String TenNv;
    String GioiTinh;
    String NgaySinh;
    int DienThoai;
    float luong;

    public NhanVien() {
    }

    public NhanVien(String MaNv, String TenNv, String GioiTinh, String NgaySinh, int DienThoai, float luong) {
        this.MaNv = MaNv;
        this.TenNv = TenNv;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DienThoai = DienThoai;
        this.luong = luong;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public String getTenNv() {
        return TenNv;
    }

    public void setTenNv(String TenNv) {
        this.TenNv = TenNv;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(int DienThoai) {
        this.DienThoai = DienThoai;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
}
