import java.util.ArrayList;
import java.util.Scanner;
public class SimpleBankSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║   Simple Bank System                ║");
        System.out.println("╚═════════════════════════════════════╝\n");
        // Add some sample accounts
        accounts.add(new BankAccount("ACC001", "Yadav", 5000));
        accounts.add(new BankAccount("ACC002", "Priya", 3000));
        accounts.add(new BankAccount("ACC003", "Arjun", 7500));
        boolean continueProgram = true;
        while(continueProgram) {
            displayMenu();
            System.out.print("Enter your choice (1-6): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!\n");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    checkBalance();
                    break;
                case 6:
                    continueProgram = false;
                    System.out.println("\nThank you for using Bank System!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.\n");
            }
        }
        scanner.close();
    }
    static void displayMenu() {
        System.out.println("\n--- Bank System Menu ---");
        System.out.println("1. Create new account");
        System.out.println("2. View all accounts");
        System.out.println("3. Deposit money");
        System.out.println("4. Withdraw money");
        System.out.println("5. Check balance");
        System.out.println("6. Exit");
    }
    static void createAccount() {
        System.out.print("\nEnter account holder name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }
        System.out.print("Enter initial deposit: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount!");
            scanner.nextLine();
            return;
        }
        double initialDeposit = scanner.nextDouble();
        if (initialDeposit < 0) {
            System.out.println("Initial deposit cannot be negative!");
            return;
        }
        String accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(accountNumber, name, initialDeposit);
        accounts.add(newAccount);
        System.out.println("✓ Account created successfully!");
        System.out.println("Account Number: " + accountNumber);
    }
    static void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("\n📭 No accounts found!");
            return;
        }
        System.out.println("\n--- All Accounts ---");
        for (BankAccount account : accounts) {
            System.out.println(account.getAccountNumber() + " - " + account.getHolderName() + ": ₹" + String.format("%.2f", account.getBalance()));
        }
    }
    static void depositMoney() {
        System.out.print("\nEnter account number: ");
        String accountNumber = scanner.nextLine().trim();
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter amount to deposit: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount!");
            scanner.nextLine();
            return;
        }
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        account.deposit(amount);
        System.out.println("✓ Deposit successful!");
        System.out.println("New balance: ₹" + String.format("%.2f", account.getBalance()));
    }
    static void withdrawMoney() {
        System.out.print("\nEnter account number: ");
        String accountNumber = scanner.nextLine().trim();
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter amount to withdraw: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount!");
            scanner.nextLine();
            return;
        }
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (!account.withdraw(amount)) {
            System.out.println("✗ Insufficient balance!");
            return;
        }
        System.out.println("✓ Withdrawal successful!");
        System.out.println("New balance: ₹" + String.format("%.2f", account.getBalance()));
    }
    static void checkBalance() {
        System.out.print("\nEnter account number: ");
        String accountNumber = scanner.nextLine().trim();
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Holder Name: " + account.getHolderName());
        System.out.println("Current Balance: ₹" + String.format("%.2f", account.getBalance()));
    }
    static BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    static String generateAccountNumber() {
        return "ACC" + String.format("%05d", accounts.size() + 1);
    }
}
class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}





