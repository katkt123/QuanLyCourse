/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.PhanCongDTO;
import DTO.PhanCongDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PhanCongDAL {
    
    private KetNoiPHP conn; 
    
    public PhanCongDAL(){
        conn = new KetNoiPHP();
    }
    
    
    public ArrayList<PhanCongDTO> getListPC(){
        ArrayList<PhanCongDTO> List = new ArrayList<>();
        ResultSet rs = null;
        String query = "Select CourseID,PersonID From courseinstructor";
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                List.add(new PhanCongDTO(rs.getInt(1), rs.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
    
    public ArrayList<PhanCongDTO> getListHienThi(){
        ArrayList<PhanCongDTO> List = new ArrayList<>();
        ResultSet rs = null;
        String query = "SELECT course.CourseID, Title, person.PersonID, CONCAT_WS(\"  \",person.Lastname,person.Firstname) AS 'Name'\n" +
        "FROM course\n" +
        "LEFT JOIN courseinstructor\n" +
        "ON course.CourseID = courseinstructor.CourseID\n" +
        "LEFT JOIN person\n" +
        "ON courseinstructor.PersonID = person.PersonID";
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                List.add(new PhanCongDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
    
    public boolean PhanCongGV(PhanCongDTO gv){
        
        return false;
    }
    
    public boolean ThemPhanCong(int CourseID, int PersonID){
        String sql = "INSERT INTO courseinstructor (CourseID, PersonID) VALUES (?, ?);";
        try {
            PreparedStatement ps = conn.getConn().prepareCall(sql);
            ps.setInt(1, CourseID);
            ps.setInt(2, PersonID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean SuaPhanCong(int CourseID, int PersonID){
        String sql = "UPDATE courseinstructor SET PersonID = ? WHERE CourseID = ?;";
        try {
            PreparedStatement ps = conn.getConn().prepareCall(sql);
            ps.setInt(1, CourseID);
            ps.setInt(2, PersonID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    public boolean XoaPhanCong(int CourseID, int PersonID){
        String sql = "DELETE FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";
        try {
            PreparedStatement ps = conn.getConn().prepareCall(sql);
            ps.setInt(1, CourseID);
            ps.setInt(2, PersonID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
            
            
}
