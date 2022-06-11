
package bankstart;

import cyber.bank.Manager;
import cyber.bank.Manager_Main;
import cyber.bank.User;
import cyber.bank.User_Main;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login_Frame extends javax.swing.JFrame {
    Connection conn =null;
    PreparedStatement pstmt =null;
    ResultSet rs = null;
    String sql;
    
    public Login_Frame() {
        initComponents();
       
    }
    
    public boolean checkPw() throws SQLException{
        boolean a=false;
        String pw = new String(PW.getPassword());
        rs = pstmt.executeQuery();
        if(rs.next()){
            if(rs.getString("pw").equals(pw)){
                a=true;
            }
        }else{
            showMessageDialog(null,"아이디 오류입니다.");
        }
        return a;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        PW = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        login_btn = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("로그인");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel1.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel1.setText("메론 은행");

        jLabel2.setText("ID :");
        jLabel2.setToolTipText("");

        jLabel3.setText("PW :");

        login_btn.setText("로그인");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        exit.setText("나가기");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(login_btn)
                        .addGap(6, 6, 6)
                        .addComponent(exit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PW, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_btn)
                    .addComponent(exit))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //나가기
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    //로그인 버튼
    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        // TODO add your handling code here:
        boolean check;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; 
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            //Mysql bank 데이터베이스와 연결
            
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            if(ID.getText().contains("user")){
                sql = "select * from user where id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, ID.getText());
                check = checkPw();
                if(check){
                    User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("level"),rs.getInt("total"));
                    User_Main u = new User_Main(user);
                    u.setVisible(true); //유저 메인페이지로 이동
                    setVisible(false);
                }else{
                    showMessageDialog(null,"비밀번호 오류입니다.");
                }
            }else if(ID.getText().contains("manager")){
                sql = "select * from manager where id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, ID.getText());
                check = checkPw();
                if(check){
                    Manager manager = new Manager(rs.getString("id"),rs.getString("name"));
                    Manager_Main u = new Manager_Main(manager);//관리자 메인 페이지로 이동
                    u.setVisible(true);
                    setVisible(false);
                }else{
                    showMessageDialog(null,"비밀번호 오류입니다.");
                }
            }else{
                showMessageDialog(null,"아이디 오류입니다.");
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs != null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }//GEN-LAST:event_login_btnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JPasswordField PW;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_btn;
    // End of variables declaration//GEN-END:variables
}
