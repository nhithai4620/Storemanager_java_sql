
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class KhachHangModify {
    public static List<KhachHang> ListallKhachHang(){
        List<KhachHang> ListKhachHang = new ArrayList<>();
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "select * from NT_KhachHang";
            statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                KhachHang kh = new KhachHang(resultset.getString("MaKhachHang"),
                        resultset.getString("TenKhachHang"),
                        resultset.getString("NgaySinh"),
                        resultset.getString("DiaChi"),
                        resultset.getString("NgayGiaNhap"),
                        resultset.getInt("Diem")
                );
                ListKhachHang.add(kh);
            }
        }
        catch (Exception e){
            System.out.println("Cannot connect");
            e.printStackTrace();
        }
        finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ListKhachHang;
    }
    public static void insertKhachHang(KhachHang kh){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = " call insert_khachhang(?,?,?,?,?,?)";
            statement = conn.prepareCall(sql);
           
            
            statement.setString(1,kh.getMaKhachHang());
            statement.setString(2,kh.getTenKhachHang());
            statement.setString(3,kh.getNgaySinh());
            statement.setString(4,kh.getDiaChi());
            statement.setString(5,kh.getNgayGiaNhap());
            statement.setInt(6,kh.getDiem());
            statement.execute();
        }
        catch (Exception e){
            System.out.println("Cannot connect");
            e.printStackTrace();
        }
        finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void deleteKhachHang(String MaKhachHang){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "call delete_khachhang(?);";
            statement = conn.prepareCall(sql);
            
            
           
            statement.setString(1,MaKhachHang);
            statement.execute();
        }
        catch (Exception e){
            System.out.println("Cannot connect");
            e.printStackTrace();
        }
        finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
    }
}
