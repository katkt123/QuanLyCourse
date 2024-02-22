/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.SinhVienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class SinhVienDAL {
    private KetNoiPHP conn; 
    
    public SinhVienDAL(){
        conn = new KetNoiPHP();
    }
    public ArrayList<SinhVienDTO> getListSV(){
        ArrayList<SinhVienDTO> List = new ArrayList<>();
        ResultSet rs = null;
        String query="Select PersonID,LastName,FirstName,EnrollmentDate From person";
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                if(rs.getString(4) != null){
                    List.add(new SinhVienDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
        } catch (Exception e) {
            System.out.println("SinhVien : getListSV * "+e);
        }
        return List;
    }
    public void AddSinhVien(SinhVienDTO sv){
        String query = "INSERT INTO person(PersonID, FirstName, LastName, EnrollmentDate) VALUES('"
            + sv.getPersonID() + "','" + sv.getFirstName() + "','" + sv.getLastName() + "',"
            + "CURRENT_TIMESTAMP);";

    try {
        this.conn.getState().executeUpdate(query);
        System.out.println("Thêm thành công !!!");
    } catch (Exception e) {
        System.out.println("Add Sinh Vien: " + e);
    }
    }
    public void UpdateSinhVien(int pID, String FiN, String LaN){
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
    public ArrayList<SinhVienDTO> search(String s) {
        ArrayList<SinhVienDTO> List = new ArrayList<>();
        ResultSet rs = null;

        try {
            String query = "SELECT PersonID,LastName,FirstName,EnrollmentDate FROM person WHERE FirstName LIKE N'%" + s + "%' OR LastName LIKE N'%" + s + "%' OR PersonID LIKE '%"+ s +"%' OR EnrollmentDate LIKE '%" + s + "%';";
            rs = this.conn.getState().executeQuery(query);

            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng SinhVienDTO
                
                if(rs.getString(4) != null){
                    List.add(new SinhVienDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý exception nếu có
        }

        return List;
    }

}
