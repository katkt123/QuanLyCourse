/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class GhiDanhDTO {
    private int EnrollmentID, CourseID, StudentID;
    private Double Grade;

    public GhiDanhDTO(int EnrollmentID, int CourseID, int StudentID, Double Grade) {
        this.EnrollmentID = EnrollmentID;
        this.CourseID = CourseID;
        this.StudentID = StudentID;
        this.Grade = Grade;
    }

    public int getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(int EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setPersonID(int StudentID) {
        this.StudentID = StudentID;
    }

    public Double getGrade() {
        return Grade;
    }

    public void setGrade(Double Grade) {
        this.Grade = Grade;
    }
    
    
}
