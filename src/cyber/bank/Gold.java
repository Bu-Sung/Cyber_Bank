package cyber.bank;




import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Gold extends User_Level implements State{
    public Gold(){}
  public Gold(LinkedList l) {//등급 값을 저장
        level= "Gold";
        benefits = l;
  }
  public Gold(User user) {//등급 값을 저장
       
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
            pstmt.setString(1, "Gold");
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
