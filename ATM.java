import java.util.Scanner;

public class ATM {
  private String accountNumber;
  private String accountHolder;
  private int balance;
  private String password;

  public ATM(String accountNumber, String accountHolder, int balance, String password) {
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.balance = balance;
    this.password = password;
  }

  public void displayMenu() {
    System.out.println("Welcome to the ATM!");
    System.out.println("1. Check Balance");
    System.out.println("2. Withdraw Cash");
    System.out.println("3. Deposit Cash");
    System.out.println("4. Change Password");
    System.out.println("5. Exit");
  }

  public void checkBalance() {
    System.out.println("Your current balance is: $" + balance);
  }

  public void withdrawCash(Scanner scanner) {
    System.out.print("Enter the amount to withdraw: $");
    int amount = scanner.nextInt();

    if (amount > balance) {
      System.out.println("Insufficient funds. Please try again.");
    } else {
      balance -= amount;
      System.out.println("Withdrawal successful. Your new balance is: $" + balance);
    }
  }

  public void depositCash(Scanner scanner) {
    System.out.print("Enter the amount to deposit: $");
    int amount = scanner.nextInt();

    balance += amount;
    System.out.println("Deposit successful. Your new balance is: $" + balance);
  }

  public void changePassword(Scanner scanner) {
    System.out.print("Enter your current password: ");
    String currentPassword = scanner.next();

    if (currentPassword.equals(password)) {
      System.out.print("Enter your new password: ");
      String newPassword = scanner.next();

      password = newPassword;
      System.out.println("Password changed successfully.");
    } else {
      System.out.println("Invalid password. Please try again.");
    }
  }

  public boolean authenticate(Scanner scanner) {
    System.out.print("Enter your password: ");
    String inputPassword = scanner.next();

    return inputPassword.equals(password);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your account number: ");
    String accountNumber = scanner.next();

    System.out.print("Enter your name: ");
    String accountHolder = scanner.next();

    System.out.print("Enter your initial balance: $");
    int balance = scanner.nextInt();

    System.out.print("Enter your password: ");
    String password = scanner.next();

    ATM atm = new ATM(accountNumber, accountHolder, balance, password);

    while (true) {
      if (atm.authenticate(scanner)) {
        atm.displayMenu();

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
          case 1:
            atm.checkBalance();
            break;
          case 2:
            atm.withdrawCash(scanner);
            break;
          case 3:
            atm.depositCash(scanner);
            break;
          case 4:
            atm.changePassword(scanner);
            break;
          case 5:
            System.out.println("Thank you for using the ATM. Goodbye!");
            return;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } else {
        System.out.println("Invalid password. Please try again.");
      }
    }
  }
}