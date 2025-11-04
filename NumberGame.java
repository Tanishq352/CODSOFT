import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int guess;

                // Input validation
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1) * 10; // score based on efficiency
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts. The number was: " + randomNumber);
            }

            System.out.println("\nYour total score: " + totalScore);

            // Ask user if they want to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame Over! Your final score: " + totalScore);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
