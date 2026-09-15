import java.util.Scanner;
public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   Welcome to Number Guessing Game   ║");
        System.out.println("╚════════════════════════════════════╝\n");
        while(playAgain) {
            playGame(scanner);
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }
        System.out.println("\nThanks for playing! Goodbye!");
        scanner.close();
    }
    static void playGame(Scanner scanner) {
        int randomNumber = (int)(Math.random() * 100) + 1;
        int guess = 0;
        int attempts = 0;
        int maxAttempts = 10;
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it!\n");
        while(attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }
            guess = scanner.nextInt();
            attempts++;
            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a number between 1 and 100!");
                continue;
            }
            if (guess == randomNumber) {
                System.out.println("\n🎉 Congratulations! You guessed it right!");
                System.out.println("The number was: " + randomNumber);
                System.out.println("You got it in " + attempts + " attempts!");
                int score = 100 - (attempts * 10);
                System.out.println("Your score: " + Math.max(score, 0) + "/100");
                break;
            } 
            else if (guess < randomNumber) {
                System.out.println("❌ Too low! Try a higher number.");
            } 
            else {
                System.out.println("❌ Too high! Try a lower number.");
            }
            int remainingAttempts = maxAttempts - attempts;
            if (remainingAttempts > 0) {
                System.out.println("Remaining attempts: " + remainingAttempts + "\n");
            }
        }
        if (guess != randomNumber) {
            System.out.println("\n😢 Game Over! You've used all " + maxAttempts + " attempts.");
            System.out.println("The correct number was: " + randomNumber);
        }
    }
}
