import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class ProductTable {

	public static void main(String[] args) {
			
		int no=1;
		String name="aa";
		int price=50;
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hellojava","root","");
			Statement stmt=con.createStatement();
			
			// insert
			String q="insert into product values( "+no+",'"+name+"', "+price+")";
			int result1=stmt.executeUpdate(q);
			System.out.println(result1+" record added");
			
			//update
			int result2=stmt.executeUpdate("Update product set name='tomato', price=59 where no=1" );
			System.out.println(result2+" record added");
			
			// delete
			
			int result3=stmt.executeUpdate("Delete from product where no=1");
			System.out.println(result3+" record added");

			

		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
