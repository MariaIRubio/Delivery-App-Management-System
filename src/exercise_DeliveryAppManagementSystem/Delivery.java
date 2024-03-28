package exercise_DeliveryAppManagementSystem;

public class Delivery {
	
	private String itemName;
	private double itemWeight;
	private int deliveryID;
	private static int nextDeliveryID = 100;
	private boolean delivered = false;

	Delivery(){}
	
	public Delivery(String customerName, String itemName, double itemWeight, int deliveryID) {
		this.itemName = itemName;
		this.itemWeight = itemWeight;
		this.deliveryID = nextDeliveryID++;
	}
	
	public String getItemName() {
		return itemName;
	}

	public double getItemWeight() {
		return itemWeight;
	}

	public int getDeliveryID() {
		return deliveryID;
	}
	

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	@Override
	public String toString() {
		return "\n*Item Name: " + itemName + "\nWeight: " + itemWeight + "\nDelivery ID: " + deliveryID + "\nDelivered: " + delivered;
	}
	
	

}
