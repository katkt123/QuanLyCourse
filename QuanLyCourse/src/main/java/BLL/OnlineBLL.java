/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnlineDAL;
import DTO.KhoaHocOnlineDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class OnlineBLL {
    OnlineDAL onlineDAL = new OnlineDAL();
    
     public ArrayList<KhoaHocOnlineDTO> getListKH(){
        return onlineDAL.getListKHol();
    }
    public void addKhoaHoc(KhoaHocOnlineDTO kh){
        onlineDAL.addKHol(kh);
    }
    public void setKhoaHoc(KhoaHocOnlineDTO kh){
        onlineDAL.setKHol(kh);
    }
    public void delKhoaHoc(int courseID){  // nhập mã của khóa học dạng int
        onlineDAL.deleteKHol(Integer.toString( courseID));
    }
    public void delKhoaHoc(String courseID){  // nhập mã của khóa học dạng String lấy trực tiếp từ textField
        onlineDAL.deleteKHol(courseID);
    }
    public boolean isCourseIDExists(int courseID) {
        return onlineDAL.isCourseIDExists(courseID);
    }
    public boolean isCourseIDExists(String courseID) {
        return onlineDAL.isCourseIDExists(Integer.parseInt(courseID));
    } 
    public KhoaHocOnlineDTO getOnlineCourseByID(int id){
        return onlineDAL.getOnlineCourseByID(id);
    }
    public KhoaHocOnlineDTO getOnlineCourseByID(String id){
        return onlineDAL.getOnlineCourseByID(Integer.parseInt(id));
    }
}
