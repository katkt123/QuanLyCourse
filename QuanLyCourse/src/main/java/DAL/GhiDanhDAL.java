/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.KhoaHocDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class GhiDanhDAL {
    private KetNoiPHP conn; 
    
    public GhiDanhDAL(){
        conn = new KetNoiPHP();
    }
    public boolean GhiDanh(int CourseID, int StudentID){
        String sql = "INSERT INTO studentgrade (CourseID,StudentID,Grade) VALUES (?,?,null);";
        try {
            PreparedStatement ps = conn.getConn().prepareCall(sql);
            ps.setInt(1, CourseID);
            ps.setInt(2, StudentID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        GhiDanhDAL aL = new GhiDanhDAL();
        System.out.println(aL.GhiDanh(1045, 2));
    }
    public ArrayList<Object[]> getStudentGradesByCourseID(int courseID) {
        ArrayList<Object[]> list = new ArrayList<>();
        ResultSet rs = null;
        String query = "SELECT sg.CourseID, sg.StudentID, p.LastName, p.FirstName, sg.Grade FROM studentgrade sg INNER JOIN person p ON sg.StudentID = p.PersonID WHERE sg.CourseID = " + courseID;
        try {
            rs = this.conn.getState().executeQuery(query);
            while (rs.next()) {
                int courseId = rs.getInt("CourseID");
                int studentID = rs.getInt("StudentID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                Double grade = rs.getDouble("Grade");

                if (rs.wasNull()) {
                    Object[] row = {courseId, studentID, lastName, firstName, null};
                    list.add(row);
                } else {
                    Object[] row = {courseId, studentID, lastName, firstName, grade};
                    list.add(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateGrade(int courseID, int studentID, double newGrade) {
        String sql = "UPDATE studentgrade SET Grade = ? WHERE CourseID = ? AND StudentID = ?";
        try {
            PreparedStatement ps = conn.getConn().prepareStatement(sql);
            ps.setDouble(1, newGrade);
            ps.setInt(2, courseID);
            ps.setInt(3, studentID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
    
}
