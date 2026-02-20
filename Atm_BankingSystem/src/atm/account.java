package atm;

public class account{
	private String accountnumber;
	private double balance;
	
	public account(String accountnumber,double balance)
	{
		this.accountnumber=accountnumber;
		this.balance=balance;
	}

	public String getaccno()
	{
		return accountnumber;
	}
	
	public void setaccno(String accountnumber)
	{
		this.accountnumber=accountnumber;
	}
	
	public void deposit(double deposit)
	{
		balance+=deposit;
		System.out.println("Money Deposited");
	}
	
	public void withdraw(double withdrawal)
	{
		if(balance>=withdrawal)
		{
			balance-=withdrawal;
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}
	public double getbalance()
	{
		return balance;
	}
	
	public void setbalance(double balance)
	{
		this.balance=balance;
	}
	
	
}
