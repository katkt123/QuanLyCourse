/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class KhoaHocDTO {
    private int CoureID, Credits, DepartmentID;
    private String Title;

    public KhoaHocDTO(){
        
    }
    
    public KhoaHocDTO(int CoureID, String Title, int Credits, int DepartmentID) {
        this.CoureID = CoureID;
        this.Credits = Credits;
        this.DepartmentID = DepartmentID;
        this.Title = Title;
    }

    public int getCoureID() {
        return CoureID;
    }

    public void setCoureID(int CoureID) {
        this.CoureID = CoureID;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    
    
}
