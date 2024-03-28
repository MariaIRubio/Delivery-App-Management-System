package exercise_DeliveryAppManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryService {
	Scanner scanner = new Scanner(System.in);
	List<Customer> customersList = new ArrayList<>();
	List<Delivery> deliveriesList = new ArrayList<>();
	Customer customer = new Customer();
	Delivery delivery = new Delivery();

	// REGISTER A COSTUMER
	public void registerCostumer() {

		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Address: ");
		String address = scanner.nextLine();
		int customerID = customer.getCustomerID();
		Customer customer = new Customer(name, address, customerID);
		if (!customersList.contains(customerID)) {
			customersList.add(customer);
			System.out.println("\nCustomer information: \nName: " + customer.getName() + "\nID: "
					+ customer.getCustomerID() + "\nCustomer added succesfully!");
		} else {
			System.out.println(customer.getName() + " with ID " + customerID + " is already register!");
		}
	}

	// GENERATE UNIQUE ID
/*	public static String generateID() {
		Random rand = new Random();

		char letter = (char) (rand.nextInt(26) + 'A');
		int number1 = rand.nextInt(100);
		int number2 = rand.nextInt(100);
		int number3 = rand.nextInt(100);

		String uniqueID = "" + letter + String.format("%02d", number1) + String.format("%02d", number2)
				+ String.format("%02d", number3);

		return uniqueID;
	}*/

	// DISPLAY CUSTOMERS
	public void displayCustomers() {
		if (!customersList.isEmpty()) {
			customersList.forEach(System.out::println);
		} else {
			System.out.println("There are no customers in the list.");
		}
	}

	// PLACE DELIVERY
	public void placeDelivery() {
		System.out.print("Customer Name: ");
		String customerName = scanner.nextLine();
		System.out.print("Customer ID: ");
		int customerID = scanner.nextInt();
		scanner.nextLine();
		boolean customerExits = false;
		// Verificar si el cliente está registrado
		for (Customer customer : customersList) {
			if (customer.getCustomerID() == customerID) {
				customerExits = true;
				break;
			}
		}
		if(!customerExits) {
			System.out.println("This customer is not registered. Please register the customer first.");
	        return;
		}
		
		System.out.print("Item Name: ");
		String itemName = scanner.nextLine();

		System.out.print("Item Weight: ");
		double itemWeight;
		while (true) {
			try {
				itemWeight = Double.parseDouble(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number for the item weight.");
				System.out.print("Item Weight: ");
			}
		}

		int deliveryID = delivery.getDeliveryID();

		// Verificar si la entrega ya existe
		boolean deliveryExists = false;
		for (Delivery delivery : deliveriesList) {
			if (delivery.getDeliveryID() == deliveryID) {
				deliveryExists = true;
				System.out.println("A delivery with this delivery ID already exits.");
				break;
			}
		}

		if (!deliveryExists) {
			Delivery delivery = new Delivery(customerName, itemName, itemWeight, deliveryID);
			deliveriesList.add(delivery);

			System.out.println("\nDelivery info: \nCustomer Name: " + customerName + "\nItem Name: " + itemName
					+ "\nItem Weight: " + itemWeight + " Kg. \nDelivery ID: " + delivery.getDeliveryID());
			System.out.println("Delivery placed successfully!");
		}

	}

	// DISPLAY DELIVERIES
	public void displayDeliveries() {
		if (!deliveriesList.isEmpty()) {
			deliveriesList.forEach(System.out::println);
		} else {
			System.out.println("There is no deliveries in the list.");
		}
	}

	// MARK DELIVERY AS DONE
	public void markDeliveryAsDelivered() {

		if (!deliveriesList.isEmpty()) {
			System.out.print("Enter delivery ID: ");
			int deliveryID = scanner.nextInt();
			scanner.nextLine();
			boolean deliveryFound = false;
			for (Delivery delivery : deliveriesList) {
				if (delivery.getDeliveryID() == deliveryID) {
					delivery.setDelivered(true);
					deliveryFound = true;
					System.out.println("Delivery with ID " + deliveryID + " marked as delivered.");
					break;
				}
			}
			if (!deliveryFound) {
				System.out.println("Delivery with ID " + deliveryID + " not found.");
			}
		} else {
			System.out.println("There is no deliveries in the list.");
		}
	}

	// DISPLAY DELIVERED DELIVERIES
	public void displayDeliveredDeliveries() {
		if (!deliveriesList.isEmpty()) {
			for (Delivery delivery : deliveriesList) {
				if (delivery.isDelivered()) {
					System.out.println(delivery);
				}
			}
		} else {
			System.out.println("There is no deliveries in the list.");
		}
	}
}
