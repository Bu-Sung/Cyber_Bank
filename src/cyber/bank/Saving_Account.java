package cyber.bank;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

// 작성자 : 이수진
// 클래스 사용 이유 : 통장에 대한 상품이 예금인것에 대한 처리

class Saving_Account extends Account {

    Connection conn = null;
    PreparedStatement pstmt = null;

    public Saving_Account() { //통장에 대한 정보를 스트레티지 패턴을 통해 저장
        // 입출금 통장
        account_Type = new Bankbook();
        // 카드 개설 가능
        with_Or_Without_Card = new With_Card();
    }

    public String benefits() {
        return "예금";
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
            pstmt.setString(2, user.getId()); //통장 생성 유저
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
            } else {
                showMessageDialog(null, "통장 개설의 실패하였습니다.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstmt != null) try { pstmt.close();} catch (SQLException ex) {}
            if (conn != null) try { conn.close();} catch (SQLException ex) {}
        }
    }
}
