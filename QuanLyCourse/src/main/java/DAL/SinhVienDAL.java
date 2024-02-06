/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.SinhVienDTO;
import java.sql.ResultSet;
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
        String query="Select PersonID,FirstName,LastName,EnrollmentDate From person";
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
}
