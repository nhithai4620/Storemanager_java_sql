
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

public class NhanVienModify {
     public static List<NhanVien> ListallNhanVien(){
        List<NhanVien> ListNhanVien = new ArrayList<>();
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        Statement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "select * from NT_NhanVien";
            statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                NhanVien nv = new NhanVien(resultset.getString("MaNv"),
                        resultset.getString("TenNv"),
                        resultset.getString("GioiTinh"),
                        resultset.getString("NgaySinh"),
                        resultset.getInt("DienThoai"),
                        resultset.getFloat("Luong")
                );
                ListNhanVien.add(nv);
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
        return ListNhanVien;
    }
     public static void insertNhanVien(NhanVien nv){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = " call insert_nhanvien(?,?,?,?,?,?)";
            statement = conn.prepareCall(sql);
           
            
            statement.setString(1,nv.getMaNv());
            statement.setString(2,nv.getTenNv());
            statement.setString(3,nv.getGioiTinh());
            statement.setString(4,nv.getNgaySinh());
            statement.setInt(5,nv.getDienThoai());
            statement.setFloat(6,nv.getLuong());
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
