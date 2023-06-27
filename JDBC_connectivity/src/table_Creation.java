// PROGRAM 12.2 java program to illustrate inserting to the database  12.21

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class table_Creation {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int no=59;
		String name="yashYeole";
		int age=23;
			try 
			{
				//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// creating connection
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/my_java","root","");
				Statement stmt=con.createStatement();
				//create datebase
				String a="insert into student values("+no+",'"+name+"',"+age+")";
				
				
				int x=stmt.executeUpdate(a);
				System.out.println("Table is created");
				con.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}
