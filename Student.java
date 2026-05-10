import java.sql.*;
import java.util.Scanner;

public class Student {

	static final String URL ="jdbc:mysql://localhost:3306/studentdb";
	static final String USER = "root";
	static final String PASS = "";


	public static void main(String[] arg) throws Exception {
		

		Scanner reader = new Scanner(System.in);
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		System.out.println("\n Connected to Database!");

		int choice;

		do {

			System.out.println("\n====== Student Management ======");
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = reader.nextInt();
			reader.nextLine();

			switch (choice) {
				case 1:
					System.out.print("Enter name: ");
					String name = reader.nextLine();
					System.out.print("Enter department: ");
					String dept = reader.nextLine();
					System.out.print("Enter marks: ");
					double marks = reader.nextDouble(); 

					PreparedStatement ps1 = con.prepareStatement( "INSERT INTO students (name, dept, marks) VALUES (?,?,?)");
					ps1.setString(1, name);
					ps1.setString(2, dept);
					ps1.setDouble(3, marks);
					ps1.executeUpdate();
					System.out.println("Student added!");
					break;

				case 2:
					PreparedStatement ps2 = con.prepareStatement("SELECT * FROM students");
					ResultSet rs = ps2.executeQuery();
					System.out.println("\n STUD_ID |   Name   |   DEPT   |   MARKS   |");
					System.out.println("==============================================");
					while (rs.next()) {
						System.out.println( rs.getInt("id") + "   |  " + rs.getString("name") + " | " + rs.getString("dept") + "  |  " + rs.getDouble("marks"));
					}
					break;
	
				case 3:
					System.out.print("Enter ID to update: ");
					int uid = reader.nextInt();
					reader.nextLine();
					System.out.print("Enter new name: ");
					String uname = reader.nextLine();
					System.out.print("Enter new dept: ");
					String udept = reader.nextLine();
					System.out.print("Enter new marks: ");
					double umarks = reader.nextDouble();

					PreparedStatement ps3 = con.prepareStatement( "UPDATE students SET name=?, dept=?, marks=? WHERE id=?");
					ps3.setString(1, uname);
					ps3.setString(2, udept);
					ps3.setDouble(3, umarks);
					ps3.setInt(4, uid);
					ps3.executeUpdate();
					System.out.println("Student updated!");
					break;

				case 4:
					System.out.print("Enter ID to delete: ");
					int did = reader.nextInt();

					PreparedStatement ps4 = con.prepareStatement( "DELETE FROM students WHERE id=?");
					ps4.setInt(1, did);
					ps4.executeUpdate();
					System.out.println("Student deleted!");
					break;

				case 5:
					System.out.println("Goodbye!");
					break;

				default:
					System.out.println("Invalid Option!");
			}
		} while (choice !=5);
		con.close();
		reader.close();
	}
}		 
