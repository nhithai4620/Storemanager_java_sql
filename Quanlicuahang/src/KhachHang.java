/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class KhachHang {
    String MaKhachHang;
    String TenKhachHang;
    String NgaySinh;
    String DiaChi;
    String NgayGiaNhap;
    int Diem;

    public KhachHang() {
    }

    public KhachHang(String MaKhachHang, String TenKhachHang, String NgaySinh, String DiaChi, String NgayGiaNhap, int Diem) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.NgayGiaNhap = NgayGiaNhap;
        this.Diem = Diem;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getNgayGiaNhap() {
        return NgayGiaNhap;
    }

    public void setNgayGiaNhap(String NgayGiaNhap) {
        this.NgayGiaNhap = NgayGiaNhap;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int Diem) {
        this.Diem = Diem;
    }
    
    
}
