
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;



public class ForgetPassword extends javax.swing.JInternalFrame {

    Connection cn;
    PreparedStatement pst;
    ResultSet rs;
    String ssql,sql,id;
    public ForgetPassword() {
        initComponents();
    }

      public void check(String name,String pass)
    {
        try
        {
            MyConnection();
            
            ssql = "SELECT * FROM sform where uname=? and hpass=?";
        
            pst=cn.prepareStatement(ssql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pst.setString(1,name);
            pst.setString(2,pass);
            
            rs=pst.executeQuery();
            while(rs.next())
            {
                id=rs.getString("email");
            }
            rs.last();
            if(rs.getRow()!=0)
            {
        
                //sql="Select email from sform where uname='"+name+"'";
                //pst=cn.prepareStatement(ssql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                //rs=pst.executeQuery();
                
                Email em = new SimpleEmail();
                em.setHostName("smtp.googlemail.com");
                em.setSmtpPort(465);
                em.setAuthenticator(new DefaultAuthenticator("arorakarun786@gmail.com","98K@run55"));
                em.setSSLOnConnect(true);
                em.setFrom("noreply@karunarora.com");
                em.setSubject("Password Reset");
           
                Random ran = new Random();
                int top=6;
                char data=' ';
                String dat="";
                
                for(int i=0;i<=top;i++)
                {
                    data=(char)(ran.nextInt(25)+97);
                    dat=data+dat;
                }
                em.setMsg("Your new Password is= "+dat);
                em.addTo(id);
                em.send();
                JOptionPane.showMessageDialog(this, "Check your Mail!");
                
            ssql="UPDATE sform SET pass=? where uname=?";
            pst=cn.prepareStatement(ssql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pst.setString(1,dat);
            pst.setString(2,name);
           
            pst.executeUpdate();
            
            
            cn.close();
           
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Username & Hint Password are not matched !");
                        
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
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

        lbluname = new javax.swing.JLabel();
        lblque = new javax.swing.JLabel();
        lblhpass = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        btnrecover = new javax.swing.JButton();
        txtque = new javax.swing.JComboBox();
        txthpass = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Forget Password");
        setPreferredSize(new java.awt.Dimension(476, 322));

        lbluname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbluname.setText("Username :");

        lblque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblque.setText("Hint Question :");

        lblhpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblhpass.setText("Hint Password :");

        btnrecover.setText("Recover");
        btnrecover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecoverActionPerformed(evt);
            }
        });

        txtque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is your First Car's no?", "Where were you born?", "What is your mother tongue?", "What is your fav sweet dish?", "Who is sunima?" }));
        txtque.setSelectedIndex(4);
        txtque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbluname)
                            .addComponent(lblhpass)
                            .addComponent(lblque))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtuname)
                            .addComponent(txtque, 0, 1, Short.MAX_VALUE)
                            .addComponent(txthpass, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnrecover)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbluname)
                    .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblque)
                    .addComponent(txtque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblhpass)
                    .addComponent(txthpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnrecover)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqueActionPerformed

    }//GEN-LAST:event_txtqueActionPerformed

    private void btnrecoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecoverActionPerformed
        String nm=txtuname.getText();
        String pass = txthpass.getText();
         
        check(nm,pass);
    }//GEN-LAST:event_btnrecoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrecover;
    private javax.swing.JLabel lblhpass;
    private javax.swing.JLabel lblque;
    private javax.swing.JLabel lbluname;
    private javax.swing.JPasswordField txthpass;
    private javax.swing.JComboBox txtque;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
