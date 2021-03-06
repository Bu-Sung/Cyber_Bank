package cyber.bank;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * 시작일 : 2022-06-01
 * 완료일 : 2022-06-04
 * @author 김부성, 손진제
 * 클래스 사용 이유 : 고객의 송금 실행에 따른 잔액 변경과 그에 따른 고객의 등급 변경
 */
public class Send {
    private int money; // 송금 금액
    private String s_acc; // 송신자 계좌
    private String r_acc; //수신자 계좌
    
    //DB 사용을 위한 변수
    Connection conn =null;
    PreparedStatement pstmt =null;
    ResultSet rs =null;
    String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; 
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
    
    public Send(String s_acc, String r_acc, int money){ //유저 메인에서 송금하기 실행시 발생하는 생성자
        try {
            this.s_acc=s_acc;
            this.r_acc=r_acc;
            this.money=money;
            Class.forName("com.mysql.cj.jdbc.Driver"); //DB사용을 위한 구문
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User request(String acc){ // 유저의 최신 상태를 반환
        User user = null;
        try {
            //Mysql bank 데이터베이스와 연결
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            //유저 아이디 검색을 위해 입력 받은 계좌번호를 이용한 sql 구문
            String sql = "select * from user where id in (select id from account where account_num=?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, acc);
            rs = pstmt.executeQuery();
            if(rs.next()){
                user = new User(rs.getString("id"),rs.getString("name"),rs.getString("level"),rs.getInt("total"));
            }
            System.out.println(user.getTotal());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
        return user;
    }
    
    public boolean changeBalance(){ //각 계좌에 잔액 변경사항을 저장
        boolean succes=false;
        try {
            boolean s = false;
            boolean r = false;
            boolean s_money = false;
            int s_balance = 0;
            int r_balance = 0;
            //Mysql bank 데이터베이스와 연결
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            // 송금자 계좌 정보 확인 SQL
            String a_sql = "select account_num,balance from account where account_num=? or account_num=?";
            // 잔액 변경 SQL
            String sql = "update account set balance=? where account_num=?";
            //송금자 잔액 변경
            pstmt = conn.prepareStatement(a_sql);
            pstmt.setString(1, s_acc);
            pstmt.setString(2, r_acc);
            rs = pstmt.executeQuery(); //송금자 계좌와 수신자 계좌에 잔액이 얼마인지 검색
            while(rs.next()){
                if(rs.getString("account_num").equals(s_acc)){ //리스트에 송금자 계좌가 있는지 확인
                    s = true;
                    if((rs.getInt("balance")-money) >= 0 ){ //송금자 계좌가 송금시 잔액이 있는지 확인
                        s_money = true;
                        s_balance = rs.getInt("balance")-money; // 송금자 잔액 정보를 업데이트
                    }
                }else if(rs.getString("account_num").equals(r_acc)){ //리스트에 수신자 계좌가 있는지 확인
                    r = true;
                    r_balance = rs.getInt("balance")+money; // 수신자 잔액 정보를 업데이트
                }
            }
            if(!s){ //송금자 계좌가 없을 때
                showMessageDialog(null, "잘못된 송금자 계좌 입니다.");
            }else if(!r){// 수신자 계좌가 없을 때
                showMessageDialog(null, "잘못된 수신자 계좌 입니다.");
            }else if(!s_money){ // 잔액이 부족할 때
                showMessageDialog(null, "잔액이 부족합니다.");
            }else{ // 위 해당사항을 모두 만족 했을 때 잔액 변경을 진행
                pstmt = conn.prepareStatement(sql);
                //송신자 잔액 저장
                pstmt.setInt(1,s_balance);
                pstmt.setString(2,s_acc);
                pstmt.executeUpdate();
                //수신자 잔액 저장
                pstmt.setInt(1, r_balance);
                pstmt.setString(2,r_acc);
                pstmt.executeUpdate();
                // 각 유저 총 금액 변경
                changeTotal(s_acc);
                changeTotal(r_acc);
                showMessageDialog(null, "송금이 완료되었습니다.");
                succes = true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
        return succes;
    }
    
    public void changeTotal(String acc){ //유저의 총 금액을 변경
        try {
            //Mysql bank 데이터베이스와 연결
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            // 유저 총 금액 변경 sql - 중첩 질의를 통행 계좌로 아이디 값을 찾고 그 아이디에 해당하는 계좌에 잔액 합산한다.
            String sql = "update user set total=(select sum(balance) from account where id in (select id from account where account_num=?)) where id in (select id from account where account_num=?)";
            //송금자 잔액 변경
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, acc);
            pstmt.setString(2, acc);
            pstmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
}
