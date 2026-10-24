
class BankAccount {
    private int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(
            Thread.currentThread().getName()
            + " deposited Rs. " + amount
            + " | Balance: Rs. " + balance
        );
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                Thread.currentThread().getName()
                + " withdrew Rs. " + amount
                + " | Balance: Rs. " + balance
            );
        } else {
            System.out.println(
                Thread.currentThread().getName()
                + " failed to withdraw Rs. " + amount
                + " | Insufficient balance!"
            );
        }
    }

    synchronized void displayBalance() {
        System.out.println("Final Balance: Rs. " + balance);
    }
}

class DepositThread extends Thread {
    BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.deposit(500);
        account.deposit(200);
    }
}

class WithdrawalThread extends Thread {
    BankAccount account;

    WithdrawalThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.withdraw(300);
        account.withdraw(400);
    }
}

public class exr1 {
    public static void main(String[] args) {

        // Mohammed Tawfik
        // PRN: 25070122112

        BankAccount account = new BankAccount();

        DepositThread deposit = new DepositThread(account);
        WithdrawalThread withdrawal = new WithdrawalThread(account);

        deposit.setName("Deposit Thread");
        withdrawal.setName("Withdrawal Thread");

        System.out.println("Initial Balance: Rs. 1000");

        deposit.start();
        withdrawal.start();

        try {
            deposit.join();
            withdrawal.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        account.displayBalance();
    }
}
