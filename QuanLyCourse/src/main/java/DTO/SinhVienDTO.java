/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class SinhVienDTO {
    private int PersonID;
    private String LastName;
    private String FirstName;
    private String EnrollmentDate;
    private String HireDate = null;
    
    public SinhVienDTO(){
        this.EnrollmentDate = "";
        this.FirstName = "";
        this.LastName = "";
        this.PersonID = 0;
    }

    public SinhVienDTO(int PersonID, String LastName, String FirstName, String EnrollmentDate) {
        this.PersonID = PersonID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.EnrollmentDate = EnrollmentDate;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getEnrollmentDate() {
        return EnrollmentDate;
    }

    public String getLastName() {
        return LastName;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setEnrollmentDate(String EnrollmentDate) {
        this.EnrollmentDate = EnrollmentDate;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public void setHireDate(String HireDate) {
        this.HireDate = HireDate;
    }

    public String getHireDate() {
        return HireDate;
    }
    
}
