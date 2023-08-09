import java.util.ArrayList;

public class CoffeeKiosk {

//	member variables
	public ArrayList<Item> menu;
	public ArrayList<Order> orders;
	
//	constructor method
	public CoffeeKiosk() {
		this.menu = new ArrayList<Item>();
		this.orders = new ArrayList<Order>();
	}
	
//	class methods
	public void addMenuItem(String itemName, double price, int index) {
		Item newItem = new Item(itemName, price, index);
		this.menu.add(index, newItem);
	}
	public void displayMenu() {
		for (int i = 0; i < this.menu.size(); i++) {
			System.out.printf("%s %s -- $%s\n", this.menu.get(i).getIndex(), this.menu.get(i).getName(), this.menu.get(i).getPrice());
		}
	}
	public void newOrder() {
		System.out.println("Please enter customer name for new order: ");
		String name = System.console().readLine();
		Order nOrder = new Order(name);
		displayMenu();
		
		System.out.println("Please enter a menu item index or q to quit");
		String itemNumber = System.console().readLine();
		while (!itemNumber.equals("q")) {
			nOrder.items.add(this.menu.get(Integer.parseInt(itemNumber)));
		}
		
		System.out.println("Would you like to add anything else to your order? If not, hit q to quit");
		String itemIndex = System.console().readLine();
		while (!itemIndex.equals("q")) {
			nOrder.items.add(this.menu.get(Integer.parseInt(itemIndex)));
		}
		
		this.orders.add(nOrder);
		nOrder.display();
	}
}
