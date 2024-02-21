/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PhanCongDAL;
import DTO.GiangVienDTO;
import DTO.HienThiPhanCongDTO;
import DTO.KhoaHocDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PhanCongBLL {
    PhanCongDAL phanCongBLL = new PhanCongDAL();
    ArrayList<HienThiPhanCongDTO> listHTPC = new ArrayList<>();
    
    public ArrayList<HienThiPhanCongDTO> getListHienThiPhanCong(){
        return phanCongBLL.getListHienThi();
    }
    
}
