public class CafeJava {
    public static void main(String[] args) {
        // greetings/statements
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly.";
        String readyMessage = ", your order is ready.";
        String priceMessage = "Your total today is, $";
        // drink price variables
        double mocha = 3.5;
        double dripCoffee = 2.5;
        int latte = 4;
        double cappuccino = 3.5;
        // customer name variables
        String customer1 = "Chindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
        // order status variables
        boolean orderOneStatus = false;
        boolean orderTwoStatus = true;
        boolean orderThreeStatus = true;
        boolean orderFourStatus = false;
        // print statements
        System.out.println(orderOneStatus ? customer1 + readyMessage : customer1 + pendingMessage);
        System.out.println(orderFourStatus ? customer4 + readyMessage + priceMessage + cappuccino : customer4 + pendingMessage);
        System.out.println(customer3 + ". " + priceMessage + 2*cappuccino);
        System.out.println(orderTwoStatus ? customer2 + readyMessage : customer2 + pendingMessage);
        System.out.println(customer3 + ". " + priceMessage + (latte - dripCoffee));
    }
}