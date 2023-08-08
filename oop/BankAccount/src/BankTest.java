
public class BankTest {
	public static void main(String[] args) {
//		instantiating BankAccounts
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		BankAccount account3 = new BankAccount();
		
//		test deposit method
		account1.deposit("checkings", 2000);
		account1.deposit("savings", 3000);
		System.out.printf("account1 checkings: %s\naccount1 savings: %s\n", account1.getChecking(), account1.getSavings());
		account2.deposit("checkings", 200);
		account2.deposit("savings", 10000);
		System.out.printf("acount2 checkings: %s\naccount1 savings: %s\n", account2.getChecking(), account2.getSavings());
		account3.deposit("checkings", 1500);
		account3.deposit("savings", 5000);
		System.out.printf("account3 checkings: %s\naccount3 savings: %s\n", account3.getChecking(), account3.getSavings());
		
//		get balance across all accounts
		System.out.println("Balance across all accounts after depositing money: " + BankAccount.getTotalMoney());
		
//		test withdraw method
		account1.withdraw("checkings", 500);
		System.out.printf("account1 checkings: %s\n", account1.getChecking());
		account2.withdraw("checkings", 300);
		account3.withdraw("savings", 500);
		System.out.printf("account2 savings: %s\n", account3.getSavings());
		
//		get balance across all accounts 
		System.out.println("Balance across all accounts after withdrawing money: " + BankAccount.getTotalMoney());
	}

}
