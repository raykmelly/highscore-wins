package com.pluralsight;
import java.util.Scanner;

public class HighscoreWins {
    public static void main(String[] args) {
        // Create scanner
        Scanner scanner = new Scanner(System.in);

        // Get user input and prompt
        System.out.println("Input a game score like this: (Home:Visitor|21:9): ");
        String gameScore = scanner.nextLine();

        // Display the winner
        String winner = getWinner(gameScore);
        if (winner.equalsIgnoreCase("Tie")) {
            // The game was a tie
            System.out.println("The game was a tie!");
        } else {
            // There was a winning team
            System.out.printf("The winner is %s!",winner);
        }

        // Close the scanner
        scanner.close();
    }

    public static String getWinner(String gameScore) {
        // Split the string into important bits
        String[] gameInfo1 = gameScore.split("\\|");
        String[] teamNames = gameInfo1[0].split(":");
        String[] finalScores = gameInfo1[1].split(":");

        // Get the score information
        int homeScore = Integer.parseInt(finalScores[0]);
        int visitorScore = Integer.parseInt(finalScores[1]);

        // Return the winner of the game, or tie if the game is a draw
        if (homeScore > visitorScore) {
            return teamNames[0];
        } else if (homeScore < visitorScore) {
            return teamNames[1];
        } else {
            return "Tie";
        }
    }
}