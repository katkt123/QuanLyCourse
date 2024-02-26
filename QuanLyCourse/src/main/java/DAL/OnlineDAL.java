/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.KhoaHocOnSiteDTO;
import DTO.KhoaHocOnlineDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class OnlineDAL {
     private KetNoiPHP conn; 
    
    public OnlineDAL(){
        conn = new KetNoiPHP();
    }
    public ArrayList<KhoaHocOnlineDTO> getListKHol(){
        ArrayList<KhoaHocOnlineDTO> List = new ArrayList<>();
        ResultSet rs = null;
        String query = "Select CourseID,url From onlinecourse";
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                List.add(new KhoaHocOnlineDTO(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
    
     public void addKHol(KhoaHocOnlineDTO course) {
         String sql = "INSERT INTO onlinecourse VALUES (";
                sql += " '"+course.getCourseID()+"',";
                sql += " '"+course.getURL()+"')";
         System.out.println(sql);
        try {
            this.conn.getState().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OnlineDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void setKHol(KhoaHocOnlineDTO course) {
        String sql = "UPDATE onlinecourse SET ";
        sql += "url='"+course.getURL()+"', ";
        sql += " WHERE CourseID="+course.getCourseID();
        System.out.println(sql);
        try {
            this.conn.getState().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Sửa thành công!");
    }
     
     public void deleteKHol(String id)
    {
        String sql = "DELETE FROM `onlinecourse` WHERE CourseID ="+id;
        try {
            this.conn.getState().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql);
        JOptionPane.showMessageDialog(null, "Xóa thành công!");
    } 
     
    public boolean isCourseIDExists(int courseID) {
        
        String query = "SELECT COUNT(*) FROM onlinecourse WHERE CourseID = ?";
        try {
            PreparedStatement statement = this.conn.getConn().prepareStatement(query);
            statement.setInt(1, courseID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
