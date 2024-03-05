/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class JDialogChiTiet extends JDialog {
    private JTextPane textPane;
    private JTextField searchField;
    
    public JDialogChiTiet(JFrame parent, String title, String text) {
        super(parent, title, true);
        
        // Tạo một JTextArea
        textPane = new JTextPane();
        textPane.setText(text);
        textPane.setEditable(false);
        Font consoleFont = new Font(Font.MONOSPACED, Font.PLAIN, 12); // Điều chỉnh kích thước font theo nhu cầu
        
        // Tạo Style mặc định
        Style defaultStyle = textPane.addStyle("DefaultStyle", null);
        StyleConstants.setForeground(defaultStyle, Color.BLACK);

        textPane.setFont(consoleFont);
        
        searchField = new JTextField(20);
        
        searchField.setForeground(Color.GRAY); // Thiết lập màu chữ mặc định là màu xám
        searchField.setText(" Search...."); // Thiết lập gợi ý mặc định
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                performSearch();
            }
        });
        // Thêm sự kiện focus listener để xử lý hiển thị và ẩn gợi ý
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals(" Search....")) {
                    searchField.setText(""); 
                    searchField.setForeground(Color.BLACK); 
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText(" Search...."); 
                    searchField.setForeground(Color.GRAY); 
                }
            }
        });

        
        // Đặt JTextArea vào JScrollPane để cuộn nếu cần
        JScrollPane scrollPane = new JScrollPane(textPane);
        
        // Thêm JScrollPane vào JDialog
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        getContentPane().add(searchField, BorderLayout.SOUTH);
        
        // Thiết lập kích thước và hiển thị JDialog
        setSize(500, 500);
        setLocationRelativeTo(parent);
    }
    private void performSearch() {
    // Lấy từ khóa tìm kiếm từ JTextField
    String keyword = searchField.getText().trim();

    // Nếu từ khóa không rỗng thì thực hiện tìm kiếm và đổi màu chữ
    if (!keyword.isEmpty()) {
        // Xóa tất cả các thuộc tính định dạng văn bản đã được thiết lập
        resetTextFormat();

        // Tìm kiếm và thay đổi màu chữ và màu nền cho các từ khớp với từ khóa
        highlightText(keyword, Color.WHITE, Color.BLUE);
    } else {
        // Nếu không có từ khóa, đặt các thuộc tính văn bản trở lại trạng thái ban đầu
        resetTextFormat();
    }
}
    private void resetTextFormat() {
        StyledDocument doc = textPane.getStyledDocument();
        Style defaultStyle = textPane.getStyle("DefaultStyle");
        doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, true);
    }
    private String removeNewLines(String text) {
        text = text.replaceAll("\n", " ");
        return text;
    }

    // Phương thức để đổi màu chữ cho từ khóa và đổi màu nền của văn bản
private void highlightText(String keyword, Color textColor, Color bgColor) {
    keyword = keyword.toLowerCase();
    StyledDocument doc = textPane.getStyledDocument();
    String text = textPane.getText().toLowerCase();
    text = removeNewLines(text);
    int index = text.indexOf(keyword);
    while (index >= 0) {
        try {
            // Tạo một Style mới với màu chữ mong muốn
            Style highlightStyle = textPane.addStyle("HighlightStyle", null);
            StyleConstants.setForeground(highlightStyle, textColor);

            // Tạo một Style mới để đặt màu nền
            Style bgStyle = textPane.addStyle("BgStyle", null);
            StyleConstants.setBackground(bgStyle, bgColor);

            // Áp dụng Style mới cho từ khớp
            doc.setCharacterAttributes(index, keyword.length(), highlightStyle, false);
            doc.setCharacterAttributes(index, keyword.length(), bgStyle, false);

            // Tiếp tục tìm kiếm từ khóa tiếp theo
            index = text.indexOf(keyword, index + 1);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

    // Phương thức hiển thị JDialog
    public void showDialog() {
        setVisible(true);
    }
}
