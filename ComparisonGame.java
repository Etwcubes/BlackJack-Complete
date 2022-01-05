import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
public class ComparisonGame {
    public static void main(String[] args) {
        Hand player1 = new Hand();
        Hand player2 = new Hand();

        Deck mainDeck = new Deck();


        mainDeck.shuffle();

        //player 1 & 2 gets card from deck
        //compare the card values and print out a line saying who won and print out each players card suit & value
        //clear each players hands and restart game
        player1.addCard(mainDeck.dealCard());
        player1.addCard(mainDeck.dealCard());
        player1.addCard(mainDeck.dealCard());
        player1.addCard(mainDeck.dealCard());
        player1.addCard(mainDeck.dealCard());
        player2.addCard(mainDeck.dealCard());
        player2.addCard(mainDeck.dealCard());
        player2.addCard(mainDeck.dealCard());
        player2.addCard(mainDeck.dealCard());
        player2.addCard(mainDeck.dealCard());


//        for (int i = 0; i < 52; i+=2) {


//        }



        //////////////player 1 chooses their card
        System.out.print("Player 1 these are your cards, enter a number to choose your card(top card is number 1)" + "\r\n");
        for(int i = 0; i < player1.getCardCount(); i++){
            System.out.print(player1.getCard(i) + "\r\n");
        }
        Scanner p1Cardnumber = new Scanner(System.in);  // Create a Scanner object


        int p1cardnumberfr = p1Cardnumber.nextInt();  // Read user input
        p1cardnumberfr -= 1;
        /////////////////player 2 chooses their card
        System.out.print("Player 2 these are your cards, enter a number to choose your card(top card is number 1)" + "\r\n");
        for(int i = 0; i < player2.getCardCount(); i++){
            System.out.print(player2.getCard(i) + "\r\n");
        }
        Scanner p2Cardnumber = new Scanner(System.in);  // Create a Scanner object


        int p2cardnumberfr = p2Cardnumber.nextInt();  // Read user input
        p2cardnumberfr -= 1;

        Card word1 = player1.getCard(p1cardnumberfr);
        Card word2 = player2.getCard(p2cardnumberfr);
        int Value1 = word1.getSuit() + word1.getValue();
        int Value2 = word2.getSuit() + word2.getValue();

        ////////comparing the two pieces of shits together
        System.out.print("Today we are comparing " + word1 + "to " + word2 + "and it looks like....");

        if(Value1 > Value2){
            System.out.print("Player 1 is the winner!");
        } else{
            System.out.print("Player 2 is the winner!");
        } //print out which cards are being compared and also print out the players hands
    }
}
