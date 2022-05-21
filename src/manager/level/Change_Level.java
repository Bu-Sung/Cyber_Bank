/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.level;

import cyber.bank.gui.Manager_Main;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import manager.Manager;
import user.User;

/**
 *
 * @author User
 */
public final class Change_Level extends javax.swing.JFrame {
    User user;
    Manager manager;
    LinkedList<User> userlist = new LinkedList<User>();
    LinkedList<User> changelist = new LinkedList<User>();
    Connection conn =null;
    PreparedStatement pstmt =null;
    ResultSet rs = null;
    String jdbcDriver;
    String dbUser;
    String dbPass;
    public Change_Level(Manager manager) {
        try {
            initComponents();
            this.manager = manager;
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC";
            dbUser ="banker"; //MySQL 접속 아이디
            dbPass ="1234"; //비밀번호
            checkLevel();
            addList();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Change_Level.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addList(){
        //청구 내역
        DefaultTableModel table = (DefaultTableModel)TABLE.getModel();
        table.setNumRows(0);
        for(int i =0 ;i<changelist.size();i++){ 
            Object[] list = {changelist.get(i).getName(),changelist.get(i).getId(),changelist.get(i).getLevel(),changelist.get(i).getTotal() };
            table.addRow(list);//행추가
        }
    }
    
    public void checkLevel(){;
        try{
            
            String sql = "select * from user"; //이미 저장된 혜택 지우기
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            userlist.clear();
            while(rs.next()){
               if(rs.getString("id").contains("user")){
                    user = new User(rs.getString("id"),rs.getString("name"),rs.getString("level"),rs.getInt("total"));
                    userlist.add(user);
               }
            }
            changelist.clear();
            for(int i=0; i<userlist.size();i++){
                if(userlist.get(i).getTotal()>=100000 && userlist.get(i).getTotal()<500000){//총 금액이 10만 이상 50만 이하
                    if(!userlist.get(i).getLevel().equals("Silver"))//실버 등급이 아니면
                        changelist.add(userlist.get(i));// 조정 리스트에 추가
                }else if(userlist.get(i).getTotal()>=500000 && userlist.get(i).getTotal()<1000000){
                    if(!userlist.get(i).getLevel().equals("Gold"))
                        changelist.add(userlist.get(i));
                }else if(userlist.get(i).getTotal() >= 1000000){
                    if(!userlist.get(i).getLevel().equals("Vip"))
                        changelist.add(userlist.get(i));
                }else if(userlist.get(i).getTotal() < 100000){
                    if(!userlist.get(i).getLevel().equals("Nomal"))
                        changelist.add(userlist.get(i));
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null)try{rs.close();}catch(SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    public String inputNewLevel(int total){// 총 금액에 맞는 등급을 선택
        String newlevel=null;
        if(total>=100000 && total<500000)
            newlevel = "Silver";
        else if(total>=500000 && total<1000000)
            newlevel = "Gold";
        else if(total>=1000000)
            newlevel = "Vip";
        else
            newlevel = "Nomal";
        return newlevel;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        CHANGE = new javax.swing.JButton();
        EXIT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel1.setText("등급 조정하기");

        TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "이름", "아이디", "등급", "총 금액"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TABLE);

        CHANGE.setText("변경하기");
        CHANGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHANGEActionPerformed(evt);
            }
        });

        EXIT.setText("나가기");
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CHANGE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EXIT)
                    .addComponent(CHANGE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITActionPerformed
        // TODO add your handling code here:
        //뒤로가기
        Manager_Main m = new Manager_Main(manager);
        m.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_EXITActionPerformed

    private void CHANGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGEActionPerformed
        // TODO add your handling code here:
        //회원등급 변경하기
         try{
            conn=null;
            pstmt=null;
            String sql;
            //Mysql bank 데이터베이스와 연결
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            //pstmt = conn.prepareStatement(sql);
            for(int i=0; i<changelist.size();i++){
                changelist.get(i).setLevel(inputNewLevel(changelist.get(i).getTotal()));
                sql="update user set level=? where id=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,(String)changelist.get(i).getLevel());
                pstmt.setString(2,(String)changelist.get(i).getId());
                int co = pstmt.executeUpdate();
                if(co==1)
                    System.out.println("성공");
                else
                    System.out.println("실패");
                System.out.println("-----------------");
            }
            checkLevel();
            addList();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }//GEN-LAST:event_CHANGEActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CHANGE;
    private javax.swing.JButton EXIT;
    private javax.swing.JTable TABLE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
