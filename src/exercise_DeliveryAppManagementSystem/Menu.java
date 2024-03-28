package exercise_DeliveryAppManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Scanner scanner = new Scanner(System.in);
	DeliveryService deliveryService = new DeliveryService();
	
	public void displayMenu() {
		int choice = 7;

		while (choice != 0) {
			System.out.println("""
					
					Delivery Management System Menu:
					1. Customer Registration.
					2. Display Customers.
					3. Place a Delivery.
					4. Display deliveries.
					5. Mark a delivery as delivered.
					6. Display delivered deliveries.
					0. Exit the program.
					""");
			try {
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("1. Customer Registration.");
				deliveryService.registerCostumer();
				break;

			case 2:
				System.out.println("2. Display Customers.");
				deliveryService.displayCustomers();
				break;

			case 3:
				System.out.println("3. Place a Delivery.");
				deliveryService.placeDelivery();
				break;
			case 4:
				System.out.println("4. Display deliveries.");
				deliveryService.displayDeliveries();
				break;

			case 5:
				System.out.println("5. Mark a delivery as delivered.");
				deliveryService.markDeliveryAsDelivered();
				break;
				
			case 6: 
				System.out.println("6. Display delivered deliveries.");
				deliveryService.displayDeliveredDeliveries();
				break;
				
			case 0:
				System.out.println("Exit the program.");
				break;

			default:
				System.out.println("Wrong choice. Plsease enter a right one.");
			}
			}catch(InputMismatchException e) {
				System.out.println("Wrong input. Choice must be a number from 0 to 5.");
				scanner.nextLine();
			}
		}
	}

}
