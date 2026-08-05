import java.util.*;

 class BankAccount{

    private double balance;
    int accountNumber;
    String accountHolderName;
    BankAccount(double balance, int accountNumber, String accountHolderName){
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
public class Encapsulation{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.println("Enter account holder name: ");
        String accountHolderName = sc.nextLine();
        System.out.println("Enter account balance: ");
        double balance = sc.nextDouble();
        BankAccount bankAccount = new BankAccount(balance, accountNumber, accountHolderName);
        System.out.println("Account number: " + bankAccount.accountNumber);
        System.out.println("Account holder name: " + bankAccount.accountHolderName);
        System.out.println("Account balance: " + bankAccount.getBalance());
    }
}