import java.util.ArrayList;


public class TestKiosk {
	public static void main(String[] args) {
		
//		instantiating Kiosk and adding menu items
		CoffeeKiosk mainKiosk = new CoffeeKiosk();
		mainKiosk.addMenuItem("banana", 2.0, 0);
		mainKiosk.addMenuItem("coffee", 1.50, 1);
		mainKiosk.addMenuItem("latte", 4.50, 2);
		mainKiosk.addMenuItem("cappuccino", 3.00, 3);
		mainKiosk.addMenuItem("muffin", 4.00, 4);
		
//		displaying menu items
		mainKiosk.displayMenu();
		
//		testing console method
		mainKiosk.newOrder();
	}

}
