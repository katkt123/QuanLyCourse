/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class DepartmentDTO {
    private int DepartmentID, Administrator;
    private String Name;
    private double Budget;
    private Date StartDate;

    public DepartmentDTO(int DepartmentID, String Name,  double Budget, Date StartDate, int Administrator) {
        this.DepartmentID = DepartmentID;
        this.Administrator = Administrator;
        this.Name = Name;
        this.Budget = Budget;
        this.StartDate = StartDate;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepatmentID(int DapertmentID) {
        this.DepartmentID = DapertmentID;
    }

    public int getAdministrator() {
        return Administrator;
    }

    public void setAdministrator(int Administrator) {
        this.Administrator = Administrator;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getBudget() {
        return Budget;
    }

    public void setBudget(double Budget) {
        this.Budget = Budget;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }
    
    
}
