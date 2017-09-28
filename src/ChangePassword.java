
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ChangePassword extends javax.swing.JInternalFrame {

   
    Connection cn;
    PreparedStatement pst;
    ResultSet rs;
    int i=0,count=0;
    String ssql,sql;
    public ChangePassword() {
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
    
    public void UpdateRecords(String op,String np,String nm)
    {
        try
        {
            MyConnection();
          
            ssql = "SELECT * FROM sform where uname=? and pass=?";
        
            pst=cn.prepareStatement(ssql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pst.setString(1,nm);
            pst.setString(2,op);
            rs=pst.executeQuery();
            rs.last();

        if(rs.getRow()!=0)
        {
           
            ssql="UPDATE sform SET pass=? where uname=?";
            pst=cn.prepareStatement(ssql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pst.setString(1,np);
            pst.setString(2,nm);
           
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Password Changed");
            
            cn.close();
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Wrong password");
        }
        }
        
        catch(Exception e)
        {
            
            JOptionPane.showMessageDialog(this,e);
        }
                    
               
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtoldpass = new javax.swing.JPasswordField();
        txtnewpass = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Change Password");
        setPreferredSize(new java.awt.Dimension(387, 234));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Old Password :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("New Password :");

        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtoldpass, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtnewpass)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButton1)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtoldpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnewpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            String op=txtoldpass.getText();
            String np=txtnewpass.getText();
            String nm=SignIn.txtuname1.getText();
            UpdateRecords(op,np,nm);
            txtoldpass.setText("");
            txtnewpass.setText("");
            dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtnewpass;
    private javax.swing.JPasswordField txtoldpass;
    // End of variables declaration//GEN-END:variables
}
