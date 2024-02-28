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
 * @author ASUS
 */
public class GiangVienBLL {
    GiangVienDAL svDAL = new GiangVienDAL();
    
    public ArrayList<GiangVienDTO> getListGV(){
        return svDAL.getListSV();
    }
    public void AddGiangVien(GiangVienDTO sv){
        svDAL.AddGiangVien(sv);
    }
    public void UpdateGiangVien(int pID,String FiN,String LaN){
        svDAL.UpdateGiangVien(pID, FiN, LaN);
    }
    public int initID(){
        return svDAL.initID();
    }
    public ArrayList<GiangVienDTO> search(String s){
        return svDAL.search(s);
    }
}
