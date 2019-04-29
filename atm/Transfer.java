package atm;

public class Transfer extends Transactions {
	 public static boolean check() {
			boolean sourceexist = false;
			boolean targetexist = false;
			boolean enough = false;
			
			for (int i = 0; i < accounts.size(); i++ ) {
				if (accounts.get(i).getAccountNumber() == sourceAccount) {
					sourceexist = true;
					return true;
				} else {
					System.out.println("This account does not exist.");
				}
			}
			for (int i = 0; i < accounts.size(); i++ ) {
				if (accounts.get(i).getAccountNumber() == targetAccount) {
					targetexist = true;
					return true;
				} else {
					System.out.println("The target account does not exist.");
				}
			}
			for (int i = 0; i < accounts.size(); i++ ) {
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
		public static void doTransaction() {
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getAccountNumber() == targetAccount)
					accounts.get(i).balance += money;
				if (accounts.get(i).getAccountNumber() == sourceAccount)
					accounts.get(i).balance -= money;
			}
		}
		public void increasBalance(double sum) {
			balance += sum;
		}

		public void decreasBalance(double sum) {
			balance -= sum;
		}

	} 

}
