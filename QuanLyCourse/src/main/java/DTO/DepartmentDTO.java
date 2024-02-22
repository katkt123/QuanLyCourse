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
    private int DapertmentID, Administrator;
    private String Name;
    private double Budget;
    private Date StartDate;

    public DepartmentDTO(int DapertmentID, int Administrator, String Name, double Budget, Date StartDate) {
        this.DapertmentID = DapertmentID;
        this.Administrator = Administrator;
        this.Name = Name;
        this.Budget = Budget;
        this.StartDate = StartDate;
    }

    public int getDapertmentID() {
        return DapertmentID;
    }

    public void setDapertmentID(int DapertmentID) {
        this.DapertmentID = DapertmentID;
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
