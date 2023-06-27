import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class praticre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no=12;
		String name="yyyy";
		int age=45;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/my_java","root","");
			
			Statement stmt=con.createStatement();
			//insert value
			String q2="insert into emp values("+no+",'"+name+"',"+age+")";
			int result=stmt.executeUpdate(q2);
			System.out.println(result+"record");
		}
		catch(Exception e) {
			System.out.println("e");
		}
	}

}
