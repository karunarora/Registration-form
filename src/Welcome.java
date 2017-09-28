
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.plaf.DesktopPaneUI;


public class Welcome extends javax.swing.JInternalFrame {

    Connection cn;
    PreparedStatement pst;
    ResultSet rs;
    int i=0,count=0;
    String ssql,sql;
    public Welcome() {
        initComponents();
        String a=SignIn.txtuname1.getText();
        lblname.setText(a);
        jTextField1.show(false);
        //jButton1.show(false);
    }

    public void MyConnection()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost;instance=KARUN;DatabaseName=Demo2;user=karun2;password=123";
            cn=DriverManager.getConnection(url);    
            
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(this,e);
                    
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktoppane2 = new javax.swing.JDesktopPane();
        lblname = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cpmenu = new javax.swing.JMenuItem();
        logoutmenu = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Welcome");
        setPreferredSize(new java.awt.Dimension(650, 500));

        lblname.setFont(new java.awt.Font("Tekton Pro", 0, 36)); // NOI18N
        lblname.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Status :");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout desktoppane2Layout = new javax.swing.GroupLayout(desktoppane2);
        desktoppane2.setLayout(desktoppane2Layout);
        desktoppane2Layout.setHorizontalGroup(
            desktoppane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktoppane2Layout.createSequentialGroup()
                .addGroup(desktoppane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktoppane2Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(desktoppane2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        desktoppane2Layout.setVerticalGroup(
            desktoppane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktoppane2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(desktoppane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addGroup(desktoppane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );
        desktoppane2.setLayer(lblname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktoppane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktoppane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktoppane2.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuBar1.setAlignmentX(getAlignmentX());
        jMenuBar1.setAutoscrolls(true);

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Karun\\Desktop\\websites data\\setting (Custom) (2).png")); // NOI18N
        jMenu1.setAutoscrolls(true);

        cpmenu.setText("Change Password");
        cpmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpmenuActionPerformed(evt);
            }
        });
        jMenu1.add(cpmenu);

        logoutmenu.setText("Logout");
        logoutmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutmenuActionPerformed(evt);
            }
        });
        jMenu1.add(logoutmenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktoppane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktoppane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpmenuActionPerformed
        ChangePassword cp = new ChangePassword();
        desktoppane2.add(cp);
        cp.show();
    }//GEN-LAST:event_cpmenuActionPerformed

    private void logoutmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutmenuActionPerformed
        dispose();
        SignIn s= new SignIn();
        Main.DesktopPane.add(s);
        s.show();
        
    }//GEN-LAST:event_logoutmenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cpmenu;
    private javax.swing.JDesktopPane desktoppane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblname;
    private javax.swing.JMenuItem logoutmenu;
    // End of variables declaration//GEN-END:variables
}
