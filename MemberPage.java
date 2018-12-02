import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class is the Member Page with all functionalities including searching other members and editing their own  * details
 * @author SEETHA VEEZHINATHAN
 *
 */

public class MemberPage extends JFrame
{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		MemberAdminQueryPage qb = new MemberAdminQueryPage();
		DataObjectChild dataChild = new DataObjectChild();
		
		String UserName;
		Container c;
		JButton bt_edit_member;		
		JButton bt_SaveMember;
		JButton bt_view_member;
		JButton bt_logout;
		JLabel lbl_Mtitle;
		JLabel lbl_Username;
		JLabel lbl_Fname;
		JLabel lbl_Lname;
		JLabel lbl_Role;
		JLabel lbl_Contact;
		JLabel lbl_Address;
		JLabel lbl_Pwd;
		JTextField txt_viewUsername;
		JTextField txt_viewFname;
		JTextField txt_viewLname;
		JTextField txt_viewRole;
		JTextField txt_viewContact;
		JTextField txt_viewAddress;

		JTextField txt_editUsername;
		JTextField txt_editFname;
		JTextField txt_editLname;
		JTextField txt_editRole;
		JTextField txt_editContact;
		JTextField txt_editAddress;
		JPasswordField txt_editPwd;
		JLabel lbl_enter_uname;
		JTextField txt_enter_Uname;
		JLabel lbl_addMessage;
		JLabel lbl_Welcome;
		JLabel lbl_user;
		
		Color bt_MBck = new Color( 59,89,152);
		Color txt_Mcol = new Color( 59,89,152);

		
		public void getUserName(String Uname)
		{
			lbl_Welcome.setText("Welcome   " +Uname);
			lbl_user.setText(Uname);
		}
		
		public MemberPage()
		{
					
			// Create 2 Buttons which will display the various functionalities of the Member
			setSize(1750,730);
			setVisible(true);
			setTitle("Member Home Page");
			c=getContentPane();
			Color mdBck = new Color( 223,227,238 );
			c.setBackground(mdBck);
			
			//Display Member Page title section
			
			lbl_Mtitle=new JLabel("  Member Portal");
			lbl_Mtitle.setBounds(0,0,1750,100);
			lbl_Mtitle.setOpaque(true);
			Color tit_Mcol = new Color(59,89,152);
			lbl_Mtitle.setBackground(tit_Mcol);
			lbl_Mtitle.setForeground(Color.WHITE);
			lbl_Mtitle.setFont(new Font("Tahoma", Font.BOLD, 35));
			c.add(lbl_Mtitle);

			
			lbl_Welcome = new JLabel();			
			lbl_Welcome.setVisible(true);
			lbl_Welcome.setBounds(50,100,200,40);
			lbl_Welcome.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
			lbl_Welcome.setForeground(Color.BLACK);  
			c.add(lbl_Welcome);
			
			lbl_user = new JLabel();
			
			txt_enter_Uname = new JTextField();
			txt_enter_Uname.setBounds(250,150,180, 40);
		    txt_enter_Uname.setVisible(true);
		    c.add(txt_enter_Uname); 
	        
			lbl_enter_uname = new JLabel("Enter User Name to Search");
			lbl_enter_uname.setBounds(20, 150, 300, 40);
			lbl_enter_uname.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
			lbl_enter_uname.setForeground(txt_Mcol);
			lbl_enter_uname.setVisible(true);
			c.add(lbl_enter_uname);
			
			JButton bt_view_member=new JButton("Search Member");    
			bt_view_member.setBounds(480,150,160,40); 
			bt_view_member.setFont(new Font("Tahoma", Font.BOLD, 12));
			bt_view_member.setBackground(bt_MBck);
			bt_view_member.setForeground(Color.WHITE);
			
			JButton bt_edit_member=new JButton("Edit My Information");    
			bt_edit_member.setBounds(700, 150, 170, 40);
			bt_edit_member.setFont(new Font("Tahoma", Font.BOLD, 12));
			bt_edit_member.setBackground(bt_MBck);
			bt_edit_member.setForeground(Color.WHITE);
			
			JButton bt_SaveMember=new JButton("Save");    
			bt_SaveMember.setBounds(500,580,140, 40); 
			bt_SaveMember.setBounds(250, 630, 160, 40);
			bt_SaveMember.setFont(new Font("Tahoma", Font.BOLD, 12));
			bt_SaveMember.setBackground(bt_MBck);
			bt_SaveMember.setForeground(Color.WHITE);
	        bt_SaveMember.setVisible(false);
			
			JButton bt_logout=new JButton("Logout");    
			bt_logout.setBounds(1200, 150, 120, 40); 
			bt_logout.setFont(new Font("Tahoma", Font.BOLD, 12));
			bt_logout.setBackground(Color.BLACK);
			bt_logout.setForeground(Color.WHITE);
			
			c.add(bt_edit_member);
			c.add(bt_view_member);
	        c.add(bt_SaveMember);
			c.add(bt_logout);
			c.setLayout(null);

			// Label and Text Field Initialization 
			lbl_Username = new JLabel("User Name");
			lbl_Username.setBounds(20, 250, 100, 20);
	        lbl_Username.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
	        lbl_Username.setForeground(txt_Mcol);
	        lbl_Username.setVisible(false);
	        c.add(lbl_Username);            
	                    
			lbl_Fname = new JLabel("First Name");
			lbl_Fname.setBounds(20, 300, 100, 20);
	        lbl_Fname.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Fname.setForeground(txt_Mcol);
	        lbl_Fname.setVisible(false);
	        c.add(lbl_Fname);
	        
			lbl_Lname = new JLabel("Last Name");
			lbl_Lname.setBounds(20, 350, 100, 20);
	        lbl_Lname.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Lname.setForeground(txt_Mcol);
	        lbl_Lname.setVisible(false);
	        c.add(lbl_Lname);
	        
			lbl_Role = new JLabel("Member Role");
			lbl_Role.setBounds(20, 400, 150, 20);
	        lbl_Role.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
	        lbl_Role.setForeground(txt_Mcol);
	        lbl_Role.setVisible(false);
	        c.add(lbl_Role);
	        
			lbl_Contact = new JLabel("Contact Number");
			lbl_Contact.setBounds(20, 450, 150, 20);
	        lbl_Contact.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
	        lbl_Contact.setForeground(txt_Mcol);
	        lbl_Contact.setVisible(false);
	        c.add(lbl_Contact);
	        
			lbl_Address = new JLabel("Mailing Address");
	        lbl_Address.setBounds(20,500, 150, 20);
            lbl_Address.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Address.setForeground(txt_Mcol);
	        lbl_Address.setVisible(false);
	        c.add(lbl_Address);
	        
			lbl_Pwd = new JLabel("Password");
			lbl_Pwd.setBounds(20,550, 100, 20);
            lbl_Pwd.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Pwd.setForeground(txt_Mcol);
	        lbl_Pwd.setVisible(false);
	        c.add(lbl_Pwd);	     
	        
	        txt_viewUsername = new JTextField();
	        txt_viewUsername.setBounds(250, 250, 300, 25);
	        txt_viewUsername.setVisible(false);
	        c.add(txt_viewUsername);      
	        
	        txt_viewFname = new JTextField();
	        txt_viewFname.setBounds(250, 300, 300, 25);
			txt_viewFname.setVisible(false);
	        c.add(txt_viewFname);
	        
			txt_viewLname = new JTextField();
			txt_viewLname.setBounds(250, 350, 300, 25);
			txt_viewLname.setVisible(false);
	        c.add(txt_viewLname);
	        
			txt_viewRole = new JTextField();
			txt_viewRole.setBounds(250, 400, 300, 25);
			txt_viewRole.setVisible(false);
	        c.add(txt_viewRole);
	        
			txt_viewContact = new JTextField();
			txt_viewContact.setBounds(250,450,300,25);
			txt_viewContact.setVisible(false);
	        c.add(txt_viewContact);
	        
			txt_viewAddress = new JTextField();
			txt_viewAddress.setBounds(250, 500, 300, 25);
			txt_viewAddress.setVisible(false);
	        c.add(txt_viewAddress);
	        
	        txt_editUsername = new JTextField();
	        txt_editUsername.setBounds(250, 250, 300, 25);
	        txt_editUsername.setVisible(false);
	        c.add(txt_editUsername);      
	        
			txt_editFname = new JTextField();
			txt_editFname.setBounds(250, 300, 300, 25);
			txt_editFname.setVisible(false);
	        c.add(txt_editFname);
	        
			txt_editLname = new JTextField();
			txt_editLname.setBounds(250, 350, 300, 25);
			txt_editLname.setVisible(false);
	        c.add(txt_editLname);
	        
			txt_editRole = new JTextField();
			txt_editRole.setBounds(250, 400, 300, 25);
			txt_editRole.setVisible(false);
	        c.add(txt_editRole);
	        
			txt_editContact = new JTextField();
			txt_editContact.setBounds(250, 450, 300, 25);
			txt_editContact.setVisible(false);
	        c.add(txt_editContact);
	        
			txt_editAddress = new JTextField();
			txt_editAddress.setBounds(250, 500, 300, 25);
			txt_editAddress.setVisible(false);
	        c.add(txt_editAddress);
	        
			txt_editPwd = new JPasswordField();
			txt_editPwd.setBounds(250, 550, 300, 25);
			txt_editPwd.setVisible(false);
	        c.add(txt_editPwd);
	        
	        lbl_addMessage = new JLabel();
        
	        // Button event to view details of other members
	        bt_view_member.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(txt_enter_Uname.getText().equals(""))
        			{
        				lbl_addMessage.setVisible(false);
    	        		lbl_Username.setVisible(false);
    	          		lbl_Fname.setVisible(false);
    	          		lbl_Lname.setVisible(false);
    	          		lbl_Role.setVisible(false);
    	          		lbl_Contact.setVisible(false);
    	          		lbl_Address.setVisible(false);
    	          		lbl_Pwd.setVisible(false);
    	          		bt_SaveMember.setVisible(false);
    	          		txt_editUsername.setVisible(false);
    	          		txt_editFname.setVisible(false);
    	          		txt_editLname.setVisible(false);
    	          		txt_editRole.setVisible(false);
    	          		txt_editContact.setVisible(false);
    	          		txt_editAddress.setVisible(false);
    	          		txt_editPwd.setVisible(false);
    	          		txt_viewUsername.setVisible(false);
    	          		txt_viewFname.setVisible(false);
    	          		txt_viewLname.setVisible(false);
    	          		txt_viewRole.setVisible(false);
    	          		txt_viewContact.setVisible(false);
    	          		txt_viewAddress.setVisible(false);
    	          		txt_viewUsername.setEditable(false);
    	          		txt_viewFname.setEditable(false);
    	          		txt_viewLname.setEditable(false);
    	          		txt_viewRole.setEditable(false);
    	          		txt_viewContact.setEditable(false);
    	          		txt_viewAddress.setEditable(false);  	
    	          		
    	          		JOptionPane.showMessageDialog(lbl_addMessage,"Enter Username to View Information!");
           				lbl_addMessage.setBounds(500,300,100,100);
        				c.add(lbl_addMessage);
        			}
        			else
        			{   	          			
    	          		String[] string = new String[7];
    	          		string = qb.viewMemberDetails(txt_enter_Uname.getText());
    	          		
   	        			txt_viewUsername.setText(string[0]);
	          			txt_viewFname.setText(string[1]);
	          			txt_viewLname.setText(string[2]);
	          			txt_viewRole.setText(string[3]);
	          			txt_viewContact.setText(string[4]);
	          			txt_viewAddress.setText(string[5]);
	          			//txt_viewPwd.setText(string[6]); 
	          			
	          			if (txt_viewUsername.getText().equals(" "))
              			{
    	          			lbl_addMessage.setVisible(false);
        	        		lbl_Username.setVisible(false);
        	          		lbl_Fname.setVisible(false);
        	          		lbl_Lname.setVisible(false);
        	          		lbl_Role.setVisible(false);
        	          		lbl_Contact.setVisible(false);
        	          		lbl_Address.setVisible(false);
        	          		lbl_Pwd.setVisible(false);
        	          		bt_SaveMember.setVisible(false);
        	          		txt_editUsername.setVisible(false);
        	          		txt_editFname.setVisible(false);
        	          		txt_editLname.setVisible(false);
        	          		txt_editRole.setVisible(false);
        	          		txt_editContact.setVisible(false);
        	          		txt_editAddress.setVisible(false);
        	          		txt_editPwd.setVisible(false);
        	          		txt_viewUsername.setVisible(false);
        	          		txt_viewFname.setVisible(false);
        	          		txt_viewLname.setVisible(false);
        	          		txt_viewRole.setVisible(false);
        	          		txt_viewContact.setVisible(false);
        	          		txt_viewAddress.setVisible(false);
        	          		txt_viewUsername.setEditable(false);
        	          		txt_viewFname.setEditable(false);
        	          		txt_viewLname.setEditable(false);
        	          		txt_viewRole.setEditable(false);
        	          		txt_viewContact.setEditable(false);
        	          		txt_viewAddress.setEditable(false);  		
        	          		txt_enter_Uname.setText("");
        	          		
        	          		JOptionPane.showMessageDialog(lbl_addMessage,"Enter correct Username!");
               				lbl_addMessage.setBounds(500,300,100,100);
            				c.add(lbl_addMessage);
              			}
    	          		else
    	          		{
  	          			
   		          			lbl_addMessage.setVisible(false);
        	        		lbl_Username.setVisible(true);
        	          		lbl_Fname.setVisible(true);
        	          		lbl_Lname.setVisible(true);
        	          		lbl_Role.setVisible(true);
        	          		lbl_Contact.setVisible(true);
        	          		lbl_Address.setVisible(true);
        	          		lbl_Pwd.setVisible(false);
        	          		bt_SaveMember.setVisible(false);
        	          		txt_editUsername.setVisible(false);
        	          		txt_editFname.setVisible(false);
        	          		txt_editLname.setVisible(false);
        	          		txt_editRole.setVisible(false);
        	          		txt_editContact.setVisible(false);
        	          		txt_editAddress.setVisible(false);
        	          		txt_editPwd.setVisible(false);
        	          		txt_viewUsername.setVisible(true);
        	          		txt_viewFname.setVisible(true);
        	          		txt_viewLname.setVisible(true);
        	          		txt_viewRole.setVisible(true);
        	          		txt_viewContact.setVisible(true);
        	          		txt_viewAddress.setVisible(true);
        	          		
        	          		txt_viewUsername.setEditable(false);
        	          		txt_viewFname.setEditable(false);
        	          		txt_viewLname.setEditable(false);
        	          		txt_viewRole.setEditable(false);
        	          		txt_viewContact.setEditable(false);
        	          		txt_viewAddress.setEditable(false);
        	          		txt_enter_Uname.setText("");
        	          		
    	          		}

    	          	}
	        	}
	        });

	       // Button Event to enable member to edit his/her information
	       bt_edit_member.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {	        		
	        		lbl_Username.setVisible(true);
	          		lbl_Fname.setVisible(true);
	          		lbl_Lname.setVisible(true);
	          		lbl_Role.setVisible(true);
	          		lbl_Contact.setVisible(true);
	          		lbl_Address.setVisible(true);
	          		lbl_Pwd.setVisible(true);
	          		bt_SaveMember.setVisible(true);
	          		txt_viewUsername.setVisible(false);
	          		txt_viewFname.setVisible(false);
	          		txt_viewLname.setVisible(false);
	          		txt_viewRole.setVisible(false);
	          		txt_viewContact.setVisible(false);
	          		txt_viewAddress.setVisible(false);
	          		txt_editUsername.setEditable(false);
	          		txt_editUsername.setVisible(true);
	          		txt_editFname.setVisible(true);
	          		txt_editLname.setVisible(true);
	          		txt_editRole.setVisible(true);
	          		txt_editContact.setVisible(true);
	          		txt_editAddress.setVisible(true);
	          		txt_editPwd.setVisible(true);
	          		try {
	          			String[] string = new String[7];
	          			string = qb.viewMemberDetails(lbl_user.getText());
	          			txt_editUsername.setText(string[0]);
	          			txt_editFname.setText(string[1]);
	          			txt_editLname.setText(string[2]);
	          			txt_editRole.setText(string[3]);
	          			txt_editContact.setText(string[4]);
	          			txt_editAddress.setText(string[5]);
	          			txt_editPwd.setText(string[6]);           			
	          			
					} catch (Exception e1)
	          		{
						e1.printStackTrace();
					}

	        	}
	        });
	       
	       // Button Event to Save the edited information
	       
	       bt_SaveMember.addActionListener(new ActionListener() {
           	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
           		lbl_addMessage.setVisible(true);    		
           		lbl_addMessage.setText("");
           		boolean bool = false;
           		bool = qb.editMember(txt_editUsername.getText(),txt_editFname.getText(),txt_editLname.getText(),
   				txt_editRole.getText(),txt_editContact.getText(),txt_editAddress.getText(),txt_editPwd.getText());
           		if(bool)
           		{
           			JOptionPane.showMessageDialog(lbl_addMessage,"Member information updated Successfully!");
       				lbl_addMessage.setBounds(500,300,100,100);
    				c.add(lbl_addMessage);
          		}
           		else
           		{
           			JOptionPane.showMessageDialog(lbl_addMessage,"Member information could not be updated!");
       				lbl_addMessage.setBounds(500,300,100,100);
    				c.add(lbl_addMessage); 
           		}
           	}
           });

	       
           // Button Event for logout
           bt_logout.addActionListener(new ActionListener() 
           {
             	public void actionPerformed(ActionEvent e) 
             	{
             	    int a=JOptionPane.showConfirmDialog(c,"Are you Sure?","Logout",JOptionPane.OK_CANCEL_OPTION);  
             	    if(a==JOptionPane.YES_OPTION){
                  	    LoginFrame lf = new LoginFrame();
                  	    lf.setVisible(true);
                  	    dispose();
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
		              new MemberPage();

		          }
		      }); 
		  } 
}
