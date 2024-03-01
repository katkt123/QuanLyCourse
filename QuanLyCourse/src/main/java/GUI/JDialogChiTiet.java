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
        Font consoleFont = new Font(Font.MONOSPACED, Font.PLAIN, 12); // Điều chỉnh kích thước font theo nhu cầu
        textArea.setFont(consoleFont);
        
        // Đặt JTextArea vào JScrollPane để cuộn nếu cần
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Thêm JScrollPane vào JDialog
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        // Thiết lập kích thước và hiển thị JDialog
        setSize(500, 300);
        setLocationRelativeTo(parent);
    }

    // Phương thức hiển thị JDialog
    public void showDialog() {
        setVisible(true);
    }
}
