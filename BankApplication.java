// Define the BankAccount class
class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void accountDetails() {
        System.out.println("Your account number is " + accountNumber);
        System.out.println("Your current balance is " + balance);
    }

    public double getBalance(int pinCode) {
        if (pinCode == 5857) {
            return balance;
        } else {
            System.out.println("Your pin code is not correct, please provide a correct pin code.");
            return -1;
        }
    }

    public int getAccountNumber(int pinCode) {
        if (pinCode == 5857) {
            return accountNumber;
        } else {
            System.out.println("Your pin code is not correct, please provide a correct pin code.");
            return -1;
        }
    }

    public void displayAccountType() {
        System.out.println("It is a checking account");
    }
}

// Define the SavingsAccount class that extends BankAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = getBalance(5857) * (interestRate / 100);
        deposit(interest);
    }

    @Override
    public void displayAccountType() {
        System.out.println("It is a saving account");
    }
}

// Main class to demonstrate the functionality
public class BankApplication {
    public static void main(String[] args) {
        BankAccount arun = new BankAccount(1234, 400);
        System.out.println(arun.getBalance(5857));  // Output: 400.0
        arun.deposit(1000);
        arun.withdraw(100);
        arun.accountDetails();  // Output: Your account number is 1234, Your current balance is 1300.0

        SavingsAccount arunSavings = new SavingsAccount(111, 900, 5.0);
        arunSavings.calculateInterest();
        arunSavings.accountDetails();  // Output: Your account number is 111, Your current balance is 945.0
    }
}
