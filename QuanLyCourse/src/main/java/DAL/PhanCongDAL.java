/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.HienThiPhanCongDTO;
import DTO.PhanCongDTO;
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
    
    public ArrayList<HienThiPhanCongDTO> getListHienThi(){
        ArrayList<HienThiPhanCongDTO> List = new ArrayList<>();
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
                List.add(new HienThiPhanCongDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
    
    public boolean PhanCongGV(PhanCongDTO gv){
        
        return false;
    }
            
            
}
