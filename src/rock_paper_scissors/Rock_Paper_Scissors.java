package rock_paper_scissors;

import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissors {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int playerScore = 0;
        int compScore = 0;
        int draws = 0;
        
        boolean valid = true;
        boolean selecting = true;
        
        while (valid) {
            String[][] computerPick = new String[3][2];

            computerPick[0][1] = "Scissors";
            computerPick[1][1] = "Rock";
            computerPick[2][1] = "Paper";

            String[][] playerPick = new String[3][2];

            int playerGuess = 5;
            playerPick[0][1] = "Rock";
            playerPick[1][1] = "Paper";
            playerPick[2][1] = "Scissors";

            while (selecting) {
                try {
                    System.out.println("Print either:");
                    System.out.println("Rock, Paper or Scissors ");
                    String selected = input.next();
                    System.out.println();
                    
                    int bonuspoint = rand.nextInt(2);
                    int compRand = rand.nextInt(2);
                    
                    if (selected.equals(playerPick[0][1])) {

                        playerGuess = 0;
                    }
                    if (selected.equals(playerPick[1][1])) {

                        playerGuess = 1;
                    }
                    if (selected.equals(playerPick[2][1])) {

                        playerGuess = 2;
                    }

                    if (playerGuess == bonuspoint) {
                        if (playerGuess == compRand) {
                            System.out.println("You win a bonus point as you won with " + playerPick[playerGuess][1]
                                    + "! The computer chose " + computerPick[compRand][1]);
                            playerScore = playerScore + 2;
                        }

                        if ((playerGuess == compRand + 1) || (playerGuess == compRand - 2)) {
                            System.out.println("Draw! Both players chose " + playerPick[playerGuess][1]);
                            draws++;
                        }

                        if ((playerGuess == compRand - 1) || (playerGuess == compRand + 2)) {
                            System.out.println("Computer wins a bonus point as it won with " + computerPick[compRand][1] + "!");
                            compScore = compScore + 2;
                        }
                    }

                    if (playerGuess != bonuspoint) {
                        if (playerGuess == compRand) {
                            System.out.println("You win! The computer chose " + computerPick[compRand][1]);
                            playerScore = playerScore + 1;
                        }

                        if ((playerGuess == compRand + 1) || (playerGuess == compRand - 2)) {
                            System.out.println("Draw! Both players chose " + playerPick[playerGuess][1]);
                            draws++;
                        }

                        if ((playerGuess == compRand - 1) || (playerGuess == compRand + 2)) {
                            System.out.println("Computer wins! It chose " + computerPick[compRand][1]);
                            compScore = compScore + 1;

                        }

                    }
                    System.out.println("Player's points: " + playerScore);
                    System.out.println("Computers's points: " + compScore);
                    System.out.println("Draws: " + draws);
                    System.out.println();
                    
                } catch (Exception error) {
                    System.out.println(error);
                    input.next();
                }

            }

        }

    }
}
