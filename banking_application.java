import java.util.Scanner;

public class banking_application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to Simple Banking Application");
            System.out.println("1. Deposit (or 'd')");
            System.out.println("2. Withdraw (or 'w')");
            System.out.println("3. Check Balance (or 'c')");
            System.out.println("4. Exit (or 'e')");
            System.out.print("Please choose an option: ");
            
            String choice = scanner.next().toLowerCase();

            switch (choice) {
                case "1":
                case "d":
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("Successfully deposited $" + depositAmount);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case "2":
                case "w":
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("Successfully withdrew $" + withdrawAmount);
                    } else {
                        System.out.println("Invalid withdrawal amount or insufficient funds.");
                    }
                    break;
                case "3":
                case "c":
                    System.out.println("Your current balance is: $" + balance);
                    break;
                case "4":
                case "e":
                    exit = true;
                    System.out.println("Thank you for using . Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
