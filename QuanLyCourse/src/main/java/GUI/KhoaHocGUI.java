/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.KhoaHocBLL;
import BLL.OnlineBLL;
import BLL.OnsiteBLL;
import BLL.SinhVienBLL;
import DTO.KhoaHocDTO;
import DTO.SinhVienDTO;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class KhoaHocGUI extends javax.swing.JPanel {

    KhoaHocBLL khBLL = new KhoaHocBLL();
    
    ArrayList<KhoaHocDTO> arrKhoaHoc = new ArrayList<KhoaHocDTO>();

    DefaultTableModel modelKH = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column != 3){
                return false; 
            }
            return true;
        }
        
       
    };
    
    public KhoaHocGUI() {
        initComponents();
        
        jTable_KhoaHoc.setModel(modelKH);
        
        modelKH.addColumn("CourseID");
        modelKH.addColumn("Title");
        modelKH.addColumn("Credit");
        modelKH.addColumn("Department");
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setFont(new Font("Arial", Font.BOLD, 20)); // Set bold font
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); // Set center alignment
        
        for (int i = 0; i < jTable_KhoaHoc.getColumnCount(); i++) {
            jTable_KhoaHoc.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Set center alignment
        
        for (int i = 0; i < jTable_KhoaHoc.getColumnCount(); i++) {
            jTable_KhoaHoc.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        
        jTable_KhoaHoc.addMouseListener(new MouseAdapter() {
        	@Override
                public void mousePressed(MouseEvent mouseEvent) {
        		if (mouseEvent.getClickCount() == 2 ) {
                            int row = jTable_KhoaHoc.getSelectedRow();
                            int idkh = (int) jTable_KhoaHoc.getValueAt(row, 0);
                            String tt = jTable_KhoaHoc.getValueAt(row, 1).toString();
                            int cr = (int) jTable_KhoaHoc.getValueAt(row, 2);
                            int dp = (int) jTable_KhoaHoc.getValueAt(row, 3);
                            System.out.println("ID: " + idkh + "TT: " + tt + "CR: " + cr + "DP: " + dp);
                        }		
        	}
        });
        
        setIconAdd();
        setIconEdit();
        setIconDelete();
        setIconRefresh();
        loadKH();
    }
    
     public void setIconAdd(){
        String imagePath = "src\\main\\java\\Image\\Add.png"; // 
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        jButton_Add.setIcon(icon);
    }
    public void setIconEdit(){
        String imagePath = "src\\main\\java\\Image\\Edit.png"; // 
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        jButton_Edit.setIcon(icon);
    }
    public void setIconDelete(){
        String imagePath = "src\\main\\java\\GUI_Custom_Table_PC\\Delete_PC.png"; // 
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        jButton_Delete.setIcon(icon);
    }
    public void setIconRefresh(){
        String imagePath = "src\\main\\java\\Image\\Refresh.png"; // 
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        jButton_Refresh.setIcon(icon);
    }
    
    public void setIconSearch(){
        String imagePath = "src\\main\\java\\Image\\Search.png"; // 
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        jLabel1.setIcon(icon);
    }
    
    public void loadKH(){
        arrKhoaHoc = khBLL.getListKH();
//        int a = arrNCC.size();
        for(int i = modelKH.getRowCount()-1;i>=0;i--)
            modelKH.removeRow(i);
        for(int i = 0; i<arrKhoaHoc.size();i++){
            KhoaHocDTO kh= arrKhoaHoc.get(i);
            int stt= i+1;
            
            int id= kh.getCoureID();
            String tt = kh.getTitle();
            int cr = kh.getCredits();
            int dp = kh.getDepartmentID();
            
        
            Object[] row = {id,tt,cr,dp};
            modelKH.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_Add = new javax.swing.JButton();
        jButton_Edit = new javax.swing.JButton();
        jButton_Refresh = new javax.swing.JButton();
        jTextField_Search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton_Delete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_KhoaHoc = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton_Add.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        jButton_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditActionPerformed(evt);
            }
        });

        jButton_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RefreshActionPerformed(evt);
            }
        });

        jTextField_Search.setText("Nhập thông tin tìm kiếm : .....");
        jTextField_Search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_SearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_SearchFocusLost(evt);
            }
        });
        jTextField_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SearchActionPerformed(evt);
            }
        });
        jTextField_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_SearchKeyReleased(evt);
            }
        });

        jLabel1.setMaximumSize(new java.awt.Dimension(32, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(24, 24));
        jLabel1.setPreferredSize(new java.awt.Dimension(32, 32));

        jButton_Delete.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addGap(296, 296, 296)
                .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton_Add, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(jButton_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_Search)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton_Delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                    .addComponent(jButton_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable_KhoaHoc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable_KhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_KhoaHoc.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_KhoaHoc.setMinimumSize(new java.awt.Dimension(60, 200));
        jTable_KhoaHoc.setRowHeight(50);
        jScrollPane1.setViewportView(jTable_KhoaHoc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefreshActionPerformed
        loadKH();  
    }//GEN-LAST:event_jButton_RefreshActionPerformed

    private void jButton_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditActionPerformed
//        JOptionPane.showMessageDialog(this, "Chỉnh sửa khóa học", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton_EditActionPerformed

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed

        AddKhoaHocGUI khoaHocGUI = new AddKhoaHocGUI();
        khoaHocGUI.setVisible(true);
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jTextField_SearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_SearchFocusGained
        // TODO add your handling code here:
        if (jTextField_Search.getText().equals("Nhập thông tin tìm kiếm : .....")) {
            jTextField_Search.setText("");
            
        }
    }//GEN-LAST:event_jTextField_SearchFocusGained

    private void jTextField_SearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_SearchFocusLost
        // TODO add your handling code here:
        if (jTextField_Search.getText().isEmpty()) {
            jTextField_Search.setText("Nhập thông tin tìm kiếm : .....");
            
        }
    }//GEN-LAST:event_jTextField_SearchFocusLost

    private void jTextField_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SearchActionPerformed

    private void jTextField_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchKeyReleased
        // TODO add your handling code here:
        String searchText = jTextField_Search.getText().trim();

        // Gọi hàm search với nội dung tìm kiếm
        ArrayList<KhoaHocDTO> searchResult = khBLL.search(searchText);

        for(int i = modelKH.getRowCount()-1;i>=0;i--)
        modelKH.removeRow(i);
        for(int i = 0; i<searchResult.size();i++){
            KhoaHocDTO em = searchResult.get(i);
            int stt= i+1;
            int id= em.getCoureID();
            String tt = em.getTitle();
            int cr= em.getCredits();
            int dp= em.getDepartmentID();
            
            

            Object[] row = {id,tt,cr,dp};
            modelKH.addRow(row);
        }
    }//GEN-LAST:event_jTextField_SearchKeyReleased

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        int i = jTable_KhoaHoc.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần xóa! ");
        } else {
            OnlineBLL ol = new OnlineBLL();
            OnsiteBLL os = new OnsiteBLL();
            if (ol.isCourseIDExists(jTable_KhoaHoc.getValueAt(i, 0).toString()))
                ol.delKhoaHoc(jTable_KhoaHoc.getValueAt(i, 0).toString());
            else if (os.isCourseIDExists(jTable_KhoaHoc.getValueAt(i, 0).toString()))
                os.delKhoaHoc(jTable_KhoaHoc.getValueAt(i, 0).toString());
            
            khBLL.delKhoaHoc(jTable_KhoaHoc.getValueAt(i, 0).toString());
        }
    }//GEN-LAST:event_jButton_DeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Edit;
    private javax.swing.JButton jButton_Refresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_KhoaHoc;
    private javax.swing.JTextField jTextField_Search;
    // End of variables declaration//GEN-END:variables
}
