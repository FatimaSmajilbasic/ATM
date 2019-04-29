package atm;
import java.util.ArrayList;

public class Account  {
	private  int accountNumber;
	private  String client;
	protected double balance;
	public static ArrayList<Account> accounts = new ArrayList<Account>();


	Account(){
		
	}
	Account(int accountNumber, String client, double balance){
		this.accountNumber = accountNumber;
		this.client = client;
		this.balance = balance;
		accounts.add(this);
		
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public static void checkBalance(int accountNumber) {
		for (int i = 0; i < accounts.size(); i++)
			if (accounts.get(i).accountNumber == accountNumber) {
				System.out.println(accounts.get(i).toString());
				return;
			}
		System.out.println("Account is incorrect.");
	}
	
	
	public static int numberOfAccountsCreated(){
		return accounts.size();
	}
	


	public static boolean isBalanceValid(double balance) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getBalance() < 0) {
				return true;
			}
		}
		return false;

	}
	public static boolean isAccountNumberValid(int accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			while (accounts.get(i).getAccountNumber() == accountNumber) {
				return true;
			}
		}
		return false;
	}
	

	public static void printoutsOfAccounts(int accountNumber) {
		for (int i = 0; i < accounts.size(); i++)
			if (accounts.get(i).accountNumber == accountNumber) {
				System.out.println(accounts.get(i).toString());
				return;
			}
		System.out.println("Account is incorrect.");

	}

	public static boolean validName(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				return false;
			}
		}

		return true;

	}
	
	  
		public  String toString() {
		return "Account [Account No = " + accountNumber + ", client = "
				+ client + ", balance = " + balance + " $]";
	
	}
}



	



