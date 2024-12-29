package PakageHoaLen;
import javax.swing.*;

import java.awt.*;

public class HoaLen extends JFrame {
    public HoaLen() {
        // Thiết lập cửa sổ
        setTitle("Hoa Len - Sản phẩm Handmade");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Mảng sản phẩm mẫu
        String[][] products = {
            {"Hoa Cẩm Chướng Len", "50,000đ", "-33%", "AnhHoaLen\\hoa_cam_chuong.jpg"},
            {"Giỏ Hoa Len Handmade", "350,000đ", "-8%", "AnhHoaLen\\gio_hoa_len.jpg"},
            {"Hoa Len 5 Cánh", "450,000đ", "-18%", "AnhHoaLen\\len5canh.jpg"},
            {"Hoa Cẩm Tú Cầu Len", "225,000đ", "-30%", "AnhHoaLen\\camtucau.jpg"},
            {"Hoa Hướng Dương Len", "425,000đ", "-19%", "AnhHoaLen\\hoa_huong_duong.jpg"},
            {"Hoa Sen Len", "300,000đ", "-12%", "AnhHoaLen\\hoa_sen_len.jpg"},
            {"Hoa Hồng", "200,000đ", "-25%", "AnhHoaLen\\hoa_hong.jpg"},
            {"Hoa Tulip Len Handmade", "400,000đ", "-8%", "AnhHoaLen\\hoa_tulip_len.jpg"},
            {"Bó Hoa Lavender Len", "350,000đ", "-10%", "AnhHoaLen\\hoa_lavender.jpg"},
            {"Hoa Mẫu Đơn Len", "500,000đ", "-15%", "AnhHoaLen\\chau_hoa_mau_don.jpg"},
            {"Bouquet Len", "400,000đ", "-20%", "AnhHoaLen\\bouquet.jpg"},
            {"Hoa Linh Lan", "180,000đ", "-18%", "AnhHoaLen\\hoa_linh_lan.jpg"}
        };

        // Panel sản phẩm
        JPanel productPanel = new JPanel(new GridLayout(0, 4, 20, 20)); // Lưới: Số cột cố định, số hàng tự động
        productPanel.setBackground(new Color(255, 245, 235));
        productPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Tạo danh sách sản phẩm
        for (String[] product : products) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            itemPanel.setPreferredSize(new Dimension(250, 300)); // Kích thước cố định cho mỗi ô sản phẩm
            itemPanel.setBackground(Color.WHITE);
            itemPanel.setBorder(BorderFactory.createLineBorder(new Color(203, 182, 162)));

            // Hình ảnh sản phẩm (căn chỉnh kích thước cho vừa khung)
            ImageIcon originalIcon = new ImageIcon(product[3]);
            Image scaledImage = originalIcon.getImage().getScaledInstance(300, 370, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            itemPanel.add(imageLabel, BorderLayout.NORTH);

            // Thêm sự kiện nhấp chuột vào ảnh của sản phẩm
            if (product[0].equals("Hoa Cẩm Chướng Len")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new HoaCamChuongDetails(); // Mở giao diện chi tiết Hoa Cẩm Chướng Len
                    }
                });
            } else if (product[0].equals("Giỏ Hoa Len Handmade")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new GioHoaLenDetails(); // Mở giao diện chi tiết Giỏ Hoa Len
                    }
                });
            } else if (product[0].equals("Hoa Len 5 Cánh")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new Hoa5CanhDetails(); // Mở giao diện chi tiết Hoa Len 5 Cánh
                    }
                });
            } else if (product[0].equals("Hoa Cẩm Tú Cầu Len")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new HoaCamTuCauDetails(); // Mở giao diện chi tiết Hoa Cẩm Tú Cầu Len
                    }
                });
            } else if (product[0].equals("Hoa Hướng Dương Len")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new HoaHuongDuongDetails(); // Mở giao diện chi tiết hoa hướng dương len
                    }
                });
            } else if (product[0].equals("Hoa Sen Len")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new HoaSenLenDetails(); // Mở giao diện chi tiết Hoa Sen len
                    }
                });
            } else if (product[0].equals("Hoa Hồng")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new HoaHongDetails(); // Mở giao diện chi tiết Hoa Hồng
                    }
                });
            } else if (product[0].equals("Hoa Tulip Len Handmade")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new HoaTulipDetails(); // Mở giao diện chi tiết Hoa TulipLen
                    }
                });
            } else if (product[0].equals("Bó Hoa Lavender Len")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new HoaLavenderDetails(); // Mở giao diện chi tiết Hoa Lavender
                    }
                });
            } else if (product[0].equals("Hoa Mẫu Đơn Len")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new HoaMauDonDetails(); // Mở giao diện chi tiết Hoa Mẫu đơn
                    }
                });
            } else if (product[0].equals("Bouquet Len")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new BouquetLenDetails(); // Mở giao diện chi tiết BouquetLen
                    }
                });
            } else if (product[0].equals("Hoa Linh Lan")) {
                imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new HoaLinhLanDetails(); // Mở giao diện chi tiết Hoa LinhLan
                    }
                });
            }

            // Thông tin sản phẩm
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setBackground(Color.WHITE);

            JLabel nameLabel = new JLabel(product[0]);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            infoPanel.add(nameLabel);

            JLabel priceLabel = new JLabel(product[1]);
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            priceLabel.setForeground(new Color(60, 180, 75));
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            infoPanel.add(priceLabel);

            JLabel discountLabel = new JLabel(product[2]);
            discountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            discountLabel.setForeground(Color.RED);
            discountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            infoPanel.add(discountLabel);

            itemPanel.add(infoPanel, BorderLayout.SOUTH);
            productPanel.add(itemPanel);
        }

        // Đặt kích thước cố định cho productPanel để đảm bảo cuộn
        productPanel.setPreferredSize(new Dimension(1000, (products.length / 4 + 1) * 350));

        // Thêm productPanel vào JScrollPane
        JScrollPane scrollPane = new JScrollPane(productPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Tăng tốc độ cuộn
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        // Panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(255, 245, 235));

        // Tiêu đề
        JLabel titleLabel = new JLabel("Danh sách sản phẩm Hoa Len", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(60, 45, 40));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Thêm JScrollPane (danh sách sản phẩm) vào mainPanel
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Nút quay lại
        JButton closeButton = new JButton("Quay lại");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setBackground(new Color(190, 155, 123));
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(e -> dispose());
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(new Color(255, 245, 235));
        footerPanel.add(closeButton);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Thêm panel chính vào frame
        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HoaLen::new);
    }
}