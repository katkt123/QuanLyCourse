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
    public void setKhoaHoc(KhoaHocDTO kh){
        khocHocDAL.setCourse(kh);
    }
    public void delKhoaHoc(KhoaHocDTO kh){ // nhập đối tượng DTO
        khocHocDAL.delete(Integer.toString( kh.getCoureID()));
    }
    public void delKhoaHoc(int courseID){  // nhập mã của khóa học dạng int
        khocHocDAL.delete(Integer.toString( courseID));
    }
    public void delKhoaHoc(String courseID){  // nhập mã của khóa học dạng String lấy trực tiếp từ textField
        khocHocDAL.delete(courseID);
    }
    public int initID(){
        return khocHocDAL.initID();
    }
    public ArrayList<KhoaHocDTO> search(String s){
        return khocHocDAL.search(s);
    }
    public String getDepartment(int did){
        return khocHocDAL.getDepartment(did);
    }
    public KhoaHocDTO getCourseByID(int id){
        return khocHocDAL.getCourseByID(id);
    }
    public KhoaHocDTO getCourseByID(String id){
        return khocHocDAL.getCourseByID(Integer.parseInt(id));
    }
    public String getTeacherCourse(int cid){
        return khocHocDAL.getTeacherCourse(cid);
    }
//    public static void main(String[] args) {
//        KhoaHocBLL kh = new KhoaHocBLL();
//        kh.delKhoaHoc(1);
//    }
    
    public ArrayList<KhoaHocDTO> getListGhiDanh(int PersonID){
        return khocHocDAL.GetListGhiDanh(PersonID);
    }
}

