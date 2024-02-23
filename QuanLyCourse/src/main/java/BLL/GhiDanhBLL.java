/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.GhiDanhDAL;

/**
 *
 * @author DELL
 */
public class GhiDanhBLL {
    GhiDanhDAL gd = new GhiDanhDAL();
    public String GhiDanh(int CourseID, int StudentID){
        if (gd.GhiDanh(CourseID, StudentID)){
            return "Ghi danh thành công";
        }
        return "Ghi danh thất bại :((";
    }
}
