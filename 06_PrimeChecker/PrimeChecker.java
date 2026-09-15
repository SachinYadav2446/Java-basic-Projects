import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class PrimeChecker {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║   Prime Number Checker              ║");
        System.out.println("╚═════════════════════════════════════╝\n");
        boolean continueProgram = true;
        while(continueProgram) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    checkSinglePrime();
                    break;
                case 2:
                    checkPrimesInRange();
                    break;
                case 3:
                    findPrimeFactors();
                    break;
                case 4:
                    continueProgram = false;
                    System.out.println("\nThank you for using Prime Checker!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.\n");
            }
        }
        scanner.close();
    }
    static void displayMenu() {
        System.out.println("\n--- Prime Number Operations ---");
        System.out.println("1. Check if a number is prime");
        System.out.println("2. Find all primes in a range");
        System.out.println("3. Find prime factors");
        System.out.println("4. Exit");
    }
    static void checkSinglePrime() {
        System.out.print("\nEnter a number: ");
        int number = scanner.nextInt();
        if (isPrime(number)) {
            System.out.println(number + " is a PRIME number ✓");
        } else {
            System.out.println(number + " is NOT a prime number ✗");
        }
    }
    static void checkPrimesInRange() {
        System.out.print("\nEnter start of range: ");
        int start = scanner.nextInt();
        System.out.print("Enter end of range: ");
        int end = scanner.nextInt();
        if (start > end) {
            System.out.println("Start should be less than or equal to end!");
            return;
        }
        System.out.println("\nPrime numbers between " + start + " and " + end + ":");
        System.out.print("[ ");
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("]");
        System.out.println("Total primes found: " + count);
    }
    static void findPrimeFactors() {
        System.out.print("\nEnter a number: ");
        int number = scanner.nextInt();
        List<Integer> factors = getPrimeFactors(number);
        System.out.println("Prime factors of " + number + ": " + factors);
        // Calculate the product to verify
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        System.out.println("Verification: " + factors + " multiply to " + product);
    }
    static boolean isPrime(int number) {
        // Handle edge cases
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        // Check odd divisors up to sqrt(number)
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    static List<Integer> getPrimeFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        // Handle negative numbers
        if (number < 0) number = -number;
        if (number <= 1) return factors;
        // Divide by 2 while even
        while (number % 2 == 0) {
            factors.add(2);
            number = number / 2;
        }
        // Check odd factors
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                factors.add(i);
                number = number / i;
            }
        }
        // If number > 1, then it's a prime factor
        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }
}



