import java.util.ArrayList;

public class TestOrders {
	public static void main(String[] args) {
//		instantiating Items 
		Item item1 = new Item();
		item1.name = "mocha";
		item1.price = 4.5;
		Item item2 = new Item();
		item2.name = "latte";
		item2.price = 3.5;
		Item item3 = new Item();
		item3.name = "drip coffee";
		item3.price = 2.0;
		Item item4 = new Item();
		item4.name = "cappuccino";
		item4.price = 3.0;
//		instantiating Orders
		Order order1 = new Order();
		order1.name = "Cindhuri";
		Order order2 = new Order();
		order2.name = "Jimmy";
		Order order3 = new Order();
		order3.name = "Noah";
		Order order4 = new Order();
		order4.name = "Sam";
//		adding item1 to order2 and increment total
		order2.items.add(item1);
		order2.total = item1.price;
//		add cappuccino to Noah's order
		order3.items.add(item4);
		order3.total = item3.price;
//		add latte to Sam's order
		order4.items.add(item2);
		order4.total = item2.price;
//		update Cindhuri's status to ready
		order1.ready = true;
//		Sam ordered two more lattes
		order4.items.add(item2);
		order4.items.add(item2);
		order4.total = order4.total + (item2.price*2);
//		Jimmy's order is ready, update his status
		order2.ready = true;
//		print results to console
		System.out.printf("Name: %s\n", order1.name);
		System.out.printf("Total: %s\n", order1.total);
		System.out.printf("Ready: %s\n", order1.ready);
		System.out.printf("Name: %s\n", order2.name);
		System.out.printf("Total: %s\n", order2.total);
		System.out.printf("Ready: %s\n", order2.ready);
		System.out.printf("Name: %s\n", order3.name);
		System.out.printf("Total: %s\n", order3.total);
		System.out.printf("Ready: %s\n", order3.ready);
		System.out.printf("Name: %s\n", order4.name);
		System.out.printf("Total: %s\n", order4.total);
		System.out.printf("Ready: %s\n", order4.ready);
	}

}
