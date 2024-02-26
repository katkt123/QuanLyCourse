/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class KhoaHocOnlineDTO {
    private int CourseID;
    private String URL;
    
    public KhoaHocOnlineDTO() {
       
    }

    public KhoaHocOnlineDTO(int CourseID, String URL) {
        this.CourseID = CourseID;
        this.URL = URL;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
    
    
}
