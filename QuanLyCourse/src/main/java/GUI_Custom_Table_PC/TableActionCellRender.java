/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI_Custom_Table_PC;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DELL
 */
public class TableActionCellRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
       
       PanelAction action = new PanelAction();
       if (isSelected == false && row % 2 == 0){
           action.setBackground(Color.WHITE);
       }
       else{
           action.setBackground(com.getBackground());
       }
       return action;
       
       /*
       return action;: Trả về PanelAction thay vì thành phần mặc định. Điều này có nghĩa là trong bảng, 
       thay vì hiển thị nội dung của ô bằng thành phần mặc định, nó sẽ sử dụng PanelAction để hiển thị các hành động tùy chỉnh.*/
    }
    
    
}
