import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class OnlineShopApp extends JFrame {
    private ArrayList<User> users; // Danh sách người dùng

    public OnlineShopApp() {
        users = new ArrayList<>();
        loadUsers(); // Tải danh sách người dùng từ tệp
        initLoginUI();
    }

    // Giao diện đăng nhập
    private void initLoginUI() {
        setTitle("APP BÁN HÀNG ONLINE - Đăng Nhập");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Màu sắc chủ đạo
        Color backgroundColor = new Color(240, 228, 216); // Beige nhạt
        Color buttonColor = new Color(190, 155, 123); // Nâu nhạt
        Color headerColor = new Color(203, 182, 162); // Nâu xám ấm
        Color textColor = new Color(60, 45, 40); // Chữ nâu đậm

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(backgroundColor);

        JLabel title = new JLabel("APP BÁN HÀNG ONLINE", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(headerColor);
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = new JLabel("User Name:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameLabel.setForeground(textColor);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15);
        usernameField.setBorder(BorderFactory.createLineBorder(headerColor));
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setForeground(textColor);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBorder(BorderFactory.createLineBorder(headerColor));
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(passwordField, gbc);

        JButton loginButton = createStyledButton("Sign In", buttonColor, Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(loginButton, gbc);

        JButton registerButton = createStyledButton("Register", new Color(140, 100, 80), Color.WHITE); // Tông nâu tối
        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(registerButton, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JButton exitButton = createStyledButton("Exit", new Color(220, 198, 185), textColor); // Nút "Exit" màu nhạt hơn
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(backgroundColor);
        footerPanel.add(exitButton);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Sự kiện cho các nút
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticateUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "Welcome " + username + "!");
                    dispose();
                    new MainAppPage(username); // Chuyển sang lớp MainAppPage
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegisterUI();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Hiển thị giao diện đăng ký
    private void showRegisterUI() {
        JFrame registerFrame = new JFrame("APP BÁN HÀNG ONLINE - Đăng Ký");
        registerFrame.setSize(500, 450);
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerFrame.setLocationRelativeTo(null);

        // Màu sắc chủ đạo
        Color backgroundColor = new Color(240, 228, 216);
        Color buttonColor = new Color(190, 155, 123);
        Color headerColor = new Color(203, 182, 162);
        Color textColor = new Color(60, 45, 40);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = new JLabel("User Name:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameLabel.setForeground(textColor);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15);
        usernameField.setBorder(BorderFactory.createLineBorder(headerColor));
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(usernameField, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setForeground(textColor);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(emailLabel, gbc);

        JTextField emailField = new JTextField(15);
        emailField.setBorder(BorderFactory.createLineBorder(headerColor));
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setForeground(textColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBorder(BorderFactory.createLineBorder(headerColor));
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(passwordField, gbc);

        JButton registerButton = createStyledButton("Register", buttonColor, Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(registerButton, gbc);

        registerFrame.add(mainPanel);
        registerFrame.setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    users.add(new User(username, email, password));
                    saveUsers(); // Lưu danh sách người dùng vào tệp
                    JOptionPane.showMessageDialog(registerFrame, "Registration successful!");
                    registerFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(registerFrame, "Please fill all fields!");
                }
            }
        });
    }

    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            users = (ArrayList<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing user data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JButton createStyledButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(bgColor.darker()));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        return button;
    }

    private boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    static class User implements Serializable {
        private String username;
        private String email;
        private String password;

        public User(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OnlineShopApp().setVisible(true);
        });
    }
}