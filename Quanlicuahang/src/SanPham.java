/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class SanPham {


    String MaHang;
    String TenHang;
    Float DonGia;
    String NoiSx;
    String NgaySx;
    public SanPham() {
    }

    public SanPham(String MaHang, String TenHang, Float DonGia, String NoiSx, String NgaySx) {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
        this.DonGia = DonGia;
        this.NoiSx = NoiSx;
        this.NgaySx = NgaySx;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public Float getDonGia() {
        return DonGia;
    }

    public void setDonGia(Float DonGia) {
        this.DonGia = DonGia;
    }

    public String getNoiSx() {
        return NoiSx;
    }

    public void setNoiSx(String NoiSx) {
        this.NoiSx = NoiSx;
    }

    public String getNgaySx() {
        return NgaySx;
    }

    public void setNgaySx(String NgaySx) {
        this.NgaySx = NgaySx;
    }
    
    
}
