/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.KhoaHocDTO;
import DTO.KhoaHocOnSiteDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class OnsiteDAL {
     private KetNoiPHP conn; 
    
    public OnsiteDAL(){
        conn = new KetNoiPHP();
    }
    public ArrayList<KhoaHocOnSiteDTO> getListKHos(){
        ArrayList<KhoaHocOnSiteDTO> List = new ArrayList<>();
        ResultSet rs = null;
        String query = "Select CourseID,Location,Days,Time From onsitecourse";
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                List.add(new KhoaHocOnSiteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTime(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
    
    public void addKHos(KhoaHocOnSiteDTO course) {
         String sql = "INSERT INTO onsitecourse VALUES (";
                sql += "'"+course.getCourseID()+"',";
                sql += "'"+course.getLocation()+"',";
                sql += "'"+course.getDays()+"',";
                sql += "'"+course.getTime()+"')";
         System.out.println(sql);
        try {
            this.conn.getState().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void setKHos(KhoaHocOnSiteDTO course) {
        String sql = "UPDATE onsitecourse SET ";
        sql += "Location='"+course.getLocation()+"', ";
        sql += "Days="+course.getDays()+", ";
        sql += "Time="+course.getTime()+" ";
        sql += " WHERE CourseID="+course.getCourseID();
        System.out.println(sql);
        try {
            this.conn.getState().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Sửa thành công!");
    }
     
    public void delete(String id)
    {
        String sql = "DELETE FROM `onsitecourse` WHERE CourseID ="+id;
        try {
            this.conn.getState().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql);
        JOptionPane.showMessageDialog(null, "Xóa thành công!");
    } 
    public boolean isCourseIDExists(int courseID) {
        
        String query = "SELECT COUNT(*) FROM onsitecourse WHERE CourseID = ?";
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
    public KhoaHocOnSiteDTO getOnSiteCourseByID(int courseID) {
        KhoaHocOnSiteDTO course = null;
        String query = "SELECT Location, Days, Time FROM onsitecourse WHERE CourseID = ?";
        try {
            PreparedStatement statement = this.conn.getConn().prepareStatement(query);
            statement.setInt(1, courseID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String location = rs.getString("Location");
                String days = rs.getString("Days");
                Time time = rs.getTime("Time");

                // Tạo đối tượng KhoaHocOnSiteDTO từ thông tin lấy được
                course = new KhoaHocOnSiteDTO(courseID, location, days, time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
}
