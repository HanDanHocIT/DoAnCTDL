package PakageGioiThieu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GioiThieu extends JFrame {

    public GioiThieu() {
        // Thiết lập cửa sổ
        setTitle("Giới Thiệu");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(255, 248, 235)); // Màu nền từ hình ảnh

        // Phần tiêu đề
        JLabel titleLabel = new JLabel("GIỚI THIỆU");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        titleLabel.setForeground(new Color(91, 60, 17)); // Màu nâu đậm
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Phần banner
        ImageIcon bannerIcon = new ImageIcon("AnhAvata\\nen.jpg"); // Đường dẫn đến ảnh banner
        Image scaledBanner = bannerIcon.getImage().getScaledInstance(850, 300, Image.SCALE_SMOOTH); // Kích thước banner
        JLabel bannerLabel = new JLabel(new ImageIcon(scaledBanner));
        bannerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bannerLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Phần giới thiệu chính
        JTextArea aboutText = new JTextArea(
                "F4 Shop là một thương hiệu với sứ mệnh mang đến những sản phẩm len chất lượng cao, tinh tế, và phù hợp với túi tiền người tiêu dùng.\n\n" +
                "Chúng tôi cam kết không chỉ cung cấp sản phẩm mà còn mang đến sự hài lòng trong từng dịch vụ. Với triết lý 'Tận Tâm - Tận Tụy - Tận Trí',\n" +
                "F4 Shop không ngừng cải tiến để đem đến trải nghiệm tốt nhất cho khách hàng.\n"
        );
        aboutText.setFont(new Font("Tahoma", Font.ITALIC, 16));
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setEditable(false);
        aboutText.setBackground(new Color(255, 248, 235)); // Màu nền trùng với màu tổng thể
        aboutText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(aboutText);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Phần đội ngũ nhân sự
        JLabel teamLabel = new JLabel("ĐỘI NGŨ NHÂN SỰ");
        teamLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        teamLabel.setForeground(new Color(91, 60, 17));
        teamLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(teamLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel teamPanel = new JPanel(new GridLayout(2, 2, 20, 20)); // Thêm khoảng cách giữa các ô
        teamPanel.setBackground(new Color(255, 248, 235));

        // 4 Ảnh nhân sự
        String[] names = {"Lê Viết Khanh", "Nguyễn Văn Anh Hàn", "Hà Phạm Thành Nhân", "Trần Hoàng Quân"};
        String[] roles = {"Marketing Manager", "CEO & Founder", "Designer", "Sales Manager"};
        String[] imagePaths = {
                "AnhAvata\\anhkhanh.jpg", // Thay đường dẫn
                "AnhAvata\\anhhan.jpg", 
                "AnhAvata\\anhnhan.jpg", 
                "AnhAvata\\anhquan.jpg"
        };

        for (int i = 0; i < 4; i++) {
            JPanel personPanel = new JPanel();
            personPanel.setLayout(new BoxLayout(personPanel, BoxLayout.Y_AXIS));
            personPanel.setBackground(new Color(255, 248, 235));

            ImageIcon personIcon = new ImageIcon(imagePaths[i]);
            Image scaledPerson = personIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Tuỳ chỉnh kích thước
            JLabel personLabel = new JLabel(new ImageIcon(scaledPerson));
            personLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel nameLabel = new JLabel(names[i]);
            nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel roleLabel = new JLabel(roles[i]);
            roleLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
            roleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            personPanel.add(personLabel);
            personPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            personPanel.add(nameLabel);
            personPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            personPanel.add(roleLabel);

            teamPanel.add(personPanel);
        }

        mainPanel.add(teamPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));
     // Thêm câu chuyện dưới phần đội ngũ nhân sự
        JLabel storyLabel = new JLabel("CÂU CHUYỆN VỀ F4 Shop");
        storyLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        storyLabel.setForeground(new Color(91, 60, 17)); // Màu nâu đậm
        storyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(storyLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JTextArea storyText = new JTextArea(
                "Ở Aimer, triết lý kinh doanh của chúng tôi chú trọng vào việc duy trì chất lượng và xây dựng uy tín nhằm mang lại những trải nghiệm mua sắm tuyệt vời nhất cho khách hàng. " +
                "Đội ngũ của chúng tôi gồm những chuyên gia giàu kinh nghiệm trong lĩnh vực LEN, đồng thời cũng là những người sáng tạo ra những sản phẩm độc đáo. " +
                "Chúng tôi tin tưởng rằng Aimer không chỉ là nơi cung cấp sản phẩm, mà còn là cầu nối giúp những tác phẩm nghệ thuật len tìm thấy chủ nhân xứng đáng, những người biết trân trọng và phát huy vẻ đẹp riêng biệt của chúng.\n\n" +
                "Mỗi tác phẩm tại Aimer không chỉ là sản phẩm, mà còn là câu chuyện về nghề len. " +
                "Chúng tôi tự hào giới thiệu những thiết kế độc đáo, mỗi một chi tiết, từ đường len đến họa tiết len tinh xảo, đều phản ánh phong cách đặc trưng và sự say mê của chúng tôi. " +
                "Sự quyến rũ độc đáo của LEN cùng với tâm huyết chúng tôi dành cho từng sản phẩm chắc chắn sẽ làm bạn mê mẩn!"
        );
        storyText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        storyText.setLineWrap(true);
        storyText.setWrapStyleWord(true);
        storyText.setEditable(false);
        storyText.setBackground(new Color(255, 248, 235)); // Màu nền trùng với màu tổng thể
        storyText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(storyText);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));


        // Phần dịch vụ
        JLabel serviceLabel = new JLabel("DỊCH VỤ CHÚNG TÔI CUNG CẤP");
        serviceLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        serviceLabel.setForeground(new Color(91, 60, 17));
        serviceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(serviceLabel);

        JTextArea servicesText = new JTextArea(
                "✔️ Cung cấp sản phẩm len chất lượng cao.\n" +
                "✔️ Tư vấn thiết kế và sản xuất theo yêu cầu.\n" +
                "✔️ Bảo hành sản phẩm trong 12 tháng.\n" +
                "✔️ Dịch vụ giao hàng toàn quốc với chính sách ưu đãi.\n"
        );
        servicesText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        servicesText.setLineWrap(true);
        servicesText.setWrapStyleWord(true);
        servicesText.setEditable(false);
        servicesText.setBackground(new Color(255, 248, 235));
        servicesText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(servicesText);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Thông tin liên hệ
        JLabel contactLabel = new JLabel("THÔNG TIN LIÊN HỆ");
        contactLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        contactLabel.setForeground(new Color(91, 60, 17));
        contactLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(contactLabel);

        JTextArea contactText = new JTextArea(
                "📍 Địa chỉ: 123 Đường ABC, Phường DEF, TP. XYZ\n" +
                "📞 Hotline: 090 123 4567\n" +
                "📧 Email: support@f4shop.com\n" +
                "🌐 Website: www.f4shop.com\n"
        );
        contactText.setFont(new Font("Arial", Font.PLAIN, 14));
        contactText.setLineWrap(true);
        contactText.setWrapStyleWord(true);
        contactText.setEditable(false);
        contactText.setBackground(new Color(255, 248, 235));
        contactText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(contactText);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        mainPanel.add(contactText);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Đoạn mã để thêm ảnh vào cuối giao diện
        JLabel footerImageLabel = new JLabel();
        ImageIcon footerImageIcon = new ImageIcon("AnhAvata\\cuoi.jpg"); // Đường dẫn đến tấm ảnh cuối
        Image scaledFooterImage = footerImageIcon.getImage().getScaledInstance(850, 400, Image.SCALE_SMOOTH); // Tuỳ chỉnh kích thước ảnh
        footerImageLabel.setIcon(new ImageIcon(scaledFooterImage));
        footerImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(footerImageLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Khoảng cách sau ảnh

        // Nút Back
        JButton backButton = new JButton("Quay Lại");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setBackground(new Color(91, 60, 17)); // Màu nâu đậm
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng cửa sổ
            }
        });
        mainPanel.add(backButton);

        // Thêm thanh cuộn cho toàn bộ nội dung
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Tốc độ cuộn
        add(scrollPane);

        // Đặt thanh cuộn về đầu
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GioiThieu::new);
    }
}
