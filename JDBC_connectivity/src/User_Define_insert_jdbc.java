import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class User_Define_insert_jdbc {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		try 
		{
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// creating connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/my_java","root","");
			
			//create statement
			Statement stmt=con.createStatement();
			
			//addding data like scanner statement 
			DataInputStream dis= new DataInputStream(System.in);
			
			System.out.println("Number ");
			System.out.println("name ");
			System.out.println("age ");
			
			int no=Integer.parseInt(dis.readLine());
			String name=dis.readLine();
			int age=Integer.parseInt(dis.readLine());
			
			String q4="insert into student values("+no+",'"+name+"',"+age+")";
			System.out.println(q4);
			
			int x=stmt.executeUpdate(q4);
			System.out.println(x+"record added");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}