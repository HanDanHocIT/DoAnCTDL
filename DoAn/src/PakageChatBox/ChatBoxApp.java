package PakageChatBox;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBoxApp extends JFrame {
    private JPanel chatPanel;
    private JScrollPane scrollPane;
    private JTextField inputField;
    private JButton sendButton;

    public ChatBoxApp() {
        setTitle("Hộp thoại trò chuyện");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo panel chính chứa các tin nhắn
        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        chatPanel.setBackground(new Color(240, 240, 240));

        // Thêm panel cuộn cho tin nhắn
        scrollPane = new JScrollPane(chatPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Khu vực nhập liệu
        inputField = new JTextField(25);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 14));
        sendButton.setBackground(new Color(60, 179, 113));
        sendButton.setForeground(Color.WHITE);

        // Panel nhập liệu
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Thêm các thành phần vào JFrame
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Sự kiện gửi tin nhắn
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String userMessage = inputField.getText().trim();
        if (!userMessage.isEmpty()) {
            // Hiển thị tin nhắn người dùng (bên phải)
            addMessage(userMessage, true);
            // Hiển thị tin nhắn bot (bên trái)
            String botReply = generateBotReply(userMessage);
            addMessage(botReply, false);

            inputField.setText("");
            inputField.requestFocus();
        }
    }

    private void addMessage(String message, boolean isUser) {
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.setOpaque(false);

        // Tạo bong bóng tin nhắn
        JLabel messageLabel = new JLabel("<html><p style='width: 200px;'>" + message + "</p></html>");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        messageLabel.setOpaque(true);

        if (isUser) {
            messageLabel.setBackground(new Color(173, 216, 230)); // Nền xanh nhạt cho người dùng
            messageLabel.setForeground(Color.BLACK);
            messageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            messagePanel.add(messageLabel, BorderLayout.EAST);
        } else {
            messageLabel.setBackground(new Color(224, 224, 224)); // Nền xám nhạt cho bot
            messageLabel.setForeground(Color.BLACK);
            messageLabel.setHorizontalAlignment(SwingConstants.LEFT);
            messagePanel.add(messageLabel, BorderLayout.WEST);
        }

        messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Khoảng cách giữa các tin nhắn
        chatPanel.add(messagePanel);
        chatPanel.revalidate();
        chatPanel.repaint();

        // Cuộn xuống cuối cùng
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()));
    }

    private String generateBotReply(String userMessage) {
        if (userMessage.equalsIgnoreCase("hello") || userMessage.equalsIgnoreCase("hi")) {
            return "Xin chào! Tôi có thể giúp gì cho bạn?";
        } else if (userMessage.equalsIgnoreCase("how are you")) {
            return "Tôi ổn, cảm ơn bạn đã hỏi!";
        } else if (userMessage.equalsIgnoreCase("bye")) {
            return "Tạm biệt! Chúc bạn một ngày tốt lành!";
        } else if (userMessage.toLowerCase().contains("tôi muốn mua áo len")) {
            return "Chúng tôi có nhiều mẫu áo len với kiểu dáng và màu sắc khác nhau. Bạn muốn xem loại nào?";
        } else if (userMessage.toLowerCase().contains("tôi muốn mua hoa len")) {
            return "Hoa len là một lựa chọn độc đáo và bền lâu. Bạn thích hoa màu gì?";
        } else if (userMessage.toLowerCase().contains("tôi muốn mua móc khóa len")) {
            return "Móc khóa len rất xinh xắn và tiện dụng. Chúng tôi có nhiều mẫu dễ thương cho bạn lựa chọn!";
        } else if (userMessage.toLowerCase().contains("giá bao nhiêu")) {
            return "Giá cả tùy thuộc vào sản phẩm bạn chọn. Bạn có thể cho tôi biết bạn quan tâm đến mặt hàng nào không?";
        } else if (userMessage.toLowerCase().contains("cách đặt hàng")) {
            return "Để đặt hàng, bạn chỉ cần chọn sản phẩm yêu thích và cung cấp thông tin liên hệ của mình!";
        } else if (userMessage.toLowerCase().contains("chất liệu")) {
            return "Sản phẩm của chúng tôi được làm từ len cao cấp, mềm mại và an toàn cho người sử dụng.";
        } else {
            return "Xin lỗi, tôi không hiểu câu hỏi của bạn. Bạn có thể hỏi về các sản phẩm như áo len, hoa len hoặc móc khóa len nhé!";
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChatBoxApp().setVisible(true);
        });
    }
}
