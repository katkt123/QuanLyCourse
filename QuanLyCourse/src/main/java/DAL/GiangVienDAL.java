/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.GiangVienDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class GiangVienDAL {
    private KetNoiPHP conn; 
    
    public GiangVienDAL(){
        conn = new KetNoiPHP();
    }
    public ArrayList<GiangVienDTO> getListGV(){
        ArrayList<GiangVienDTO> List = new ArrayList<>();
        ResultSet rs = null;
        String query = "Select PersonID,FirstName,LastName,HireDate From person";
        try {
            rs = this.conn.getState().executeQuery(query);
            while(rs.next()){
                if(rs.getString(4) != null){
                    List.add(new GiangVienDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }

}
