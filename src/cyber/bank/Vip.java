package cyber.bank;

import static cyber.bank.Manager_Main.vipList;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 작성자 : 김부성
// 클래스 사용 이유 : Vip 등급에 대한 이벤트를 처리

class Vip extends User_Level implements State,Observer{
    private Insert_Event e;
    
    
    public Vip(){} //등급 조정을 위한 생성자
    
    public Vip(LinkedList l) {
        //등급 지정
        level= "Vip";
        //혜택 리스트 지정
        benefits = l;
    }   
    
    public  Vip(Insert_Event e) { //옵저버리스트에 추가
        this.e=e;
        e.registerObserver(this);
    }

    public void update(String date, String title) {
        vipList.add(new Event(date, title));
    }
    
    
    @Override
    public void changeLevel(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String jdbcDriver = "jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC";
        String dbUser = "banker"; //MySQL 접속 아이디
        String dbPass = "1234"; //비밀번호
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update user set level=? where id=?";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Vip");
            pstmt.setString(2, user.getId());
            pstmt.executeUpdate();
           
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
            if (conn != null) try {conn.close();} catch (SQLException ex) {}
        }
    }
}
