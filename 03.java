class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

   
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

   
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
}

class Bank {
    private BankAccount[] accounts;
    private int accountCount;

    public Bank() {
        accounts = new BankAccount[5]; 
        accountCount = 0;
    }

    public void addAccount(BankAccount account) {
        if (accountCount < accounts.length) {
            accounts[accountCount++] = account;
        } else {
            System.out.println("Bank account limit reached.");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        boolean found = false;
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                found = true;
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal of " + amount + " from account " + accountNumber + " successful.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Account number " + accountNumber + " not found.");
        }
    }

    public void displayAllAccounts() {
        System.out.println("Bank Accounts:");
        for (int i = 0; i < accountCount; i++) {
            BankAccount acc = accounts[i];
            System.out.println("Account Number: " + acc.getAccountNumber()
                    + ", Holder: " + acc.getAccountHolder()
                    + ", Balance: " + acc.getBalance());
        }
    }
}

class Main {
    public static void main(String[] args) {
        
        Bank bank = new Bank();

        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        bank.withdrawFromAccount(1001, 6000.0); 
        bank.withdrawFromAccount(1002, 1000.0); 

        bank.displayAllAccounts();
    }
}
