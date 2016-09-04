import java.util.Scanner;
import java.util.Random;
public class TestProject2 {
    public static void main(String[] args) {
        int playerCash = 100;
        while (playerCash > 0) {
            boolean playerBust = false;
            System.out.println("New Round!");
            System.out.println("You have " + playerCash + " dollars left.");
            System.out.println("How much do you want to bet?");
            Scanner bet = new Scanner(System.in);
            int firstBet = bet.nextInt();
            while (firstBet > playerCash) {
                System.out.println("You only have " + playerCash + " dollars left.");
                System.out.println("How much do you want to bet?");
                Scanner betAgain = new Scanner(System.in);
                firstBet = betAgain.nextInt();
            }
            playerCash = playerCash - firstBet;
            Random pCardOne = new Random();
            int range = 11 - 1;
            int pCardOneValue = pCardOne.nextInt(range)+1;
            Random dCardOne = new Random();
            int dCardOneValue = dCardOne.nextInt(range)+1;
            Random pCardTwo = new Random();
            int pCardTwoValue = pCardTwo.nextInt(range)+1;
            int pTotal = pCardOneValue + pCardTwoValue;
            Random dCardTwo = new Random();
            int dCardTwoValue = dCardTwo.nextInt(range)+1;
            int dTotal = dCardOneValue + dCardTwoValue;
            System.out.println("Your first card: " + pCardOneValue);
            System.out.println("Your second card: " + pCardTwoValue);
            System.out.println("Your total: " + pTotal);
            System.out.println("Dealer is showing: " + dCardOneValue);
            if ((pTotal)==21) {
                System.out.println("Blackjack!");
            }
            else {
                boolean isSafe = true;
                while (isSafe == true) {
                    System.out.println("Hit or Stay?");
                    Scanner scan = new Scanner(System.in);
                    String confirmCard = scan.nextLine();
                    
                    if (confirmCard.equals("Hit")) {
                        Random pNewCard = new Random();
                        int pNewCardValue = pNewCard.nextInt(range)+1;
                        pTotal = pNewCardValue + pTotal;
                        System.out.println("You got a " + pNewCardValue);
                        System.out.println("You have: " + pTotal);
                        if ((pTotal)>21) {
                            isSafe = false;
                            playerBust = true;
                        }
                        else if ((pTotal)==21) {
                            isSafe = false;
                        }
                        else {
                            
                        }
                    }
                    else {
                        isSafe = false;
                    }
                }
            }
            boolean dealerSafe = true;
            if (playerBust == false) {
                System.out.println("Dealer's second card: " + dCardTwoValue);
                System.out.println("Dealer's Total: " + dTotal);
                if (dTotal < 17) {
                    while (dealerSafe == true) {
                        Random dNewCard = new Random();
                        int dNewCardValue = dNewCard.nextInt(range)+1;
                        dTotal = dNewCardValue + dTotal;
                        System.out.println("Dealer got a " + dNewCardValue);
                        System.out.println("Dealer's Total: " + dTotal);
                        if (dTotal > 16) {
                            dealerSafe = false;
                        }
                        else {
                        }
                    }
                }
                else {
                }
            }
            else {
            }
            if (playerBust == true) {
                System.out.println("You busted!");
            }
            else if (dTotal>21) {
                System.out.println("Dealer busted, you win!");
                playerCash = (2*firstBet) + playerCash;
            }
            else if ((playerBust != true) && (pTotal > dTotal)) {
                System.out.println("You win!");
                playerCash = (2*firstBet) + playerCash;
            }
            else if ((playerBust != true) && (pTotal == dTotal)) {
                System.out.println("Push");
                playerCash = firstBet + playerCash;
            }
            else {
                System.out.println("You lost " + firstBet + " dollars.");
            }
        }
        System.out.println("You ran out of money. asldfkasd");
    }
}
