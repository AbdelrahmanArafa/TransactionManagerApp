import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;
        int dcount = 0;
        int wcount = 0;


        System.out.println("--- Welcome ---");
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Enter Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show current balance");
            System.out.println("5. Cancel last transaction");
            System.out.println("6. Exit");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Please Enter Your Account Number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Please Enter Your Owner Name: ");
                    String ownerName = scanner.next();
                    System.out.print("Please Enter Your Balance: ");
                    double balance = scanner.nextDouble();
                    System.out.println();
                    account = new Account(accountNumber, ownerName, balance);
                    break;
                case 2:
                    if (account == null) {
                        System.out.println("Sorry You Have not an Account Yet , Please press #1 and Enter Account Details First");
                        System.out.println();
                        break;
                    } else {
                        System.out.print("Enter The Deposit Amount: ");
                        double amount = scanner.nextDouble();
                        Deposit deposit = new Deposit(amount);
                        deposit.execute(account);
                        System.out.println("The Balance After Deposit = " + account.balance);
                        System.out.println();
                        dcount++;
                        break;
                    }
                case 3:
                    if (account == null) {
                        System.out.println("Sorry You Have not an Account Yet , Please press #1 and Enter Account Details First");
                        System.out.println();
                        break;
                    } else {
                        System.out.print("Enter The Withdraw Amount: ");
                         double amount = scanner.nextDouble();
                        Withdraw withdraw = new Withdraw(amount);
                        withdraw.execute(account);
                        System.out.println("The Balance After Withdraw = " + account.balance);
                        System.out.println();
                        wcount++;
                        break;
                    }
                case 4:
                    if (account == null) {
                        System.out.println("Sorry You Have not an Account Yet , Please press #1 and Enter Account Details First");
                        System.out.println();
                        break;
                    } else {
                        System.out.print("Enter currency type (U for USD, E for Euro , P for Pound): ");
                        String currencyType = scanner.next().toUpperCase();
                        BalanceInquiry balanceInquiry = new BalanceInquiry(currencyType);
                        balanceInquiry.execute(account);
                        System.out.println("Current balance: "  + account.balance + currencyType);
                        System.out.println();
                        break;
                    }
                case 5:
                    if (account == null) {
                        System.out.println("You Have not an Account Yet , Please press #1 and Enter Account Details First");
                        System.out.println();
                        break;
                    } else {
                        if (dcount == 0 && wcount == 0) {
                            System.out.println("There is no transaction to canceled");
                            System.out.println();
                            break;
                        }
                        else if (dcount > 0) {
                            Deposit deposit = new Deposit();
                            deposit.cancelTransaction(account);
                            System.out.println("The Transaction canceled Successfully");
                            System.out.println("The balance now = "+account.balance );
                            System.out.println();
                            dcount--;
                            break;
                        } else if (wcount > 0) {
                            Withdraw withdraw = new Withdraw();
                            withdraw.cancelTransaction(account);
                            System.out.println("The Transaction canceled Successfully");
                            System.out.println("The balance now = " + account.balance);
                            System.out.println();
                            wcount--;
                            break;
                        }
                    }
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    System.out.println();
            }
        }
    }
}
