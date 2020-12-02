
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
public class SanPhamModify {
       public static List<SanPham> ListallSanPham(){
        List<SanPham> ListSanPham = new ArrayList<>();
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "select * from NT_SanPham";
            statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                SanPham sp = new SanPham(resultset.getString("MaHang"),
                        resultset.getString("TenHang"),
                        resultset.getFloat("DonGia"),
                        resultset.getString("NoiSx"),
                        resultset.getString("NgaySx")
                );
                ListSanPham.add(sp);
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
        return ListSanPham;
    }
       
    public static void insertSanPham(SanPham sp){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = " call insert_sanpham(?,?,?,?,?)";
            statement = conn.prepareCall(sql);
           
            
            statement.setString(1,sp.getMaHang());
            statement.setString(2,sp.getTenHang());
            statement.setFloat(3,sp.getDonGia());
            statement.setString(4,sp.getNoiSx());
            statement.setString(5,sp.getNgaySx());
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
    public static void deleteSanPham(String MaHang){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "call delete_sanpham(?);";
            statement = conn.prepareCall(sql);
            
            
           
            statement.setString(1,MaHang);
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
