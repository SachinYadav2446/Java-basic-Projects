import java.util.ArrayList;
import java.util.Scanner;
public class BankAccountManager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<BankAccountOOP> accounts = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║   Bank Account Manager (OOP)        ║");
        System.out.println("╚═════════════════════════════════════╝\n");
        // Create sample accounts
        accounts.add(new BankAccountOOP("ACC001", "Yadav", 5000, "Savings"));
        accounts.add(new BankAccountOOP("ACC002", "Priya", 8000, "Current"));
        accounts.add(new BankAccountOOP("ACC003", "Arjun", 3000, "Savings"));
        boolean continueProgram = true;
        while(continueProgram) {
            displayMenu();
            System.out.print("Enter your choice (1-7): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!\n");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    performTransaction();
                    break;
                case 4:
                    viewAccountDetails();
                    break;
                case 5:
                    transferMoney();
                    break;
                case 6:
                    calculateInterest();
                    break;
                case 7:
                    continueProgram = false;
                    System.out.println("\nThank you for using Bank Manager!");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
        scanner.close();
    }
    static void displayMenu() {
        System.out.println("\n--- Bank Manager Menu ---");
        System.out.println("1. Create new account");
        System.out.println("2. View all accounts");
        System.out.println("3. Perform transaction (Deposit/Withdraw)");
        System.out.println("4. View account details");
        System.out.println("5. Transfer money between accounts");
        System.out.println("6. Calculate interest");
        System.out.println("7. Exit");
    }
    static void createNewAccount() {
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
        double deposit = scanner.nextDouble();
        scanner.nextLine();
        if (deposit < 0) {
            System.out.println("Initial deposit cannot be negative!");
            return;
        }
        System.out.print("Enter account type (Savings/Current): ");
        String type = scanner.nextLine().trim();
        if (!type.equalsIgnoreCase("Savings") && !type.equalsIgnoreCase("Current")) {
            type = "Savings";
            System.out.println("Invalid type. Setting to Savings.");
        }
        String accountNumber = generateAccountNumber();
        BankAccountOOP newAccount = new BankAccountOOP(accountNumber, name, deposit, type);
        accounts.add(newAccount);
        System.out.println("✓ Account created!");
        System.out.println("Account Number: " + accountNumber);
    }
    static void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("\n📭 No accounts!");
            return;
        }
        System.out.println("\n--- All Accounts ---");
        for (BankAccountOOP account : accounts) {
            System.out.println(account.getAccountNumber() + " - " + account.getHolderName() + " (" + account.getAccountType() + "): ₹" + String.format("%.2f", account.getBalance()));
        }
    }
    static void performTransaction() {
        System.out.print("\nEnter account number: ");
        String accountNumber = scanner.nextLine().trim();
        BankAccountOOP account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("\n1. Deposit");
        System.out.println("2. Withdraw");
        System.out.print("Choose transaction type: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input!");
            scanner.nextLine();
            return;
        }
        int type = scanner.nextInt();
        System.out.print("Enter amount: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount!");
            scanner.nextLine();
            return;
        }
        double amount = scanner.nextDouble();
        if (type == 1) {
            account.deposit(amount);
            System.out.println("✓ Deposit successful!");
        } else if (type == 2) {
            if (account.withdraw(amount)) {
                System.out.println("✓ Withdrawal successful!");
            } else {
                System.out.println("✗ Insufficient balance!");
            }
        } else {
            System.out.println("Invalid transaction type!");
        }
        System.out.println("New balance: ₹" + String.format("%.2f", account.getBalance()));
    }
    static void viewAccountDetails() {
        System.out.print("\nEnter account number: ");
        String accountNumber = scanner.nextLine().trim();
        BankAccountOOP account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("\n--- Account Details ---");
        account.displayDetails();
    }
    static void transferMoney() {
        System.out.print("\nEnter from account number: ");
        String fromAccount = scanner.nextLine().trim();
        BankAccountOOP from = findAccount(fromAccount);
        if (from == null) {
            System.out.println("From account not found!");
            return;
        }
        System.out.print("Enter to account number: ");
        String toAccount = scanner.nextLine().trim();
        BankAccountOOP to = findAccount(toAccount);
        if (to == null) {
            System.out.println("To account not found!");
            return;
        }
        System.out.print("Enter transfer amount: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount!");
            scanner.nextLine();
            return;
        }
        double amount = scanner.nextDouble();
        if (from.withdraw(amount)) {
            to.deposit(amount);
            System.out.println("✓ Transfer successful!");
            System.out.println(from.getHolderName() + "'s balance: ₹" + 
                              String.format("%.2f", from.getBalance()));
            System.out.println(to.getHolderName() + "'s balance: ₹" + 
                              String.format("%.2f", to.getBalance()));
        } else {
            System.out.println("✗ Insufficient balance in source account!");
        }
    }
    static void calculateInterest() {
        System.out.print("\nEnter account number: ");
        String accountNumber = scanner.nextLine().trim();
        BankAccountOOP account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter interest rate (%) per annum: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid rate!");
            scanner.nextLine();
            return;
        }
        double rate = scanner.nextDouble();
        double interest = account.calculateInterest(rate);
        System.out.println("\n--- Interest Calculation ---");
        System.out.println("Current Balance: ₹" + String.format("%.2f", account.getBalance()));
        System.out.println("Interest Rate: " + rate + "% p.a.");
        System.out.println("Annual Interest: ₹" + String.format("%.2f", interest));
        System.out.println("Amount after 1 year: ₹" + 
                          String.format("%.2f", account.getBalance() + interest));
    }
    static BankAccountOOP findAccount(String accountNumber) {
        for (BankAccountOOP account : accounts) {
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
class BankAccountOOP {
    // Private variables (encapsulation)
    private String accountNumber;
    private String holderName;
    private double balance;
    private String accountType; // "Savings" or "Current"
    private ArrayList<Transaction> transactions;
    // Constructor
    public BankAccountOOP(String accountNumber, String holderName, 
                         double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
        this.transactions.add(new Transaction("Initial Deposit", initialBalance));
    }
    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    // Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", -amount));
            return true;
        }
        return false;
    }
    public double calculateInterest(double rate) {
        return (balance * rate) / 100;
    }
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: ₹" + String.format("%.2f", balance));
        System.out.println("Total Transactions: " + transactions.size());
    }
}
class Transaction {
    private String type;
    private double amount;
    private long timestamp;
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public long getTimestamp() { return timestamp; }
}





