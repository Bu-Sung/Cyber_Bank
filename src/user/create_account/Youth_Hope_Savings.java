package user.create_account;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import user.User;

class Youth_Hope_Savings extends Account {

    Connection conn = null;
    PreparedStatement pstmt = null;

    public Youth_Hope_Savings() {
        account_Type = new Installment_Savings();
        with_Or_Without_Card = new Without_Card();
    }

    public String benefits() {
        return "청년희망적금";
    }

    public void create_Account(User user, String pw) {
        this.user = user;
        //계좌번호 8자리 랜덤 생성
        int num = ((int) (Math.random() * 90000000) + 10000000);
        accountNumber = Integer.toString(num);
        //db 삽입을 위한

        String sql = "insert into account value(?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver = "jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC";
            String dbUser = "banker"; //MySQL 접속 아이디
            String dbPass = "1234"; //비밀번호
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, accountNumber); // 계좌 번호 설정
            pstmt.setString(2, user.getId());
            pstmt.setString(3, pw);
            pstmt.setString(4, account_Type.type());
            pstmt.setString(5, with_Or_Without_Card.card());
            pstmt.setString(6, benefits());
            pstmt.setInt(7, 0); //잔액 초기 설정
            pstmt.setString(8, null);
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
            if (conn != null) try { conn.close();} catch (SQLException ex) { }
        }
    }
}
