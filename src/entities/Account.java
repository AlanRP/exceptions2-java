package entities;

import exceptions.BusinessException;

public class Account {
	private int number;
	private String holder;
	private double balance;
	private double withdrawLimite;

	public Account(int number, String holder) {
		this.number = number;
		this.holder = holder;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public double getWithdrawLimite() {
		return withdrawLimite;
	}

	public void setWithdrawLimite(double withdrawLimite) {
		this.withdrawLimite = withdrawLimite;
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
	
	private void validateWithdraw(double amount) { 
		if(getWithdrawLimite() < amount) {
			throw new BusinessException("The amount exceeds withdraw limit");
		}
		if(getBalance() < amount) {
			throw new BusinessException("Not enough balance");
		}		
	}
	
	
	@Override
	public String toString() {
		return "Account " + number + " holder " + holder;
	}
}
