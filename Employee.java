import java.sql.*;
import java.util.Scanner;

public class Employee {

	static final String URL ="jdbc:mysql://localhost:3306/employeedb";
	static final String USER = "root";
	static final String PASS = "";


	public static void main(String[] arg) throws Exception {
		

		Scanner reader = new Scanner(System.in);
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		System.out.println("Connected to Database!");

		int choice;

		do {

			System.out.println("\n====== Employee Management ======");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
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
					System.out.print("Enter salary: ");
					double salary = reader.nextDouble(); 

					PreparedStatement ps1 = con.prepareStatement( "INSERT INTO employees (name, dept, salary) VALUES (?,?,?)");
					ps1.setString(1, name);
					ps1.setString(2, dept);
					ps1.setDouble(3, salary);
					ps1.executeUpdate();
					System.out.println("Employee added!");
					break;

				case 2:
					PreparedStatement ps2 = con.prepareStatement("SELECT * FROM employees");
					ResultSet rs = ps2.executeQuery();
					System.out.println("\n ID |   Name   |   DEPT   |   SALARY   |");
					System.out.println("===========================================");
					while (rs.next()) {
						System.out.println( rs.getInt("id") + "   |  " + rs.getString("name") + " | " + rs.getString("dept") + "  |  " + rs.getDouble("salary"));
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
					System.out.print("Enter new salary: ");
					double usalary = reader.nextDouble();

					PreparedStatement ps3 = con.prepareStatement( "UPDATE employees SET name=?, dept=?, salary=? WHERE id=?");
					ps3.setString(1, uname);
					ps3.setString(2, udept);
					ps3.setDouble(3, usalary);
					ps3.setInt(4, uid);
					ps3.executeUpdate();
					System.out.println("Employee updated!");
					break;

				case 4:
					System.out.print("Enter ID to delete: ");
					int did = reader.nextInt();

					PreparedStatement ps4 = con.prepareStatement( "DELETE FROM employees WHERE id=?");
					ps4.setInt(1, did);
					ps4.executeUpdate();
					System.out.println("Employee deleted!");
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
