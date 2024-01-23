package ATM_Interface;

import java.util.Scanner;

public class ATM_Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize Bank Account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create ATM object connected to the user's bank account
        ATM atm = new ATM(userAccount);

        // Main ATM loop
        while (true) {
            atm.displayMenu();
            System.out.print("Enter option (1-4): ");
            int option = scanner.nextInt();

            // Process the user's chosen option
            atm.processOption(option, scanner);
        }
    }
}

// ATM Class
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Current balance: " + bankAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

// Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}
