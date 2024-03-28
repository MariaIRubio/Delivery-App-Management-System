package exercise_DeliveryAppManagementSystem;

public class Customer {
	
	private String name;
	private String address;
	private int customerID;
	private static int nextCustomerID = 1;

	
	public Customer() {}
	
	public Customer(String name, String address, int customerID) {
		this.name = name;
		this.address = address;
		this.customerID = nextCustomerID++;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getCustomerID() {
		return customerID;
	}

	@Override
	public String toString() {
		return "\n*Name: " + name + "\nAddress: " + address + "\nID: " + customerID;
	}
	
	
	

}
