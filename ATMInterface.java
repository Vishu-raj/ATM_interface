import java.util.Scanner;

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
            System.out.println("Successfully deposited $" + amount + ". Updated balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount + ". Updated balance: $" + balance);
        } else {
            System.out.println("Withdrawal amount is invalid or exceeds balance.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void showMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Exit");
    }

    public void executeTransaction(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.println("Your current balance is: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter the amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter the amount to withdraw: $");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Goodbye!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial balance for the account: $");
        double initialBalance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.showMenu();
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            atm.executeTransaction(option, scanner);
        }
    }
}
