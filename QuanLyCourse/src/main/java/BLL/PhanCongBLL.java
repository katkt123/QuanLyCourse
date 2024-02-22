/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PhanCongDAL;
import DTO.GiangVienDTO;
import DTO.PhanCongDTO;
import DTO.KhoaHocDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PhanCongBLL {
    PhanCongDAL phanCongDAL = new PhanCongDAL();
    ArrayList<PhanCongDTO> listHTPC = new ArrayList<>();
    
    public ArrayList<PhanCongDTO> getListHienThiPhanCong(){
        return phanCongDAL.getListHienThi();
    }
    
    public String XoaPhanCong(int CourseID, int PersonID){
        if (phanCongDAL.XoaPhanCong(CourseID, PersonID)){
            return "Xóa phân công thành công";
        }
        return "Xóa phân công thất bại :((";
    }
    
}
