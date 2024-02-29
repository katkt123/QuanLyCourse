/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.DePartBLL;
import BLL.KhoaHocBLL;
import BLL.OnlineBLL;
import BLL.OnsiteBLL;
import DTO.DepartmentDTO;
import DTO.KhoaHocDTO;
import DTO.KhoaHocOnSiteDTO;
import DTO.KhoaHocOnlineDTO;
import DTO.SinhVienDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class AddKhoaHocGUI extends javax.swing.JFrame {

    private int courseid;
    
    ArrayList<DepartmentDTO> arrDP = new ArrayList<DepartmentDTO>();
    
    
    int selectedId;
    int something;
    
    KhoaHocBLL khbll = new KhoaHocBLL();
    DePartBLL dp = new DePartBLL();
    
    int chucnang ;
    public AddKhoaHocGUI(String id) {
        initComponents();
        initHere();
        setTitle("Sửa Khóa Học");
        TextID.setEditable(false);
        jLabel1.setText("SỬA KHÓA HỌC");
        
        KhoaHocBLL kh = new KhoaHocBLL();
        KhoaHocDTO khDTO = kh.getCourseByID(id);
        
        TextID.setText(id);
        TextTitle.setText(khDTO.getTitle());
        TextCredit.setText("" +khDTO.getCredits());
        
        ComboboxDPT.setSelectedItem(new DePartBLL().getDepartmentByID(khDTO.getDepartmentID()).getName());
        OnlineBLL ol = new OnlineBLL();
        OnsiteBLL os = new OnsiteBLL();
        if (os.isCourseIDExists(id)){
            ComboType.setSelectedIndex(0);
            KhoaHocOnSiteDTO onsite = os.getOnSiteCourseByID(khDTO.getCoureID());
            TextLoca.setText(onsite.getLocation());
            
            setDaysCheckbox(onsite.getDays());
            
            SimpleDateFormat sdfHour = new SimpleDateFormat("HH");
            SimpleDateFormat sdfMinute = new SimpleDateFormat("mm");

            String hour = sdfHour.format(onsite.getTime());
            String minute = sdfMinute.format(onsite.getTime());
            TextHour.setText(hour);
            TextMinute.setText(minute);
        }
        else if (ol.isCourseIDExists(id)) {
            ComboType.setSelectedIndex(1);
            KhoaHocOnlineDTO online = ol.getOnlineCourseByID(khDTO.getCoureID());
            TextURL.setText(online.getURL());
        }
        
        
    }   
    public void setDaysCheckbox(String days) {
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);

        for (char c : days.toCharArray()) {
            switch (c) {
                case 'M':
                    jCheckBox1.setSelected(true);
                    break;
                case 'T':
                    jCheckBox2.setSelected(true);
                    break;
                case 'W':
                    jCheckBox3.setSelected(true);
                    break;
                case 'H':
                    jCheckBox4.setSelected(true);
                    break;
                case 'F':
                    jCheckBox5.setSelected(true);
                    break;
                case 'S':
                    jCheckBox6.setSelected(true);
                    break;
                default:
                    // Xử lý trường hợp không hợp lệ nếu cần thiết
                    break;
            }
        }
    }

    
    public AddKhoaHocGUI() {
        initComponents();
        initHere();
        setTitle("Thêm Khóa Học");
    }
    private void initHere(){
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        jLabel1.setHorizontalAlignment(jLabel1.CENTER); // Đưa chữ về giữa theo chiều ngang
        jLabel2.setHorizontalAlignment(jLabel2.CENTER); // Đưa chữ về giữa theo chiều ngang
        jLabel3.setHorizontalAlignment(jLabel3.CENTER); // Đưa chữ về giữa theo chiều ngang
        jLabel4.setHorizontalAlignment(jLabel4.CENTER); // Đưa chữ về giữa theo chiều ngang
        
        
        arrDP = dp.getListDP();
        
       
        for(int i = 0; i<arrDP.size();i++){
            DepartmentDTO dp = arrDP.get(i);
            int stt= i+1;
            
            int id = dp.getDepartmentID();
            String name = dp.getName();
            
            
            ComboboxDPT.addItem(name);
        }
        
        
        
        ComboboxDPT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                for(int i = 0; i<arrDP.size();i++){
                DepartmentDTO dp = arrDP.get(i);
                int stt= i+1;
            
                if (dp.getName().equals(ComboboxDPT.getSelectedItem()))
                {
                    selectedId = dp.getDepartmentID();
                }
            }
              
               
            }
        });
        
        
        
        ComboboxDPT.setSelectedIndex(0);
        ComboType.setSelectedIndex(0);
        
        ComboType.setSelectedIndex(0);
        TextURL.setVisible(false);
        
        
        
        ComboType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                System.out.println("Type: " + ComboType.getSelectedIndex());
                if (ComboType.getSelectedIndex() == 0){
                    TextURL.setVisible(false);
                    jLabel11.setVisible(true);
                    TextHour.setVisible(true);
                    TextLoca.setVisible(true);
                    TextMinute.setVisible(true);
                    jCheckBox1.setVisible(true);
                    jCheckBox2.setVisible(true);
                    jCheckBox3.setVisible(true);
                    jCheckBox4.setVisible(true);
                    jCheckBox5.setVisible(true);
                    jCheckBox6.setVisible(true);
                    jLabel8.setVisible(true);
                    jLabel9.setVisible(true);
                    
                  
                    jLabel7.setText("LOCATION");
                    
                }else if(ComboType.getSelectedIndex() == 1){
                    TextURL.setVisible(true);
                    TextLoca.setVisible(false);
                    jLabel11.setVisible(false);
                    TextHour.setVisible(false);
                    TextMinute.setVisible(false);
                    jCheckBox1.setVisible(false);
                    jCheckBox2.setVisible(false);
                    jCheckBox3.setVisible(false);
                    jCheckBox4.setVisible(false);
                    jCheckBox5.setVisible(false);
                    jCheckBox6.setVisible(false);                    
                    jLabel8.setVisible(false);
                    jLabel9.setVisible(false);
                    jLabel7.setText("URL");
                }
            }
        });
    }

    public void addonsite(int id){
       KhoaHocOnSiteDTO khos = new KhoaHocOnSiteDTO();
       OnsiteBLL osbll = new OnsiteBLL();      
       
       String loca = TextLoca.getText().toString();
       String gio = TextHour.getText().toString();
       String phut = TextMinute.getText().toString();
       
       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
       
       LocalTime localTime = LocalTime.of( Integer.parseInt(TextHour.getText().toString()), Integer.parseInt(TextMinute.getText().toString()));
       Time time = Time.valueOf(localTime);

       String ngay = "";
       if (jCheckBox1.isSelected()) ngay += "M";
       if (jCheckBox2.isSelected()) ngay += "T";
       if (jCheckBox3.isSelected()) ngay += "W";
       if (jCheckBox4.isSelected()) ngay += "H";
       if (jCheckBox5.isSelected()) ngay += "F";
       if (jCheckBox6.isSelected()) ngay += "S";
       
       khos.setCourseID(id);
       khos.setLocation(loca);
       khos.setTime(time);
       khos.setDays(ngay);
       osbll.addKhoaHoc(khos);
    }
    
    public void addonline(int id){
        
        KhoaHocOnlineDTO khol = new KhoaHocOnlineDTO();
        OnlineBLL olbll = new OnlineBLL();
        
        
        
        String url = TextURL.getText().toString();
        
        khol.setURL(url);
        khol.setCourseID(id);
        
        olbll.addKhoaHoc(khol);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextID = new javax.swing.JTextField();
        TextTitle = new javax.swing.JTextField();
        TextCredit = new javax.swing.JTextField();
        jButton_ok = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextLoca = new javax.swing.JTextField();
        TextHour = new javax.swing.JTextField();
        ComboboxDPT = new javax.swing.JComboBox<>();
        ComboType = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        TextURL = new javax.swing.JTextField();
        TextMinute = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM KHÓA HỌC");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("TITLE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("CREDIT");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("DEPARTMENT");

        TextID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextIDActionPerformed(evt);
            }
        });

        TextTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        TextCredit.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextCreditActionPerformed(evt);
            }
        });

        jButton_ok.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_ok.setText("OK");
        jButton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_okActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("TYPE");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("LOCATION");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("DAY");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("TIME");

        TextLoca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        TextHour.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextHourActionPerformed(evt);
            }
        });

        ComboboxDPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboboxDPTActionPerformed(evt);
            }
        });

        ComboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Onsite", "Online" }));
        ComboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTypeActionPerformed(evt);
            }
        });

        jCheckBox1.setText("M");

        jCheckBox2.setText("T");

        jCheckBox3.setText("W");

        jCheckBox4.setText("TH");

        jCheckBox5.setText("F");

        jCheckBox6.setText("S");

        TextURL.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        TextMinute.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextMinute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextMinuteActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText(":");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(TextID, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboboxDPT, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TextCredit)
                                .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(TextURL, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextLoca))
                        .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TextHour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(309, 309, 309))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(315, 315, 315))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextLoca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextURL, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextHour, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboboxDPT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(jButton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextIDActionPerformed
        
    }//GEN-LAST:event_TextIDActionPerformed

    private void jButton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_okActionPerformed
        
        if (getTitle().equals("Thêm Khóa Học")) {
            courseid = khbll.initID() + 1;
        
            int id = Integer.parseInt(TextID.getText().toString());
            String tt = TextTitle.getText().toString();
            int cr = Integer.parseInt(TextCredit.getText().toString());
            int dp = selectedId;

            if (!"".equals(id) && !"".equals(tt) && !"".equals(cr) && !"".equals(dp)) {
                KhoaHocDTO kh = new KhoaHocDTO();
                kh.setCoureID(id);
                kh.setTitle(tt);
                kh.setCredits(cr);
                kh.setDepartmentID(dp);
                khbll.addKhoaHoc(kh);
                if (ComboType.getSelectedIndex() == 0 && !TextLoca.getText().isEmpty()){
                    addonsite(id);
                }if(ComboType.getSelectedIndex() == 1 && !TextURL.getText().isEmpty()){
                    addonline(id);
                }

                JOptionPane.showMessageDialog(null, "Thêm thành công !!!", "Thêm sinh viên", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Dữ liệu chưa được nhập!!", "Thông tin lỗi", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            int id = Integer.parseInt(TextID.getText().toString());
            String tt = TextTitle.getText().toString();
            int cr = Integer.parseInt(TextCredit.getText().toString());
            int dp = selectedId;

            if (!"".equals(id) && !"".equals(tt) && !"".equals(cr) && !"".equals(dp)) {
                KhoaHocDTO kh = new KhoaHocDTO();
                kh.setCoureID(id);
                kh.setTitle(tt);
                kh.setCredits(cr);
                kh.setDepartmentID(dp);
                khbll.setKhoaHoc(kh);
                
                OnsiteBLL osbll = new OnsiteBLL();   
                OnlineBLL olbll = new OnlineBLL();
                
                if (ComboType.getSelectedIndex() == 0){
                    KhoaHocOnSiteDTO khos = new KhoaHocOnSiteDTO();                

                    String loca = TextLoca.getText().toString();
                    LocalTime localTime = LocalTime.of( Integer.parseInt(TextHour.getText().toString()), 
                            Integer.parseInt(TextMinute.getText().toString()));
                    Time time = Time.valueOf(localTime);
                    String ngay = "";
                    if (jCheckBox1.isSelected()) ngay += "M";
                    if (jCheckBox2.isSelected()) ngay += "T";
                    if (jCheckBox3.isSelected()) ngay += "W";
                    if (jCheckBox4.isSelected()) ngay += "H";
                    if (jCheckBox5.isSelected()) ngay += "F";
                    if (jCheckBox6.isSelected()) ngay += "S";

                    khos.setCourseID(id);
                    khos.setLocation(loca);
                    khos.setTime(time);
                    khos.setDays(ngay);
                    
                    if (olbll.isCourseIDExists(id)) {
                        olbll.delKhoaHoc(id);
                        osbll.addKhoaHoc(khos);
                    } else if (osbll.isCourseIDExists(id))
                        osbll.setKhoaHoc(khos);
                    else 
                        osbll.addKhoaHoc(khos);
                }if(ComboType.getSelectedIndex() == 1){
                    KhoaHocOnlineDTO khol = new KhoaHocOnlineDTO();

                    String url = TextURL.getText().toString();
                    khol.setURL(url);
                    khol.setCourseID(id);
                    if (osbll.isCourseIDExists(id)) {
                        osbll.delKhoaHoc(id);
                        olbll.addKhoaHoc(khol);
                    } else if (olbll.isCourseIDExists(id))
                        olbll.setKhoaHoc(khol);
                    else 
                        olbll.addKhoaHoc(khol);
                }
            }
        }  
    }//GEN-LAST:event_jButton_okActionPerformed

    private void TextCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCreditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCreditActionPerformed

    private void TextHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextHourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextHourActionPerformed

    private void TextMinuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextMinuteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextMinuteActionPerformed

    private void ComboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTypeActionPerformed

    private void ComboboxDPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboboxDPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboboxDPTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddKhoaHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddKhoaHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddKhoaHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddKhoaHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddKhoaHocGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboType;
    private javax.swing.JComboBox<String> ComboboxDPT;
    private javax.swing.JTextField TextCredit;
    private javax.swing.JTextField TextHour;
    private javax.swing.JTextField TextID;
    private javax.swing.JTextField TextLoca;
    private javax.swing.JTextField TextMinute;
    private javax.swing.JTextField TextTitle;
    private javax.swing.JTextField TextURL;
    private javax.swing.JButton jButton_ok;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
