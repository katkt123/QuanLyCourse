/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GUI_Custom_Table_PC;

/**
 *
 * @author DELL
 */
public interface TableActionEvent {
    
    public void onAdd(int row);
    
    public void onEdit(int row);
    
    public void onDelete(int row);
    
}
