import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.io.*;

public class Doner {
	public static void main(String[] args)throws Exception {
// TODO Auto-generated method stub
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/my_java","root","");
		String name,bg,addr;
		int age;
		Statement stmt=con.createStatement ();
		ResultSet rs;
		DataInputStream dis=new DataInputStream(System.in);
		while(true) {
				System.out.println("Enter choice : ");
				System.out.println("Menu ....");
				System.out.println("1.Insert");
				System.out.println("2.Display blood group wise");
				System.out.println("3.Update addrress");
				System.out.println("4.Delete record whose age is less than 18");
				System.out.println("5.Exit");
				
				int ch=Integer.parseInt(dis.readLine());
				switch(ch)	{

				case 1:
	
					System.out.println("Enter name : ");
					name=dis.readLine();
					System.out.println("Enter age : ");
					age=Integer.parseInt(dis.readLine());
					System.out.println("Enter addrress : ");
					addr=dis.readLine();
					System.out.println("Enter blood group : ");
					bg=dis.readLine();
					String q="insert into Doner values('"+name+"',"+age+",'"+addr+"','"+bg+"')";
					stmt.executeUpdate(q);
					System.out.println("Record inserted successfully......");
					break;

				case 2:
					System.out.println("Blood Group wise Doner display......");
					String q1="select * from Doner order by bg";
					ResultSet res=stmt.executeQuery(q1);
					while(res.next()) {
						System.out.print(" Name = "+res.getString(1));
						System.out.print(" Age = "+res.getInt(2));
						System.out.print(" addrress = "+res.getString(3));
						System.out.print(" Blood group = "+res.getString(4));
						System.out.println();
					}
					break;

				case 3:
					System.out.println("Enter name of Doner whose addrress you want to update : ");
					String n=dis.readLine();
					String q3="select * from Doner where name='"+n+"'";
					ResultSet r=stmt.executeQuery(q3);
					if(r.next()) {
						System.out.print(" Name = "+r.getString(1));
						System.out.print(" Age = "+r.getInt(2));
						System.out.print(" addrress = "+r.getString(3));
						System.out.print(" Blood group = "+r.getString(4));
						System.out.println();
						System.out.println("Enter new addrress : ");

						String addr1=dis.readLine();
						String q4="update Doner set addr = '"+addr1+"' where name='"+n+"'";
						int no=stmt.executeUpdate(q4);

						System.out.println("Record updated ");
					}
					else {
						System.out.println("NO RECORD FOUND ");
						}
					break;

				case 4:
						int a=18;
						String q5="delete from Doner where age < "+a;
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
	catch(Exception e){System.out.println(e);
	}
	}
}

