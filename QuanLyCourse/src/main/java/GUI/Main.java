/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ASUS
 */
public class Main extends javax.swing.JFrame {
    private int working = -1;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        toolsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setLocationRelativeTo(null);
        addComponent("Khóa Học",new KhoaHocGUI(),"Course.png");
        addComponent("Sinh Viên",new SinhVienGUI(),"Student.png");
        addComponent("Giảng Viên",new GiangVienGUI(),"Teacher.png");
        addComponent("Khoa",new SinhVienGUI(),"Faculty.png");
        addComponent("Phân Công",new PhanCongGiangDay(),"Pen.png");
        addComponent("Nhập Điểm",new SinhVienGUI(),"Score.png");
        Event();
        
    }
    private void addComponent(String buttonName, JPanel panelName, String path) {
        int compQuantity = this.toolsPanel.getComponentCount();
        this.toolsPanel.setPreferredSize(new Dimension(this.toolsPanel.getWidth(), 50 * (compQuantity + 1)));
        JButton btn = new JButton(buttonName);
        btn.setPreferredSize(new Dimension(500, 50));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btn.setBackground(new Color(255,0,0));
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font(btn.getFont().getName(), Font.BOLD, 20));
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setIconTextGap(30);
        if (path == "") {
            btn.setIcon(null);
        } else {
            String imagePath = "src\\main\\java\\Image\\"+path; // 
            ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
            btn.setIcon(icon);
        }

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainDisplay.removeAll();
                panelName.setVisible(true);
                mainDisplay.add(panelName);
                mainDisplay.repaint();
                mainDisplay.revalidate();
//                System.out.println("MainDisplay size : " + mainDisplay.getSize());
                
            }
        });
        
        btn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            btn.setBackground(Color.RED); // Màu nền khi rê chuột vào
            btn.setForeground(new Color(255,0,0)); // Màu chữ khi rê chuột vào
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btn.setBackground(new Color(255,0,0)); // Màu nền ban đầu
            btn.setForeground(Color.BLACK); // Màu chữ ban đầu
        }
    });
        this.toolsPanel.add(btn);
        

//        this.logo.requestFocusInWindow();
    }
    
    private void Event(){
        for (int i = 0; i < this.toolsPanel.getComponentCount(); i++) {
            int tmp = i;
            this.toolsPanel.getComponent(i).addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (working >= 0) {
                        ((JButton) toolsPanel.getComponent(working)).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
                    }
                    working = tmp;
                    ((JButton) toolsPanel.getComponent(tmp)).setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.green));
                }
            });
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

        toolsPanel = new javax.swing.JPanel();
        mainDisplay = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Course");
        setMaximumSize(new java.awt.Dimension(1400, 800));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1360, 732));

        toolsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout toolsPanelLayout = new javax.swing.GroupLayout(toolsPanel);
        toolsPanel.setLayout(toolsPanelLayout);
        toolsPanelLayout.setHorizontalGroup(
            toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        toolsPanelLayout.setVerticalGroup(
            toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );

        mainDisplay.setBackground(new java.awt.Color(255, 102, 102));
        mainDisplay.setMaximumSize(new java.awt.Dimension(950, 700));
        mainDisplay.setMinimumSize(new java.awt.Dimension(950, 700));
        mainDisplay.setPreferredSize(new java.awt.Dimension(950, 700));
        mainDisplay.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainDisplay;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
