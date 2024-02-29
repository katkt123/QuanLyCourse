/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;

public class JDialogChiTiet extends JDialog {
    public JDialogChiTiet(JFrame parent, String title, String text) {
        super(parent, title, true);
        
        // Tạo một JTextArea
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setText(text);
        textArea.setEditable(false);
        
        // Đặt JTextArea vào JScrollPane để cuộn nếu cần
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Thêm JScrollPane vào JDialog
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        // Thiết lập kích thước và hiển thị JDialog
        setSize(400, 300);
        setLocationRelativeTo(parent);
    }

    // Phương thức hiển thị JDialog
    public void showDialog() {
        setVisible(true);
    }
}
