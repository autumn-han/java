import java.util.Arrays;
import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        // getStreakGoal method
        CafeUtil testUtil = new CafeUtil();
        int drinkNum = testUtil.getStreakGoal(10);
        System.out.println("----- getStreakGoal test -----");
        System.out.println(drinkNum);
        // getOrderTotal method
        double[] priceArr = {3.5, 5.0, 6.5, 4.5, 5};
        double orderTotal = testUtil.getOrderTotal(priceArr);
        System.out.println("----- getOrderTotal test -----");
        System.out.println(orderTotal);
        // displayMenu method
        ArrayList<String> menuArr = new ArrayList<String>();
        menuArr.add("drip coffee");
        menuArr.add("cappuccino");
        menuArr.add("latte");
        menuArr.add("mocha");
        System.out.println("----- displayMenu test -----");
        testUtil.displayMenu(menuArr);
        // addCustomer method
        ArrayList<String> custArr = new ArrayList<String>();
        custArr.add("Samuel");
        custArr.add("RJ");
        custArr.add("Emily");
        custArr.add("Peter");
        custArr.add("Autumn");
        System.out.println("----- addCustomer test -----");
        testUtil.addCustomer(custArr);
        testUtil.addCustomer(custArr);
    }
}