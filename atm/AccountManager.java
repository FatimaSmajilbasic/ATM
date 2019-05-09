package atm;

public class AccountManager extends Account {
    

	public static boolean isAccountNumberValid(int accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			while (accounts.get(i).getAccountNumber() == accountNumber ) {
				return false;
			}
		}
		return true;
	}
	public static boolean isBalanceValid(double balance) {
		if (balance < 0)
				return false;
		
		return true;

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
