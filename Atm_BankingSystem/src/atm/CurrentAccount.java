package atm;

	public class CurrentAccount extends account {
	

	    public CurrentAccount(String accountnumber, double balance) {
			super(accountnumber, balance);
		}

		private static final double OVERDRAFT_LIMIT = 1000;

	    @Override
	    public void withdraw(double withdrawal) {
	        if (getbalance() + OVERDRAFT_LIMIT >= withdrawal) {
	            setbalance(getbalance() - withdrawal);
	            System.out.println("Withdrawal successful");
	        } else {
	            System.out.println("Overdraft limit exceeded");
	        }
	    }
	}

