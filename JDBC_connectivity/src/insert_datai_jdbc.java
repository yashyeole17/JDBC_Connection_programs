// 12.2 PG12.20 program for inserting data in mysql phpAdmin Using jdbc Connectivity
//import java.io.*;

//      ALL OOPEARATIONS DONE LIKE  CREATE INSERT UPADTE DELETE 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert_datai_jdbc {

	public static void main(String[] args) {

		int no = 60;
		String name = "iiiii";
		int age = 92;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/my_java", "root", "");
			Statement stmt = con.createStatement();

	/*		// insert data query
			String q1 = "insert into emp values(" + no + ",'" + name + "'," + age + ")";
			
			int result = stmt.executeUpdate(q1);
			System.out.println(result + "record added");
*/
					// update
			int result2 = stmt.executeUpdate("update emp  set name='mananana',no=60 where age=92");
			System.out.println(result2 + "record update");
			/*
			// delete
			int result1 = stmt.executeUpdate("delete from emp where no=1");
			System.out.println(result1 + "records delete");
*/
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
