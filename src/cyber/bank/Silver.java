package cyber.bank;


import static cyber.bank.Manager_Main.silverList;
import java.util.LinkedList;
import cyber.bank.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Silver extends User_Level implements State,Observer{
    private Insert_Event e;
    
    public Silver(){}
    public Silver(LinkedList l) {//등급 값을 저장
        level= "Silver";
        benefits = l;
    }
  
    public  Silver(Insert_Event e) {
        this.e=e;
        e.registerObserver(this);
    }

    public void update(String date, String title) {
        silverList.add(new Event(date, title));
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
            pstmt.setString(1, "Silver");
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
