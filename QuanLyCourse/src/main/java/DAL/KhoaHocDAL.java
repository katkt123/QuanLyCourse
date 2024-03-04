/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.GiangVienDTO;
import DTO.KhoaHocDTO;
import java.sql.PreparedStatement;
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
    public String getDepartment(int did){
        String s = "";
        ResultSet rs = null;
        String query="Select Name From department where DepartmentID = "+did   ;
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                s = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Get Department :  "+e);
        }
        
        return s;
    }
    public void addCourse(KhoaHocDTO course) {
         String sql = "INSERT INTO Course VALUES (";
                sql += "'"+course.getCoureID()+"',";
                sql += "'"+course.getTitle()+"',";
                sql += "'"+course.getCredits()+"',";
                sql += "'"+course.getDepartmentID()+"')";
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
        
    }
    public KhoaHocDTO getCourseByID(int courseID) {
    KhoaHocDTO course = null;
    String query = "SELECT Title, DepartmentID, Credits FROM Course WHERE CourseID = ?";
    try {
        PreparedStatement statement = this.conn.getConn().prepareStatement(query);
        statement.setInt(1, courseID);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            String title = rs.getString("Title");
            int departmentID = rs.getInt("DepartmentID");
            int credits = rs.getInt("Credits");
            
            course = new KhoaHocDTO(courseID, title, credits, departmentID);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return course;
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
            System.out.println("Init Khoa  hoc:  "+e);
        }
        return id;
    }
    
    public ArrayList<KhoaHocDTO> search(String s) {
        ArrayList<KhoaHocDTO> List = new ArrayList<>();
        ResultSet rs = null;

        try {
            String query = "SELECT CourseID,Title,Credits,DepartmentID FROM course WHERE CourseID LIKE N'%" + s + "%' OR Title LIKE N'%" + s + "%' OR Credits LIKE '%"+ s +"%' OR DepartmentID LIKE '%" + s + "%';";
            rs = this.conn.getState().executeQuery(query);

            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng SinhVienDTO
                
                if(rs.getString(4) != null){
                    List.add(new KhoaHocDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý exception nếu có
        }

        return List;
    }

    public String getTeacherCourse(int cid){
        String s = "";
        int pid = 0;
        ResultSet rs = null;
        ResultSet rs1 = null;
        String query="Select PersonID From courseinstructor where CourseID = "+cid   ;
        
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                pid = rs.getInt(1);
                String query1="Select Lastname,Firstname From person where PersonID = "+pid   ;
                rs1 = this.conn.getState().executeQuery(query1);
                while(rs1.next()){
                    String ln = rs1.getString(1);
                    String fn = rs1.getString(2);
                    s = ln +" "+ fn;
                }
                
            }
        } catch (Exception e) {
            System.out.println("Get Teacher :  "+e);
        }
        
        return s;

    }
    public ArrayList<KhoaHocDTO> GetListGhiDanh(int PersonID) {
        ArrayList<KhoaHocDTO> List = new ArrayList<>();
        ResultSet rs = null;

        try {
            String query = "SELECT * \n" +
            "FROM course\n" +
            "WHERE course.CourseID NOT IN (\n" +
            "SELECT studentgrade.CourseID\n" +
            "FROM person\n" +
            "JOIN studentgrade ON studentgrade.StudentID = person.PersonID\n" +
            "WHERE person.PersonID = "+PersonID+")";
            rs = this.conn.getState().executeQuery(query);

            while (rs.next()) {

                if(rs.getString(4) != null){
                    List.add(new KhoaHocDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý exception nếu có
        }

        return List;

    }
}
