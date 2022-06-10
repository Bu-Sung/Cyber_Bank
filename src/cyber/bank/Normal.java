package cyber.bank;

import static cyber.bank.Manager_Main.normalList;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 작성자 : 김부성
// 클래스 사용 이유 : 회원 등급 중 Normal에 대한 이벤트 처리

class Normal extends User_Level implements State ,Observer{
    private Insert_Event e;
    
    public Normal() { //등급 변환을 위해 사용되는 생성자
    }

    public Normal(LinkedList l) {// 등급에 대한 혜택 값 저장
        // 선택한 등급 값을 반환
        level = "Normal";
        benefits = l;
    }
    
    public  Normal(Insert_Event e) { //옵저버 리스트에 추가를 위한 생성자
        this.e=e;
        e.registerObserver(this);
    }
    
    public void update(String date, String title) {
        normalList.add(new Event(date, title));
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
            pstmt.setString(1, "Normal");
            pstmt.setString(2, user.getId());
            int co = pstmt.executeUpdate();
            if(co==1){
                System.out.println("변환");
            }else{
                System.out.println("실패");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
            if (conn != null) try {conn.close();} catch (SQLException ex) {}
        }
    }
}
