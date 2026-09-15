import java.util.Scanner;
public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("=== Simple Calculator ===\n");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        displayMenu();
        System.out.print("\nEnter your choice (1-5): ");
        int choice = scanner.nextInt();
        performOperation(num1, num2, choice);
    }
    static void displayMenu() {
        System.out.println("\n--- Choose an operation ---");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Modulus (%)");
    }
    static void performOperation(double num1, double num2, int choice) {
        double result;
        switch(choice) {
            case 1:
                result = num1 + num2;
                System.out.println("\nResult: " + num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("\nResult: " + num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("\nResult: " + num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("\nError: Cannot divide by zero!");
                } else {
                    result = num1 / num2;
                    System.out.println("\nResult: " + num1 + " / " + num2 + " = " + result);
                }
                break;
            case 5:
                if (num2 == 0) {
                    System.out.println("\nError: Cannot perform modulus with zero!");
                } else {
                    result = num1 % num2;
                    System.out.println("\nResult: " + num1 + " % " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("\nError: Invalid choice! Please enter 1-5.");
        }
    }
}
