package atm;

public class Atmapplication {
	 public static void main(String[] args) {

	        AccountDAO dao = new AccountDAO();

	       account acc = dao.getaccountnumber("ACC1001");

	       CurrentAccount account = new CurrentAccount("ACC1001", 5000);

	        // Initial balance
	        System.out.println("Initial Balance: " + account.getbalance());

	        // Deposit money
	        account.deposit(1000);
	        System.out.println("After Deposit: " + account.getbalance());

	        // Withdraw money
	        account.withdraw(5500);
	        System.out.println("After Withdrawal: " + account.getbalance());

	        // Try exceeding overdraft
	        account.withdraw(2000);
	        System.out.println("Final Balance: " + account.getbalance());
}
}
