import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Account{
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance=balance+amount;
            System.out.println("Deposited: $" + amount + "|" + "New Balance: $" + balance);
        }
        else{
            System.out.println("Invalid amount!");
        }
    }
    public abstract void withdraw(double amount);
    public double getBalance(){
        return balance;
    }
}

class SavingsAccount extends Account{
    private static final double minBalance = 500.00;
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, Math.max(balance, minBalance));
    }

    @Override
    public void withdraw(double amount){
        if(amount < 0){
            System.out.println("Invalid amount!");
        }
        else if(amount>0 && balance-amount>=minBalance){
            balance=balance-amount;
            System.out.println("Withdrawn amount : $" + amount);
        }
        else{
            System.out.println("Maintain Minimum Balance" + minBalance);
        }
    }
}
class CheckingAccount extends Account{
    private final double overDraftLimit;
    public CheckingAccount(String accountNumber, double balance, double overDraftLimit) {
        super(accountNumber, balance);
        this.overDraftLimit=overDraftLimit;
    }

    @Override
    public void withdraw(double amount){
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        }
        else if (balance - amount >= -overDraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + balance);
        }
        else {
            System.out.println("Overdraft limit exceeded! Transaction declined.");
        }
    }
}

class Customer{
    private String name;
    private int id;
    private final List<Account> accounts = new ArrayList<>();

    public Customer(String name, int id){
        this.name=name;
        this.id=id;
    }
    public void addAccount(Account account){
        accounts.add(account);
    }
    public String getName(){
        return name;
    }
}

class Bank {
    private Customer cName;

    public Customer createCustomer(String name) {
        cName = new Customer(name, 1);
        System.out.println("Customer created: " + name);
        return cName;
    }

    public Account openSavings(String accountNumber, double openingBalance) {
        Account acc = new SavingsAccount(accountNumber, openingBalance);
        cName.addAccount(acc);
        System.out.println("Savings Account (" + accountNumber + ") opened for " + cName.getName());
        return acc;
    }

    public Account openChecking(String accountNumber, double openingBalance, double overdraftLimit) {
        Account acc = new CheckingAccount(accountNumber, openingBalance, overdraftLimit);
        cName.addAccount(acc);
        System.out.println("Checking Account (" + accountNumber + ") opened for " + cName.getName());
        return acc;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        bank.createCustomer(name);

        Account account = null;

        System.out.println("\nSelect account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) {
            case 1-> {
                System.out.print("Enter Savings Account Number: ");
                String accNo = sc.nextLine();
                System.out.print("Enter initial deposit amount: ");
                double opening = sc.nextDouble();
                if (opening > 500) {
                    account = bank.openSavings(accNo, opening);
                    System.out.println("Savings account created successfully!");
                } else {
                    System.out.println("Minimum Initial Deposit should be $500");
                    System.out.print("Enter initial deposit amount: ");
                }
            }
            case 2->  {
                System.out.print("Enter Checking Account Number: ");
                String accNo = sc.nextLine();
                System.out.print("Enter initial deposit amount: ");
                double opening = sc.nextDouble();
                System.out.print("Enter overdraft limit: ");
                double overdraft = sc.nextDouble();
                account = bank.openChecking(accNo, opening, overdraft);
                System.out.println("Checking account created successfully!");
            }
            case 3-> {
                System.out.println("Invalid choice. Exiting.");
                sc.close();
                return;
            }
        }

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choose = sc.nextInt();

            switch (choose) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double amt = sc.nextDouble();
                    account.deposit(amt);
                }
                case 2 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double amt = sc.nextDouble();
                    account.withdraw(amt);
                }
                case 3 -> System.out.println("Current Balance: $" + account.getBalance());
                case 4 -> {
                    System.out.println("Thank you for banking with us!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}