/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.GiangVienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class GiangVienDAL {
    private KetNoiPHP conn; 
    
    public GiangVienDAL(){
        conn = new KetNoiPHP();
    }
    public ArrayList<GiangVienDTO> getListSV(){
        ArrayList<GiangVienDTO> List = new ArrayList<>();
        ResultSet rs = null;
        String query="Select PersonID,LastName,FirstName,HireDate From person";
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                if(rs.getString(4) != null){
                    List.add(new GiangVienDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
        } catch (Exception e) {
            System.out.println("GiangVien : getListSV * "+e);
        }
        return List;
    }
    public void AddGiangVien(GiangVienDTO sv){
        String query = "INSERT INTO person(PersonID, FirstName, LastName, HireDate) VALUES('"
            + sv.getPersonID() + "','" + sv.getFirstName() + "','" + sv.getLastName() + "',"
            + "CURRENT_TIMESTAMP);";

        try {
            this.conn.getState().executeUpdate(query);
            System.out.println("Thêm thành công !!!");
        } catch (Exception e) {
            System.out.println("Add Sinh Vien: " + e);
        }
    }
    public void UpdateGiangVien(int pID, String FiN, String LaN){
        String query = "UPDATE person SET FirstName='" + FiN + "', LastName='" + LaN + "' WHERE PersonID='" + pID + "';";
        try {
            this.conn.getState().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("\nUpdate Sinh Vien: "+e);
        }
    }
    public int initID(){
        int id= 0;
        String query = "Select Count(*) From person";
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
    public ArrayList<GiangVienDTO> search(String s) {
        ArrayList<GiangVienDTO> List = new ArrayList<>();
        ResultSet rs = null;

        try {
            String query = "SELECT PersonID,LastName,FirstName,HireDate FROM person WHERE FirstName LIKE '%" + s + "%' OR LastName LIKE '%" + s + "%' OR PersonID LIKE '%"+ s +"%' OR HireDate LIKE '%" + s + "%';";
            rs = this.conn.getState().executeQuery(query);

            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng GiangVienDTO
                
                if(rs.getString(4) != null){
                    List.add(new GiangVienDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý exception nếu có
        }

        return List;
    }

}
