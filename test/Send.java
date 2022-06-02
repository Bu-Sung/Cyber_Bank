
import user.User;

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
 *2022-06-01
 * @author Kim Bu-Sung
 * 용도 : 고객의 송금 기능 구현
 */
public class Send {
    private User s_user; // 송신자 고객
    private User r_user; // 수신자 고객
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
            changeBalance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void request_level(){ // 송, 수신자의 정보를 객체에 저장
        try {
            //Mysql bank 데이터베이스와 연결
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            //송금자 먼저 정보를 저장
            String sql = "select * from user where id in (select id from account where account_num=?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, s_acc);
            rs = pstmt.executeQuery();
            if(rs.next()){
                s_user = new User(rs.getString("id"),rs.getString("name"),rs.getString("level"),rs.getInt("total"));
                s_user.setTotal(s_user.getTotal()-money);
            }else{
                showMessageDialog(null, "잘못된 송금자 계좌 입니다.");
            }
            // 수신자 정보를 저장 (같은 sql문을 사용한다)
            pstmt.setString(1, r_acc);
            rs = pstmt.executeQuery();
            if(rs.next()){
                r_user = new User(rs.getString("id"),rs.getString("name"),rs.getString("level"),rs.getInt("total"));
                r_user.setTotal(r_user.getTotal()+money);
            }else{
                showMessageDialog(null, "잘못된 수신자 계좌 입니다.");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    public void setLevel(){ // 송금 후 고객의 총 금액에 따라 등급과 맞는지 확인
        String u_s_level = getLevel(s_user); 
        String u_r_level = getLevel(r_user);
        State state;
        //송금자 등급 확인
        if(!s_user.getLevel().equals(u_s_level)){
            if(u_s_level.equals("Normal")){
                state= new Normal(s_user);
            }else if(u_s_level.equals("Silver")){
                state= new Silver(s_user);
            }else if(u_s_level.equals("Gold")){
                state= new Gold(s_user);
            }else if(u_s_level.equals("Vip")){
                state= new Vip(s_user);
            }
        }
        // 수신자 등급 확인
        if(!r_user.getLevel().equals(u_r_level)){
            if(u_r_level.equals("Normal")){
                state= new Normal(r_user);
            }else if(u_r_level.equals("Silver")){
                state= new Silver(r_user);
            }else if(u_r_level.equals("Gold")){
                state= new Gold(r_user);
            }else if(u_r_level.equals("Vip")){
                state= new Vip(r_user);
            }
        }
    }
    
    public String getLevel(User user){ // 변화된 총 금액에 따른 등급을 확인한다.
        if(user.getTotal()<100000){
            return "Normal";
        }else if(user.getTotal()>=100000 && user.getTotal()<500000){
            return "Silver";
        }else if(user.getTotal()>=500000 && user.getTotal()<1000000){
            return "Gold";
        }else{
            return "Vip";
        }
    }
    
    public void changeBalance(){
        request_level();
        setLevel();
    }
}
