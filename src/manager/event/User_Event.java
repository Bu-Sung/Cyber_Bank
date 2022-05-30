package manager.event;




import java.sql.*;

class User_Event implements Observer {
    private Insert_Event e;
    Connection conn =null;
    PreparedStatement pstmt =null;
    
    public  User_Event(Insert_Event e) {
        this.e=e;
        e.registerObserver(this);
    }

    public void update(String datetostr, String title, String news, String writer) {
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC";
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            String sql = "insert into user_news value (?,?,?)"; //이미 저장된 혜택 지우기
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, datetostr);
            pstmt.setString(2,title);
            pstmt.setString(3, news);
            pstmt.executeUpdate();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
}


