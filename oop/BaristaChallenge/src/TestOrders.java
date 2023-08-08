import java.util.ArrayList;

public class TestOrders {
	public static void main(String[] args) {
		
//		instantiating orders and items
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order("Charlie");
		Order order4 = new Order("Jenny");
		Order order5 = new Order("Quinn");
		Item item1 = new Item("latte", 3.5);
		Item item2 = new Item("mocha", 4.5);
		Item item3 = new Item("drip coffee", 1.5);
		Item item4 = new Item("cappuccino", 3.0);
		
//		implementing Order methods
		order1.addItem(item1);
		order1.addItem(item2);
		order2.addItem(item4);
		order3.addItem(item3);
		order3.addItem(item3);
		order4.addItem(item2);
		order5.addItem(item1);
		order5.addItem(item4);
		order3.display();
		
//		test getStatusMessage
		order1.isReady(true);
		System.out.println(order1.getStatusMessage());
		
//		test printing return value for getting the total
		System.out.println(order1.getOrderTotal());
		
//		display all orders
		order1.display();
		order2.display();
		order3.display();
		order4.display();
		order5.display();
	}

}
