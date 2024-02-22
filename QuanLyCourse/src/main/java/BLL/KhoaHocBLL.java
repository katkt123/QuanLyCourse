/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.KhoaHocDAL;
import DTO.KhoaHocDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KhoaHocBLL {
    KhoaHocDAL khocHocDAL = new KhoaHocDAL();
    
    public ArrayList<KhoaHocDTO> getListKH(){
        return khocHocDAL.getListKH();
    }
    public void addKhoaHoc(KhoaHocDTO kh){
        khocHocDAL.addCourse(kh);
    }

}

