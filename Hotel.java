import java.util.Scanner;

public class Hotel {

	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);

		int[][] rooms = new int[3][4];
		int choice;

		do{
			System.out.println("\n ===== Hotel Room Booking =====");
			System.out.println("1. View Rooms");
			System.out.println("2. Book a Room");
			System.out.println("3. Exit");
			System.out.print("Choice: ");
			choice = sc.nextInt();

			switch (choice) {

				case 1:
					System.out.println("\nFloor |  Room1  Room2  Room3  Room4");
									System.out.println("------------------------------------------");


					for (int i =0; i<3; i++){
						System.out.print(" " + (i+1) + "    |");
						for (int j =0; j< 4; j++){
							if (rooms [i][j] == 0){
								System.out.print("  [ O ]");
							}else{
								System.out.print("  [ X ]");
							}
						}
						System.out.println();
					}
					System.out.println("O = Available   X = Booked");
					break;

				case 2:
					System.out.print("Enter Floor (1-3): ");
					int floor = sc.nextInt();
					System.out.print("Enter Room  (1-4): ");
					int room = sc.nextInt();

					if (floor < 1 || floor > 3 || room < 1 || room > 4) {
						System.out.println("Invalid floor or room number!");
						break;
					}


					int f = floor - 1;
					int r = room - 1;

					if (rooms[f][r] == 1) {
						System.out.print("Room " + room + " on Floor " + floor + " already booked!");
					}
					else {
						rooms[f][r] = 1;
						System.out.println("Room" + room + " on Floor " + floor + " booked successfully!");
					} break;

				case 3: 
					System.out.println("Thank you! GoodBye!");
					break;

				default:
					System.out.println("Invalid choice! Enter 1-3.");
			}
		} while (choice != 3);
		sc.close();
	}
}			