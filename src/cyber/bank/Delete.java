/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber.bank;

import java.sql.*;

/**
 * 작성일 : 2022-06-05
 * @author 김부성
 * 클래스 사용 이유 : 계좌, 카드를 삭제하는 기능을 처리한다
 */
public class Delete {
    private String acc;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    String jdbcDriver = "jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC";
    String dbUser = "banker"; //MySQL 접속 아이디
    String dbPass = "1234"; //비밀번호
    
    Delete(String acc) { //계좌 삭제
        try {
            this.acc = acc;
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void acc() {
        User user;
        State state = null;
        try {
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            
            String sql = "delete from account where account_num=?"; //계좌 삭제 sql
            String user_sql ="select * from user where id in (select id from account where account_num=?)"; //아이디 검색 sql
            //계좌 삭제
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, acc);
            pstmt.executeUpdate();
            //유저 계좌에 대한 유저 검색
            pstmt = conn.prepareStatement(user_sql);
            pstmt.setString(1, acc);
            rs = pstmt.executeQuery();
            if(rs.next()){ // 송금 기능에서 만들었던 총 금액당 레벨변경 사용
                user = new User(rs.getString("id"),rs.getString("name"),rs.getString("level"),rs.getInt("total"));
                if (user.getTotal() < 100000) { //Normal 등급
                    state = new Normal();
                } else if (user.getTotal() >= 100000 && user.getTotal() < 500000) { //Silver 등급
                    state = new Silver();
                } else if (user.getTotal() >= 500000 && user.getTotal() < 1000000) { //Gold 등급
                    state = new Gold();
                } else { // Vip 등급
                    state = new Vip();
                }
                state.changeLevel(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (rs != null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt != null) try { pstmt.close();} catch (SQLException ex) {}
            if (conn != null) try {conn.close();} catch (SQLException ex) {}
        }

        // 메인 다시 띄우기
    }

    void card() {
        try {
            //카드 삭제
            String sql = "delete from card where aNum=?"; // 카드 개설 sql
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, acc);
            pstmt.executeUpdate();
            //계좌 카드 개설에 no로 업데이트
            sql = "update account set ccard='no' where account_num=?"; //계좌 정보 변경 sql
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, acc);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstmt != null) try { pstmt.close();} catch (SQLException ex) {}
            if (conn != null) try {conn.close();} catch (SQLException ex) {}
        }
    }  
}
