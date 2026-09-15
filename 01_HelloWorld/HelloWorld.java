import java.util.Scanner;
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("=== Welcome to Java! ===");
        System.out.println();
        int age = 25;
        double height = 5.9;
        String name = "Yadav";
        boolean isStudent = true;
        System.out.println("--- Data Types Demonstration ---");
        System.out.println("Name: " + name + " (String)");
        System.out.println("Age: " + age + " (int)");
        System.out.println("Height: " + height + " feet (double)");
        System.out.println("Is Student: " + isStudent + " (boolean)");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Interactive Input ---");
        System.out.print("Enter your name: ");
        String userInput = scanner.nextLine();
        System.out.print("Enter your age: ");
        int userAge = scanner.nextInt();
        System.out.print("Enter your height (in feet): ");
        double userHeight = scanner.nextDouble();
        System.out.println();
        System.out.println("--- Your Information ---");
        System.out.println("Hello, " + userInput + "!");
        System.out.println("You are " + userAge + " years old");
        System.out.println("Your height is " + userHeight + " feet");
        int ageInDays = userAge * 365;
        System.out.println("You've lived approximately " + ageInDays + " days");
        int ageAsInt = (int) userHeight;
        System.out.println("Height (as integer): " + ageAsInt + " feet");
        scanner.close();
    }
}
