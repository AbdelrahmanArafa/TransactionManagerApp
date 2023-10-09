public class Deposit extends Transaction implements Rollback {
    public static double amount;

    Deposit(){}

    Deposit(double amount){
        this.amount=amount;
    }
    @Override
    double execute(Account account) {
        return account.balance += amount;
    }

    @Override
    public double cancelTransaction(Account account) {
        if (account.balance >= amount) {
            account.balance -= amount;
            return account.balance;
        } else {
            System.out.println("Insufficient balance for cancellation.");
            return account.balance;
        }
    }
}
