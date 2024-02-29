/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.KhoaHocBLL;
import BLL.PhanCongBLL;
import DTO.PhanCongDTO;
import DTO.KhoaHocDTO;
import GUI_Custom_Table_PC.TableActionCellEditor;
import GUI_Custom_Table_PC.TableActionCellRender;
import GUI_Custom_Table_PC.TableActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.RootPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ASUS
 */
public class PhanCongGiangDay extends javax.swing.JPanel {
    
    private KhoaHocBLL khoaHocBLL = new KhoaHocBLL();
    
    private PhanCongBLL phanCongBLL = new PhanCongBLL();
    
    private ArrayList<PhanCongDTO> listHTPC = new ArrayList<>();
    
    DefaultTableModel modelPC = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column != 4){
                return false; // không cho phép chỉnh sửa giá trị các ô trong bảng
            }
            return true;
        }
        
       
    };
    
    /**
     * Creates new form PhanCongGiangDay
     */
    public PhanCongGiangDay() {
        initComponents();
        
        jTable_PhanCong.setModel(modelPC);

        
        modelPC.addColumn("CourseID");
        modelPC.addColumn("Title");
        modelPC.addColumn("PersonID");
        modelPC.addColumn("Name");
        modelPC.addColumn("Action");
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setFont(new Font("Arial", Font.BOLD, 20)); // Set bold font
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); // Set center alignment
        
        for (int i = 0; i < jTable_PhanCong.getColumnCount(); i++) {
            jTable_PhanCong.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Set center alignment
        
        for (int i = 0; i < jTable_PhanCong.getColumnCount(); i++) {
            jTable_PhanCong.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        
        CustomActionButton();
        setIconRefresh();
        loadPC();
              
    
    }
    public void setIconRefresh(){
        String imagePath = "src\\main\\java\\Image\\refresh_pc.png"; // 
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        btnRefresh.setIcon(icon);
    }
     public void loadPC(){
         
        ResetTXT();
         
        rdbTatCa.setSelected(true);
         
        // Thực hiện lấy dữ liệu
        listHTPC = phanCongBLL.getListHienThiPhanCong();
        
        // Xóa các hàng đã có
        modelPC.setRowCount(0);

        for(int i = 0; i< listHTPC.size();i++){
            PhanCongDTO em= listHTPC.get(i);
            int CourseID = em.getCourseID();
            String title = em.getTitle();
            int PersonID = em.getPersonID();
            String Name = em.getName();
            
            if (PersonID != 0){
                Object[] row = {CourseID,title, PersonID, Name};
                modelPC.addRow(row);
            }
            else{
                Object[] row = {CourseID,title," ", Name};
                modelPC.addRow(row);
            }
            
        }
    }
     
    public void CustomActionButton(){
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onAdd(int row) {
               
                String Name = jTable_PhanCong.getValueAt(row, 3).toString();
                
                if (Name.isEmpty()){
                    
                    int CourseID = (int) jTable_PhanCong.getValueAt(row, 0);
                    String Title = jTable_PhanCong.getValueAt(row, 1).toString();
                    
                    ThemGV_vao_khoa_hoc tgv = new ThemGV_vao_khoa_hoc(CourseID,Title);
                    tgv.setVisible(true);
                    tgv.addWindowListener(new WindowAdapter() {
                        public void windowClosed(WindowEvent e) {
                            loadPC();
                        }
                    });
                }
                else{
                    JOptionPane.showMessageDialog(jScrollPane1, "Khóa học đã được phân công");
                }
                
            }

            @Override
            public void onEdit(int row) {
                String Name = jTable_PhanCong.getValueAt(row, 3).toString();
                
                if(Name.isEmpty()){
                    JOptionPane.showMessageDialog(jScrollPane1, "Khóa học chưa được phân công");
                }
                else{
                    int CourseID = (int) jTable_PhanCong.getValueAt(row, 0);
                    String Title = jTable_PhanCong.getValueAt(row, 1).toString();
                    int PersonID = (int) jTable_PhanCong.getValueAt(row, 2);

                    SuaGV_trong_khôa_hoc sgv = new SuaGV_trong_khôa_hoc(CourseID,Title,PersonID);
                    sgv.setVisible(true);
                    sgv.addWindowListener(new WindowAdapter() {
                        public void windowClosed(WindowEvent e) {
                            loadPC();
                        }
                    });
                }
            }

            @Override
            public void onDelete(int row) {
                String Name = jTable_PhanCong.getValueAt(row, 3).toString();
                
                if(Name.isEmpty()){
                    JOptionPane.showMessageDialog(jScrollPane1, "Khóa học chưa được phân công");
                }
                else{
                    int CourseID = (int) jTable_PhanCong.getValueAt(row, 0);
                    String Title = jTable_PhanCong.getValueAt(row, 1).toString();
                    int PersonID = (int) jTable_PhanCong.getValueAt(row, 2);
                    
                    if (JOptionPane.showConfirmDialog(jScrollPane1, "Bạn có chắc muốn xóa phân công của khóa học " + Title + " không ?") == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(jScrollPane1, phanCongBLL.XoaPhanCong(CourseID, PersonID));
                        loadPC();
                    }
                }
               
            }
        };
        
        // Hiển thị
        jTable_PhanCong.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        // Hành động
        jTable_PhanCong.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }
    
    public void ResetTXT(){
        txtCourseID.setText("");
        txtName.setText("");
        txtTitle.setText("");
        txtPersonID.setText("");

    }
    
    public void SearchWith(){
        // Lấy nội dung để lọc
        String CourseID_str = txtCourseID.getText();
        String Title_str = txtTitle.getText();
        String PersonID_str = txtPersonID.getText();
        String Name_str = txtName.getText();
        
        // Xóa nội dung hiện tại trên bảng
        modelPC.setRowCount(0);
        
        //Lọc
        for(int i = 0; i < listHTPC.size();i++){
            
            PhanCongDTO em= listHTPC.get(i);
            int CourseID = em.getCourseID();
            String title = em.getTitle();
            int PersonID = em.getPersonID();
            String Name = em.getName();
            
            if (Integer.toString(CourseID).toLowerCase().contains(CourseID_str.toLowerCase()) && title.toLowerCase().contains(Title_str) 
                    && Integer.toString(PersonID).toLowerCase().contains(PersonID_str.toLowerCase()) && Name.toLowerCase().contains(Name_str.toLowerCase())){
                if(rdbTatCa.isSelected()){
                    if (PersonID != 0){
                    Object[] row = {CourseID,title, PersonID, Name};
                    modelPC.addRow(row);
                    }
                    else{
                        Object[] row = {CourseID,title," ", Name};
                        modelPC.addRow(row);
                    }
                }
                else if (rdbChua.isSelected()){
                    if (PersonID == 0){
                        Object[] row = {CourseID,title," ", Name};
                        modelPC.addRow(row);
                    }
                }
                else if (rdbDa.isSelected()){
                    if (PersonID != 0){
                        Object[] row = {CourseID,title,PersonID, Name};
                        modelPC.addRow(row);
                    }
                }
                    
            }
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

        rdbGroup = new javax.swing.ButtonGroup();
        panel2 = new java.awt.Panel();
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdbTatCa = new javax.swing.JRadioButton();
        rdbChua = new javax.swing.JRadioButton();
        rdbDa = new javax.swing.JRadioButton();
        btnRefresh = new javax.swing.JButton();
        txtCourseID = new javax.swing.JTextField();
        txtPersonID = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_PhanCong = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        panel1.setBackground(new java.awt.Color(0, 155, 155));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thông tin tìm kiếm");

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Study_In_University\\nam3\\HocKy2\\XayDungPhanMemTheoMoHinhPhanLop\\DoAn\\QuanLyCourse\\QuanLyCourse\\src\\main\\java\\Image\\Search2.png")); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("CourseID: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Title: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("PersonID: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Name: ");

        rdbGroup.add(rdbTatCa);
        rdbTatCa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbTatCa.setText("Tất cả");
        rdbTatCa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdbTatCaStateChanged(evt);
            }
        });
        rdbTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTatCaActionPerformed(evt);
            }
        });

        rdbGroup.add(rdbChua);
        rdbChua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbChua.setText("Chưa phân công");
        rdbChua.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdbChuaStateChanged(evt);
            }
        });
        rdbChua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbChuaActionPerformed(evt);
            }
        });

        rdbGroup.add(rdbDa);
        rdbDa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbDa.setText("Đã phân công");
        rdbDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbDaActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 155, 155));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon("D:\\Study_In_University\\nam3\\HocKy2\\XayDungPhanMemTheoMoHinhPhanLop\\DoAn\\QuanLyCourse\\QuanLyCourse\\src\\main\\java\\Image\\refresh_pc.png")); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        txtCourseID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCourseIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCourseIDKeyReleased(evt);
            }
        });

        txtPersonID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPersonIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPersonIDKeyReleased(evt);
            }
        });

        txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTitleKeyReleased(evt);
            }
        });

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCourseID)
                    .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(rdbTatCa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbDa)
                            .addComponent(rdbChua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(rdbTatCa)
                        .addGap(0, 0, 0)
                        .addComponent(rdbChua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbDa))
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRefresh)
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable_PhanCong.setAutoCreateRowSorter(true);
        jTable_PhanCong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable_PhanCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_PhanCong.setRowHeight(50);
        jScrollPane1.setViewportView(jTable_PhanCong);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadPC();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void rdbTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTatCaActionPerformed
        // TODO add your handling code here:
        loadPC();
    }//GEN-LAST:event_rdbTatCaActionPerformed

    private void rdbChuaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdbChuaStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rdbChuaStateChanged

    private void rdbTatCaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdbTatCaStateChanged
       
    }//GEN-LAST:event_rdbTatCaStateChanged

    private void rdbChuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbChuaActionPerformed
        // TODO add your handling code here:
        ResetTXT();
        //Xóa các hàng đã có
        modelPC.setRowCount(0);

        for(int i = 0; i< listHTPC.size();i++){
            PhanCongDTO em= listHTPC.get(i);
            int CourseID = em.getCourseID();
            String title = em.getTitle();
            int PersonID = em.getPersonID();
            String Name = em.getName();
            
            if (PersonID == 0){
                Object[] row = {CourseID,title," ", Name};
                modelPC.addRow(row);
            }

        }
    }//GEN-LAST:event_rdbChuaActionPerformed

    private void rdbDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbDaActionPerformed
        // TODO add your handling code here:
        ResetTXT();
        //Xóa các hàng đã có
        modelPC.setRowCount(0);

        for(int i = 0; i< listHTPC.size();i++){
            PhanCongDTO em= listHTPC.get(i);
            int CourseID = em.getCourseID();
            String title = em.getTitle();
            int PersonID = em.getPersonID();
            String Name = em.getName();
            
            if (PersonID != 0){
                Object[] row = {CourseID,title,PersonID, Name};
                modelPC.addRow(row);
            }

        }
    }//GEN-LAST:event_rdbDaActionPerformed

    private void txtCourseIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCourseIDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseIDKeyPressed

    private void txtCourseIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCourseIDKeyReleased
        // TODO add your handling code here:
        SearchWith();
    }//GEN-LAST:event_txtCourseIDKeyReleased

    private void txtTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyReleased
        // TODO add your handling code here:
        SearchWith();
    }//GEN-LAST:event_txtTitleKeyReleased

    private void txtPersonIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonIDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonIDKeyPressed

    private void txtPersonIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonIDKeyReleased
        // TODO add your handling code here:
        SearchWith();
    }//GEN-LAST:event_txtPersonIDKeyReleased

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        // TODO add your handling code here:
        SearchWith();
        
    }//GEN-LAST:event_txtNameKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_PhanCong;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JRadioButton rdbChua;
    private javax.swing.JRadioButton rdbDa;
    private javax.swing.ButtonGroup rdbGroup;
    private javax.swing.JRadioButton rdbTatCa;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPersonID;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
