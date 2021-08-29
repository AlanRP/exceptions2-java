package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		try {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double deposit = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double limit = sc.nextDouble();

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			Account account = new Account(number, holder);
			account.deposit(deposit);
			account.setWithdrawLimite(limit);
			account.withdraw(amount);
			
			System.out.println("New balance: " + account.getBalance());
			sc.close();
		} catch (BusinessException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}

}
