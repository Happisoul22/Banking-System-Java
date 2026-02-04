import java.util.HashMap;

public class BankService {

    private HashMap<Integer, Account> accounts = new HashMap<>();

    public void createAccount(int accNo, String name, double initialBalance) {
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists");
            return;
        }
        accounts.put(accNo, new Account(accNo, name, initialBalance));
        System.out.println("Account created successfully");
    }

    public void deposit(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
            System.out.println("Amount deposited successfully");
        } else {
            System.out.println("Account not found");
        }
    }

    public void withdraw(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            if (acc.withdraw(amount)) {
                System.out.println("Withdrawal successful");
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Account not found");
        }
    }

    public void transfer(int fromAcc, int toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("One or both accounts not found");
            return;
        }

        if (sender.withdraw(amount)) {
            receiver.deposit(amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void checkBalance(int accNo) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.println("Balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found");
        }
    }
}
