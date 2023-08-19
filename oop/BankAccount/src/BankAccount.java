
public class BankAccount {
	
//	member variables
	private double checkingBalance;
	private double savingsBalance;
	private static int accounts = 0;
	private static double totalMoney = 0;
	
//	constructor methods
	public BankAccount() {
		this.checkingBalance = 0;
		this.savingsBalance = 0;
		accounts++;
	}
	
//	getters
	public double getChecking() {
		return checkingBalance;
	}
	public double getSavings() {
		return savingsBalance;
	}
	public static int getTotalAccounts() {
		return accounts;
	}
	public static double getTotalMoney() {
		return totalMoney;
	}
	
//	deposit and withdrawal methods
	public void deposit(String accountType, double amount) {
		if (accountType.equals("checkings")) {
			this.checkingBalance += amount;
			totalMoney += amount;
		}
		else if (accountType.equals("savings")) {
			this.savingsBalance += amount;
			totalMoney += amount;
		}
	}
	public void withdraw(String accountType, double amount) {
		if (accountType.equals("checkings")) {
			if (this.checkingBalance < amount) {
				System.out.println("Unable to process request due to insufficient funds");
			}
			else {
				this.checkingBalance -= amount;
				totalMoney -= amount;
			}
		}
		else if (accountType.equals("savings")) {
			if (this.savingsBalance < amount) {
				System.out.println("Unable to process request due to insufficient funds");
			}
			else {
				this.savingsBalance -= amount;
				totalMoney -= amount;
			}
		}
	}
	
//	getting totalMoney
	public double getBalance() {
		return totalMoney;
	}
}
