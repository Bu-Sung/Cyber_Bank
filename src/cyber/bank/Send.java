package cyber.bank;


import cyber.bank.User;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 시작일 : 2022-06-01
 * 완료일 : 2022-06-04
 * @author Kim Bu-Sung
 * 용도 : 고객의 송금 기능 구현, 고객 등급 변경
 */
public class Send {
    private int money; // 송금 금액
    private String s_acc; // 송신자 계좌
    private String r_acc; //수신자 계좌
    Connection conn =null;
    PreparedStatement pstmt =null;
    ResultSet rs =null;
    String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; //접속 URL
    String dbUser ="banker"; //MySQL 접속 아이디
    String dbPass ="1234"; //비밀번호
    
    public Send(String s_acc, String r_acc, int money){
        try {
            this.s_acc=s_acc;
            this.r_acc=r_acc;
            this.money=money;
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User request(String acc){ // 유저의 상태를 반환
        User user = null;
        try {
            //Mysql bank 데이터베이스와 연결
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            //송금자 먼저 정보를 저장
            String sql = "select * from user where id in (select id from account where account_num=?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, acc);
            rs = pstmt.executeQuery();
            if(rs.next()){
                user = new User(rs.getString("id"),rs.getString("name"),rs.getString("level"),rs.getInt("total"));
            }
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
            // 송금자 계좌 정보 저장 SQL
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
                        s_balance = rs.getInt("balance")-money;
                    }
                }else if(rs.getString("account_num").equals(r_acc)){ //리스트에 수신자 계좌가 있는지 확인
                    r = true;
                    r_balance = rs.getInt("balance")+money;
                }
            }
            if(!s){ //송금자 계좌가 없을 때
                showMessageDialog(null, "잘못된 송금자 계좌 입니다.");
            }else if(!r){// 수신자 계좌가 없을 때
                showMessageDialog(null, "잘못된 수신자 계좌 입니다.");
            }else if(!s_money){ // 잔액이 부족할 때
                showMessageDialog(null, "잔액이 부족합니다.");
            }else{
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
            // 유저 총 금액 변경 sql - 중첩 질의로 계좌에 따른 아이디 값을 불러와 변경
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
