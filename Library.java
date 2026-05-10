import java.util.Scanner;
import java.util.ArrayList;

public class Library{
	
	static int totalBooks = 0;

	String title;
	int id;
	boolean issued;


	Library(String title, int id){
		this.title = title;
		this.id = id;
		this.issued = false;
		totalBooks++;
	}

	static void showTotal(){
		System.out.println("Total Books: "+ totalBooks);
	}

	void issueBook(){
		if (issued)
			System.out.println(title + " already issued!");
		else{
			issued = true;
			System.out.println(title + " issued successfully!");
		}
	}

	void returnBook() {
		if (!issued)
			System.out.println(title + " was not issued!");
		else{
			issued = false;
			System.out.println(title + " returned successfully!");
		}
	}

	void viewDetails() {
		System.out.println("ID: "+id+" | "+title+" | "+(issued ? "Issued" : "Available"));
	}
	
	public static void main (String[] arg){
		Scanner sc = new Scanner(System.in);
		ArrayList<Library> books = new ArrayList<>();

		int choice;

		do{

			System.out.println("\n==== Library Management System ====");
			System.out.println("1. Add Book");
			System.out.println("2. Issue Book");
			System.out.println("3. Return Book");
			System.out.println("4. View All Book");
			System.out.println("5. Total Books Count");
			System.out.println("6. Exit");
			System.out.print("Choice: ");

			choice = sc.nextInt();
			sc.nextLine();


			switch (choice) {

				case 1:
					System.out.print("Enter title : ");
					String title = sc.nextLine();
					System.out.print("Enter ID  : ");
					int id = sc.nextInt();
					sc.nextLine();
					books.add(new Library(title, id));
					System.out.println("Book added successfully!");
					break;

				case 2:
					System.out.print("Enter Title to Issue: ");
					String issueTitle = sc.nextLine();
					boolean found1 = false;
					for (Library b : books){
						if (b.title.equalsIgnoreCase(issueTitle)){
							b.issueBook();
							found1 = true;
							break;
						}
					}
					if (!found1) System.out.println("Book not found!");
					break;

				case 3:
					System.out.print("Enter Title to return: ");
					String returnTitle = sc.nextLine();
					boolean found2 = false;
					for (Library b : books) {
						if (b.title.equalsIgnoreCase(returnTitle)) {
							b.returnBook();
							found2 = true;
							break;
						}
					}
					if (!found2) System.out.println("Book not found!");
					break;

				case 4:
					if (books.isEmpty())
						System.out.println("No books added yet!");
					else
						for (Library b: books)
							b.viewDetails();
					break;
				case 5:
					Library.showTotal();
					break;

				case 6:
					System.out.println("Good bye!");
					break;

				default:
					System.out.println("Invalid choice!");
			}
		}while (choice != 6);
		sc.close();
	}
}