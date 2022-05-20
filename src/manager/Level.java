
package manager;

import java.util.LinkedList;
import static javax.swing.JOptionPane.showMessageDialog;

public class Level extends javax.swing.JFrame {


    LinkedList<String> list = new LinkedList<String>();
    public Level() {
        initComponents();//화면 띄우기
    }
    
    public void insertLevel(String str){ //화면 초기화를 위한 함수
        list.clear();
        SLEVEL.setText(null);
        LEVEL.setSelectedIndex(-1);
        ONE.setSelected(false);
        TWO.setSelected(false);
        THREE.setSelected(false);
        //조정을 완료 했다는 안내 메시지
        showMessageDialog(null,str+" 등급 조정이 완료되었습니다.");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LEVEL = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SLEVEL = new javax.swing.JTextField();
        ACCEPT = new javax.swing.JButton();
        EXIT = new javax.swing.JButton();
        ONE = new javax.swing.JCheckBox();
        TWO = new javax.swing.JCheckBox();
        THREE = new javax.swing.JCheckBox();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel1.setText("등급 혜택 조정하기");

        LEVEL.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Nomal", "Silver", "Gold", "Vip" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        LEVEL.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        LEVEL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LEVELValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LEVEL);

        jLabel2.setText("등급");

        jLabel3.setText("혜택");

        jLabel5.setText("선택 등급");

        SLEVEL.setEditable(false);

        ACCEPT.setText("등록하기");
        ACCEPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACCEPTActionPerformed(evt);
            }
        });

        EXIT.setText("나가기");

        ONE.setText("캐시백 5%");

        TWO.setText("melon 굿즈 증정");

        THREE.setText("연말 행사 초대권");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(SLEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(THREE)
                                    .addComponent(EXIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ACCEPT, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(TWO, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(ONE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ONE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TWO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(THREE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SLEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ACCEPT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EXIT)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LEVELValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LEVELValueChanged
        // TODO add your handling code here:
        if(evt.getValueIsAdjusting()){ // 등급 선택시 선택된 등급을 보여준다
            SLEVEL.setText(LEVEL.getSelectedValue());
        }
    }//GEN-LAST:event_LEVELValueChanged

    private void ACCEPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACCEPTActionPerformed
        // TODO add your handling code here:
        Level_Benefits b; //혜택 값을 받기위한 변수
        User_Level l; // 등급 값을 받기위한 변수
        if(!ONE.isSelected() && !TWO.isSelected() && !THREE.isSelected()){
            // 아무것도 추가하지 않았을 때 리스트에 " " 을 추가
            list.add(" ");
        }else{
            if(ONE.isSelected()){
                // 혜택 1번이 선택 되었을 때
                b = new CashBack();
                // 리스트에 혜택 1번 추가
                list.add((String) b.getBenefits());
            }
            if(TWO.isSelected()){
                // 혜택 2번이 선택되었을 때
                b = new Goods();
                // 리스트에 혜택 2번 추가
                list.add((String) b.getBenefits());
            }
            if(THREE.isSelected()){
                // 혜택 1번이 선택되었을 때
                b = new Invitation_Ticket();
                // 리스트에 혜택 3번 추가
                list.add((String) b.getBenefits());
            }
        }
        if(SLEVEL.getText().equals("Nomal")){
            // Nomal 등급이 선택되었을 때
            // 등급 생성자를 통해 혜택리스트 넘기기
            l = new Nomal(list);
            // DB에 저장하는 함수
            l.createLevel();
            insertLevel(l.getLevel());
        }else if(SLEVEL.getText().equals("Silver")){
            // Silver 등급이 선택되었을 때
            // 등급 생성자를 통해 혜택리스트 넘기기
            l = new Silver(list);
            // DB에 저장하는 함수
            l.createLevel();
            insertLevel(l.getLevel());
        }else if(SLEVEL.getText().equals("Gold")){
            // Gold 등급이 선택되었을 때
            // 등급 생성자를 통해 혜택리스트 넘기기
            l = new Gold(list);
            // DB에 저장하는 함수
            l.createLevel();
            insertLevel(l.getLevel());
        }else if(SLEVEL.getText().equals("Vip")){
            // Vip 등급이 선택되었을 때
            // 등급 생성자를 통해 혜택리스트 넘기기
            l = new Vip(list);
            // DB에 저장하는 함수
            l.createLevel();
            insertLevel(l.getLevel());
        }else{ // 등급 선택을 하지 않았을 시
             showMessageDialog(null,"등급이 선택되지 않았습니다.");
        }
    }//GEN-LAST:event_ACCEPTActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Level().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACCEPT;
    private javax.swing.JButton EXIT;
    private javax.swing.JList<String> LEVEL;
    private javax.swing.JCheckBox ONE;
    private javax.swing.JTextField SLEVEL;
    private javax.swing.JCheckBox THREE;
    private javax.swing.JCheckBox TWO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
