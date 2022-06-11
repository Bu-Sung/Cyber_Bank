package cyber.bank;

import static cyber.bank.Manager_Main.goldList;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 작성자 : 김부성
// 클래스 사용 이유 : Gold등급에 대한 이벤트 처리를 위한 클래스

class Gold extends User_Level implements State,Observer{
    private Insert_Event e; // 공지사항 업데이트기 옵저버 리스트 추가를 위한 
    
    public Gold(){}// 고객 등급 변경시 사용되는 생성자
    
    public Gold(LinkedList l) {//고객 혜택 저장시 등급 이름과 혜택 리스트를 저장하는 생성자
        level= "Gold";
        benefits = l;
    }
        
    public  Gold(Insert_Event e) { //공지사항 등록시 등급별 옵저버를 추가하기위한 생성자
        this.e=e;
        e.registerObserver(this);
    }
    
    public void update(String date, String title) {
        goldList.add(new Event(date, title));
    }


    @Override
    public void changeLevel(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; 
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update user set level=? where id=?";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Gold");
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
