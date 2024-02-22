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
    public String ThemPhanCong(int CourseID, int PersonID){
        if (phanCongDAL.ThemPhanCong(CourseID, PersonID)){
            return "Thêm phân công thành công";
        }
        return "Thêm phân công thất bại :((";
    }
    public String SuaPhanCong(int CourseID, int PersonID){
        if (phanCongDAL.SuaPhanCong(CourseID, PersonID)){
            return "Sửa phân công thành công";
        }
        return "Sửa phân công thất bại :((";
    }
    
    public String XoaPhanCong(int CourseID, int PersonID){
        if (phanCongDAL.XoaPhanCong(CourseID, PersonID)){
            return "Xóa phân công thành công";
        }
        return "Xóa phân công thất bại :((";
    }
    
}
