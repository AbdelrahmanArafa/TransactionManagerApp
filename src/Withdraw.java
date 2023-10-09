public class Withdraw extends Transaction implements Rollback{
    public static double amount ;

    Withdraw(){}
    Withdraw(double amount) {
        this.amount = amount;
    }
    @Override
    double execute(Account account) {
        if (account.balance >= amount) {
            account.balance -= amount;
            return account.balance;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            return account.balance;
        }
    }

    @Override
    public double cancelTransaction(Account account) {
        account.balance += amount;
        return account.balance;
    }
}
