import javax.swing.*;

import PakageAoLen.AoLen;
import PakageAoLen.AoSwedo;
import PakageAoLen.AoSwetim;
import PakageAoLen.AoSwevang;
import PakageAoLen.Aohoodiexanh;
import PakageAoLen.Aomutrang;
import PakageAoLen.Cadigantrang;
import PakageChatBox.ChatBoxApp;
import PakageChinhSach.MembershipPolicy;
import PakageDonHang.DonHang;
import PakageGioiThieu.GioiThieu;
import PakageHoaLen.GioHoaLenDetails;
import PakageHoaLen.Hoa5CanhDetails;
import PakageHoaLen.HoaCamChuongDetails;
import PakageHoaLen.HoaCamTuCauDetails;
import PakageHoaLen.HoaHongDetails;
import PakageHoaLen.HoaHuongDuongDetails;
import PakageHoaLen.HoaLavenderDetails;
import PakageHoaLen.HoaLen;
import PakageHoaLen.HoaLinhLanDetails;
import PakageHoaLen.HoaMauDonDetails;
import PakageHoaLen.HoaSenLenDetails;
import PakageHoaLen.HoaTulipDetails;
import PakageKhoaLen.KhoaHoa;
import PakageKhoaLen.KhoaLoppy;
import PakageKhoaLen.KhoaMeo;
import PakageKhoaLen.KhoaNoel;
import PakageKhoaLen.KhoaRong;
import PakageKhoaLen.KhoaSlim;
import PakageKhoaLen.KhoaTraiTim;
import PakageKhoaLen.KhoaVoi;
import PakageKhoaLen.MocKhoaLen;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainAppPage extends JFrame {
    public MainAppPage(String username) {
        setTitle("APP BÁN HÀNG ONLINE - F4 Shop");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Màu sắc chủ đạo
        Color backgroundColor = new Color(240, 228, 216); // Beige nhạt
        Color buttonColor = new Color(190, 155, 123); // Màu nâu nhạt
        Color headerColor = new Color(203, 182, 162); // Màu nâu xám ấm

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(backgroundColor);

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(headerColor);

        JLabel logoLabel = new JLabel("F4 Shop", JLabel.LEFT);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 28));
        logoLabel.setForeground(Color.WHITE);
        headerPanel.add(logoLabel, BorderLayout.WEST);

        JTextField searchField = new JTextField(" ");
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        searchField.setBackground(Color.WHITE);
        searchField.setForeground(new Color(60, 45, 40));
        headerPanel.add(searchField, BorderLayout.CENTER);

        JButton searchButton = new JButton("Tìm kiếm");
        searchButton.setBackground(buttonColor);
        searchButton.setForeground(Color.WHITE);
        headerPanel.add(searchButton, BorderLayout.EAST);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        userPanel.setBackground(headerColor);
        JButton userIcon = new JButton(username);
        userIcon.setBackground(headerColor);
        userIcon.setForeground(Color.WHITE);
        userIcon.setFont(new Font("Arial", Font.BOLD, 14));
        userIcon.setBorderPainted(false);
        userPanel.add(userIcon);

        headerPanel.add(userPanel, BorderLayout.SOUTH);

        userIcon.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn đăng xuất?",
                    "Đăng xuất",
                    JOptionPane.YES_NO_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
                new OnlineShopApp().setVisible(true);
            }
        });

        // Danh sách sản phẩm và điều hướng
        Map<String, Runnable> productMap = new HashMap<>();
        // các loài hoa
        productMap.put("hoa len", () -> new HoaLen());
        productMap.put("hoa", () -> new HoaLen());
        productMap.put("hoa hướng dương", () -> new HoaHuongDuongDetails());
        productMap.put("giỏ hoa len ", () -> new GioHoaLenDetails());
        productMap.put("hoa 5 cánh", () -> new Hoa5CanhDetails());
        productMap.put("hoa cẩm chướng", () -> new HoaCamChuongDetails());
        productMap.put("hoa cẩm tú cầu", () -> new HoaCamTuCauDetails());
        productMap.put("hoa hồng", () -> new HoaHongDetails());
        productMap.put("hoa lavender", () -> new HoaLavenderDetails());
        productMap.put("hoa linh lan", () -> new HoaLinhLanDetails());
        productMap.put("hoa mẫu đơn", () -> new HoaMauDonDetails());
        productMap.put("hoa sen", () -> new HoaSenLenDetails());
        productMap.put("hoa tulip", () -> new HoaTulipDetails());

        // các loại móc khóa
        productMap.put("móc khóa len", () -> new MocKhoaLen());
        productMap.put("móc khóa", () -> new MocKhoaLen());
        productMap.put("móc khóa hoa", () -> new KhoaHoa());
        productMap.put(" khóa hoa", () -> new KhoaHoa());
        productMap.put("móc khóa loppy", () -> new KhoaLoppy());
        productMap.put(" khóa loppy", () -> new KhoaLoppy());
        productMap.put("loppy", () -> new KhoaLoppy());
        productMap.put("móc khóa mèo", () -> new KhoaMeo());
        productMap.put("khóa mèo", () -> new KhoaMeo());
        productMap.put("mèo", () -> new KhoaMeo());
        productMap.put("móc khóa noel", () -> new KhoaNoel());
        productMap.put("noel", () -> new KhoaNoel());
        productMap.put(" khóa noel", () -> new KhoaNoel());
        productMap.put("móc khóa rồng", () -> new KhoaRong());
        productMap.put("khóa rồng", () -> new KhoaRong());
        productMap.put("rồng", () -> new KhoaRong());
        productMap.put("móc khóa slim", () -> new KhoaSlim());
        productMap.put("khóa slim", () -> new KhoaSlim());
        productMap.put("slim", () -> new KhoaSlim());
        productMap.put("móc khóa trái tim", () -> new KhoaTraiTim());
        productMap.put("khóa trái tim", () -> new KhoaTraiTim());
        productMap.put("trái tim", () -> new KhoaTraiTim());
        productMap.put("móc khóa voi", () -> new KhoaVoi());
        productMap.put("khóa voi", () -> new KhoaVoi());
        productMap.put("voi", () -> new KhoaVoi());
        
        // các loại áo len
        productMap.put("áo len", () -> new AoLen());
        productMap.put("áo", () -> new AoLen());
        productMap.put("hoodie", () -> new Aohoodiexanh());
        productMap.put("áo hoodie", () -> new Aohoodiexanh());
        productMap.put("áo hoodie xanh", () -> new Aohoodiexanh());
        productMap.put("áo mũ trắng", () -> new Aomutrang());
        productMap.put("mũ trắng", () -> new Aomutrang());
        productMap.put("áo trắng", () -> new Aomutrang());
        productMap.put("áo sweater đỏ", () -> new AoSwedo());
        productMap.put("áo đỏ", () -> new AoSwedo());
        productMap.put("sweater đỏ", () -> new AoSwedo());
        productMap.put("áo sweater tím", () -> new AoSwetim());
        productMap.put("áo tím", () -> new AoSwetim());
        productMap.put("sweater tím", () -> new AoSwetim());
        productMap.put("áo sweater vàng", () -> new AoSwevang());
        productMap.put("sweater vàng", () -> new AoSwevang());
        productMap.put("áo vàng", () -> new AoSwevang());
        productMap.put("áo cadigan trắng", () -> new Cadigantrang());
        productMap.put("áo trắng", () -> new Cadigantrang());
        productMap.put("cadigan trắng", () -> new Cadigantrang());



        productMap.put("giới thiệu", () -> new GioiThieu());
        productMap.put("giới", () -> new GioiThieu());
        productMap.put("thiệu", () -> new GioiThieu());


        productMap.put("chính sách thành viên", () -> new MembershipPolicy());
        productMap.put("thành viên", () -> new MembershipPolicy());
        productMap.put("chính sách", () -> new MembershipPolicy());
        productMap.put("chính sách thành", () -> new MembershipPolicy());




        List<String> productList = new ArrayList<>(productMap.keySet()); // Danh sách sản phẩm

        // PopupMenu hiển thị gợi ý
        JPopupMenu suggestionMenu = new JPopupMenu();
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = searchField.getText().trim().toLowerCase();
                suggestionMenu.removeAll(); // Xóa gợi ý cũ

                if (!input.isEmpty()) {
                    boolean hasSuggestions = false; // Biến kiểm tra có gợi ý nào không

                    for (String product : productList) {
                        if (product.toLowerCase().contains(input)) { // Kiểm tra từ khóa
                            JMenuItem item = new JMenuItem(product);
                            item.setFont(new Font("Arial", Font.PLAIN, 14));
                            item.addActionListener(event -> {
                                searchField.setText(product); // Cập nhật ô tìm kiếm
                                suggestionMenu.setVisible(false); // Ẩn gợi ý
                                productMap.get(product.toLowerCase()).run(); // Điều hướng
                            });
                            suggestionMenu.add(item);
                            hasSuggestions = true;
                        }
                    }

                    if (hasSuggestions) {
                        SwingUtilities.invokeLater(() -> {
                            suggestionMenu.show(searchField, 0, searchField.getHeight());
                            searchField.requestFocusInWindow(); // Giữ tiêu điểm
                        });
                    } else {
                        suggestionMenu.setVisible(false); // Không có gợi ý thì ẩn menu
                    }
                } else {
                    suggestionMenu.setVisible(false); // Ô tìm kiếm trống thì ẩn menu
                }
            }
        });




        searchButton.addActionListener(e -> {
            String keyword = searchField.getText().trim().toLowerCase();
            Runnable action = productMap.get(keyword);
            if (action != null) {
                action.run();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Không tìm thấy sản phẩm phù hợp với từ khoá: " + keyword,
                        "Không tìm thấy",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(backgroundColor);

        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        menuPanel.setBackground(headerColor);

        // Thêm button Trang chủ ở đầu
        JButton homeButton = new JButton("Trang chủ");
        homeButton.setFont(new Font("Arial", Font.PLAIN, 16));
        homeButton.setPreferredSize(new Dimension(160, 40));
        homeButton.setBackground(buttonColor);
        homeButton.setForeground(Color.WHITE);
        homeButton.setFocusPainted(false);
        homeButton.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "Bạn đang ở Trang chủ!",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE
        ));
        menuPanel.add(homeButton);

        // Button GioiThieu
        JButton ButtonGioiThieu = new JButton("Giới Thiệu");
        ButtonGioiThieu.setFont(new Font("Arial", Font.PLAIN, 16));
        ButtonGioiThieu.setBackground(buttonColor);
        ButtonGioiThieu.setForeground(Color.WHITE);
        ButtonGioiThieu.setPreferredSize(new Dimension(160, 40));

        ButtonGioiThieu.setFocusPainted(false);
        ButtonGioiThieu.addActionListener(e -> new GioiThieu()); // Liên kết với lớp Giới Thiệu
        menuPanel.add(ButtonGioiThieu);
        
        // Các button còn lại
        JButton hoaLenButton = new JButton("Hoa Len");
        hoaLenButton.setFont(new Font("Arial", Font.PLAIN, 16));
        hoaLenButton.setBackground(buttonColor);
        hoaLenButton.setForeground(Color.WHITE);
        hoaLenButton.setPreferredSize(new Dimension(160, 40));

        hoaLenButton.setFocusPainted(false);
        hoaLenButton.addActionListener(e -> new HoaLen()); // Liên kết với lớp HoaLen
        menuPanel.add(hoaLenButton);
        
        JButton MocKhoaLenButton = new JButton("Móc Khóa Len");
        MocKhoaLenButton.setFont(new Font("Arial", Font.PLAIN, 16));
        MocKhoaLenButton.setBackground(buttonColor);
        MocKhoaLenButton.setForeground(Color.WHITE);
        MocKhoaLenButton.setPreferredSize(new Dimension(160, 40));

        MocKhoaLenButton.setFocusPainted(false);
        MocKhoaLenButton.addActionListener(e -> new MocKhoaLen()); // Liên kết với lớp Móc Khóa Len
        menuPanel.add(MocKhoaLenButton);
        
        JButton AoLenButton = new JButton("Áo Len");
        AoLenButton.setFont(new Font("Arial", Font.PLAIN, 16));
        AoLenButton.setBackground(buttonColor);
        AoLenButton.setForeground(Color.WHITE);
        AoLenButton.setPreferredSize(new Dimension(160, 40));

        AoLenButton.setFocusPainted(false);
        AoLenButton.addActionListener(e -> new AoLen()); // Liên kết với lớp Áo Len
        menuPanel.add(AoLenButton);

        // Thêm button Chính sách thành viên ở cuối
        JButton policyButton = new JButton("Chính sách thành viên");
        policyButton.setFont(new Font("Arial", Font.PLAIN, 16));
        policyButton.setPreferredSize(new Dimension(160, 40));
        policyButton.setBackground(buttonColor);
        policyButton.setForeground(Color.WHITE);
        policyButton.setFocusPainted(false);
        policyButton.addActionListener(e -> new MembershipPolicy());
        menuPanel.add(policyButton);

        contentPanel.add(menuPanel, BorderLayout.NORTH);

        JLabel imageLabel = new JLabel(new ImageIcon("anhnen.jpg"));
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setBackground(backgroundColor);
        contentPanel.add(imagePanel, BorderLayout.CENTER);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(headerColor);

        JLabel footerLabel = new JLabel("Chào mừng đến với F4 Shop", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setForeground(Color.WHITE);

        JButton chatButton = new JButton("Chat");
        chatButton.setBackground(new Color(140, 100, 80)); // Màu nâu tối hơn
        chatButton.setForeground(Color.WHITE);
        chatButton.setFont(new Font("Arial", Font.BOLD, 14));
        chatButton.addActionListener(e -> new ChatBoxApp().setVisible(true));
        
        JButton dathangButton = new JButton("Đơn Hàng");
        dathangButton.setBackground(new Color(140, 100, 80)); // Màu nâu tối hơn
        dathangButton.setForeground(Color.WHITE);
        dathangButton.setFont(new Font("Arial", Font.BOLD, 14));
        dathangButton.addActionListener(e -> new DonHang().setVisible(true));

        footerPanel.add(footerLabel, BorderLayout.CENTER);
        footerPanel.add(chatButton, BorderLayout.EAST);

        footerPanel.add(dathangButton, BorderLayout.WEST);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainAppPage("Khách hàng"));
    }
}
