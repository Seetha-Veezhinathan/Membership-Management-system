import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the login page of the application
 * @author SEETHA VEEZHINATHAN
 *
 */

public class LoginFrame extends JFrame
{
/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	Container c;
	JLabel lbl_uname;
	JLabel lbl_password;
	JLabel lbl_title;
	JLabel lbl_Log;
	JTextField txt_username;
	JTextField txt_password;
	JButton bt_Login;

	MemberAdminQueryPage qb = new MemberAdminQueryPage();
	DataObjectChild dataChild = new DataObjectChild();

	public LoginFrame() {
		setSize(1750,730);
		setVisible(true);

		c=getContentPane();
		Color pan1 = new Color( 223,227,238 );
		c.setBackground(pan1);
		
		lbl_title=new JLabel("  Online Membership System");
		lbl_title.setBounds(0,0,1750,100);
		lbl_title.setOpaque(true);		
		Color tit_col = new Color(59,89,152);
		lbl_title.setBackground(tit_col);
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 35));
		lbl_title.setForeground(Color.white); 
		
		lbl_Log=new JLabel("Please Login");
		lbl_Log.setBounds(620,120,150,150);
		lbl_Log.setFont(new Font("Tahoma", Font.BOLD, 20));
		Color log_col = new Color( 59,89,152);
		lbl_Log.setForeground(log_col);
		 			
		lbl_uname=new JLabel("Username");
		lbl_uname.setBounds(450,250,100,50);
		lbl_uname.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		Color un_col = new Color( 59,89,152);
		lbl_uname.setForeground(un_col);			
	
		lbl_password=new JLabel("Password");
		lbl_password.setBounds(450,350,100,50);
		lbl_password.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		Color pwd_col = new Color( 59,89,152);
		lbl_password.setForeground(pwd_col);  
		
		txt_username=new JTextField(10);
		txt_username.setBounds(580,260,250,30);
		txt_password = new JPasswordField();
		txt_password.setBounds(580,360,250,30);

		JButton bt_Login=new JButton("LOGIN");
		bt_Login.setBounds(620,450,150,40);
		Color bt_1 = new Color( 59,89,152);
		bt_Login.setBackground(bt_1);
		bt_Login.setForeground(Color.WHITE);
		
		bt_Login.setFont(new Font("Lucida Calligraphy", Font.BOLD, 12));
		
		c.add(lbl_title);
		c.add(lbl_Log);
		c.add(lbl_uname);
		c.add(lbl_password);
		c.add(txt_username);
		c.add(txt_password);
		c.add(bt_Login);
		c.setLayout(null);
 
		JLabel message=new JLabel();	
		message.setBounds(250,350,200,50);
  
		bt_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pwd = qb.performCredValidation(txt_username.getText(), txt_password.getText());
				message.setText("");
				if(pwd.equals(txt_password.getText()))
				{
					
					String userRole = qb.getUserRole(txt_username.getText());
					if(userRole.equals("Admin"))
					{
						AdminPage ap = new AdminPage();
						ap.setVisible(true);	
						ap.displayMemberTable();
						dispose();
					}			
					else if(userRole.equals("Member"))
					{
						MemberPage mp = new MemberPage();
						mp.getUserName(txt_username.getText());
						mp.setVisible(true);		
						dispose();
					}
      				//JOptionPane.showMessageDialog(message,"Login Successful!");
      				message.setBounds(500,300,100,100);
    				c.add(message); 
    				txt_username.setEnabled(false);
					txt_password.setEnabled(false);					 			
				}
				else
				{
      				JOptionPane.showMessageDialog(message,"Wrong Username or Password!");
      				message.setBounds(500,300,100,100);
    				c.add(message); 
				}
			}
		});
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
              // TODO Auto-generated method stub
              new LoginFrame();

          }
      });
	} 
}
