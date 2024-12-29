package PakageChinhSach;
import javax.swing.*;
import java.awt.*;

public class MembershipPolicy extends JFrame {
    public MembershipPolicy() {
        setTitle("Chính Sách Thành Viên");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel policyPanel = new JPanel(new BorderLayout());
        policyPanel.setBackground(new Color(255, 245, 235)); // Nền nhẹ hơn beige

        JTextArea policyText = new JTextArea();
        policyText.setText("""
                Chính Sách Thành Viên Về Mua Bán Đồ Handmade
1. Giới Thiệu Chính Sách Thành Viên
Chào mừng bạn đến với cộng đồng mua bán đồ handmade của chúng tôi! Để tạo ra một môi trường an toàn, minh bạch và hỗ trợ tối đa cho cả người mua và người bán, chúng tôi thiết lập chính sách thành viên nhằm đảm bảo quyền lợi, trách nhiệm và sự hài lòng của tất cả các bên. Khi tham gia, bạn đồng ý tuân thủ các quy định dưới đây.
________________________________________
2. Quyền Lợi Của Thành Viên
Người Mua
•	Sản phẩm chất lượng: Các sản phẩm handmade được kiểm tra để đảm bảo chất lượng, đáp ứng các tiêu chí về nguyên liệu và thiết kế.
•	Hỗ trợ đổi trả: Đối với sản phẩm lỗi hoặc không đúng mô tả, người mua có quyền yêu cầu đổi trả theo quy định.
•	Ưu đãi đặc biệt: Thành viên thường xuyên sẽ được ưu đãi giảm giá hoặc quà tặng kèm theo khi mua hàng.
•	Dễ dàng tiếp cận: Nền tảng giúp bạn tìm kiếm sản phẩm phù hợp nhanh chóng và dễ dàng.
Người Bán
•	Không gian bán hàng: Cung cấp nền tảng miễn phí hoặc phí thấp để người bán trưng bày sản phẩm.
•	Hỗ trợ quảng bá: Giúp sản phẩm tiếp cận khách hàng thông qua các chương trình quảng bá, sự kiện hoặc bài đăng nổi bật.
•	Bảo vệ bản quyền: Cam kết bảo vệ các thiết kế độc quyền và sáng tạo của người bán.
•	Phát triển cộng đồng: Tạo cơ hội giao lưu, học hỏi giữa các nhà sản xuất đồ handmade để nâng cao kỹ năng và chất lượng sản phẩm.
________________________________________
3. Nghĩa Vụ Của Thành Viên
Người Mua
•	Tôn trọng người bán: Không yêu cầu, đòi hỏi sản phẩm ngoài phạm vi thỏa thuận hoặc phá giá.
•	Phản hồi trung thực: Cung cấp đánh giá chính xác, góp ý xây dựng cho sản phẩm và dịch vụ của người bán.
•	Thực hiện thanh toán đúng hạn: Đảm bảo thanh toán đầy đủ và đúng thời gian theo các phương thức đã thỏa thuận.
Người Bán
•	Sản phẩm đúng mô tả: Đảm bảo mô tả sản phẩm trung thực, bao gồm kích thước, chất liệu, và các chi tiết quan trọng.
•	Giá cả minh bạch: Công khai giá bán rõ ràng, tránh tăng giá bất hợp lý.
•	Thời gian giao hàng: Đảm bảo giao hàng đúng thời hạn đã cam kết.
•	Bảo mật thông tin khách hàng: Không tiết lộ thông tin cá nhân của người mua khi chưa được sự đồng ý.
________________________________________
4. Quy Tắc Ứng Xử
•	Tất cả thành viên phải tuân thủ các giá trị cốt lõi: Tôn trọng - Trung thực - Hợp tác.
•	Cấm các hành vi như gian lận, sao chép thiết kế trái phép, hoặc cung cấp thông tin sai lệch.
•	Chúng tôi khuyến khích tinh thần sáng tạo và giao lưu tích cực trong cộng đồng.
________________________________________
5. Xử Lý Vi Phạm
Trong trường hợp vi phạm chính sách, chúng tôi sẽ áp dụng các biện pháp:
•	Cảnh báo: Gửi cảnh báo trực tiếp đến thành viên vi phạm.
•	Hạn chế quyền truy cập: Đình chỉ tài khoản trong một thời gian nhất định.
•	Hủy tư cách thành viên: Xóa tài khoản nếu vi phạm nghiêm trọng hoặc tái phạm nhiều lần.
________________________________________
6. Liên Hệ Và Hỗ Trợ
Nếu bạn có bất kỳ thắc mắc hoặc cần hỗ trợ, hãy liên hệ đội ngũ của chúng tôi qua:
•	Email: nguyenvananhhan555@gmail.com
•	Hotline: 0365-403-194
Cảm ơn bạn đã tham gia và xây dựng cộng đồng đồ handmade! Chúng tôi mong muốn cùng bạn tạo nên những trải nghiệm tuyệt vời nhất.

""");
        policyText.setFont(new Font("Arial", Font.PLAIN, 14));
        policyText.setLineWrap(true);
        policyText.setWrapStyleWord(true);
        policyText.setEditable(false);
        policyText.setBackground(new Color(255, 245, 235));
        policyText.setForeground(new Color(60, 45, 40)); // Màu chữ nâu đậm

        JScrollPane scrollPane = new JScrollPane(policyText);
        policyPanel.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Đóng");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setBackground(new Color(190, 155, 123)); // Nâu nhạt
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(e -> dispose());

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.add(closeButton);
        footerPanel.setBackground(new Color(255, 245, 235));

        policyPanel.add(footerPanel, BorderLayout.SOUTH);
        add(policyPanel);
        setVisible(true);
    }
}
