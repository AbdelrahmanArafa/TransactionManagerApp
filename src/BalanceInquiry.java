public class BalanceInquiry extends Transaction{
    String currencyType ;
    BalanceInquiry(String currencyType){
        this.currencyType=currencyType;
    }
    @Override
    double execute(Account account) {
        if (currencyType.equals("U")) {
            return account.balance*=33.30 ;
        } else if (currencyType.equals("E")) {
            return account.balance*=30.91 ;
        } else if (currencyType.equals("P")) {
            return account.balance;
        }
        else {
            System.out.println("Invalid currency type.");
            return account.balance;
        }
    }
}
