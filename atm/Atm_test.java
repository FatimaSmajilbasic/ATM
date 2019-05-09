package atm;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class Atm_test {

	public static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
    
		Scanner input = new Scanner(System.in);
		int choice = -1;
		int accNumber = 0;
	
		while(choice != 0 ) {
		System.out.print("Please choose an option: \n" + "\n 1. Create account\n"
				+ "\n 2. Transfer money to another account\n" + "\n 3. Print account details \n " + "\n 4. Exit \n");

		 choice = input.nextInt();
		switch (choice) {

		case 1:
            Account account = new Account();
			input.nextLine();
			System.out.println("Please insert your name :");
			String name = input.nextLine();
			while (!AccountManager.validName(name)) {
				System.out.print("Name should contain only letters! Try again :");
				
				name = input.nextLine();
			}
			account.setClient(name);
			
			System.out.println("Please insert number of account :");
			boolean continueInput;
			do {
				try {

					 accNumber = input.nextInt();

					input.nextLine();
				   continueInput = false;
				
					while (!AccountManager.isAccountNumberValid(accNumber) || accNumber < 0) {
						
						System.out.println("Please choose another account number: ");
						accNumber = input.nextInt();
					}
					account.setAccountNumber(accNumber);
				} 
				catch (InputMismatchException ex) {
					System.out.println("Incorrect input: an integer is required. Try again! ");
					input.nextLine();
					continueInput = true;
				}
			} while (continueInput);
		

			System.out.println("Please insert account balance :");

			double balance = input.nextDouble();
			while (balance < 0 ) {
				System.out.print("Please insert your balance again : ");
				balance = input.nextDouble();
			}
			account.setBalance(balance);
			
			System.out.println("You have successfully created an account. Insert 3 to check account details.");
			Account acc = new Account(accNumber, name, balance);
			accounts.add(acc);	
			
	

			break;

		case 2:
			Transactions transaction = new Transactions();
			System.out.println("Enter the account number from which you want to transfer money: ");
			int sourcenumber = input.nextInt();
			input.nextLine();
			transaction.setSourceAccount(sourcenumber);
			System.out.println("Enter the account number to which you want to transfer money: ");
			int targetnumber = input.nextInt();
			input.nextLine();
			transaction.setTargetAccount(targetnumber);
			System.out.println("Enter the sum of money you want to transfer :");
			double money = input.nextDouble();
			input.nextLine();
			transaction.setSumMoney(money);
			if (Transactions.check()) {
				Transactions.doTransaction();
				System.out.println("The transaction was successfully executed.");
			} else {
				System.out.println("Something went wrong, please try again.");
			}

			break;

		case 3:
			System.out.println("Please insert your number of account :");
			accNumber = input.nextInt();
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getAccountNumber() == accNumber) {
					System.out.println();
					Account.checkAccounts(accNumber);
				}
			}
			break;
		
		case 0:
			System.out.println("Have a nice day!"); break;
	
		}
		}
		input.close();
	}

}