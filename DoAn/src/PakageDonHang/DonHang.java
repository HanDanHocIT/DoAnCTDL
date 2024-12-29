package PakageDonHang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class DonHang extends JFrame {

    private static final String ORDERS_FILE = "orders.csv";
    private JTable ordersTable;
    private DefaultTableModel tableModel;

    public DonHang() {
        // Thiết lập cửa sổ
        setTitle("Danh Sách Đơn Hàng");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chính
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(245, 245, 220)); // Màu be
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Tiêu đề
        JLabel titleLabel = new JLabel("Danh Sách Đơn Hàng", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(34, 139, 34)); // Màu xanh lá
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Bảng hiển thị đơn hàng
        String[] columnNames = {"OrderID", "ProductName", "Name", "Phone", "Email", "Address", "Quantity", "Total", "PaymentMethod", "Note"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            // Ngăn người dùng chỉnh sửa bảng
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ordersTable = new JTable(tableModel);
        ordersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(ordersTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel nút chức năng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(245, 245, 220));

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setFont(new Font("Arial", Font.PLAIN, 14));
        refreshButton.setBackground(new Color(34, 139, 34));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFocusPainted(false);
        refreshButton.addActionListener(e -> loadOrders());
        buttonPanel.add(refreshButton);

        JButton deleteButton = new JButton("Xóa Đơn Hàng");
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 14));
        deleteButton.setBackground(new Color(178, 34, 34)); // Màu đỏ đậm
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(e -> deleteSelectedOrder());
        buttonPanel.add(deleteButton);

        JButton closeButton = new JButton("Đóng");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        closeButton.setBackground(new Color(190, 155, 123));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> dispose());
        buttonPanel.add(closeButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Thêm panel chính vào frame
        add(mainPanel);

        // Tải đơn hàng khi khởi chạy
        loadOrders();

        setVisible(true);
    }

    // Phương thức để tải đơn hàng từ file và hiển thị trong bảng
    private void loadOrders() {
        tableModel.setRowCount(0); // Xóa dữ liệu bảng hiện tại

        Path ordersPath = Paths.get(ORDERS_FILE);
        if (Files.exists(ordersPath)) {
            try (BufferedReader reader = Files.newBufferedReader(ordersPath)) {
                String line;
                boolean isFirstLine = true;
                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) { // Bỏ qua dòng tiêu đề
                        isFirstLine = false;
                        continue;
                    }
                    String[] fields = parseCSVLine(line);
                    if (fields.length == 10) {
                        tableModel.addRow(fields);
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi đọc file đơn hàng: " + ex.getMessage(),
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa có đơn hàng nào.", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Phương thức để phân tích một dòng CSV, xử lý các giá trị có chứa dấu phẩy
    private String[] parseCSVLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '\"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                tokens.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        tokens.add(current.toString());
        return tokens.toArray(new String[0]);
    }

    // Phương thức để xóa đơn hàng đã chọn
    private void deleteSelectedOrder() {
        int selectedRow = ordersTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một đơn hàng để xóa.", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String orderID = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa đơn hàng ID: " + orderID + "?",
                "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Đọc tất cả các đơn hàng, loại bỏ đơn hàng có OrderID trùng
        List<String> remainingOrders = new ArrayList<>();
        Path ordersPath = Paths.get(ORDERS_FILE);
        if (Files.exists(ordersPath)) {
            try (BufferedReader reader = Files.newBufferedReader(ordersPath)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống
                    if (line.startsWith("OrderID")) { // Bỏ qua dòng tiêu đề
                        remainingOrders.add(line);
                        continue;
                    }
                    String currentOrderID = line.split(",")[0];
                    if (!currentOrderID.equals(orderID)) {
                        remainingOrders.add(line);
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi đọc file đơn hàng: " + ex.getMessage(),
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Ghi lại các đơn hàng còn lại vào file
            try (BufferedWriter writer = Files.newBufferedWriter(ordersPath)) {
                for (String orderLine : remainingOrders) {
                    writer.write(orderLine);
                    writer.newLine();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi ghi file đơn hàng: " + ex.getMessage(),
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this, "Đơn hàng đã được xóa thành công.", "Thành công",
                    JOptionPane.INFORMATION_MESSAGE);
            loadOrders(); // Cập nhật lại bảng
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DonHang::new);
    }
}
