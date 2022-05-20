package manager;

import java.sql.*;
import java.sql.SQLException;
import java.util.LinkedList;

class User_Level {
    protected String level;
    protected LinkedList benefits;
    Connection conn =null;
    PreparedStatement pstmt =null;

    public String getLevel() {
        return level;
    }
    
    public String gettBenefits() {
        return " ";
    }

    public void createLevel() { //각 등급에 맞게 혜택을 저장
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             //접속 URL
            String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; 
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            String sql = "delete from level where level=?"; //이미 저장된 혜택 지우기
            //Mysql bank 데이터베이스와 연결
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, level);
            int co = pstmt.executeUpdate();
            if(co==1){
                System.out.println("delete");
            }else{
                System.out.println("delete failed");
            }
            sql = "insert into level value(?,?)";
            pstmt = conn.prepareStatement(sql);
            // 리스트에 저장되어 있는 혜택을 저장하기
            for(int i = 0; i<benefits.size();i++){
                pstmt.setString(1, level);
                pstmt.setString(2, (String) benefits.get(i));
                int a = pstmt.executeUpdate();
                if(a==1)
                    System.out.println("into data");
                else
                    System.out.println("fail into data");
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }

}
