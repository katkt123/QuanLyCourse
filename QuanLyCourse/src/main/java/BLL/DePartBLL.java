/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DepartDAL;
import DTO.DepartmentDTO;
import DTO.KhoaHocDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DePartBLL {
    
    DepartDAL depart = new DepartDAL();
    
    public ArrayList<DepartmentDTO> getListDP(){
        return depart.getListDP();
    }
}
