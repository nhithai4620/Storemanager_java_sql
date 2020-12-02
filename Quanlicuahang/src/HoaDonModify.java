
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class HoaDonModify {
    public static List<HoaDon> ListallHoaDon(){
        List<HoaDon> ListHoaDon = new ArrayList<>();
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "select * from NT_HoaDon";
            statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                HoaDon hd = new HoaDon(resultset.getString("SoHoaDon"),
                        resultset.getString("MaNv"),
                        resultset.getString("ThoiGian"),
                        resultset.getFloat("GiaTri"),
                        resultset.getString("MaKhachHang")
                );
                ListHoaDon.add(hd);
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
        return ListHoaDon;
    }
    
    public static void insertHoaDon(HoaDon hd){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = " call insert_hoadon(?,?,?,?,?)";
            statement = conn.prepareCall(sql);
           
            
            statement.setString(1,hd.getSoHoaDon());
            statement.setString(2,hd.getMaNv());
            statement.setString(3,hd.getThoiGian());
            statement.setFloat(4,hd.getGiaTri());
            statement.setString(5,hd.getMaKhachHang());
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
    
    public static void updateHoaDon(HoaDon hd){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "update NT_HoaDon set MaNv=?,ThoiGian=?,GiaTri=?,MaKhachHang=? where SoHoaDon=?";
            statement = conn.prepareCall(sql);
            ResultSet resultset = statement.executeQuery(sql);
            
            
            statement.setString(1,hd.getMaNv());
            statement.setString(2,hd.getThoiGian());
            statement.setFloat(3,hd.getGiaTri());
            statement.setString(4,hd.getMaKhachHang());
            statement.setString(5,hd.getSoHoaDon());
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
    public static void deleteHoaDon(String Sohoadon){
        Connection conn = null;
        String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
        String user = "root";
        String password = "nhithai4620";
        PreparedStatement statement = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connStr,user,password);
            System.out.println("Connect succes");
            
            String sql = "call delete_hoadon(?);";
            statement = conn.prepareCall(sql);
            
            
            statement.setString(1,Sohoadon);
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
