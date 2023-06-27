import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class Total_operation_jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no=6;
		String name="yash";
		int age=23;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/my_java","root","");
			
			//Statement
			Statement stmt=con.createStatement();
			
			//insert
			String n1="insert into emp values("+no+",'"+name+"',"+age+")";
			int result1=stmt.executeUpdate(n1);
			System.out.println(result1+" record update");
			
			//update
			int result2=stmt.executeUpdate("Update emp set name='ramm', no=15 where age=23" );
			System.out.println(result2+" record update");
					
			//delete
			int result3=stmt.executeUpdate("Delete from emp where age=23");
			System.out.println(result3+" record update");

			
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
