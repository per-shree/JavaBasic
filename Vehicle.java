import java.util.Scanner;

public class Vehicle{

	String brand;
	int speed;

	Vehicle(String brand, int speed){
		this.brand = brand;
		this.speed = speed;

	}

	void start() {
		System.out.println(brand + " is starting.");
	}


	void stop(){
		System.out.println(brand + " is stopping.");
	}


	void display() {
		System.out.println("Brand : " +brand);
		System.out.println("Speed : " +speed+ " km/h");
	}
}

class Car extends Vehicle {

	int doors;

	Car(String brand, int speed, int doors){
		super(brand, speed);
		this.doors = doors;
	}

	void honk() {
		System.out.println(brand +" is honking: Beep Beep!");
	}

	void display() {
		super.display();
		System.out.println("Doors : "+doors);
	}

	public static void main(String[] arg){
		Scanner reader = new Scanner(System.in);

		System.out.print("Enter car brand: ");
		String brand = reader.nextLine();
		
		System.out.print("Enter car speed: ");
		int speed = reader.nextInt();

		System.out.print("Enter number of doors: ");
		int doors = reader.nextInt();

		Car c = new Car(brand, speed, doors);

		System.out.println("\n Choose an option:");
		System.out.println("1. Start");
		System.out.println("2. Stop");
		System.out.println("3. Honk");
		System.out.println("4. Display Details");
		System.out.print("Enter Your choice: ");
		int choice = reader.nextInt();

		switch (choice) {
			case 1:
				c.start();
				break;
			case 2:
				c.stop();
				break;
			case 3:
				c.honk();
				break;
			case 4:
				c.display();
				break;
			default:
				System.out.println("Error! Invalid option.");
		}
		reader.close();
	}
}	