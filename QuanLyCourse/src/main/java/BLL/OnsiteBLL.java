/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnsiteDAL;
import DTO.KhoaHocDTO;
import DTO.KhoaHocOnSiteDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class OnsiteBLL {
    
    OnsiteDAL onsiteDAL = new OnsiteDAL();
    
     public ArrayList<KhoaHocOnSiteDTO> getListKH(){
        return onsiteDAL.getListKHos();
    }
    public void addKhoaHoc(KhoaHocOnSiteDTO kh){
        onsiteDAL.addKHos(kh);
    }
    
    public void delKhoaHoc(int courseID){  // nhập mã của khóa học dạng int
        onsiteDAL.delete(Integer.toString( courseID));
    }
    public void delKhoaHoc(String courseID){  // nhập mã của khóa học dạng String lấy trực tiếp từ textField
        onsiteDAL.delete(courseID);
    }
    public boolean isCourseIDExists(int courseID) {
        return onsiteDAL.isCourseIDExists(courseID);
    }
    public boolean isCourseIDExists(String courseID) {
        return onsiteDAL.isCourseIDExists(Integer.parseInt(courseID));
    } 
}
