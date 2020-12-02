
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
public class ChiTietHoaDonModify {
    public static List<ChiTietHoaDon> ListallChiTietHoaDon(){
        List<ChiTietHoaDon> ListChiTietHoaDon = new ArrayList<>();
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "select * from NT_ChiTietHoaDon";
            statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                ChiTietHoaDon cthd = new ChiTietHoaDon(resultset.getString("SoHoaDon"),
                        resultset.getString("MaHang"),
                        resultset.getInt("SoLuong")
                        
                );
                ListChiTietHoaDon.add(cthd);
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
        return ListChiTietHoaDon;
    }
    public static void insertChiTietHoaDon(ChiTietHoaDon cthd){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = " call insert_chitiethoadon(?,?,?)";
            statement = conn.prepareCall(sql);
           
            
            statement.setString(1,cthd.getSoHoaDon());
            statement.setString(2,cthd.getMaHang());
            statement.setInt(3,cthd.getSoLuong());
            
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
    public static void deleteChiTietHoaDon(String Sohoadon,String MaHang){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "call delete_chitiethoadon(?,?);";
            statement = conn.prepareCall(sql);
            
            
            statement.setString(1,Sohoadon);
            statement.setString(2,MaHang);
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
