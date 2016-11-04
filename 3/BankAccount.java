/** 
 * Class that holds a BankAccount which has a balance and an account number.
 * You can deposit money into the account, withdraw money from the account and
 * transfer money to another account.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class BankAccount {
    /** Counter that keeps track of the number of accounts created.  Used
     * to assign account numbers to new accounts.
     */
    private static int nextAccountNumber = 1;
    private double balance = 0.0;
    private int accountNumber = 1;
    
    /** 
     * Creates a default account with start balance $0.00.
     */
    public BankAccount() {
        this(0.0);
    }
    
    /**
     * Creates a new account setting the balance of the account to
     * the specified start balance.
     * @param startBalance the initial balance for this new account.
     */
    public BankAccount(double startBalance) {
        balance = startBalance;
        accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }
    
    /**
     * Creates a copy of the account specified as an argument.  Both
     * accounts will have the same account number and the same balance.
     * @param accountToCopy the account to create a copy of.
     */
    public BankAccount(BankAccount accountToCopy) {
        if (accountToCopy != null) {
            balance = accountToCopy.balance;
            accountNumber = accountToCopy.accountNumber;
        }
    }
    
    /** 
     * This accessor methods returns the current balance in this account.
     * @return the current balance of the account.
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * This accessor method returns the account number of this account.
     * @return The account number of the account.
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * This mutator method withdraws the specified amount if sufficient funds 
     * exist in this account.  The amount is required to be a positive amount.
     * @param amount The amount to withdraw from the account.
     * @return Whether the withdraw was successful.
     */
    public boolean withdraw(double amount) {
        if (amount <= balance  && amount > 0) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    /**
     * This mutator method deposits the specified amount, which is required
     * to be positive.
     * @param amount The amount to deposit into the account.
     * @return Whether the deposit was successful.
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
    
    /**
     * This mutator method transfers the specified amount from this account
     * to the specified account if there is sufficient funds in this account.
     * The amount is required to be positive.
     * @param amount The amount to transfer.
     * @param toAccount The account to transfer the funds to.
     */
    public boolean transfer(double amount, BankAccount toAccount) {
        boolean success = false;
        if (amount > 0 && balance >= amount) {
            withdraw(amount);
            toAccount.deposit(amount);
            success = true;
        }
        return success;
    }

    /**
     * This accessor method returns a string representation of this account
     * in the format (<account_number>,<current_balance>).
     * @return a string representation of this account.
     */
    public String toString() {
        return String.format("%d,%.2f",accountNumber,balance);
    }
    
    /**
     * Returns true if this account is considered equal to the specified account.
     * Two BankAccounts are considered equal if they have the same account number.
     * @param other The account to check for equality with.
     */
    public boolean equals(BankAccount other) {
        return accountNumber == other.accountNumber;
    }
}