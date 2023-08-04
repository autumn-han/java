import java.util.ArrayList;

class CafeUtil {
    public int getStreakGoal(int numWeeks) {
        int drinkSum = 0;
        for (int i = 0; i <= numWeeks; i++) {
            drinkSum = drinkSum + i;
        }
        return drinkSum;
    }
    public double getOrderTotal(double[] prices) {
        double priceSum = 0;
        for (int i = 0; i < prices.length; i++) {
            priceSum = priceSum + prices[i];
        }
        return priceSum;
    }
    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            String item = menuItems.get(i);
            System.out.println(i + " " + item);
        }
    }
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String username = System.console().readLine();
        System.out.println("Hello, " + username);
        System.out.println("There are " + customers.size() + " people in front of you");
        customers.add(username);
        System.out.println(customers);
    }
}
