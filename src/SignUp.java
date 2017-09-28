
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class SignUp extends javax.swing.JInternalFrame {

    Connection cn;
    PreparedStatement pst;
    ResultSet rs;
    int i=0;
    String ssql,sql;
    public SignUp() {
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
   
   public void InsertRecords(String name,String pass,String repass,Object hq,String hp,String email)
    {
        try
        {
            MyConnection();
            ssql="Select * From sform Where uname=?";
            
            pst=cn.prepareStatement(ssql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pst.setString(1,name);
            rs=pst.executeQuery();
            rs.last();
            if(rs.getRow()==0)
            {
                
                if(pass.equalsIgnoreCase(repass))
                {
                    ssql="insert into sform values(?,?,?,?,?)";
                    pst=cn.prepareStatement(ssql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    pst.setString(1,name);
                    pst.setString(2,pass);
                    pst.setObject(3,hq);
                    pst.setString(4,hp);
                    pst.setString(5,email);
            
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this,"You've Registered Succesfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Password do no match!");
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Username is already taken! Try a new one");
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

        lbluname = new javax.swing.JLabel();
        lblpass = new javax.swing.JLabel();
        lblrepass = new javax.swing.JLabel();
        lblque = new javax.swing.JLabel();
        lblans = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        btnregister = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtrepass = new javax.swing.JPasswordField();
        txtpass = new javax.swing.JPasswordField();
        txthpass = new javax.swing.JPasswordField();
        txtque = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sign Up ");
        setPreferredSize(new java.awt.Dimension(500, 444));

        lbluname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbluname.setText("Username :");

        lblpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblpass.setText("Password :");

        lblrepass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblrepass.setText("Retype Password :");

        lblque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblque.setText("Hint Question :");

        lblans.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblans.setText("Hint Password :");

        lblemail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblemail.setText("Email Id :");

        btnregister.setText("Register");
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tekton Pro Cond", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("New User");

        txthpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthpassActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbluname, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblque)
                            .addComponent(lblpass)
                            .addComponent(lblrepass)
                            .addComponent(lblans)
                            .addComponent(lblemail))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtuname)
                            .addComponent(txtemail)
                            .addComponent(txtrepass)
                            .addComponent(txtpass)
                            .addComponent(txthpass)
                            .addComponent(txtque, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnregister)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbluname, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpass)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblrepass)
                    .addComponent(txtrepass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblque)
                    .addComponent(txtque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblans)
                    .addComponent(txthpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblemail)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnregister)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
            
            String name=txtuname.getText();
            String pass=txtpass.getText();
            
            String repass=txtrepass.getText();
            Object hq=txtque.getSelectedItem();
           // String hq=txtque.getText();
            String hp=txthpass.getText();
            String email=txtemail.getText();
            
            
            
            
            InsertRecords(name,pass,repass,hq,hp,email);
            
            txtuname.setText("");
            txtpass.setText("");
            txtrepass.setText("");
            //txtque.setText("");
            txthpass.setText("");
            txtemail.setText("");
            
    }//GEN-LAST:event_btnregisterActionPerformed

    private void txthpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthpassActionPerformed

    private void txtqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqueActionPerformed
        
    }//GEN-LAST:event_txtqueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblans;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblpass;
    private javax.swing.JLabel lblque;
    private javax.swing.JLabel lblrepass;
    private javax.swing.JLabel lbluname;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txthpass;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JComboBox txtque;
    private javax.swing.JPasswordField txtrepass;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
