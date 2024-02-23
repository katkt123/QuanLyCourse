/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;

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
}
