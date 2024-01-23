package CodSoft;


import java.util.*;

class Bank{
    private double balance;

    public Bank(double balance){
        this.balance = balance;
    }

    public boolean deposit(double amount){
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount){
        if (amount > 0) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance(){
        return this.balance;
    }
}

class ATM {
    private Bank account;
    private Scanner scanner;

    public ATM(Bank account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + account.checkBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.println("Deposit successful. New balance: " + account.checkBalance());
            System.out.println();
        } else {
            System.out.println("Invalid deposit amount.");
            System.out.println();
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + account.checkBalance());
        System.out.println();
    }

    public void start(int acnum, int balance) {
        System.out.println("Hello Account no. " +acnum);
        System.out.println("Your initial balance is: Rs" + balance);
        System.out.println();
        while (true) {
            System.out.println("Enter your choice (1/2/3/4): ");
            displayMenu();
            int choice = scanner.nextInt();

            

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: \n");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: \n");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Signing out for Account Number: " + acnum);
                    System.out.println("Exiting ATM. Have a nice day!\n");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.\n");
            }
            scanner.nextLine();
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi! Welcome to the ATM.");
        System.out.println("Please Enter your Account Number");
        int acnum = sc.nextInt();
        
        int balance = 1000;

        Bank userAccount = new Bank(balance);  
        ATM atm = new ATM(userAccount);
        atm.start(acnum, balance);

        sc.close();
    }
}


