import java.util.Scanner;

public class ATM {

	static double balance = 5000.00;

	static void deposit(double amount) {
		try {
			if (amount <=0)
				throw new IllegalArgumentException("Amount must be greater than 0!");
			balance += amount;
			System.out.println("Deposited: Rs." + amount);
			System.out.println("New Balance: Rs." + balance);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage()); 
		} finally {
			System.out.println("Deposit process completed.");
		}
	}


	static void withdraw(double amount) {
		try {
			if (amount <= 0)
				throw new IllegalArgumentException("Amount must be greater than 0!");
			if (amount > balance)
				throw new ArithmeticException("Insufficient funds!");
			balance -= amount;
			System.out.println("Withdrawn: Rs." + amount);
			System.out.println("Remaining Balance: Rs." + balance);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			System.out.println("Withdrawal process completed.");
		}
	}


	static void checkBalance() {
		try {
			System.out.println("Current Balance: Rs." + balance);
		} finally {
			System.out.println("Balance check completed.");
		}
	}


	public static void main(String[] arg) {
		Scanner reader = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n===== ATM MACHINE =====");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposite");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			try {
				choice = reader.nextInt();
			} catch (Exception e) {
				System.out.println("Error: Invalid input!");
				reader.nextLine();
				choice = 0;
				continue;
			}


			switch (choice) {
				case 1: 
					checkBalance();
					break;
				case 2: 
					System.out.print("Enter deposit amount: ");
					try {
						double amt = reader.nextDouble();
						deposit(amt);
					} catch (Exception e) {
						System.out.println("Error: Invalid Input!");
						reader.nextLine();
					}
					break;
				case 3:
					System.out.print("Enter withdrawal amount: ");
					try {
						double amt = reader.nextDouble();
						withdraw(amt);
					} catch (Exception e) {
						System.out.println("Error: Invalid input!");
						reader.nextLine();
					}
					break;
				case 4:
					System.out.println("Thank you for using ATM. Goodbye!");
					break;
				default:
					System.out.println("Error! Invalid option.");
			
			} 
		} while (choice != 4);
		reader.close();
	}
}
	
