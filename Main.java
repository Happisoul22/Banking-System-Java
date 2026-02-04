import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while (true) {
            System.out.println("\n1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Transfer");
            System.out.println("5.Check Balance");
            System.out.println("6.Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();

                    bank.createAccount(accNo, name, bal);
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    int dAcc = sc.nextInt();
                    System.out.print("Amount: ");
                    double dAmt = sc.nextDouble();
                    bank.deposit(dAcc, dAmt);
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    int wAcc = sc.nextInt();
                    System.out.print("Amount: ");
                    double wAmt = sc.nextDouble();
                    bank.withdraw(wAcc, wAmt);
                    break;

                case 4:
                    System.out.print("From Account: ");
                    int from = sc.nextInt();
                    System.out.print("To Account: ");
                    int to = sc.nextInt();
                    System.out.print("Amount: ");
                    double tAmt = sc.nextDouble();
                    bank.transfer(from, to, tAmt);
                    break;

                case 5:
                    System.out.print("Account Number: ");
                    int cAcc = sc.nextInt();
                    bank.checkBalance(cAcc);
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
