/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber.bank;

import bankstart.Login_Frame;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

// 작성자 : 김부성, 이수진, 박채빈
// 클래스 사용 이유 : 고객의 관한 인터페이스 및 기능 연결

public class User_Main extends javax.swing.JFrame {

    DefaultTableModel table; //테이블 변수 재사용
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String jdbcDriver = "jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC";
    String dbUser = "banker"; //MySQL 접속 아이디
    String dbPass = "1234"; //비밀번호
    User user; //로그인한 고객 객체 변수 저장

    public User_Main(User user) {
        try {
            initComponents();
            this.user = user;
            gotoMain();
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeAll() { //패널이 겹쳐서 튀어나오지 않게 지우기
        CREATE_P.setVisible(false);
        EVENT_P.setVisible(false);
        MAIN_P.setVisible(false);
        SEND_P.setVisible(false);
        PRODUCT_P.setVisible(false);
        CREATE_C_P.setVisible(false);
    }

    public void createProduct(String kind) { // 계좌 개설의 상품 목록을 출력
        DefaultTableModel model = (DefaultTableModel) P_TABLE.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from product where kind=?";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kind);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] list = {rs.getString("product"), rs.getString("kind")};
                model.addRow(list);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (rs != null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt != null) try { pstmt.close();} catch (SQLException ex) {}
            if (conn != null) try {conn.close();} catch (SQLException ex) {}
        }
    }

    public void createMain() { //메인 패널에 있는 보유 계좌 테이블 출력
        table = (DefaultTableModel) A_TABLE.getModel();
        table.setRowCount(0);
        try {
            String sql = "select * from account where id=?";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] list = {rs.getString("account_num"), rs.getString("balance"), rs.getString("kind"), rs.getString("ccard"), rs.getString("benefit")};
                table.addRow(list);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (rs != null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt != null) try { pstmt.close();} catch (SQLException ex) {}
            if (conn != null) try {conn.close();} catch (SQLException ex) {}
        }
    }

    public void gotoMain() { //메인 패널 이동시 초기화
        removeAll();
        MAIN_P.setVisible(true);
        NAME.setText(user.getName());
        LEVEL.setText(user.getLevel());
        createMain();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        TransportButtGroup = new javax.swing.ButtonGroup();
        AbroadButtGroup = new javax.swing.ButtonGroup();
        NoticeButtGroup = new javax.swing.ButtonGroup();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        MAIN_P = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        A_TABLE = new javax.swing.JTable();
        DELETE = new javax.swing.JButton();
        DELETE_C = new javax.swing.JButton();
        SEND_P = new javax.swing.JPanel();
        S_ACC = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        R_ACC = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        BALANCE = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        MONEY = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        PW = new javax.swing.JPasswordField();
        jLabel19 = new javax.swing.JLabel();
        SEND_BTN = new javax.swing.JButton();
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
        jLabel8 = new javax.swing.JLabel();
        Check3 = new javax.swing.JCheckBox();
        Check4 = new javax.swing.JCheckBox();
        Check5 = new javax.swing.JCheckBox();
        Check6 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        CreateCardButt = new javax.swing.JButton();
        ANumText = new javax.swing.JTextField();
        Check1 = new javax.swing.JCheckBox();
        Check2 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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

        jLabel17.setText("jLabel17");

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
                "계좌 번호", "잔액", "종류", "카드 개설", "혜택"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        A_TABLE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        A_TABLE.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(A_TABLE);

        DELETE.setText("계좌삭제하기");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        DELETE_C.setText("카드삭제하기");
        DELETE_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE_CActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MAIN_PLayout = new javax.swing.GroupLayout(MAIN_P);
        MAIN_P.setLayout(MAIN_PLayout);
        MAIN_PLayout.setHorizontalGroup(
            MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MAIN_PLayout.createSequentialGroup()
                        .addComponent(DELETE_C)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DELETE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        MAIN_PLayout.setVerticalGroup(
            MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DELETE)
                    .addComponent(DELETE_C))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel4.add(MAIN_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, 400));

        SEND_P.setBackground(new java.awt.Color(255, 255, 255));

        S_ACC.setEditable(false);
        S_ACC.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        S_ACC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        S_ACC.setText("00000000");

        jLabel12.setText("보낸 사람 계좌");

        jLabel13.setText("받는 사람 계좌");

        R_ACC.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        R_ACC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel14.setText("잔액");

        BALANCE.setEditable(false);
        BALANCE.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel15.setText("원");

        jLabel16.setText("금액");

        MONEY.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel18.setText("원");

        jLabel19.setText("비밀번호");

        SEND_BTN.setText("송금");
        SEND_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEND_BTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SEND_PLayout = new javax.swing.GroupLayout(SEND_P);
        SEND_P.setLayout(SEND_PLayout);
        SEND_PLayout.setHorizontalGroup(
            SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SEND_PLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(S_ACC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addGroup(SEND_PLayout.createSequentialGroup()
                        .addComponent(BALANCE, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SEND_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(SEND_PLayout.createSequentialGroup()
                                .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(PW, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MONEY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(R_ACC, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(139, 139, 139))
        );
        SEND_PLayout.setVerticalGroup(
            SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SEND_PLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(S_ACC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_ACC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SEND_PLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BALANCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(SEND_PLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MONEY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(4, 4, 4)
                        .addComponent(PW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(SEND_BTN)
                .addGap(55, 55, 55))
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
        LEVEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LEVELMouseClicked(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        jLabel8.setText("알림");

        AbroadButtGroup.add(Check3);
        Check3.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        Check3.setText("On");

        AbroadButtGroup.add(Check4);
        Check4.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        Check4.setText("Off");

        NoticeButtGroup.add(Check5);
        Check5.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        Check5.setText("On");

        NoticeButtGroup.add(Check6);
        Check6.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        Check6.setText("Off");

        jLabel9.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        jLabel9.setText("계좌번호");

        CreateCardButt.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        CreateCardButt.setText("카드 생성하기");
        CreateCardButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateCardButtActionPerformed(evt);
            }
        });

        ANumText.setEditable(false);
        ANumText.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        ANumText.setText("jTextField1");

        TransportButtGroup.add(Check1);
        Check1.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        Check1.setText("On");

        TransportButtGroup.add(Check2);
        Check2.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        Check2.setText("Off");

        jLabel10.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        jLabel10.setText("교통");

        jLabel11.setFont(new java.awt.Font("굴림", 0, 16)); // NOI18N
        jLabel11.setText("해외");

        javax.swing.GroupLayout CREATE_C_PLayout = new javax.swing.GroupLayout(CREATE_C_P);
        CREATE_C_P.setLayout(CREATE_C_PLayout);
        CREATE_C_PLayout.setHorizontalGroup(
            CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CREATE_C_PLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(ANumText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CreateCardButt)
                    .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(CREATE_C_PLayout.createSequentialGroup()
                            .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8))
                            .addGap(45, 45, 45)
                            .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(CREATE_C_PLayout.createSequentialGroup()
                                    .addComponent(Check5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Check6))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CREATE_C_PLayout.createSequentialGroup()
                                    .addComponent(Check1)
                                    .addGap(47, 47, 47)
                                    .addComponent(Check2))))
                        .addGroup(CREATE_C_PLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(45, 45, 45)
                            .addComponent(Check3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Check4))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        CREATE_C_PLayout.setVerticalGroup(
            CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CREATE_C_PLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CREATE_C_PLayout.createSequentialGroup()
                        .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Check1)
                            .addComponent(Check2)
                            .addComponent(jLabel10))
                        .addGap(34, 34, 34)
                        .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Check3)
                            .addComponent(Check4))
                        .addGap(27, 27, 27)
                        .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(CREATE_C_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Check5)
                                .addComponent(Check6))))
                    .addGroup(CREATE_C_PLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(ANumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(CreateCardButt)
                .addContainerGap(93, Short.MAX_VALUE))
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
        CREATE_P.setVisible(true); // 계좌개설 패널로 이동
        // 로그인 정보를 통한 정보 설정
        C_ID.setText(user.getId());
        C_NAME.setText(user.getName());
        C_PW.setText(null); //통장 비밀번호 입력 받기
        C_KIND.setSelectedIndex(0); // 통장 종류 미선택 설정
        String kind = C_KIND.getSelectedItem().toString(); //종류를 선택
        createProduct(kind);// 종류에 따른 상품 목록 출력
    }//GEN-LAST:event_CREATEActionPerformed

    //공지사항 메뉴 클릭시
    private void EVENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EVENTActionPerformed
        removeAll();
        EVENT_P.setVisible(true);
        table = (DefaultTableModel) E_TABLE.getModel();
        try {
            String sql = "select * from news where "+user.getLevel().toLowerCase()+"=1"; //유저 등급에 맞는 공지사항  sql
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            table.setNumRows(0);     
            while (rs.next()) {
                Object[] list = {rs.getString("date"), rs.getString("title")};
                table.addRow(list);//행추가
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (rs != null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt != null) try { pstmt.close();} catch (SQLException ex) {}
            if (conn != null) try {conn.close();} catch (SQLException ex) {}
        }
    }//GEN-LAST:event_EVENTActionPerformed

    //공지사항 테이블에서 공지사항 하나 클릭시
    private void E_TABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E_TABLEMouseClicked
        int row = E_TABLE.getSelectedRow();
        String key = (String) E_TABLE.getValueAt(row, 1);
        Event_View v = new Event_View(key); //제목을 통한 본문 검색
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
        int row = A_TABLE.getSelectedRow();
        if (row == -1) {
            showMessageDialog(null, "계좌를 선택해 주세요.");
        } else if (!((String) A_TABLE.getValueAt(row, 2)).equals("입출금통장")) {
            showMessageDialog(null, "송금은 입출금 통장만 가능합니다.");
        } else {
            removeAll();
            //송금 패널로 이동하면서 선택한 계좌와 잔액 설정
            SEND_P.setVisible(true);
            S_ACC.setText((String) A_TABLE.getValueAt(row, 0));
            BALANCE.setText((String) A_TABLE.getValueAt(row, 1));
        }
    }//GEN-LAST:event_SENDActionPerformed

    //제목(메론소다) 클릭시 메인 패널로 이동
    private void TITLE_PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TITLE_PMouseClicked
        // TODO add your handling code here:
        gotoMain();
    }//GEN-LAST:event_TITLE_PMouseClicked

    //카드 개설 패널 이동
    private void CREATE_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATE_CActionPerformed
        int row = A_TABLE.getSelectedRow();
        if (row == -1) {
            showMessageDialog(null, "계좌를 선택해 주세요.");
        } else if (((String) A_TABLE.getValueAt(row, 3)) == null) {  // 카드 개설을 할 수 없는 계좌라면
            showMessageDialog(null, "카드를 생성할 수 없는 계좌입니다.");
        } else if (((String) A_TABLE.getValueAt(row, 3)).equals("yes")) {  // 카드 개설이 이미 된 상태면
            showMessageDialog(null, "이미 카드가 개설된 계좌입니다.");
        } else {  // 카드 개설이 안된 상태면
            removeAll();
            String aNum = (String) A_TABLE.getValueAt(row, 0);  // 테이블에서 선택된 계좌번호 받아오기 
            ANumText.setText(aNum);
            // 체크박스버튼 초기화
            TransportButtGroup.clearSelection();
            AbroadButtGroup.clearSelection();
            NoticeButtGroup.clearSelection();
            // 카드 개설 패널로 이동
            CREATE_C_P.setVisible(true);
        }
    }//GEN-LAST:event_CREATE_CActionPerformed

    //계좌 개설 중 통장 종류가 바뀔 때
    private void C_KINDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_C_KINDItemStateChanged
        // TODO add your handling code here:
        String kind = C_KIND.getSelectedItem().toString();
        createProduct(kind);// 화면에 있는 통장 종류 값 받아오기
    }//GEN-LAST:event_C_KINDItemStateChanged

    //통장 개설하기 버튼 클릭시
    private void CREATE_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATE_NActionPerformed
        // TODO add your handling code here:
        String pw = C_PW.getText(); //화면에 있는 비밀번호 값 받아오기
        if (pw.isEmpty()) {
            showMessageDialog(null, "비밀번호를 입력해주세요");
        } else {
            table = (DefaultTableModel) P_TABLE.getModel();
            String product = (String) P_TABLE.getModel().getValueAt(P_TABLE.getSelectedRow(), 0);
            //선택한 상품에 따라 입력받은 정보를 통해 계좌 생성
            if(product.equals("메론입출금")){ 
                Account b = new Melon_Bankbook();
                b.create_Account(user,pw);
            }else if(product.equals("예금")){
                Saving_Account b = new Saving_Account();
                b.create_Account(user,pw);
            }else if(product.equals("청년주택청약")){
                Youth_Housing_Subscription b = new  Youth_Housing_Subscription();
                b.create_Account(user,pw); 
            }else if(product.equals("청년희망적금")){
                Youth_Hope_Savings b = new Youth_Hope_Savings();
                b.create_Account(user,pw);  
            }          
            gotoMain();
        }

    }//GEN-LAST:event_CREATE_NActionPerformed

    //카드 생성하기 버튼 클릭시
    private void CreateCardButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateCardButtActionPerformed
        // String 타입의 cb 배열 null로 초기화
        // (교통 "on"/"off", 해외 "on"/"off", 알림 "on"/"off") 
        String[] cb = {null, null, null};

        Button butt = new Button();

        // 교통 기능
        if (Check1.isSelected()) {  // 교통 on 클릭시
            Transport transport = new Transport();
            TransportOnCommand transportOn = new TransportOnCommand(transport);
            butt.setCommand(transportOn);  //교통 on Command로 설정
            butt.pressed();  // 교통 on 기능 수행
            cb[0] = transport.on();  // cb 배열의 0번째 인덱스에 transport의 on() 리턴값 "on" 저장
        } else if (Check2.isSelected()) {  // 교통 off 클릭시
            Transport transport = new Transport();
            TransportOffCommand transportOff = new TransportOffCommand(transport);
            butt.setCommand(transportOff);  //교통 off Command로 설정
            butt.pressed();  // 교통 off 기능 수행
            cb[0] = transport.off();  // cb 배열의 0번째 인덱스에 transport의 off() 리턴값 "off" 저장
        }

        // 해외 기능
        if (Check3.isSelected()) {  // 해외 on 클릭시
            Abroad abroad = new Abroad();
            AbroadOnCommand abroadOn = new AbroadOnCommand(abroad);
            butt.setCommand(abroadOn);
            butt.pressed();
            cb[1] = abroad.on();
        } else if (Check4.isSelected()) {  // 해외 off 클릭시
            Abroad abroad = new Abroad();
            AbroadOffCommand abroadOff = new AbroadOffCommand(abroad);
            butt.setCommand(abroadOff);
            butt.pressed();
            cb[1] = abroad.off();
        }

        // 알림 기능
        if (Check5.isSelected()) {  // 알림 on 클릭시
            Notice notice = new Notice();
            NoticeOnCommand noticeOn = new NoticeOnCommand(notice);
            butt.setCommand(noticeOn);
            butt.pressed();
            cb[2] = notice.on();
        } else if (Check6.isSelected()) {  // 알림 off 클릭시
            Notice notice = new Notice();
            NoticeOffCommand noticeOff = new NoticeOffCommand(notice);
            butt.setCommand(noticeOff);
            butt.pressed();
            cb[2] = notice.off();
        }

        int row = A_TABLE.getSelectedRow();
        // 테이블에서 계좌번호 가져옴
        String aNum = (String) A_TABLE.getValueAt(A_TABLE.getSelectedRow(), 0);
        // 카드번호 : 계좌번호 앞에 c를 붙인 값으로 설정
        String cNum = 'c' + aNum;

        // 교통, 해외, 알림 중 선택되지 않은 기능이 있다면
        if (!((Check1.isSelected() == true || Check2.isSelected() == true) && (Check3.isSelected() == true || Check4.isSelected() == true) && (Check5.isSelected() == true || Check6.isSelected() == true))) {
            showMessageDialog(null, "선택되지 않은 기능이 있습니다.");
            // 체크박스 초기화 
            TransportButtGroup.clearSelection();
            AbroadButtGroup.clearSelection();
            NoticeButtGroup.clearSelection();
            return;
        } else {  // 교통, 해외, 알림 모두 선택되었다면

            // card 테이블에 값 넣기 
            String sql = "insert into card values(?, ?, ?, ?, ?)";
            try {
                conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, aNum);  // 계좌번호
                pstmt.setString(2, cNum);  // 카드번호
                pstmt.setString(3, cb[0]);  // 교통 (on, off)
                pstmt.setString(4, cb[1]);  // 해외 (on, off)
                pstmt.setString(5, cb[2]);  // 알림 (on, off)

                pstmt.executeUpdate();
                showMessageDialog(null, "카드 생성이 완료되었습니다.");
                //메인화면으로 이동 
                

                // 카드 개설 후 account 테이블의 카드 개설 여부 "yes"로 변경 
                sql = "update account set ccard =? where account_num=?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "yes"); // 카드개설여부 "yes" 설정
                pstmt.setString(2, aNum);   // 계좌번호 aNum으로 설정
                pstmt.executeUpdate();
                gotoMain();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (rs != null) try {rs.close();} catch (SQLException ex) {}
                if (pstmt != null) try { pstmt.close();} catch (SQLException ex) {}
                if (conn != null) try {conn.close();} catch (SQLException ex) {}
            }
        }
    }//GEN-LAST:event_CreateCardButtActionPerformed

    //송금 진행
    private void SEND_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEND_BTNActionPerformed
        // TODO add your handling code here:
        boolean a= false; //송금 성공 여부
        String pw = new String(PW.getPassword());
        User s_user; //송금자 계좌
        User r_user; //수신자 계좌
        State s_state; //송신자 상태
        State r_state;//수신자 상태
        try {
            if(R_ACC.getText().isEmpty() || MONEY.getText().isEmpty()|| pw.isEmpty()){
                showMessageDialog(null, "입력되지 않은 항목이 존재합니다.");
            }else{
                String sql = "select * from account where account_num=?";
                conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, S_ACC.getText());
                rs = pstmt.executeQuery();
                if(rs.next()){ //송신자 계좌 비밀번호 비교를 위한 검색
                    if (!pw.equals(rs.getString("pw"))) {
                        showMessageDialog(null, "비밀번호 오류입니다,");
                        System.out.println(rs.getString("pw"));
                        System.out.println(pw);
                    } else {//비밀번호가 확인 되었을 때
                        Send send = new Send(S_ACC.getText(), R_ACC.getText(), Integer.parseInt(MONEY.getText()));
                        a = send.changeBalance();
                        if(a){
                            s_user = send.request(S_ACC.getText());//송금자 상태 객체 받기
                            r_user = send.request(R_ACC.getText());// 수신자 상태 객체 받기
                            //송금자 총 금액 상태에 따라 등급 전환
                            // 송금자 = 현재 로그인 계정이므로 현재 로그인 계정도 전환
                            if (s_user.getTotal() < 100000) { //Normal 등급
                                s_state = new Normal();
                                user.setLevel("Normal");
                            } else if (s_user.getTotal() >= 100000 && s_user.getTotal() < 500000) { //Silver 등급
                                s_state = new Silver();
                                user.setLevel("Silver");
                            } else if (s_user.getTotal() >= 500000 && s_user.getTotal() < 1000000) { //Gold 등급
                                s_state = new Gold();
                                user.setLevel("Gold");
                            } else { // Vip 등급
                                s_state = new Vip();
                                user.setLevel("Vip");
                            }
                            //수신자 총 금액 상태에 따라 등급 전환
                            if (r_user.getTotal() < 100000) {
                                r_state = new Normal();
                            } else if (r_user.getTotal() >= 100000 && r_user.getTotal() < 500000) {
                                r_state = new Silver();
                            } else if (r_user.getTotal() >= 500000 && r_user.getTotal() < 1000000) {
                                r_state = new Gold();
                            } else {
                                r_state = new Vip();
                            }
                            s_state.changeLevel(s_user);//DB 등급 값 변환
                            r_state.changeLevel(r_user);//DB 등급 값 변환
                            LEVEL.setText(user.getLevel()); // 회원 등급 출력
                            gotoMain();
                        }
                    }
                }
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (rs != null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt != null) try { pstmt.close();} catch (SQLException ex) {}
            if (conn != null) try {conn.close();} catch (SQLException ex) {}
        }
    }//GEN-LAST:event_SEND_BTNActionPerformed

    //계좌 삭제
    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        // TODO add your handling code here:
        int row = A_TABLE.getSelectedRow();
        Delete d = new Delete((String) A_TABLE.getValueAt(row, 0));
        d.acc();
        showMessageDialog(null, "계좌가 삭제되었습니다.");
        setVisible(false);
        User_Main u = new User_Main(user);
        u.setVisible(true);
    }//GEN-LAST:event_DELETEActionPerformed

    //카드 삭제
    private void DELETE_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE_CActionPerformed
        // TODO add your handling code here:
        int row = A_TABLE.getSelectedRow();
        Delete d = new Delete((String) A_TABLE.getValueAt(row, 0));
        d.card();
        showMessageDialog(null, "카드가 삭제되었습니다.");
        gotoMain();
    }//GEN-LAST:event_DELETE_CActionPerformed

    //회원이 등급 클릭시 해택
    private void LEVELMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LEVELMouseClicked
        // TODO add your handling code here:
        ShowBenefit s = new ShowBenefit(LEVEL.getText());
        s.setVisible(true);
    }//GEN-LAST:event_LEVELMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ANumText;
    private javax.swing.JTable A_TABLE;
    private javax.swing.ButtonGroup AbroadButtGroup;
    private javax.swing.JTextField BALANCE;
    private javax.swing.JButton CREATE;
    private javax.swing.JButton CREATE_C;
    private javax.swing.JPanel CREATE_C_P;
    private javax.swing.JButton CREATE_N;
    private javax.swing.JPanel CREATE_P;
    private javax.swing.JTextField C_ID;
    private javax.swing.JComboBox<String> C_KIND;
    private javax.swing.JTextField C_NAME;
    private javax.swing.JTextField C_PW;
    private javax.swing.JCheckBox Check1;
    private javax.swing.JCheckBox Check2;
    private javax.swing.JCheckBox Check3;
    private javax.swing.JCheckBox Check4;
    private javax.swing.JCheckBox Check5;
    private javax.swing.JCheckBox Check6;
    private javax.swing.JButton CreateCardButt;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton DELETE_C;
    private javax.swing.JButton EVENT;
    private javax.swing.JPanel EVENT_P;
    private javax.swing.JTable E_TABLE;
    private javax.swing.JLabel LEVEL;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JPanel MAIN_P;
    private javax.swing.JPanel MENU_P;
    private javax.swing.JTextField MONEY;
    private javax.swing.JLabel NAME;
    private javax.swing.ButtonGroup NoticeButtGroup;
    private javax.swing.JPanel PRODUCT_P;
    private javax.swing.JPasswordField PW;
    private javax.swing.JTable P_TABLE;
    private javax.swing.JTextField R_ACC;
    private javax.swing.JButton SEND;
    private javax.swing.JButton SEND_BTN;
    private javax.swing.JPanel SEND_P;
    private javax.swing.JTextField S_ACC;
    private javax.swing.JPanel TITLE_P;
    private javax.swing.ButtonGroup TransportButtGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
