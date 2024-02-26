/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.SinhVienBLL;
import DTO.SinhVienDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class SinhVienGUI extends javax.swing.JPanel {
    SinhVienBLL svBLL = new SinhVienBLL();
    
    ArrayList<SinhVienDTO> arrSinhVien = new ArrayList<SinhVienDTO>();
    
    DefaultTableModel modelSV = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // không cho phép chỉnh sửa giá trị các ô trong bảng
        }
    };
    
    public static int pid;
    public static String fn;
    public static String ln;
    public static String ed;
    
    /**
     * Creates new form SinhVienGUI
     */
    public SinhVienGUI() {
        initComponents();
        
        jTable_SinhVien.setModel(modelSV);
        
        modelSV.addColumn("PersonID");
        modelSV.addColumn("FirstName");
        modelSV.addColumn("LastName");
        modelSV.addColumn("EnrollmentDate");
        
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setFont(new Font("Arial", Font.BOLD, 20)); // Set bold font
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); // Set center alignment
        
        for (int i = 0; i < jTable_SinhVien.getColumnCount(); i++) {
            jTable_SinhVien.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Set center alignment
        
        for (int i = 0; i < jTable_SinhVien.getColumnCount(); i++) {
            jTable_SinhVien.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        setIconAdd();
        setIconEdit();
        setIconRefresh();
        setIconSearch();
        setIconEnroll();
        loadSV();
        
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
    
    public void setIconEnroll(){
        String imagePath = "src\\main\\java\\Image\\Enrollment.png"; // 
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        btnGhiDanh.setIcon(icon);
    }
    
    public void loadSV(){
        arrSinhVien = svBLL.getListSV();
//        int a = arrNCC.size();
        for(int i = modelSV.getRowCount()-1;i>=0;i--)
            modelSV.removeRow(i);
        for(int i = 0; i<arrSinhVien.size();i++){
            SinhVienDTO em= arrSinhVien.get(i);
            int stt= i+1;
            int id= em.getPersonID();
            String first = em.getFirstName();
            String last = em.getLastName();
            String enrollment = em.getEnrollmentDate();
            
        
            Object[] row = {id,first,last,enrollment};
            modelSV.addRow(row);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_Add = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Search = new javax.swing.JTextField();
        jButton_Edit = new javax.swing.JButton();
        jButton_Refresh = new javax.swing.JButton();
        btnGhiDanh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_SinhVien = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(930, 680));
        setMinimumSize(new java.awt.Dimension(930, 680));
        setPreferredSize(new java.awt.Dimension(930, 680));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton_Add.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setMaximumSize(new java.awt.Dimension(32, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(24, 24));
        jLabel1.setPreferredSize(new java.awt.Dimension(32, 32));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField_Search))
                .addContainerGap())
        );

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

        btnGhiDanh.setForeground(new java.awt.Color(255, 255, 255));
        btnGhiDanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiDanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                .addComponent(btnGhiDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButton_Refresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnGhiDanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setRowHeaderView(null);

        jTable_SinhVien.setAutoCreateRowSorter(true);
        jTable_SinhVien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable_SinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_SinhVien.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_SinhVien.setRowHeight(50);
        jScrollPane1.setViewportView(jTable_SinhVien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        // TODO add your handling code here:
        AddSinhVienGUI asv = new AddSinhVienGUI();
        asv.setVisible(true);
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_SinhVien.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa đổi.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            pid = (int) jTable_SinhVien.getValueAt(selectedRow, 0);
            fn = jTable_SinhVien.getValueAt(selectedRow, 1).toString();
            ln = jTable_SinhVien.getValueAt(selectedRow, 2).toString();
            ed = jTable_SinhVien.getValueAt(selectedRow, 3).toString();
            UpdateSinhVienGUI usv = new UpdateSinhVienGUI(pid,fn,ln,ed);
            usv.setVisible(true);
        }
    }//GEN-LAST:event_jButton_EditActionPerformed

    private void jButton_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefreshActionPerformed
        // TODO add your handling code here:
        loadSV();
    }//GEN-LAST:event_jButton_RefreshActionPerformed

    private void jTextField_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchKeyReleased
        // TODO add your handling code here:
        String searchText = jTextField_Search.getText().trim();

        // Gọi hàm search với nội dung tìm kiếm
        ArrayList<SinhVienDTO> searchResult = svBLL.search(searchText);
        
        for(int i = modelSV.getRowCount()-1;i>=0;i--)
            modelSV.removeRow(i);
        for(int i = 0; i<searchResult.size();i++){
            SinhVienDTO em= searchResult.get(i);
            int stt= i+1;
            int id= em.getPersonID();
            String first = em.getFirstName();
            String last = em.getLastName();
            String enrollment = em.getEnrollmentDate();
            
        
            Object[] row = {id,first,last,enrollment};
            modelSV.addRow(row);
        }
    }//GEN-LAST:event_jTextField_SearchKeyReleased

    private void jTextField_SearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_SearchFocusGained
        // TODO add your handling code here:
        if (jTextField_Search.getText().equals("Nhập thông tin tìm kiếm : .....")) {
                    jTextField_Search.setText("");
                    jTextField_Search.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField_SearchFocusGained

    private void jTextField_SearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_SearchFocusLost
        // TODO add your handling code here:
        if (jTextField_Search.getText().isEmpty()) {
                    jTextField_Search.setText("Nhập thông tin tìm kiếm : .....");
                    jTextField_Search.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jTextField_SearchFocusLost

    private void jTextField_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SearchActionPerformed

    private void btnGhiDanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiDanhActionPerformed
        // TODO add your handling code here:
        int SelectedRow = jTable_SinhVien.getSelectedRow();
        if (SelectedRow == -1){
            JOptionPane.showMessageDialog(jPanel2, "Vui lòng chọn sinh viên để ghi danh !!!");
            return;
        }
        int StudentID = (int) jTable_SinhVien.getValueAt(SelectedRow, 0);
        String Name = (String) jTable_SinhVien.getValueAt(SelectedRow, 1) + " " + (String) jTable_SinhVien.getValueAt(SelectedRow, 2);
        GhiDanhGUI ghiDanhGUI = new GhiDanhGUI(StudentID, Name);
        ghiDanhGUI.setVisible(true);
        ghiDanhGUI.addWindowListener(new WindowAdapter() {
                        public void windowClosed(WindowEvent e) {
                            loadSV();
                        }
                    });
    }//GEN-LAST:event_btnGhiDanhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhiDanh;
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Edit;
    private javax.swing.JButton jButton_Refresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_SinhVien;
    private javax.swing.JTextField jTextField_Search;
    // End of variables declaration//GEN-END:variables
}
