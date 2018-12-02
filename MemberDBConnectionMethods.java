import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class has the methods for doing Database validation and manipulation
 * @author SEETHA VEEZHINATHAN
 *
 */

public class MemberDBConnectionMethods 
{

	public static final String user = "*****";
	public static final String password = "*****";
	public static final String url = "jdbc:mysql://sql2.njit.edu:3306/sv575";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	public void openConnection()
	{
		try
		{
			connection = null;
			statement = null;
			resultSet = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void closeConnection()
	{
		try 
		{
			if( resultSet != null )
				resultSet.close();
			if( statement != null )
				statement.close();
			if( connection != null )
				connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	// Method to Check Credential Validation
	public String performCredValidation(String query)
	{
		openConnection();
		try
		{
			statement = connection.createStatement();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);				
			resultSet = statement.executeQuery(query);
			resultSet.next();
			return resultSet.getString(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
			closeConnection();
			return "Error";
	}
	
	// Method to Get the UserRole of the Member
	public String getUserRole(String query)
	{
		openConnection();
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(query);
			resultSet.next();				
			return resultSet.getString(1);
				
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		closeConnection();
			return "Error";
	}
	
	// Method to Check whether a member already exists in DB
	public String[] checkUserNameinDB(String query)
	{
		openConnection();
		String[] data = new String[1];
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(query);
			if(!resultSet.next())
			{
				data[0] = " "; 
			}
			else
			{
				data[0] = resultSet.getString(1); 
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		closeConnection();
			return data;
	}
	
	// Method to View the member details for a selected User
	public String[] viewMemberDetails(String query)

	{
		openConnection();
		String[] data = new String[7];
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(query);
			if (!resultSet.next())
			{
				data[0] = " "; 
				data[1] = " ";
				data[2] = " ";
				data[3] = " ";
				data[4] = " ";
				data[5] = " ";
				data[6] = " ";
			}
			else
			{		
				data[0] = resultSet.getString(1); 
				data[1] = resultSet.getString(2);
				data[2] = resultSet.getString(3);
				data[3] = resultSet.getString(4);
				data[4] = resultSet.getString(5);
				data[5] = resultSet.getString(6);
				data[6] = resultSet.getString(7);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
			closeConnection();
			return data;
	}
	
	
	// Method for Adding New Member to the DB
	public boolean addNewMember(String query)
	{
		openConnection();
		boolean bool = false;
		try
		{
			statement = connection.createStatement(); 
			statement.executeUpdate(query);
			bool = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		closeConnection();
		return bool;
	}
	
	// Method for Removing an existing member from the DB
	public boolean removeMember(String query)
	{
		openConnection();
		boolean bool = false;
		try
		{
			statement = connection.createStatement(); 
			statement.executeUpdate(query);
			bool = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		closeConnection();
		return bool;
	}
	
	
	// Method to Update the edited Member information in to the Database
	public boolean editMember(String query)
	{
		openConnection();
		boolean bool = false;
		try
		{
			statement = connection.createStatement();
			statement.executeUpdate(query);
			bool = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		closeConnection();
		return bool;
	}
	
	
	// Method to Display all the members in the database in a JTable in the front end
	public Object[][] getMemberDetails(String query)
	{
		openConnection();
		Object[][] data = null;
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			statement = connection.createStatement(); 
			resultSet = statement.executeQuery(query);

			int rowCount = getRowCount(resultSet); // Row Count
			int columnCount = getColumnCount(resultSet); // Column Count
			data = new Object[rowCount][columnCount];
			resultSet.beforeFirst();

			int i = 0;
			
			while (resultSet.next()) {

				int j = 0;

				data[i][j++] = resultSet.getString("Username");
				data[i][j++] = resultSet.getString("First Name");
				data[i][j++] = resultSet.getString("Last Name");
				data[i][j++] = resultSet.getString("Role");
				data[i][j++] = resultSet.getString("Phone Number");
				data[i][j++] = resultSet.getString("Address");
				data[i][j++] = resultSet.getString("Password");

				i++;
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		closeConnection();
		return data;
	}
	
	// Method to get Row Count from ResultSet Object
	private int getRowCount(ResultSet rs) {

		try {
			
			if(rs != null) {
				
				rs.last();
				
				return rs.getRow(); 
			}
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}

	// Method to get Column Count from ResultSet Object
	private int getColumnCount(ResultSet rs) {

		try {

			if(rs != null)
				return rs.getMetaData().getColumnCount();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}
}
