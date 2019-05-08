package atm;

public class AccountManager extends Account {


	public static boolean isAccountNumberValid(int accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			while (accounts.get(i).getAccountNumber() == accountNumber) {
				return true;
			}
		}
		return false;
	}
	public static boolean isBalanceValid(double balance) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getBalance() < 0) {
				return true;
			}
		}
		return false;

	}
	public static boolean validName(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				return false;
			}
		}

		return true;

	}
	
	
}
