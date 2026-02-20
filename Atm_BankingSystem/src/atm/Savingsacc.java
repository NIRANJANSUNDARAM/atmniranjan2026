package atm;

public class Savingsacc extends account {
	
 public Savingsacc(String accountnumber, double balance) {
		super(accountnumber, balance);
	}

 private static final double minbalance=500;
 
 @Override
 public void withdraw(double withdrawal)
 {
	 if(getbalance()-withdrawal>=minbalance)
	 {
		 setbalance(getbalance()-withdrawal);
		 System.out.println("Withdraw success");
	 }
	 else
	 {
		 System.out.println("Minimum Balance Required");
	 }
 }
}
