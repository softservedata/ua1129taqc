package com.softeserve.hw;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0;
        int computerScore = 0;

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Let's play Rock, Paper, Scissors!");
            System.out.print("Enter your choice (rock, paper, or scissors), or 'quit' to end the game: ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("quit")) {
                playAgain = false;
                continue;
            }

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', or 'scissors'.");
                continue;
            }

            int computerChoiceIndex = random.nextInt(3); // 0 for rock, 1 for paper, 2 for scissors
            String[] choices = {"rock", "paper", "scissors"};
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer chooses: " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("Computer wins!");
                computerScore++;
            }

            System.out.println("Your score: " + userScore);
            System.out.println("Computer's score: " + computerScore);
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
