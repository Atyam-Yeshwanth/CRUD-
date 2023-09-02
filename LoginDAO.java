package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;
import model.Login;

public class LoginDAO {
	public boolean checkCredential(Login l) throws ClassNotFoundException, SQLException
	{
		//1.Get the details from Login.java file.
		String username= l.getUsername();
		String password= l.getPassword();
		
		//2.jdbc connection
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		//3.Create statement
		Statement st=con.createStatement();
		//4.Write and execute the query
		ResultSet rt= st.executeQuery("select * from login");
		
		//5.check username and password
		while(rt.next())
		{
			if(username.equals(rt.getString("username")) && password.equals(rt.getString("password")))
			{
				cm.closeConnection();
				return true;
			}
		}
		return false;
	}
}
