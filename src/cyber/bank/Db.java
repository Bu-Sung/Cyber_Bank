package cyber.bank;
import java.sql.*;

public class Db {
    Connection conn =null;
    Statement stmt =null;
    
    public void apply_Sql(String sql){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver ="jdbc:mysql://49.50.166.193:3306/bank?serverTimezone=UTC"; 
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            //Mysql bank 데이터베이스와 연결
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (stmt !=null) try { stmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
}
