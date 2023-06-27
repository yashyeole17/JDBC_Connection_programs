import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Select_Query_JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int no=10;
		String name="sjsfhkj";
		int age=22;
		
		try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/my_java","root","");
				Statement stmt=con.createStatement();
				
				//SELECT QUERY
				String q5="SELECT * from student where no=2";
				ResultSet rs = stmt.executeQuery(q5);
				if(rs.next()) {
					System.out.println(no +rs.getInt(2));
					System.out.println("name: "+rs.getString("gaurav"));
					System.out.println(age +rs.getInt(22));
				}
				else {
					System.out.println("data is NOT found");
				}
				con.close();		
				
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
