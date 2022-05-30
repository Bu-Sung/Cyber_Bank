/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import cyber.bank.gui.Event_View;
import cyber.bank.gui.Login_Frame;
import user.create_account.Create_account;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class User_Main extends javax.swing.JFrame {
    DefaultTableModel table;
    Connection conn =null;
    PreparedStatement pstmt =null;
    ResultSet rs = null;
    User user;
    /**
     * Creates new form test
     */
    public User_Main(User user) {
            initComponents();
            this.user = user;
            NAME.setText(user.getName());
            LEVEL.setText(user.getLevel());
            removeAll();
            MAIN_P.setVisible(true);
            createMain();
    }
    
    
    public void removeAll(){
        CREATE_P.setVisible(false);
        EVENT_P.setVisible(false);
        MAIN_P.setVisible(false);
        SEND_P.setVisible(false);
        PRODUCT_P.setVisible(false);
        CREATE_C_P.setVisible(false);
    }
    
    public void createProduct(String kind){
        DefaultTableModel model = (DefaultTableModel) P_TABLE.getModel();
        model.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; 
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            //Mysql bank 데이터베이스와 연결
            String sql = "select * from product where kind=?";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kind);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Object[] list = {rs.getString("product"), rs.getString("kind")}; 
                model.addRow(list);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    public void createMain(){ //메인 패널에 있는 보유 계좌 테이블 출력
        table = (DefaultTableModel) A_TABLE.getModel();
        table.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; 
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            //Mysql bank 데이터베이스와 연결
            String sql = "select * from account where id=?";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            rs = pstmt.executeQuery();
            while(rs.next()){
                Object[] list = {rs.getString("account_num"), rs.getString("balance"),rs.getString("kind") ,rs.getString("ccard") }; 
                table.addRow(list);
            }
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        MAIN_P = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        A_TABLE = new javax.swing.JTable();
        SEND_P = new javax.swing.JPanel();
        TITLE_P = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MENU_P = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NAME = new javax.swing.JLabel();
        LEVEL = new javax.swing.JLabel();
        CREATE = new javax.swing.JButton();
        EVENT = new javax.swing.JButton();
        SEND = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        CREATE_C = new javax.swing.JButton();
        EVENT_P = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        E_TABLE = new javax.swing.JTable();
        CREATE_P = new javax.swing.JPanel();
        CREATE_N = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        C_NAME = new javax.swing.JTextField();
        C_ID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        C_PW = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        C_KIND = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        P_TABLE = new javax.swing.JTable();
        PRODUCT_P = new javax.swing.JPanel();
        CREATE_C_P = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("메론소다");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));

        jPanel4.setMinimumSize(new java.awt.Dimension(700, 200));
        jPanel4.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MAIN_P.setBackground(new java.awt.Color(255, 255, 255));

        A_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "계좌 번호", "잔액", "종류", "카드 개설"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        A_TABLE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        A_TABLE.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(A_TABLE);

        javax.swing.GroupLayout MAIN_PLayout = new javax.swing.GroupLayout(MAIN_P);
        MAIN_P.setLayout(MAIN_PLayout);
        MAIN_PLayout.setHorizontalGroup(
            MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        MAIN_PLayout.setVerticalGroup(
            MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.add(MAIN_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, 400));

        SEND_P.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout SEND_PLayout = new javax.swing.GroupLayout(SEND_P);
        SEND_P.setLayout(SEND_PLayout);
        SEND_PLayout.setHorizontalGroup(
            SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        SEND_PLayout.setVerticalGroup(
            SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel4.add(SEND_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, 400));

        TITLE_P.setBackground(new java.awt.Color(204, 255, 204));
        TITLE_P.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TITLE_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TITLE_PMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("함초롬돋움", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MelonSoda Bank");

        javax.swing.GroupLayout TITLE_PLayout = new javax.swing.GroupLayout(TITLE_P);
        TITLE_P.setLayout(TITLE_PLayout);
        TITLE_PLayout.setHorizontalGroup(
            TITLE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLE_PLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        TITLE_PLayout.setVerticalGroup(
            TITLE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLE_PLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        jPanel4.add(TITLE_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        MENU_P.setBackground(new java.awt.Color(247, 247, 247));
        MENU_P.setPreferredSize(new java.awt.Dimension(150, 400));

        jLabel2.setText("님");

        NAME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NAME.setText("고객");

        LEVEL.setFont(new java.awt.Font("굴림", 1, 15)); // NOI18N
        LEVEL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LEVEL.setText("Normal");

        CREATE.setText("계좌 개설하기");
        CREATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREATEActionPerformed(evt);
            }
        });

        EVENT.setText("공지사항확인");
        EVENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EVENTActionPerformed(evt);
            }
        });

        SEND.setText("송금하기");
        SEND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SENDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel3.setText("메뉴");

        LOGOUT.setText("로그아웃");
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });

        CREATE_C.setText("카드 개설하기");
        CREATE_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREATE_CActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MENU_PLayout = new javax.swing.GroupLayout(MENU_P);
        MENU_P.setLayout(MENU_PLayout);
        MENU_PLayout.setHorizontalGroup(
            MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU_PLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU_PLayout.createSequentialGroup()
                                .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(LEVEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
            .addGroup(MENU_PLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SEND, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EVENT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CREATE, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(CREATE_C, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        MENU_PLayout.setVerticalGroup(
            MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_PLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LEVEL)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(22, 22, 22)
                .addComponent(CREATE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EVENT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SEND)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CREATE_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(LOGOUT)
                .addGap(29, 29, 29))
        );

        jPanel4.add(MENU_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        EVENT_P.setBackground(new java.awt.Color(255, 255, 255));
        EVENT_P.setPreferredSize(new java.awt.Dimension(550, 400));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        E_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "일시", "제목"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        E_TABLE.setGridColor(new java.awt.Color(204, 204, 204));
        E_TABLE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        E_TABLE.setShowHorizontalLines(false);
        E_TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E_TABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(E_TABLE);

        javax.swing.GroupLayout EVENT_PLayout = new javax.swing.GroupLayout(EVENT_P);
        EVENT_P.setLayout(EVENT_PLayout);
        EVENT_PLayout.setHorizontalGroup(
            EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EVENT_PLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EVENT_PLayout.setVerticalGroup(
            EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EVENT_PLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.add(EVENT_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, -1));

        CREATE_P.setBackground(new java.awt.Color(255, 255, 255));
        CREATE_P.setPreferredSize(new java.awt.Dimension(550, 400));

        CREATE_N.setText("개설하기");
        CREATE_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREATE_NActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 204), 3, true));

        C_NAME.setEditable(false);

        C_ID.setEditable(false);

        jLabel5.setText("통장 종류");

        jLabel4.setText("계좌 비밀 번호");

        jLabel7.setText("이름");

        jLabel6.setText("ID ");

        C_KIND.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "입출금통장", "적금통장", "주택청약통장" }));
        C_KIND.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                C_KINDItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(C_PW, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(C_KIND, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(C_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(C_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(C_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(C_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(C_PW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(C_KIND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        P_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "상품", "종류"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P_TABLE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(P_TABLE);

        javax.swing.GroupLayout CREATE_PLayout = new javax.swing.GroupLayout(CREATE_P);
        CREATE_P.setLayout(CREATE_PLayout);
        CREATE_PLayout.setHorizontalGroup(
            CREATE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CREATE_PLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(CREATE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CREATE_N, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CREATE_PLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        CREATE_PLayout.setVerticalGroup(
            CREATE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CREATE_PLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(CREATE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(CREATE_N)
                .addGap(27, 27, 27))
        );

        jPanel4.add(CREATE_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, -1));

        javax.swing.GroupLayout PRODUCT_PLayout = new javax.swing.GroupLayout(PRODUCT_P);
        PRODUCT_P.setLayout(PRODUCT_PLayout);
        PRODUCT_PLayout.setHorizontalGroup(
            PRODUCT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        PRODUCT_PLayout.setVerticalGroup(
            PRODUCT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel4.add(PRODUCT_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, 400));

        CREATE_C_P.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout CREATE_C_PLayout = new javax.swing.GroupLayout(CREATE_C_P);
        CREATE_C_P.setLayout(CREATE_C_PLayout);
        CREATE_C_PLayout.setHorizontalGroup(
            CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        CREATE_C_PLayout.setVerticalGroup(
            CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel4.add(CREATE_C_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //계좌 개설 메뉴 클릭시
    private void CREATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATEActionPerformed
        removeAll();
        CREATE_P.setVisible(true);
        C_ID.setText(user.getId());
        C_NAME.setText(user.getName());
        C_PW.setText(null);
        C_KIND.setSelectedIndex(0);
        String kind = C_KIND.getSelectedItem().toString();
        createProduct(kind);
    }//GEN-LAST:event_CREATEActionPerformed
    
    //공지사항 메뉴 클릭시
    private void EVENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EVENTActionPerformed
        removeAll();
        EVENT_P.setVisible(true);
        table = (DefaultTableModel) E_TABLE.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC";
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            String sql = "select * from user_news"; 
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            table.setNumRows(0);
            while(rs.next()){
                Object[] list = {rs.getString("date"),rs.getString("title")};
                table.addRow(list);//행추가
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }//GEN-LAST:event_EVENTActionPerformed
    
    //공지사항 테이블에서 공지사항 하나 클릭시
    private void E_TABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E_TABLEMouseClicked
        int row = E_TABLE.getSelectedRow();
        String key = (String) E_TABLE.getValueAt(row, 1);
        Event_View v = new Event_View(key);
        v.setVisible(true);
    }//GEN-LAST:event_E_TABLEMouseClicked
    
    //로그아웃 버튼
    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
         Login_Frame login = new Login_Frame();
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_LOGOUTActionPerformed
    
    //송금하기 버튼 클릭시
    private void SENDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SENDActionPerformed
        removeAll();
        SEND_P.setVisible(true);
    }//GEN-LAST:event_SENDActionPerformed

    //제목(메론소다) 클릭시 메인 패널로 이동
    private void TITLE_PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TITLE_PMouseClicked
        // TODO add your handling code here:
        removeAll();
        MAIN_P.setVisible(true);
        createMain();
    }//GEN-LAST:event_TITLE_PMouseClicked

    //카드 개설 패널 이동
    private void CREATE_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATE_CActionPerformed
    removeAll();
    CREATE_C_P.setVisible(true);
    }//GEN-LAST:event_CREATE_CActionPerformed

    //계좌 개설 중 통장 종류가 바뀔 때
    private void C_KINDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_C_KINDItemStateChanged
        // TODO add your handling code here:
        String id = C_ID.getText(); //화면에 있는 아이디 값 받아오기
        String name = C_NAME.getText(); //화면에 있는 이름 값 받아오기
        String pw = C_PW.getText(); //화면에 있는 비밀번호 값 받아오기
        String kind = C_KIND.getSelectedItem().toString();
        createProduct(kind);// 화면에 있는 통장 종류 값 받아오기
        
    }//GEN-LAST:event_C_KINDItemStateChanged

    //통장 개설하기 버튼 클릭시
    private void CREATE_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATE_NActionPerformed
        // TODO add your handling code here:
        
        String pw = C_PW.getText(); //화면에 있는 비밀번호 값 받아오기
        if(pw.isEmpty()){
            showMessageDialog(null,"비밀번호를 입력해주세요");
        }else{
            try{
                table=(DefaultTableModel) P_TABLE.getModel();
                String product = (String)P_TABLE.getModel().getValueAt(P_TABLE.getSelectedRow(), 0);
                Create_account acc = new Create_account(user, pw,product);
                acc.create();
                removeAll();
                MAIN_P.setVisible(true);
                createMain();
           }catch(ArrayIndexOutOfBoundsException ex){
                showMessageDialog(null,"선택한 상품이 없습니다.");
           }
        }
        
    }//GEN-LAST:event_CREATE_NActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable A_TABLE;
    private javax.swing.JButton CREATE;
    private javax.swing.JButton CREATE_C;
    private javax.swing.JPanel CREATE_C_P;
    private javax.swing.JButton CREATE_N;
    private javax.swing.JPanel CREATE_P;
    private javax.swing.JTextField C_ID;
    private javax.swing.JComboBox<String> C_KIND;
    private javax.swing.JTextField C_NAME;
    private javax.swing.JTextField C_PW;
    private javax.swing.JButton EVENT;
    private javax.swing.JPanel EVENT_P;
    private javax.swing.JTable E_TABLE;
    private javax.swing.JLabel LEVEL;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JPanel MAIN_P;
    private javax.swing.JPanel MENU_P;
    private javax.swing.JLabel NAME;
    private javax.swing.JPanel PRODUCT_P;
    private javax.swing.JTable P_TABLE;
    private javax.swing.JButton SEND;
    private javax.swing.JPanel SEND_P;
    private javax.swing.JPanel TITLE_P;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
