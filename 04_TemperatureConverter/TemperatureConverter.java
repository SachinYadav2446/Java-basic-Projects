import java.util.Scanner;
public class TemperatureConverter {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║   Temperature Converter Program      ║");
        System.out.println("╚═════════════════════════════════════╝\n");
        boolean continueProgram = true;
        while(continueProgram) {
            displayMenu();
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    celsiusToFahrenheit();
                    break;
                case 2:
                    fahrenheitToCelsius();
                    break;
                case 3:
                    celsiusToKelvin();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
                    continue;
            }
            System.out.print("\nDo you want to convert another temperature? (yes/no): ");
            String response = scanner.next().toLowerCase();
            continueProgram = response.equals("yes") || response.equals("y");
            System.out.println();
        }
        System.out.println("Thank you for using Temperature Converter!");
        scanner.close();
    }
    static void displayMenu() {
        System.out.println("--- Select Conversion Type ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
    }
    static void celsiusToFahrenheit() {
        System.out.print("\nEnter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = convertCelsiusToFahrenheit(celsius);
        System.out.println("Result: " + celsius + "°C = " + 
                          String.format("%.2f", fahrenheit) + "°F");
    }
    static void fahrenheitToCelsius() {
        System.out.print("\nEnter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = convertFahrenheitToCelsius(fahrenheit);
        System.out.println("Result: " + fahrenheit + "°F = " + 
                          String.format("%.2f", celsius) + "°C");
    }
    static void celsiusToKelvin() {
        System.out.print("\nEnter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double kelvin = convertCelsiusToKelvin(celsius);
        System.out.println("Result: " + celsius + "°C = " + 
                          String.format("%.2f", kelvin) + "K");
    }
    // Conversion methods
    static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    static double convertCelsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
}
