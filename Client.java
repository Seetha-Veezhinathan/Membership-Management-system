import java.io.*;
import java.net.*;

public class Client{
	public static DataObjectChild sendObjectToServer(DataObjectChild object) {
	
		try {

				Socket socketToServer = new Socket("afsconnect1.njit.edu", 2605);
				ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
				ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
				
				
				DataObjectChild dataChild = (DataObjectChild) object;
				
				myOutputStream.writeObject(dataChild);

				object = (DataObjectChild) myInputStream.readObject();

				myOutputStream.close();

				myInputStream.close();

				socketToServer.close();	
			}
		catch(Exception e){
			System.out.println(e);
        		}
		
		return object;
		
	}
}


   
