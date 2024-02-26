/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DepartmentDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DepartDAL {
    private KetNoiPHP conn; 
    
    public DepartDAL(){
        conn = new KetNoiPHP();
    }
    public ArrayList<DepartmentDTO> getListDP(){
        ArrayList<DepartmentDTO> List = new ArrayList<>();
        ResultSet rs = null;
        String query = "Select DepartmentID,Name,Budget,StartDate,Administrator From department";
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                List.add(new DepartmentDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
    public void addDepart(DepartmentDTO course) {
         String sql = "INSERT INTO Course VALUES (";
                sql += "'"+course.getDepartmentID()+"',";
                sql += "'"+course.getName()+"',";
                sql += "'"+course.getBudget()+"',";
                sql += "'"+course.getStartDate()+"')";
                sql += "'"+course.getAdministrator()+"')";
         System.out.println(sql);
        try {
            this.conn.getState().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DepartDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public DepartmentDTO getDepartmentByID(int departmentID) {
        DepartmentDTO department = null;
        String query = "SELECT Name, Budget, StartDate, Administrator FROM Department WHERE DepartmentID = ?";
        try {
            PreparedStatement statement = this.conn.getConn().prepareStatement(query);
            statement.setInt(1, departmentID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("Name");
                double budget = rs.getDouble("Budget");
                Date startDate = rs.getDate("StartDate");
                int administrator = rs.getInt("Administrator");

                // Tạo đối tượng DepartmentDTO từ thông tin lấy được
                department = new DepartmentDTO(departmentID, name, budget, startDate, administrator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }
}
