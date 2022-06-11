
package cyber.bank;

import bankstart.Login_Frame;
import java.sql.*;
import java.util.LinkedList;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

// 작성자 : 김부성
// 클래스 사용 이유 : 매니저에 관한 이벤트 처리를 위한 사용자 인터페이스 및 메인 역할을 하는 클래스

 public class Manager_Main extends javax.swing.JFrame {
    Manager manager; //매니저 객체를 저장
    DefaultTableModel table; //공지사항 목록을 출력하기 위한 테이블
    
//DB 사용을 위한 변수
    Connection conn =null;
    PreparedStatement pstmt =null;
    ResultSet rs = null;
    //접속 URL
    String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; 
    String dbUser ="banker"; //MySQL 접속 아이디
    String dbPass ="1234"; //비밀번호
    LinkedList<String> list = new LinkedList<String>(); // 등급별 혜택 조정시 사용되는 리스트 변수
   
    //등급별 공지사항을 확인 하기위한 공지사항 목록 변수
    static LinkedList<Event> vipList = new LinkedList<>();
    static LinkedList<Event> normalList = new LinkedList<>();
    static LinkedList<Event> silverList = new LinkedList<>();
    static LinkedList<Event> goldList = new LinkedList<>();
    
    public Manager_Main(Manager manager) { //초기 화면 및 기본 설정
        initComponents();
        this.manager=manager; //로그인한 관리자의 정보를 저장
        NAME.setText(manager.getName()); //관리자 정보를 이용해 이름을 출력
        gotoMain(); //초기 메인화면 작업
        setList(); // 등급별 공지사항을 리스트에 저장
    }
    
    
    public void removeAll(){//패널 지우기
        MAIN_P.setVisible(false);
        EVENT_P.setVisible(false);
        LEVEL_BE_P.setVisible(false);
    }
    
    public void createMain(){ 
        //공지사항 목록을 가지고 각 리스트에 저장하고 전체 목록을 출력        
        table = (DefaultTableModel) M_E_TABLE.getModel();
        table.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Mysql bank 데이터베이스와 연결
            String sql = "select * from news";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            table = (DefaultTableModel)M_E_TABLE.getModel();
            table.setNumRows(0);
            while(rs.next()){
                //매니저의 공지사항 목록 - 등록된 공지사항을 모두 출력
                Object[] list = {rs.getString("date"),rs.getString("title"),rs.getString("writer")};
                table.addRow(list);//행추가
            }  
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    public void setList(){//초기에 DB에서 등급별로 저장된 공지사항 목록을 리스트에 각각 저장
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Mysql bank 데이터베이스와 연결
            String sql = "select * from news";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // 공지사항 목록 중 해당하는 등급에 1 아니면 0을 저장
            while(rs.next()){
                if(rs.getInt("normal")==1){
                    normalList.add(new Event(rs.getString("date"),rs.getString("title")));
                }
                if(rs.getInt("silver")==1){
                    silverList.add(new Event(rs.getString("date"),rs.getString("title")));
                }
                if(rs.getInt("gold")==1){
                    goldList.add(new Event(rs.getString("date"),rs.getString("title")));
                }
                if(rs.getInt("vip")==1){
                    vipList.add(new Event(rs.getString("date"),rs.getString("title")));
                }  
            }  
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    public void gotoMain(){ //메인으로 초기화 위한 함수 이전에 선택했던 값들도 초기화
        SLEVEL.setText(null);
        LEVEL.setSelectedIndex(0);
        ONE.setSelected(false);
        TWO.setSelected(false);
        THREE.setSelected(false);
        TITLE.setText(null);
        NEWS.setText(null);
        removeAll();
        MAIN_P.setVisible(true);
        createMain();
    }
    
    public void clearEvent(String level){ // 등급별 혜택 설정 완료 후 저장된 리스트를 초기화 시키고 화면을 메인으로 이동
        showMessageDialog(null,level+" 혜택 설정이 완료되었습니다!");
        list.clear(); // 저장된 혜택 리스트 클리어
        gotoMain();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EVENT_P = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TITLE = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        NEWS = new javax.swing.JTextArea();
        insert_btn = new javax.swing.JButton();
        NORMAL_CHECK = new javax.swing.JCheckBox();
        SILVER_CHECK = new javax.swing.JCheckBox();
        GOLD_CHECK = new javax.swing.JCheckBox();
        VIP_CHECK = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        MAIN_P = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        M_E_TABLE = new javax.swing.JTable();
        NOMAL = new javax.swing.JButton();
        SILVER = new javax.swing.JButton();
        GOLD = new javax.swing.JButton();
        VIP = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        TITLE_P = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MENU_P = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NAME = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        INSERT = new javax.swing.JButton();
        CHANGE = new javax.swing.JButton();
        LEVEL_BE_P = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LEVEL = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        ONE = new javax.swing.JCheckBox();
        TWO = new javax.swing.JCheckBox();
        THREE = new javax.swing.JCheckBox();
        ACCEPT = new javax.swing.JButton();
        SLEVEL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        EVENT_P.setBackground(new java.awt.Color(255, 255, 255));
        EVENT_P.setPreferredSize(new java.awt.Dimension(550, 400));

        jLabel7.setText("제목");

        jLabel8.setText("내용");

        NEWS.setColumns(20);
        NEWS.setRows(5);
        jScrollPane3.setViewportView(NEWS);

        insert_btn.setText("등록하기");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });

        NORMAL_CHECK.setBackground(new java.awt.Color(255, 255, 255));
        NORMAL_CHECK.setText("Normal");

        SILVER_CHECK.setBackground(new java.awt.Color(255, 255, 255));
        SILVER_CHECK.setText("Silver");

        GOLD_CHECK.setBackground(new java.awt.Color(255, 255, 255));
        GOLD_CHECK.setText("Gold");

        VIP_CHECK.setBackground(new java.awt.Color(255, 255, 255));
        VIP_CHECK.setText("Vip");

        jLabel9.setText("공지 등급 선택");

        javax.swing.GroupLayout EVENT_PLayout = new javax.swing.GroupLayout(EVENT_P);
        EVENT_P.setLayout(EVENT_PLayout);
        EVENT_PLayout.setHorizontalGroup(
            EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EVENT_PLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(insert_btn)
                        .addGroup(EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EVENT_PLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(NORMAL_CHECK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SILVER_CHECK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(GOLD_CHECK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(VIP_CHECK)
                                .addGap(34, 34, 34))
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane3)))
                    .addComponent(TITLE))
                .addGap(102, 102, 102))
        );
        EVENT_PLayout.setVerticalGroup(
            EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EVENT_PLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TITLE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NORMAL_CHECK)
                    .addComponent(SILVER_CHECK)
                    .addComponent(GOLD_CHECK)
                    .addComponent(VIP_CHECK)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insert_btn)
                .addGap(42, 42, 42))
        );

        MAIN_P.setBackground(new java.awt.Color(255, 255, 255));
        MAIN_P.setPreferredSize(new java.awt.Dimension(550, 400));

        M_E_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "일시", "제목", "작성자"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        M_E_TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                M_E_TABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(M_E_TABLE);

        NOMAL.setText("Normal");
        NOMAL.setToolTipText("");
        NOMAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOMALActionPerformed(evt);
            }
        });

        SILVER.setText("Silver");
        SILVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SILVERActionPerformed(evt);
            }
        });

        GOLD.setText("Gold");
        GOLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GOLDActionPerformed(evt);
            }
        });

        VIP.setText("Vip");
        VIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIPActionPerformed(evt);
            }
        });

        jLabel10.setText("등급별 공지사항 확인");

        jButton1.setFont(new java.awt.Font("굴림", 0, 12)); // NOI18N
        jButton1.setText("공지사항 삭제");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MAIN_PLayout = new javax.swing.GroupLayout(MAIN_P);
        MAIN_P.setLayout(MAIN_PLayout);
        MAIN_PLayout.setHorizontalGroup(
            MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MAIN_PLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NOMAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SILVER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GOLD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(MAIN_PLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel10))))
                    .addGroup(MAIN_PLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MAIN_PLayout.setVerticalGroup(
            MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MAIN_PLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NOMAL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SILVER)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GOLD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VIP)
                        .addGap(65, 65, 65)
                        .addComponent(jButton1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TITLE_PLayout.setVerticalGroup(
            TITLE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLE_PLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        MENU_P.setBackground(new java.awt.Color(247, 247, 247));
        MENU_P.setPreferredSize(new java.awt.Dimension(150, 400));

        jLabel2.setText("님");

        NAME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NAME.setText("관리자");

        jLabel3.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel3.setText("메뉴");

        LOGOUT.setText("로그아웃");
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });

        INSERT.setText("공지사항 등록");
        INSERT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERTActionPerformed(evt);
            }
        });

        CHANGE.setText("등급 혜택 변경");
        CHANGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHANGEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MENU_PLayout = new javax.swing.GroupLayout(MENU_P);
        MENU_P.setLayout(MENU_PLayout);
        MENU_PLayout.setHorizontalGroup(
            MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_PLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CHANGE, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(MENU_PLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );
        MENU_PLayout.setVerticalGroup(
            MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_PLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(INSERT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CHANGE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(LOGOUT)
                .addGap(29, 29, 29))
        );

        LEVEL_BE_P.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 350));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 204), 3, true));

        jLabel4.setText("등급");

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
        jScrollPane2.setViewportView(LEVEL);

        jLabel6.setText("혜택");

        ONE.setBackground(new java.awt.Color(204, 255, 204));
        ONE.setText("캐시백 5%");

        TWO.setBackground(new java.awt.Color(204, 255, 204));
        TWO.setText("melon 굿즈 증정");

        THREE.setBackground(new java.awt.Color(204, 255, 204));
        THREE.setText("연말 행사 초대권");

        ACCEPT.setText("등록하기");
        ACCEPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACCEPTActionPerformed(evt);
            }
        });

        SLEVEL.setEditable(false);

        jLabel5.setText("선택 등급");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ONE)
                    .addComponent(TWO)
                    .addComponent(THREE)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(SLEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ACCEPT, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SLEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ONE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TWO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(THREE)
                    .addComponent(ACCEPT))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LEVEL_BE_PLayout = new javax.swing.GroupLayout(LEVEL_BE_P);
        LEVEL_BE_P.setLayout(LEVEL_BE_PLayout);
        LEVEL_BE_PLayout.setHorizontalGroup(
            LEVEL_BE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEVEL_BE_PLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        LEVEL_BE_PLayout.setVerticalGroup(
            LEVEL_BE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEVEL_BE_PLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MENU_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(MAIN_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TITLE_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 150, Short.MAX_VALUE)
                    .addComponent(EVENT_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 150, Short.MAX_VALUE)
                    .addComponent(LEVEL_BE_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(TITLE_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MENU_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MAIN_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 100, Short.MAX_VALUE)
                    .addComponent(EVENT_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 100, Short.MAX_VALUE)
                    .addComponent(LEVEL_BE_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //화면에 메론소다 타이틀 클릭시 메인 화면으로 이동
    private void TITLE_PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TITLE_PMouseClicked
        // TODO add your handling code here:
       gotoMain();
    }//GEN-LAST:event_TITLE_PMouseClicked

    //로그아웃을 하여 로그인 화면으로 이동
    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        Login_Frame login = new Login_Frame();
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_LOGOUTActionPerformed

    //공지사항 목록에서 하나를 클릭할 때 해당 공지사항에 본문 확인
    private void M_E_TABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_M_E_TABLEMouseClicked
        // TODO add your handling code here:
        int row = M_E_TABLE.getSelectedRow(); // 선택한 행 반환
        String key = (String) table.getValueAt(row, 1); // key값인 제목을 저장
        Event_View v = new Event_View(key); // 제목을 이용하면 본문에 상세 내용을 출력
        v.setVisible(true);
    }//GEN-LAST:event_M_E_TABLEMouseClicked
    
    // 공지사항 등록 버튼 클릭시 공지사항을 등록할 수 있는 패널로 이동
    private void INSERTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERTActionPerformed
        // TODO add your handling code here:
        removeAll();
        EVENT_P.setVisible(true);
    }//GEN-LAST:event_INSERTActionPerformed

    //혜택 조정하기 버튼 클릭시 등급별 혜택을 지정할 수 있는 패널로 이동
    private void CHANGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGEActionPerformed
        // TODO add your handling code here:
        removeAll();
        LEVEL_BE_P.setVisible(true);
    }//GEN-LAST:event_CHANGEActionPerformed

    // 혜택 등록하기에 대한 버튼 클릭시 이벤트
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
            // Normal 등급이 선택되었을 때
            // 등급 생성자를 통해 혜택리스트 넘기기
            l = new Normal(list);
            // DB에 저장하는 함수
            l.createLevel();
            clearEvent(SLEVEL.getText());
        }else if(SLEVEL.getText().equals("Silver")){
            // Silver 등급이 선택되었을 때
            // 등급 생성자를 통해 혜택리스트 넘기기
            l = new Silver(list);
            // DB에 저장하는 함수
            l.createLevel();
            clearEvent(SLEVEL.getText());
        }else if(SLEVEL.getText().equals("Gold")){
            // Gold 등급이 선택되었을 때
            // 등급 생성자를 통해 혜택리스트 넘기기
            l = new Gold(list);
            // DB에 저장하는 함수
            l.createLevel();
            clearEvent(SLEVEL.getText());
        }else if(SLEVEL.getText().equals("Vip")){
            // Vip 등급이 선택되었을 때
            // 등급 생성자를 통해 혜택리스트 넘기기
            l = new Vip(list);
            // DB에 저장하는 함수
            l.createLevel();
            clearEvent(SLEVEL.getText());
        }else{ // 등급 선택을 하지 않았을 시
            showMessageDialog(null,"등급이 선택되지 않았습니다.");
        }
    }//GEN-LAST:event_ACCEPTActionPerformed

    // 현재 은행에서 시행하고 있는 등급 리스트에서 하나를 선택할 시 리스트 아래에 선택한 등급을 출력
    private void LEVELValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LEVELValueChanged
        // TODO add your handling code here:
        if(evt.getValueIsAdjusting()){ // 등급 선택시 선택된 등급을 보여준다
            SLEVEL.setText(LEVEL.getSelectedValue());
        }
    }//GEN-LAST:event_LEVELValueChanged

    //공지사항 등록 버튼을 클릭시
    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        // TODO add your handling code here:
        Insert_Event e = new Insert_Event(); //등급별 공지사항 리스트에 새로운 공지사항을 등록하기 위해 생성
        Observer o; //옵저버 리스트를 추가하기 위한 변수
        String date ; //공지사항 등록 날짜 저장
        date = new java.util.Date().toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE); // 작성 날짜를 받는 자바 라이브러리 사용 
        date = date.substring(0, date.length()-1);//날짜 마지막에 Z도 함께 저장되어서 제거
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Mysql bank 데이터베이스와 연결
            String sql = "insert into news value (?,?,?,?,?,?,?,?)";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,date); //날짜
            pstmt.setString(2,TITLE.getText()); //제목
            pstmt.setString(3,NEWS.getText()); //본문
            pstmt.setString(4,manager.getName()); // 작성자
            pstmt.setBoolean(5, NORMAL_CHECK.isSelected()); //normal등급 체크여부
            pstmt.setBoolean(6, SILVER_CHECK.isSelected());//silver등급 체크여부
            pstmt.setBoolean(7, GOLD_CHECK.isSelected());//gold등급 체크여부
            pstmt.setBoolean(8, VIP_CHECK.isSelected());//vip등급 체크여부
            if(!NORMAL_CHECK.isSelected() && !SILVER_CHECK.isSelected() && !GOLD_CHECK.isSelected() && !VIP_CHECK.isSelected()){
                //등급을 하나도 선택하지 않았을 때
                showMessageDialog(null,"등급을 선택하여 주세요!!");
            }else{
                int co = pstmt.executeUpdate();
                if(co==1){//DB에 저장 성공시
                    if(NORMAL_CHECK.isSelected()){//Normal 등급 클릭시
                        o = new Normal(e); //업데이트 리스트에 normal 추가
                    }
                    if(SILVER_CHECK.isSelected()){//Silver 등급 클릭시
                        o = new Silver(e); //업데이트 리스트에 silver 추가
                    }
                    if(GOLD_CHECK.isSelected()){//Gold 등급 클릭시
                        o = new Gold(e); //업데이트 리스트에 gold 추가
                    }
                    if(VIP_CHECK.isSelected()){ //Vip 등급 클릭시
                        o = new Vip(e); //업데이트 리스트에 vip 추가
                    }
                    e.addNews(date, TITLE.getText());//날짜와 제목을 해당되는 리스트에 추가
                    showMessageDialog(null,"이벤트 등록이 완료되었습니다.");
                    gotoMain();
                }else{ //제목이 key값이므로 중복시에는 DB저장에 실패
                    showMessageDialog(null,"제목이 이전과 중복됩니다");
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }//GEN-LAST:event_insert_btnActionPerformed
    
    //관리자가 원하는 등급의 공지사항을 확인할 수 있도록 프레임 생성
    //Normal 등급 공지사항 확인
    private void NOMALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOMALActionPerformed
        // TODO add your handling code here:
        ShowLevelEvent e = new ShowLevelEvent("Normal");
        e.setVisible(true); 
    }//GEN-LAST:event_NOMALActionPerformed

    //Silver 등급 공지사항 확인
    private void SILVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SILVERActionPerformed
        // TODO add your handling code here:
        ShowLevelEvent e = new ShowLevelEvent("Silver");
        e.setVisible(true);
    }//GEN-LAST:event_SILVERActionPerformed
    
    //Gold 등급 공지사항 확인
    private void GOLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GOLDActionPerformed
        // TODO add your handling code here:
        ShowLevelEvent e = new ShowLevelEvent("Gold");
        e.setVisible(true);
    }//GEN-LAST:event_GOLDActionPerformed

    //Vip등급 공지사항 확인
    private void VIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIPActionPerformed
        // TODO add your handling code here:
        ShowLevelEvent e = new ShowLevelEvent("Vip");
        e.setVisible(true);
    }//GEN-LAST:event_VIPActionPerformed

    //공지사항 삭제
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int row = M_E_TABLE.getSelectedRow(); // 선택한 행 반환
        String key = (String) table.getValueAt(row, 1); // key값인 제목을 저장
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Mysql bank 데이터베이스와 연결
            String sql = "delete from news where title = ?";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, key);
            pstmt.executeUpdate();
            // 공지사항 목록 중 해당하는 등급에 1 아니면 0을 저장
            showMessageDialog(null,"공지사항이 삭제되었습니다.");
            //삭제시 리스트 조정
            normalList.clear();
            silverList.clear();
            goldList.clear();
            vipList.clear();
            setList();
            createMain();//공지사항 초기화
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACCEPT;
    private javax.swing.JButton CHANGE;
    private javax.swing.JPanel EVENT_P;
    private javax.swing.JButton GOLD;
    private javax.swing.JCheckBox GOLD_CHECK;
    private javax.swing.JButton INSERT;
    private javax.swing.JList<String> LEVEL;
    private javax.swing.JPanel LEVEL_BE_P;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JPanel MAIN_P;
    private javax.swing.JPanel MENU_P;
    private javax.swing.JTable M_E_TABLE;
    private javax.swing.JLabel NAME;
    private javax.swing.JTextArea NEWS;
    private javax.swing.JButton NOMAL;
    private javax.swing.JCheckBox NORMAL_CHECK;
    private javax.swing.JCheckBox ONE;
    private javax.swing.JButton SILVER;
    private javax.swing.JCheckBox SILVER_CHECK;
    private javax.swing.JTextField SLEVEL;
    private javax.swing.JCheckBox THREE;
    private javax.swing.JTextField TITLE;
    private javax.swing.JPanel TITLE_P;
    private javax.swing.JCheckBox TWO;
    private javax.swing.JButton VIP;
    private javax.swing.JCheckBox VIP_CHECK;
    private javax.swing.JButton insert_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
