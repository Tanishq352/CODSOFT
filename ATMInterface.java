import java.util.Scanner;

// Class to represent a user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Transaction failed.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew Rs" + amount);
        }
    }

    // Check balance method
    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor connects ATM with a BankAccount
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display menu options
    public void showMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.println("=======================");
    }

    // Method to start the ATM session
    public void start() {
        boolean exit = false;

        System.out.println("Welcome to the ATM Machine!");

        while (!exit) {
            showMenu();
            System.out.print("Choose an option (1-4): ");

            // Input validation
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: Rs" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: Rs");
                    if (scanner.hasNextDouble()) {
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: Rs");
                    if (scanner.hasNextDouble()) {
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option! Please select between 1 and 4.");
            }
        }
    }
}

// Main class to run the ATM program
public class ATMInterface {
    public static void main(String[] args) {
        // Create a BankAccount with an initial balance
        BankAccount userAccount = new BankAccount(5000.00);

        // Create ATM and connect it to user's account
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.start();
    }
}
