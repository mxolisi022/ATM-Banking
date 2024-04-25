
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Option extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'R'###, ##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    int selection;


    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {

                data.put(1478465712, 1994);
                data.put(1478465724, 1993);

                System.out.println("Welcome to ATM");
                System.out.println("Enter your account number: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter your pin number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid input" + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
 
            System.out.println("\n" + "Incorrect customer Number or Pin number" + "\n");
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Press 1 - Checking Account");
        System.out.println("Press 2 - Saving Account");
        System.out.println("Press 3 - Exit");


        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thanks for your time, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Press 1 - view balance");
        System.out.println("Press 2 - withdraw Money");
        System.out.println("Press 3 - Deposit Money");
        System.out.println("Press 4 - Exit");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thanks for your time, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
        }
    }

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Press 1 - View Balance");
        System.out.println("Press 2 - Withdraw Money");
        System.out.println("Press 3 - Deposit Money");
        System.out.println("Press 4 - Exit");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thanks for your time, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getSaving();
        }
    }
}

