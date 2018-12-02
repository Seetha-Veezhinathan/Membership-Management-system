/**
 * This class has all the queries related to inserting, editing and removing members
 * and perform validation against the database
 * @author SEETHA VEEZHINATHAN
 *
 */

public class MemberAdminQueryPage 
{		
	
	@SuppressWarnings("static-access")
	public String performCredValidation(String uName , String pwd)
	{	
		Client client = new  Client();
		DataObjectChild dataChild = new DataObjectChild();
		dataChild.setMessage("SELECT `Password` FROM `add_member` WHERE `Username`= '"+uName+"'");
		dataChild.setMethod("performCredValidation");
		dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
		return dataChild.getMessage();
	}
	
	@SuppressWarnings("static-access")
	public String getUserRole(String uName)
	{
		Client client = new Client();
		DataObjectChild dataChild = new DataObjectChild();
		dataChild.setMessage("SELECT  `Role` FROM `add_member` WHERE `Username` = '"+uName+"'");
		dataChild.setMethod("getUserRole");
		dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
		return dataChild.getMessage();
	}
	

	@SuppressWarnings("static-access")
	public String[] viewMemberDetails(String uName)
	{
			Client client = new Client();
			DataObjectChild dataChild = new DataObjectChild();
			dataChild.setMessage("SELECT * FROM `add_member` WHERE `Username`  = '"+uName+"'");
			dataChild.setMethod("viewMemberDetails");
			dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
			return dataChild.getStr();
	}
	
	@SuppressWarnings("static-access")
	public String[] checkUserNameinDB(String uName)
	{
		Client client = new Client();
		DataObjectChild dataChild = new DataObjectChild();
		dataChild.setMessage("SELECT  * FROM `add_member` WHERE `Username` = '"+uName+"'");
		dataChild.setMethod("checkUserNameinDB");
		dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
		return dataChild.getStr();
	}
	
	@SuppressWarnings("static-access")
	public boolean addNewMember(String uName , String fName, String lName, String Role, String Contact, String Address, String pwd)
	{	
		Client client = new  Client();
		DataObjectChild dataChild = new DataObjectChild();
		dataChild.setMessage("INSERT INTO `add_member`(`Username`, `First Name`, `Last Name`, `Role`, `Phone Number`, `Address`, `Password`)VALUES('"+uName+"','"+fName+"','"+lName+"','"+Role+"','"+Contact+"','"+Address+"','"+pwd+"')");
		dataChild.setMethod("addNewMember");
		dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
		return dataChild.getBool();
	}
	
	@SuppressWarnings("static-access")
	public boolean removeMember(String uName)
	{
		Client client = new  Client();
		DataObjectChild dataChild = new DataObjectChild();
		dataChild.setMessage("DELETE FROM `add_member` WHERE `Username`  = '"+uName+"'");
		dataChild.setMethod("removeMember");
		dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
		return dataChild.getBool();
	}
	
	@SuppressWarnings("static-access")
	public boolean editMember(String uName , String fName, String lName, String Role, String Contact, String Address, String pwd)
	{
		
		Client client = new Client();
		DataObjectChild dataChild = new DataObjectChild();
		dataChild.setMessage("UPDATE `add_member` SET `Username`='"+uName+"',`First Name`='"+fName+"',`Last Name`='"+lName+"',`Role`='"+Role+"',`Phone Number`='"+Contact+"',`Address`='"+Address+"',`Password`='"+pwd+"' WHERE `Username` = '"+uName+"'");
		dataChild.setMethod("editMember");
		//Server server = new Server();
		//server.testMethod(dataChild);
		dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);	
		return dataChild.getBool();
	}
	
	@SuppressWarnings("static-access")
	public Object[][] getMemberDetails()
	{	
		Client client = new  Client();
		DataObjectChild dataChild = new DataObjectChild();
		dataChild.setMessage("SELECT * FROM `add_member`");
		dataChild.setMethod("getMemberDetails");
		dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
		return dataChild.getObj();
	}
} 