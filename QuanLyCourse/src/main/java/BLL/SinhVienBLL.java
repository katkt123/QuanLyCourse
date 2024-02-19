/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.SinhVienDAL;
import DTO.SinhVienDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class SinhVienBLL {
    SinhVienDAL svDAL = new SinhVienDAL();
    
    public ArrayList<SinhVienDTO> getListSV(){
        return svDAL.getListSV();
    }
    public void AddSinhVien(SinhVienDTO sv){
        svDAL.AddSinhVien(sv);
    }
    public void UpdateSinhVien(int pID,String FiN,String LaN){
        svDAL.UpdateSinhVien(pID, FiN, LaN);
    }
    public int initID(){
        return svDAL.initID();
    }
    public ArrayList<SinhVienDTO> search(String s){
        return svDAL.search(s);
    }
}
