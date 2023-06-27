//import java.util.*;
//import java.io.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class result_Stattement_JDBC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//load database
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost/my_java","root","");
		Statement stmt=con.createStatement();
/*		stmt.executeUpdate("insert into emp values(3,'aaaaa',25)");
		stmt.executeUpdate("insert into emp values(4,'bbbbb',26)");
		stmt.executeUpdate("insert into emp values(5,'ccccc',27)");
		stmt.executeUpdate("insert into emp values(6,'ddddd',28)");
		System.out.println("values recored inserted");
	*/	 
		/*	
		//update
		int result=stmt.executeUpdate("update emp set name='gaurav',no=10 where age=22");
		System.out.println(result+"  record update");


		
				//delete
		int result=stmt.executeUpdate("delete from student where no=2");
		System.out.println(result+"  records get delete"); 	
		
		*/
		//topic preceding resultSet Objects
		ResultSet rs=stmt.executeQuery("select * from emp");
		while(rs.next())
		{
			int number =rs.getInt("no");
			String nameStud=rs.getString("name");
			int ageStud=rs.getInt("age");
		}
	
		con.close();
	}
}
