package atm;

public class Transactions extends Account {
	private static int sourceAccount;
	private static int targetAccount;
	private static double money;

	public Transactions() {

	}

	public Transactions(int sourceAccount, int targetAccount, double money) {
		Transactions.sourceAccount = sourceAccount;
		Transactions.targetAccount = targetAccount;
		Transactions.money = money;
	}

	public int getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(int sourceAccount) {
		Transactions.sourceAccount = sourceAccount;
	}

	public int getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(int targetAccount) {
		Transactions.targetAccount = targetAccount;
	}

	public double getSumMoney() {
		return money;
	}

	public void setSumMoney(double money) {
		Transactions.money = money;
	}

	public static boolean check() {
		boolean sourceexist = false;
		boolean targetexist = false;
		boolean enough = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == sourceAccount) {
				sourceexist = true;
				return true;

			} else {
				System.out.println("This account does not exist.");
			}
		}

		for (int i = 0; i < accounts.size(); i++) {

			if (accounts.get(i).getAccountNumber() == targetAccount) {
				targetexist = true;
				return true;
			} else {
				System.out.println("The target account does not exist.");
			}
		}

		for (int i = 0; i < accounts.size(); i++) {

			if ((accounts.get(i).getBalance() - money) >= 0) {
				enough = true;
				return true;
			} else {
				System.out.println("You do not have enough money on your bank account.");
			}

		}

		if (sourceexist && targetexist && enough) {
			return true;
		}

		else
			return false;
	}

	public static  void doTransaction() {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == targetAccount)
				accounts.get(i).balance += money;

			if (accounts.get(i).getAccountNumber() == sourceAccount)
				accounts.get(i).balance -= money;
		}

	}

}
