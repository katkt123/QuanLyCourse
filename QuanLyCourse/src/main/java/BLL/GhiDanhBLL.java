/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.GhiDanhDAL;
import java.util.ArrayList;

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
    
    public ArrayList<Object[]> getStudentGradesByCourseID(int courseID) {
        return gd.getStudentGradesByCourseID(courseID);
    }
    
    public String updateGrade(int courseID, int studentID, double newGrade) {
        if (gd.updateGrade(courseID, studentID, newGrade)) {
            return "Cập nhật điểm thành công";
        }
        return "Cập nhật điểm thất bại :((";
    }
}
