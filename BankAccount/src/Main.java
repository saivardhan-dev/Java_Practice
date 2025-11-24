import java.util.Scanner;

class BankAccount{
    private String name;
    private double balance;

    public BankAccount(String name, double balance){
        this.name=name;
        this.balance=balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }
    public void withdraw(double amount){
        if(amount>balance){
            System.out.println("insufficient Funds!");
        }
        else{
            balance-=amount;
            System.out.println("withdrawn: $" + amount);
        }
    }
    public void showBalance(){
        System.out.println("Current Balance: $" + balance);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account holder name: ");
        String name = sc.nextLine();

        BankAccount acc = new BankAccount(name,0);
        int choice;

        do{
            System.out.println("\n1.Deposit \n2.Withdraw \n3.Check Balance \n4. Exit");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                    break;
                case 3:
                    acc.showBalance();
                    break;
                case 4:
                    System.out.println("Thank You!");
                default:
                    System.out.println("Not an option");
            }
        }
        while(choice<=0 && choice>4);
        sc.close();
    }
}

