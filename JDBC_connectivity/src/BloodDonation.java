import java.sql.*;
import java.io.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BloodDonation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iicmr", "root", "");
			String name, bg, add;
			int age;
			Statement stmt = con.createStatement(); // create container
			ResultSet rs;
			DataInputStream dis = new DataInputStream(System.in);
			while (true) {
				System.out.println("Enter choice: ");
				System.out.println("Menu");
				System.out.print(
						"1.Insert\n2.Display blood group wise\n3.Update address\n4.Delete record whose age is less than 18\n5.Exit\n");
				int ch = Integer.parseInt(dis.readLine());
				
				
				switch (ch) {
				case 1:
					System.out.println("Enter name : ");
					name = dis.readLine();
					System.out.println("Enter age : ");
					age = Integer.parseInt(dis.readLine());
					System.out.println("Enter address : ");
					add = dis.readLine();
					System.out.println("Enter blood group : ");
					bg = dis.readLine();
					String q = "insert into donar values('" + name + "'," + age + ",'" + add + "','" + bg + "')";
					stmt.executeUpdate(q);
					System.out.println("Record inserted successfully......");
					break;
				
				
				case 2:
					System.out.println("Blood Group wise donar display......");
					String q1 = "select * from donar order by bg";
					ResultSet res = stmt.executeQuery(q1);
					while (res.next()) {
						System.out.print(" Name = " + res.getString(1));
						System.out.print(" Age = " + res.getInt(2));
						System.out.print(" Address = " + res.getString(3));
						System.out.print(" Blood group = " + res.getString(4));
						System.out.println();
					}
					break;
				
				
				case 3:
					System.out.println("Enter name of donar whose address you want to update : ");
					String n = dis.readLine();
					String q3 = "select * from donar where name='" + n + "'";
					ResultSet r = stmt.executeQuery(q3);
					if (r.next()) {
						System.out.print(" Name = " + r.getString(1));
						System.out.print(" Age = " + r.getInt(2));
						System.out.print(" Address = " + r.getString(3));
						System.out.print(" Blood group = " + r.getString(4));
						System.out.println();
						System.out.println("Enter new address : ");
						String newadd = dis.readLine();
						String q4 = "update donar set address = '" + newadd + "' where name='" + n + "'";
						int no = stmt.executeUpdate(q4);
						System.out.println("Record updated ");
					} else {
						System.out.println("NO RECORD FOUND ");
					}
					break;
				
				
				case 4:
					int a = 18;
					String q5 = "delete from donar where age < " + a;
					stmt.executeUpdate(q5);
					System.out.println("Record deleted successfully...");
					break;
				
				
				case 5:
					System.out.println("System exit successfully");
					System.exit(0);
					break;
				}
			}
		} 
		
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
