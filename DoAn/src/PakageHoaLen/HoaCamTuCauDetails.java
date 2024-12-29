package PakageHoaLen;

import javax.swing.*;

import PakageDonHang.DonHang;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HoaCamTuCauDetails extends JFrame {

    private static final String PRODUCT_NAME = "Hoa Cẩm Tú Cầu Len";
    private static final String ORDERS_FILE = "orders.csv";

    public HoaCamTuCauDetails() {
        // Thiết lập cửa sổ
        setTitle("Chi tiết sản phẩm - " + PRODUCT_NAME);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chính
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(245, 245, 220)); // Màu be (beige)
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Tiêu đề
        JLabel titleLabel = new JLabel(PRODUCT_NAME, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 28));
        titleLabel.setForeground(new Color(34, 139, 34)); // Màu xanh lá
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel nội dung chính
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBackground(new Color(245, 245, 220));

        // Ảnh sản phẩm
        ImageIcon originalIcon = new ImageIcon("AnhHoaLen\\camtucau.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(imageLabel, BorderLayout.WEST);

        // Thông tin sản phẩm
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(245, 245, 220));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel priceLabel = new JLabel("Giá: 225,000đ  (Giảm 30%)");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        priceLabel.setForeground(new Color(34, 139, 34));
        infoPanel.add(priceLabel);

        JLabel detailsLabel = new JLabel("<html>"
        		+ "Mã sản phẩm: BHCL05<br>"
                + "Giá niêm yết: 293,000đ<br>"
                + "Kích thước: 15x30cm<br>"
                + "Chất liệu: Len milk<br>"
                + "Xuất xứ: Việt Nam"

                + "</html>");
        detailsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        detailsLabel.setForeground(new Color(85, 85, 85));
        infoPanel.add(detailsLabel);

        JLabel descriptionLabel = new JLabel("<html>"
                + "<br><b>Miêu tả:</b><br>"
                + "<br><b>Miêu tả:</b><br>"
                + "Hoa cẩm tú cầu len được làm hoàn toàn thủ công từ sợi len cotton cao cấp. "
                + "Sản phẩm mang vẻ đẹp tự nhiên, phù hợp để làm quà tặng hoặc trang trí không gian sống. "
                + "Đây là lựa chọn hoàn hảo để thể hiện tình cảm và sự trân trọng dành cho người nhận.<br><br>"                + "</html>");

        descriptionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        descriptionLabel.setForeground(new Color(85, 107, 47));
        infoPanel.add(descriptionLabel);

        contentPanel.add(infoPanel, BorderLayout.CENTER);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Panel nút chức năng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(245, 245, 220));

        JButton backButton = new JButton("Quay lại");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(new Color(190, 155, 123));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> dispose());
        buttonPanel.add(backButton);

        JButton orderButton = new JButton("Đặt hàng ngay");
        orderButton.setFont(new Font("Arial", Font.BOLD, 25));
        orderButton.setBackground(new Color(34, 139, 34));
        orderButton.setForeground(Color.WHITE);
        orderButton.setFocusPainted(false);
        orderButton.addActionListener(e -> openOrderForm());
        buttonPanel.add(orderButton);

        // Thêm nút "Xem Đơn Hàng"
        JButton viewOrdersButton = new JButton("Xem Đơn Hàng");
        viewOrdersButton.setFont(new Font("Arial", Font.PLAIN, 14));
        viewOrdersButton.setBackground(new Color(70, 130, 180));
        viewOrdersButton.setForeground(Color.WHITE);
        viewOrdersButton.setFocusPainted(false);
        viewOrdersButton.addActionListener(e -> new DonHang());
        buttonPanel.add(viewOrdersButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Thêm panel chính vào frame
        add(mainPanel);
        setVisible(true);
    }

    private void openOrderForm() {
        // Tạo cửa sổ đặt hàng mới
        JFrame orderFrame = new JFrame("Đặt mua " + PRODUCT_NAME);
        orderFrame.setSize(800, 600);
        orderFrame.setLocationRelativeTo(this);

        JPanel orderPanel = new JPanel(new BorderLayout(10, 10));
        orderPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        orderPanel.setBackground(new Color(0xffe3e3)); // Màu hồng nhạt

        // Ảnh sản phẩm bên trái
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(0xffe3e3));

        ImageIcon imageIcon = new ImageIcon("AnhHoaLen\\camtucau.jpg");
        Image scaledImage = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel productNameLabel = new JLabel(PRODUCT_NAME);
        productNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        productNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(imageLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(productNameLabel);

        orderPanel.add(leftPanel, BorderLayout.WEST);

        // Form đặt hàng bên phải
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(0xffe3e3));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Họ và tên:");
        JTextField nameField = new JTextField();
        JLabel phoneLabel = new JLabel("Số điện thoại:");
        JTextField phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel addressLabel = new JLabel("Địa chỉ:");
        JTextArea addressField = new JTextArea(2, 20);
        JScrollPane addressScrollPane = new JScrollPane(addressField);
        JLabel noteLabel = new JLabel("Ghi chú:");
        JTextArea noteField = new JTextArea(2, 20);
        JScrollPane noteScrollPane = new JScrollPane(noteField);

        JLabel quantityLabel = new JLabel("Số lượng:");
        SpinnerNumberModel quantityModel = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner quantitySpinner = new JSpinner(quantityModel);
        JLabel totalLabel = new JLabel("Tổng: 225,000đ");
        quantitySpinner.addChangeListener(e -> {
            int quantity = (Integer) quantitySpinner.getValue();
            long total = quantity * 225000; // Giá giả định 200,000đ mỗi đơn vị
            totalLabel.setText("Tổng: " + String.format("%,d", total) + "đ");
        });

        JLabel paymentLabel = new JLabel("Hình thức thanh toán:");
        JRadioButton bankTransfer = new JRadioButton("Chuyển khoản ngân hàng");
        JRadioButton cod = new JRadioButton("Trả tiền mặt khi nhận hàng");
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(bankTransfer);
        paymentGroup.add(cod);

        JButton confirmButton = new JButton("Xác nhận");
        confirmButton.setBackground(new Color(34, 139, 34));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(e -> {
            String paymentMethod = bankTransfer.isSelected() ? bankTransfer.getText() :
                    (cod.isSelected() ? cod.getText() : "Chưa chọn");
            saveOrderInfo(
                    PRODUCT_NAME,
                    nameField.getText(),
                    phoneField.getText(),
                    emailField.getText(),
                    addressField.getText(),
                    (Integer) quantitySpinner.getValue(),
                    totalLabel.getText(),
                    paymentMethod,
                    noteField.getText()
            );
            JOptionPane.showMessageDialog(orderFrame, "Đặt hàng thành công!");
            orderFrame.dispose();
        });

        JButton cancelButton = new JButton("Hủy đơn");
        cancelButton.setBackground(new Color(190, 155, 123));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(orderFrame, "Bạn có chắc muốn hủy đơn?", "Xác nhận hủy",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                orderFrame.dispose();
            }
        });

        // Sắp xếp các thành phần trong GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(addressScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(noteLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(noteScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(quantityLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(quantitySpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(totalLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(paymentLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(bankTransfer, gbc);
        gbc.gridy = 8;
        formPanel.add(cod, gbc);

        orderPanel.add(formPanel, BorderLayout.CENTER);

        // Panel nút chức năng đặt hàng
        JPanel orderButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        orderButtonPanel.setBackground(new Color(0xffe3e3));
        orderButtonPanel.add(confirmButton);
        orderButtonPanel.add(cancelButton);

        orderPanel.add(orderButtonPanel, BorderLayout.SOUTH);

        orderFrame.add(orderPanel);
        orderFrame.setVisible(true);
    }

    private void saveOrderInfo(String productName, String name, String phone, String email, String address,
                               int quantity, String total, String paymentMethod, String note) {
        String orderID = generateOrderID();
        String csvLine = String.join(",",
                orderID,
                escapeCSV(productName),
                escapeCSV(name),
                escapeCSV(phone),
                escapeCSV(email),
                escapeCSV(address),
                String.valueOf(quantity),
                total.replace(",", ""), // Remove commas in total
                escapeCSV(paymentMethod),
                escapeCSV(note)
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDERS_FILE, true))) {
            // If file is empty, write header first
            if (new java.io.File(ORDERS_FILE).length() == 0) {
                writer.write("OrderID,ProductName,Name,Phone,Email,Address,Quantity,Total,PaymentMethod,Note");
                writer.newLine();
            }
            writer.write(csvLine);
            writer.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu đơn hàng: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String generateOrderID() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.now().format(formatter);
    }

    private String escapeCSV(String value) {
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            value = value.replace("\"", "\"\"");
            value = "\"" + value + "\"";
        }
        return value;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HoaCamTuCauDetails::new);
    }
}
