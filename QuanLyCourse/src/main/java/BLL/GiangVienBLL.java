/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.GiangVienDAL;
import DTO.GiangVienDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class GiangVienBLL {
    GiangVienDAL giangVienDAL = new GiangVienDAL();
    
    public ArrayList<GiangVienDTO> getList(){
        return giangVienDAL.getListGV();
    }
    
}
