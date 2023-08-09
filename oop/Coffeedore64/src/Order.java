import java.util.ArrayList;

public class Order {
//	class attributes / member variables 
	private String name;
	private boolean ready;
	public ArrayList<Item> items;
//	constructor method
	public Order() {
		this.name = "Guest";
		this.ready = false;
		this.items = new ArrayList<Item>();
	}
//	overloaded constructor method
	public Order(String name) {
		this.name = name;
		this.ready = false;
		this.items = new ArrayList<Item>();
	}
//	setters and getters for all member variables
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void isReady(boolean status) {
		this.ready = status;
	}
	public boolean isReady() {
		return ready;
	}
	public void setArray(ArrayList<Item> items) {
		this.items = items;
	}
	public ArrayList<Item> getArray() {
		return items;
	}
//	class methods
	public void addItem(Item item) {
		this.items.add(item);
	}
	public String getStatusMessage() {
		if (ready) {
			return "Your order is ready";
		}
		else {
			return "Thank you for waiting. Your order will be ready soon";
		}
	}
	public double getOrderTotal() {
		double totalPrice = 0.0;
		for (int i = 0; i < this.items.size(); i++) {
			totalPrice = totalPrice + this.items.get(i).getPrice();	
		}
		return totalPrice;
	}
	public void display() {
		System.out.printf("Customer Name: %s\n", this.name);
		for (int i = 0; i < this.items.size(); i++) {
			System.out.printf("%s - $%s\n", this.items.get(i).getName(), this.items.get(i).getPrice());
		}
		System.out.printf("Total: %s\n", this.getOrderTotal());
	}
}

