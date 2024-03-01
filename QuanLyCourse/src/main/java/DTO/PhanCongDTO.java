/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author DELL
 */
public class PhanCongDTO {
    private int CourseID, PersonID;
    private String Title, Name;
    private LocalDateTime StartDate;

    
    public PhanCongDTO(int CourseID, String Title, int PersonID, String Name, LocalDateTime StartDate) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
        this.Title = Title;
        this.Name = Name;
        this.StartDate = StartDate;
    }

    public PhanCongDTO(int CourseID, int PersonID) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }
    
    

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public LocalDateTime getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDateTime StartDate) {
        this.StartDate = StartDate;
    }

    
    
}
