
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class SignIn extends javax.swing.JInternalFrame {

    Connection cn;
    PreparedStatement pst;
    ResultSet rs;
    int i=0,count=0;
    String ssql,sql;
    public SignIn() {
        initComponents();
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
    public void check(String name,String pass)
    {
        try
        {
            MyConnection();
            
            ssql = "SELECT * FROM sform where uname=? and pass=?";
        
            pst=cn.prepareStatement(ssql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pst.setString(1,name);
            pst.setString(2,pass);
            rs=pst.executeQuery();
            rs.last();

        if(rs.getRow()!=0) 
        {

            Welcome w = new Welcome();
            Main.DesktopPane.add(w);
            w.show();
        }
        else
            {
                JOptionPane.showMessageDialog(this, "User not Exist!");
            }
         cn.close();
            
        }
        catch(Exception e)
        {
           
            JOptionPane.showMessageDialog(this,e);
        }
                    
               
    
       
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktoppane3 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lbluname1 = new javax.swing.JLabel();
        txtuname1 = new javax.swing.JTextField();
        lblpass1 = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        txtpass1 = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sign In User");
        setPreferredSize(new java.awt.Dimension(501, 329));
        setVerifyInputWhenFocusTarget(false);

        desktoppane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login to your accout");
        desktoppane3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 44, -1, -1));

        lbluname1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbluname1.setForeground(new java.awt.Color(255, 255, 255));
        lbluname1.setText("Username :");
        desktoppane3.add(lbluname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 117, -1, -1));

        txtuname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuname1ActionPerformed(evt);
            }
        });
        desktoppane3.add(txtuname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 117, 103, -1));

        lblpass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblpass1.setForeground(new java.awt.Color(255, 255, 255));
        lblpass1.setText("Password :");
        desktoppane3.add(lblpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 165, -1, -1));

        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        desktoppane3.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 220, 72, 32));
        desktoppane3.add(txtpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 165, 103, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktoppane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktoppane3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtuname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuname1ActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
            String name=txtuname1.getText();
            String pass=txtpass1.getText();
            check(name,pass);
            dispose();
    }//GEN-LAST:event_btnloginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JDesktopPane desktoppane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblpass1;
    private javax.swing.JLabel lbluname1;
    private javax.swing.JPasswordField txtpass1;
    public static javax.swing.JTextField txtuname1;
    // End of variables declaration//GEN-END:variables
}
