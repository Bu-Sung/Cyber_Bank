package cyber.bank;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

// 작성자 : 이수진
// 클래스 사용 이유 : 입출금 통장의 상품 중 멜론 입출금 통장에 대한 이벤트 처리를 위한 클래스

class Melon_Bankbook extends Account {

    Connection conn = null;
    PreparedStatement pstmt = null;

    public Melon_Bankbook() { //통장 정보를 스트레티지 패턴을 이용하여 반환
        // 해당 통장의 종류는 입출금 통장
        account_Type = new Bankbook();
        // card를 생성할 수 있는 상품
        with_Or_Without_Card = new With_Card();
    }

    public String benefits() {
        return "멜론입출금";
    }

    public void create_Account(User user, String pw) {
        this.user = user;
        //계좌번호 8자리 랜덤 생성
        int num = ((int) (Math.random() * 90000000) + 10000000);
        accountNumber = Integer.toString(num);
        //db 삽입을 위한

        String sql = "insert into account value(?,?,?,?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; 
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, accountNumber); // 계좌 번호 설정
            pstmt.setString(2, user.getId()); // 통장을 생성한 고객의 아이디
            pstmt.setString(3, pw); //통장 비밀번호
            pstmt.setString(4, account_Type.type()); //통장 종류
            pstmt.setString(5, benefits()); //상품 종류
            pstmt.setInt(6, 0); //잔액 초기 설정
            if(with_Or_Without_Card.card().equals("yes")){//카드 개설 가능 여부에 따라 
                pstmt.setString(7, "no");// 개설 가능시 초기값 no
            }else{
                pstmt.setString(7, null); //불가능 시 null 값 저장
            }
            int co = pstmt.executeUpdate();
            if (co == 1) {
                showMessageDialog(null, account_Type.type() + "통장이 개설 되었습니다.");
            } else {//통장 계좌 번호 중복으로인해 개설 실패시 안내메시지
                showMessageDialog(null, "자동계좌번호의 중복이 있어\n통장 개설의 실패하였습니다.\n다시 시도해주세요");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) {}
            if (conn != null) try {conn.close();} catch (SQLException ex) {}
        }
    }
}
