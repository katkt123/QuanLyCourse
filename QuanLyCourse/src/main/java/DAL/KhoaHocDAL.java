/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.GiangVienDTO;
import DTO.KhoaHocDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class KhoaHocDAL {
    private KetNoiPHP conn; 
    
    public KhoaHocDAL(){
        conn = new KetNoiPHP();
    }
    public ArrayList<KhoaHocDTO> getListKH(){
        ArrayList<KhoaHocDTO> List = new ArrayList<>();
        ResultSet rs = null;
        String query = "Select CourseID,Title,Credits,DepartmentID From course";
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                List.add(new KhoaHocDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
    public void addCourse(KhoaHocDTO course) {
         String sql = "INSERT INTO Course VALUES (";
                sql += "'"+course.getCoureID()+"',";
                sql += "'"+course.getTitle()+"',";
                sql += "'"+course.getDepartmentID()+"',";
                sql += "'"+course.getCredits()+"')";
         System.out.println(sql);
        try {
            this.conn.getState().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setCourse(KhoaHocDTO course) {
        String sql = "UPDATE Course SET ";
        sql += "Title='"+course.getTitle()+"', ";
        sql += "DepartmentID="+course.getDepartmentID()+", ";
        sql += "Credits="+course.getCredits()+" ";
        sql += " WHERE CourseID="+course.getCoureID();
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
        String sql = "DELETE FROM `course` WHERE CourseID ="+id;
        try {
            this.conn.getState().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql);
        JOptionPane.showMessageDialog(null, "Xóa thành công!");
    }
    
    public int initID(){
        int id= 0;
        String query = "Select Count(*) From course";
        ResultSet rs = null;
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Init Sinh Vien :  "+e);
        }
        return id;
    }
}
