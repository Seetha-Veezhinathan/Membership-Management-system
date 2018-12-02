import java.io.*;
import java.net.*;

/**
 * This class acts as the server and interacts with the client and database
 * @author SEETHA VEEZHINATHAN
 *
 */

public class ThreadedDataObjectServer
{  @SuppressWarnings("resource")
public static void main(String[] args ) 
   {  

      try 
      {  ServerSocket s = new ServerSocket(2605);
         
         for (;;)
         {  Socket incoming = s.accept( );
            new ThreadedDataObjectHandler(incoming).start();
             
	   	 }   
      }
      catch (Exception e) 
      {  System.out.println(e);
      } 
   } 
}

class ThreadedDataObjectHandler extends Thread
{  public ThreadedDataObjectHandler(Socket i) 
   { 
   		incoming = i;
   }
   
   public void run()
   {  try 
      { 	
	   
		
		DataObjectChild myObject = null;
		
		String message = "";
		
	    ObjectInputStream in = new ObjectInputStream(incoming.getInputStream());

		ObjectOutputStream out = new ObjectOutputStream(incoming.getOutputStream());

		myObject = (DataObjectChild)in.readObject();

		message = testMethod(myObject);
		
		myObject.setMessage(message);
		
		out.writeObject(myObject);

		in.close();
			
		out.close();

 		incoming.close();    
					    
      }
      catch (Exception e) 
      {  System.out.println(e);
      } 
   }
   
   DataObject myObject = null;
   private Socket incoming;
   
   public static String testMethod(DataObjectChild myObject) {
		String message = "";
		MemberDBConnectionMethods ms = new MemberDBConnectionMethods();
		
		switch (myObject.getMethod()) 
		{

			case "performCredValidation": 
			{
				message = ms.performCredValidation(myObject.getMessage());
				break;
			}
			
			case "getUserRole": 
			{
				message = ms.getUserRole(myObject.getMessage());
				break;
			}
			
			case "viewMemberDetails": 
			{
				myObject.setStr(ms.viewMemberDetails(myObject.getMessage()));
				break;
			}
			
			case "checkUserNameinDB":
			{
				myObject.setStr(ms.checkUserNameinDB(myObject.getMessage()));
				break;
			}
			
			case "addNewMember": 
			{
				myObject.setBool(ms.addNewMember(myObject.getMessage()));
				break;
			}
			
			case "removeMember": 
			{
				myObject.setBool(ms.removeMember(myObject.getMessage()));
				break;
			}
			
			case "editMember":
			{
				myObject.setBool(ms.editMember(myObject.getMessage()));
				break;
			}
			
			case "getMemberDetails": 
			{
				myObject.setObj(ms.getMemberDetails(myObject.getMessage()));
				break;
			}
			
	}
	return message;

	}
}
