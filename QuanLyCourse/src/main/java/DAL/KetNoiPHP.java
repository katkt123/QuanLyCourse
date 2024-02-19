/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS*/
public class KetNoiPHP {
    private Connection conn;
    private Statement state;
    
    private String port;
    private String database;
    private String root;
    private String pass;
    
    public KetNoiPHP() { 
        port = "3306";
        database = "school";
        root = "root";
        pass = "";
        connectPHP();
    }
    
    public void connectPHP()
    {
               
        String dbPath = "jdbc:mysql://localhost:"+port+"/"+database;
        System.out.print(dbPath);
	
        try {
            conn = (Connection) DriverManager.getConnection(dbPath,root,pass);
            state = conn.createStatement();
//            System.out.print("Kết nối PHP thành công !!!!!!!!!!!");
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }
    }
    
//    public void disconnectPHP() {
//        try {
//            if (conn != null && !conn.isClosed()) {
//                conn.close();
//                System.out.println("Đã đóng kết nối!");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    //--------------------------------------------------------------------------//
//    public static void main(String[] args){
//       KetNoiPHP a = new KetNoiPHP();
//       a.connectPHP();
//       
//       a.disconnectPHP();
//    }

    public Connection getConn() {
        return conn;
    }

    public Statement getState() {
        return state;
    }
    
}
