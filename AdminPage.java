import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class is the Admin Page with all functionalities like adding, removing and editing existing members
 * @author SEETHA VEEZHINATHAN
 *
 */

public class AdminPage extends JFrame
{
	MemberAdminQueryPage qb = new MemberAdminQueryPage();
	DataObjectChild dataChild = new DataObjectChild();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTable table;
	Container c;
	JButton bt_add_member;
	JButton bt_remove_member;
	JButton bt_edit_member;
	JButton bt_view_member;
	JButton bt_aSaveMember;
	JButton bt_delMember;
	JButton bt_eSaveMember;
	JButton bt_dispTable;
	
	JLabel lbl_Username;
	JLabel lbl_Fname;
	JLabel lbl_Lname;
	JLabel lbl_Role;
	JLabel lbl_Contact;
	JLabel lbl_Address;
	JLabel lbl_Pwd;
	JTextField txt_addUsername;
	JTextField txt_addFname;
	JTextField txt_addLname;
	JTextField txt_addRole;
	JTextField txt_addContact;
	JTextField txt_addAddress;
	JPasswordField txt_addPwd;	
	JTextField txt_delMember;
	JTextField txt_editUsername;
	JTextField txt_editFname;
	JTextField txt_editLname;
	JTextField txt_editRole;
	JTextField txt_editContact;
	JTextField txt_editAddress;
	JPasswordField txt_editPwd;
	JTextField txt_enter_Uname;
	JLabel lbl_addMessage;
	JLabel lbl_remUsername;
	JLabel lbl_Search;
	Color bt_Bck = new Color( 59,89,152);
	Color txt_col = new Color( 59,89,152);

	
	public AdminPage()
	{
			setSize(1750,730);
			setVisible(true);
			setTitle("Admin Home Page");			
			c=getContentPane();
			Color adBck = new Color( 223,227,238 );
			c.setBackground(adBck);

			//code to display Admin Page title section
			
			JLabel lbl_Atitle=new JLabel("   Administator Portal");
			lbl_Atitle.setBounds(0,0,1750,100);
			lbl_Atitle.setOpaque(true);
			Color tit_Acol = new Color(59,89,152);
			lbl_Atitle.setBackground(tit_Acol);
			lbl_Atitle.setFont(new Font("Tahoma", Font.BOLD, 35));
			lbl_Atitle.setForeground(Color.white);		
			c.add(lbl_Atitle);
          
			// Create 4 Buttons which will display the various functionalities of the Admin
			JButton bt_add_member=new JButton("Add Member");    
			bt_add_member.setBounds(100,150,160, 40);
			bt_add_member.setFont(new Font("Tahoma", Font.BOLD, 12));
			bt_add_member.setBackground(bt_Bck);
			bt_add_member.setForeground(Color.WHITE);
			
			JButton bt_remove_member=new JButton("Remove Member");    
			bt_remove_member.setBounds(300,150,160, 40); 
			bt_remove_member.setFont(new Font("Tahoma", Font.BOLD, 12));
			bt_remove_member.setBackground(bt_Bck);
			bt_remove_member.setForeground(Color.WHITE);
			
			JButton bt_view_member=new JButton("View Member");    
			bt_view_member.setBounds(500,150,160, 40); 			
			bt_view_member.setFont(new Font("Tahoma", Font.BOLD, 12));
			bt_view_member.setBackground(bt_Bck);
			bt_view_member.setForeground(Color.WHITE);
						
			JButton bt_edit_member=new JButton("Edit Member");    
			bt_edit_member.setBounds(200, 630, 140, 40);
			bt_edit_member.setFont(new Font("Tahoma", Font.BOLD, 12));
			bt_edit_member.setBackground(bt_Bck);
			bt_edit_member.setForeground(Color.WHITE);
			bt_edit_member.setVisible(false);	

			JButton bt_logout=new JButton("Logout");    
			bt_logout.setBounds(1220, 150, 120, 40); 
			bt_logout.setFont(new Font("Tahoma", Font.BOLD, 12));
			bt_logout.setBackground(Color.BLACK);
			bt_logout.setForeground(Color.WHITE);
			
			c.add(bt_add_member);
			c.add(bt_remove_member);
			c.add(bt_edit_member);
			c.add(bt_view_member);
			c.add(bt_logout);
			c.setLayout(null);
			
			// Label and Text Field Initialization 
			lbl_Username = new JLabel("User Name");
            lbl_Username.setBounds(20, 250, 100, 20);
            lbl_Username.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Username.setForeground(txt_col);  
            lbl_Username.setVisible(false);
            c.add(lbl_Username);            
                        
			lbl_Fname = new JLabel("First Name");
			lbl_Fname.setBounds(20, 300, 100, 20);
            lbl_Fname.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Fname.setForeground(txt_col);
            lbl_Fname.setVisible(false);
            c.add(lbl_Fname);
            
			lbl_Lname = new JLabel("Last Name");
			lbl_Lname.setBounds(20, 350, 100, 20);
            lbl_Lname.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Lname.setForeground(txt_col);
            lbl_Lname.setVisible(false);
            c.add(lbl_Lname);
            
			lbl_Role = new JLabel("Member Role");
			lbl_Role.setBounds(20, 400, 150, 20);
            lbl_Role.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Role.setForeground(txt_col);
            lbl_Role.setVisible(false);
            c.add(lbl_Role);
            
			lbl_Contact = new JLabel("Contact Number");
			lbl_Contact.setBounds(20, 450, 150, 20);
            lbl_Contact.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Contact.setForeground(txt_col);
            lbl_Contact.setVisible(false);
            c.add(lbl_Contact);
            
			lbl_Address = new JLabel("Mailing Address");
			lbl_Address.setBounds(20,500, 150, 20);
            lbl_Address.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Address.setForeground(txt_col);
            lbl_Address.setVisible(false);
            c.add(lbl_Address);
            
			lbl_Pwd = new JLabel("Password");
			lbl_Pwd.setBounds(20,550, 100, 20);
            lbl_Pwd.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_Pwd.setForeground(txt_col);
            lbl_Pwd.setVisible(false);
            c.add(lbl_Pwd);
            
			txt_addUsername = new JTextField();
			txt_addUsername.setBounds(250, 250, 300, 25);
			txt_addUsername.setVisible(false);
            c.add(txt_addUsername);      
            
			txt_addFname = new JTextField();
			txt_addFname.setBounds(250, 300, 300, 25);
			txt_addFname.setVisible(false);
            c.add(txt_addFname);
            
			txt_addLname = new JTextField();
			txt_addLname.setBounds(250, 350, 300, 25);
			txt_addLname.setVisible(false);
            c.add(txt_addLname);
            
			txt_addRole = new JTextField();
			txt_addRole.setBounds(250, 400, 300, 25);
			txt_addRole.setVisible(false);
            c.add(txt_addRole);
            
			txt_addContact = new JTextField();
			txt_addContact.setBounds(250, 450, 300, 25);
			txt_addContact.setVisible(false);
            c.add(txt_addContact);
            
			txt_addAddress = new JTextField();
			txt_addAddress.setBounds(250, 500, 300, 25);
			txt_addAddress.setVisible(false);
            c.add(txt_addAddress);
            
			txt_addPwd = new JPasswordField();
			txt_addPwd.setBounds(250, 550, 300, 25);
			txt_addPwd.setVisible(false);
            c.add(txt_addPwd);
            
            lbl_addMessage = new JLabel();
            lbl_addMessage.setFont(new Font("Courier New", Font.ITALIC, 20));
            
            JButton bt_aSaveMember = new JButton("Save Member");
            bt_aSaveMember.setBounds(250, 630, 160, 40);
            bt_aSaveMember.setFont(new Font("Tahoma", Font.BOLD, 12));
            bt_aSaveMember.setBackground(bt_Bck);
            bt_aSaveMember.setForeground(Color.WHITE);
            bt_aSaveMember.setVisible(false);
            c.add(bt_aSaveMember);
            
			//Label and Text Field Initialization for Removing an existing Member
            
            lbl_remUsername = new JLabel("Enter Username");
            lbl_remUsername.setBounds(100, 250, 150, 25);
            lbl_remUsername.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
            lbl_remUsername.setForeground(txt_col);
            lbl_remUsername.setVisible(false);
            c.add(lbl_remUsername);
            
            txt_delMember = new JTextField();
            txt_delMember.setBounds(350,250, 150, 25);
            txt_delMember.setVisible(false);
            c.add(txt_delMember);
                        
            JButton bt_delMember = new JButton("Delete Member");
            bt_delMember.setBounds(300, 380, 140, 40);
            bt_delMember.setFont(new Font("Tahoma", Font.BOLD, 12));
            bt_delMember.setBackground(bt_Bck);
            bt_delMember.setForeground(Color.WHITE);
            bt_delMember.setVisible(false);
            c.add(bt_delMember);
            
            // Text Field Initialization for Member Information on Search
            
            lbl_Search = new JLabel("Search");
            lbl_Search.setBounds(1090,120,100, 20);
            lbl_Search.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
            lbl_Search.setForeground(txt_col); 
            lbl_Search.setVisible(true);
            c.add(lbl_Search);
            
            txt_enter_Uname = new JTextField();
            txt_enter_Uname.setToolTipText("Enter Username to Search");
            txt_enter_Uname.setFont(new Font("Tahoma", Font.ITALIC, 16));
            txt_enter_Uname.setBounds(1190,120,150, 20);
            txt_enter_Uname.setVisible(true);
            c.add(txt_enter_Uname);   
                  
            txt_editUsername = new JTextField();
            txt_editUsername.setBounds(250, 250, 300, 20);
            txt_editUsername.setVisible(false);
            c.add(txt_editUsername);      
            
			txt_editFname = new JTextField();
			txt_editFname.setBounds(250, 300, 300, 20);
			txt_editFname.setVisible(false);
            c.add(txt_editFname);
            
			txt_editLname = new JTextField();
			txt_editLname.setBounds(250, 350, 300, 20);
			txt_editLname.setVisible(false);
            c.add(txt_editLname);
            
			txt_editRole = new JTextField();
			txt_editRole.setBounds(250, 400, 300, 20);
			txt_editRole.setVisible(false);
            c.add(txt_editRole);
            
			txt_editContact = new JTextField();
			txt_editContact.setBounds(250, 450, 300, 20);
			txt_editContact.setVisible(false);
            c.add(txt_editContact);
            
			txt_editAddress = new JTextField();
			txt_editAddress.setBounds(250, 500, 300, 20);
			txt_editAddress.setVisible(false);
            c.add(txt_editAddress);
            
			txt_editPwd = new JPasswordField();
			txt_editPwd.setBounds(250, 550, 300, 20);
			txt_editPwd.setVisible(false);
            c.add(txt_editPwd);
            
            JButton bt_eSaveMember = new JButton("Save");
            bt_eSaveMember.setBounds(500, 630, 140, 40);
            bt_eSaveMember.setFont(new Font("Tahoma", Font.BOLD, 12));
            bt_eSaveMember.setBackground(bt_Bck);
            bt_eSaveMember.setForeground(Color.WHITE);
            bt_eSaveMember.setVisible(false);
            c.add(bt_eSaveMember);
                        
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
            
            // Button Event for Add Member Button
            bt_add_member.addActionListener(new ActionListener() 
            {
              	public void actionPerformed(ActionEvent e) 
              	{
              		lbl_Username.setVisible(true);
              		lbl_Fname.setVisible(true);
              		lbl_Lname.setVisible(true);
              		lbl_Role.setVisible(true);
              		lbl_Contact.setVisible(true);
              		lbl_Address.setVisible(true);
              		lbl_Pwd.setVisible(true);
              		txt_addUsername.setVisible(true);
              		txt_addFname.setVisible(true);
              		txt_addLname.setVisible(true);
              		txt_addRole.setVisible(true);
              		txt_addContact.setVisible(true);
              		txt_addAddress.setVisible(true);
              		txt_addPwd.setVisible(true);   
              		txt_delMember.setText("");
              		bt_aSaveMember.setVisible(true);
              		lbl_remUsername.setVisible(false);
              		txt_delMember.setVisible(false);
              		bt_delMember.setVisible(false);
              		lbl_addMessage.setVisible(false);
               		txt_editUsername.setVisible(false);
              		txt_editFname.setVisible(false);
               		txt_editLname.setVisible(false);
              		txt_editRole.setVisible(false);
              		txt_editContact.setVisible(false);
              		txt_editAddress.setVisible(false);
              		txt_editPwd.setVisible(false);
              		bt_edit_member.setVisible(false);
              		bt_eSaveMember.setVisible(false);
              	}
            });
            
            // Button Action for Saving a New Member to the DB
            bt_aSaveMember.addActionListener(new ActionListener() {
            	@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) 
            	{
            		String[] QueryResult =  new String[1];
            		QueryResult = qb.checkUserNameinDB(txt_addUsername.getText());
            		if(QueryResult[0].equals(txt_addUsername.getText()))
            		{
            			
            			JOptionPane.showMessageDialog(lbl_addMessage,"Member already exists in DataBase");
           				lbl_addMessage.setBounds(500,300,100,100);
        				c.add(lbl_addMessage);                	
            		}
            		else
            		{
            			lbl_addMessage.setVisible(true);
                		lbl_addMessage.setText("");
               			boolean bool = false;
               			bool = qb.addNewMember(txt_addUsername.getText(), txt_addFname.getText(), txt_addLname.getText(),
                				txt_addRole.getText(),txt_addContact.getText(),txt_addAddress.getText(), txt_addPwd.getText());           			
               			if(bool)
               			{
               				JOptionPane.showMessageDialog(lbl_addMessage,"Member Addedd Successfully");
               				lbl_addMessage.setBounds(500,300,100,100);
            				c.add(lbl_addMessage); 
            				displayMemberTable();
              			}
               			else
               			{
               				JOptionPane.showMessageDialog(lbl_addMessage,"Member Cannot be Added");
               				lbl_addMessage.setBounds(500,300,100,100);
            				c.add(lbl_addMessage); 
               			}
            		}
           		}
         });
            
           
            // Button Event for Remove Member Button
            bt_remove_member.addActionListener(new ActionListener() 
            {
              	public void actionPerformed(ActionEvent e) 
              	{
              		lbl_remUsername.setVisible(true);
              		txt_delMember.setVisible(true);
              		bt_delMember.setVisible(true);
             		lbl_Username.setVisible(false);
              		lbl_Fname.setVisible(false);
              		lbl_Lname.setVisible(false);
              		lbl_Role.setVisible(false);
              		lbl_Contact.setVisible(false);
              		lbl_Address.setVisible(false);
              		lbl_Pwd.setVisible(false);
              		txt_addUsername.setVisible(false);
              		txt_addFname.setVisible(false);
              		txt_addLname.setVisible(false);
              		txt_addRole.setVisible(false);
              		txt_addContact.setVisible(false);
              		txt_addAddress.setVisible(false);
              		txt_addPwd.setVisible(false);  
              		txt_addUsername.setText("");
              		txt_addFname.setText("");
              		txt_addLname.setText("");
              		txt_addRole.setText("");
              		txt_addContact.setText("");
              		txt_addAddress.setText("");
              		txt_addPwd.setText("");
              		bt_aSaveMember.setVisible(false);
              		lbl_addMessage.setVisible(false);
              		txt_editUsername.setVisible(false);
              		txt_editFname.setVisible(false);
               		txt_editLname.setVisible(false);
              		txt_editRole.setVisible(false);
              		txt_editContact.setVisible(false);
              		txt_editAddress.setVisible(false);
              		txt_editPwd.setVisible(false);
              		bt_edit_member.setVisible(false);
              		bt_eSaveMember.setVisible(false);
              	}
            });
            
            // Button Event for Removing a Member from the DB
            bt_delMember.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		lbl_addMessage.setVisible(true);
            		lbl_addMessage.setText("");

            		if(txt_delMember.getText().equals(""))
            		{
            			JOptionPane.showMessageDialog(lbl_addMessage,"Enter a Username to remove the record");
           				lbl_addMessage.setBounds(500,300,100,100);
        				c.add(lbl_addMessage); 
            		}
            		else
            		{
                		boolean bool = false;
                		bool = qb.removeMember(txt_delMember.getText());
                		if(bool) 
                		{
               				JOptionPane.showMessageDialog(lbl_addMessage,"Member Successfully Removed");
               				lbl_addMessage.setBounds(500,300,100,100);
            				c.add(lbl_addMessage); 
            				displayMemberTable();
                		}
                		else
                		{
               				JOptionPane.showMessageDialog(lbl_addMessage,"Member cannot be Removed");
               				lbl_addMessage.setBounds(500,300,100,100);
            				c.add(lbl_addMessage); 
                		}
            		}
            		
            	}
            });
                        
        	// Button Event for Viewing a Member from the DB
            
        	bt_view_member.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			if(txt_enter_Uname.getText().equals(""))
        			{
        				lbl_remUsername.setVisible(false);
            			txt_delMember.setVisible(false);
            			bt_delMember.setVisible(false);
            			txt_addUsername.setVisible(false);
            			txt_addFname.setVisible(false);
            			txt_addLname.setVisible(false);
                  		txt_addRole.setVisible(false);
                  		txt_addContact.setVisible(false);
                  		txt_addAddress.setVisible(false);
                  		txt_addPwd.setVisible(false);   
                  		txt_addUsername.setText("");
                  		txt_addFname.setText("");
                  		txt_addLname.setText("");
                  		txt_addRole.setText("");
                  		txt_addContact.setText("");
                  		txt_addAddress.setText("");
                  		txt_addPwd.setText("");
                  		txt_delMember.setText("");
                  		bt_aSaveMember.setVisible(false);
                  		lbl_addMessage.setVisible(false);
          				lbl_Username.setVisible(false);
                  		lbl_Fname.setVisible(false);
                  		lbl_Lname.setVisible(false);
                  		lbl_Role.setVisible(false);
                  		lbl_Contact.setVisible(false);
                  		lbl_Address.setVisible(false);
                  		lbl_Pwd.setVisible(false);
                  		txt_editUsername.setVisible(false);
                  		txt_editFname.setVisible(false);
                  		txt_editLname.setVisible(false);
                  		txt_editRole.setVisible(false);
                  		txt_editContact.setVisible(false);
                  		txt_editAddress.setVisible(false);
                  		txt_editPwd.setVisible(false);
                  		bt_edit_member.setVisible(false);
                  		bt_eSaveMember.setVisible(false); 
                  		
    	          		JOptionPane.showMessageDialog(lbl_addMessage,"Enter Username to View Information!");
           				lbl_addMessage.setBounds(500,300,100,100);
        				c.add(lbl_addMessage);
            		}
              		else
          			{
              			String[] string = new String[7];
              			string = qb.viewMemberDetails(txt_enter_Uname.getText());
         				txt_editUsername.setText(string[0]);
          				txt_editFname.setText(string[1]);
          				txt_editLname.setText(string[2]);
          				txt_editRole.setText(string[3]);
          				txt_editContact.setText(string[4]);
          				txt_editAddress.setText(string[5]);
          				txt_editPwd.setText(string[6]);
          				
              			if (txt_editUsername.getText().equals(" "))
              			{
              				lbl_remUsername.setVisible(false);
                			txt_delMember.setVisible(false);
                			bt_delMember.setVisible(false);
                			txt_addUsername.setVisible(false);
                			txt_addFname.setVisible(false);
                			txt_addLname.setVisible(false);
                      		txt_addRole.setVisible(false);
                      		txt_addContact.setVisible(false);
                      		txt_addAddress.setVisible(false);
                      		txt_addPwd.setVisible(false);   
                      		txt_addUsername.setText("");
                      		txt_addFname.setText("");
                      		txt_addLname.setText("");
                      		txt_addRole.setText("");
                      		txt_addContact.setText("");
                      		txt_addAddress.setText("");
                      		txt_addPwd.setText("");
                      		txt_delMember.setText("");
                      		bt_aSaveMember.setVisible(false);
                      		lbl_addMessage.setVisible(false);

              				lbl_Username.setVisible(false);
                      		lbl_Fname.setVisible(false);
                      		lbl_Lname.setVisible(false);
                      		lbl_Role.setVisible(false);
                      		lbl_Contact.setVisible(false);
                      		lbl_Address.setVisible(false);
                      		lbl_Pwd.setVisible(false);
                      		txt_editUsername.setVisible(false);
                      		txt_editFname.setVisible(false);
                      		txt_editLname.setVisible(false);
                      		txt_editRole.setVisible(false);
                      		txt_editContact.setVisible(false);
                      		txt_editAddress.setVisible(false);
                      		txt_editPwd.setVisible(false);
                      		bt_edit_member.setVisible(false);
                      		bt_eSaveMember.setVisible(false); 
                      		
        	          		JOptionPane.showMessageDialog(lbl_addMessage,"Enter correct Username!");
               				lbl_addMessage.setBounds(500,300,100,100);
            				c.add(lbl_addMessage);
              			}
              			else
              			{
              				lbl_remUsername.setVisible(false);
                			txt_delMember.setVisible(false);
                			bt_delMember.setVisible(false);
                			txt_addUsername.setVisible(false);
                			txt_addFname.setVisible(false);
                			txt_addLname.setVisible(false);
                      		txt_addRole.setVisible(false);
                      		txt_addContact.setVisible(false);
                      		txt_addAddress.setVisible(false);
                      		txt_addPwd.setVisible(false);   
                      		bt_aSaveMember.setVisible(false);
                      		lbl_addMessage.setVisible(false);
              				lbl_Username.setVisible(true);
                      		lbl_Fname.setVisible(true);
                      		lbl_Lname.setVisible(true);
                      		lbl_Role.setVisible(true);
                      		lbl_Contact.setVisible(true);
                      		lbl_Address.setVisible(true);
                      		lbl_Pwd.setVisible(true);
                      		txt_addUsername.setText("");
                      		txt_addFname.setText("");
                      		txt_addLname.setText("");
                      		txt_addRole.setText("");
                      		txt_addContact.setText("");
                      		txt_addAddress.setText("");
                      		txt_addPwd.setText("");
                      		txt_delMember.setText("");
                      		txt_editUsername.setVisible(true);
                      		txt_editFname.setVisible(true);
                      		txt_editLname.setVisible(true);
                      		txt_editRole.setVisible(true);
                      		txt_editContact.setVisible(true);
                      		txt_editAddress.setVisible(true);
                      		txt_editPwd.setVisible(true);
                      		txt_editUsername.setEditable(false);
                      		txt_editFname.setEditable(false);
                      		txt_editLname.setEditable(false);
                      		txt_editRole.setEditable(false);
                      		txt_editContact.setEditable(false);
                      		txt_editAddress.setEditable(false);
                      		txt_editPwd.setEditable(false);
                      		bt_edit_member.setVisible(true);
                      		txt_enter_Uname.setText("");
              			}
		 			}           		
           	}
        });
                        
           
            // Button Event for Editing a Member from the DB
            bt_edit_member.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
              		txt_editUsername.setEditable(false);
              		txt_editFname.setEditable(true);
              		txt_editLname.setEditable(true);
              		txt_editRole.setEditable(true);
              		txt_editContact.setEditable(true);
              		txt_editAddress.setEditable(true);
              		txt_editPwd.setEditable(false);
              		bt_eSaveMember.setVisible(true);            		
            	}
            });

            bt_eSaveMember.addActionListener(new ActionListener() {
            	@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
              		txt_editUsername.setEditable(false);
              		txt_editFname.setEditable(false);
              		txt_editLname.setEditable(false);
              		txt_editRole.setEditable(false);
              		txt_editContact.setEditable(false);
              		txt_editAddress.setEditable(false);
              		txt_editPwd.setEditable(false);
            		lbl_addMessage.setVisible(true);    		
            		lbl_addMessage.setText("");
            		boolean bool = false;
            		bool = qb.editMember(txt_editUsername.getText(),txt_editFname.getText(),txt_editLname.getText(),
    				txt_editRole.getText(),txt_editContact.getText(),txt_editAddress.getText(),txt_editPwd.getText());
            		if(bool)
            		{
          				JOptionPane.showMessageDialog(lbl_addMessage,"Member Information edited Successfully");
           				lbl_addMessage.setBounds(500,300,100,100);
        				c.add(lbl_addMessage); 
        				displayMemberTable();
  		      		}
            		else
            		{
          				JOptionPane.showMessageDialog(lbl_addMessage,"Member Information edited Successfully");
           				lbl_addMessage.setBounds(500,300,100,100);
        				c.add(lbl_addMessage); 
            		}
             	}
            });
            getContentPane().setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

    // Display Member Details in a JTable
    public void displayMemberTable()
    {
        String[] columns = new String[] {
	            "Username", "First Name", "Last Name", "Role" , "Phone Number",
	            "Address"
	        };	        	
	        Object data[][] =  qb.getMemberDetails();
	        JTable table = new JTable(data, columns);
		    JScrollPane sp=new JScrollPane(table); 
	        add(sp);
	        sp.setBounds(650,250,700, 350);  
    }
    
	
	 public static void main(String[] args) 
	  {
	      SwingUtilities.invokeLater(new Runnable() {

	          @Override
	          public void run() {
	              // TODO Auto-generated method stub
	              new AdminPage();

	          }
	      }); 
	  } 
}
