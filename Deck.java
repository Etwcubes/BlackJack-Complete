import java.util.Random;
public class Deck {

    //total number of 52 cards, NO JOKERS
    private Card[] deck;
    private int cardsUsed;



    //deck[0].toString() ---> String form
    //deck[0] ----> Card

    //deck[0] = New Card(sth,sth)
    //deck[1] - new Card(sth,sth)................

    //constructor
    //TODO: create 52 cards by using 2 for loops and filling the Card[] deck out
    public Deck(){
        cardsUsed = 0;
        deck = new Card[52];
        int card_count = 0;
        for (int x = 1; x < 14; x++){
            for (int i = 0; i < 4; i++){
                deck[card_count] = new Card(x, i);
                card_count++;
            }
        }
    }

    //shuffle the Card[] deck randomly
    //TODO: go home brainstorm ideas on how to do this

    //myqueen.shuffle()
    //for(){sout(myqueen[i])}
    public void shuffle (){
        int min = 1;
        int max = 51;
        int range = max - min + 1;
        int randomIndex = (int)(Math.random() * range) + min;
        for (int i = 0; i < deck.length; i++){
            Card swap = deck[randomIndex];
            deck[randomIndex] = deck[i];
            deck[i] = swap;
            randomIndex = (int)(Math.random() * range) + min;
        }
    }

    //tells the user how many cards left in the deck
    //TODO" total number of cards - cardsUsed
    public int cardsLeft(){
        return cardsUsed;
    }

    //returns a card ready to give to user
    //TODO: removes the next card from the deck and returns it.
    public Card dealCard(){
        if(cardsUsed == deck.length){
            throw new IllegalStateException("no more cards left in the deck");
        }
        cardsUsed++;

        return deck[cardsUsed - 1]; //index 0->51
    }

    public static void main(String[] args) {
        Deck myQueen = new Deck();
        int ccount = 52;

        for(int i = 0; i<ccount;i++){

        }

// testing the code
//        myQueen.shuffle();
//        for(int i = 0; i < myQueen.deck.length; i++){
//            System.out.println(myQueen.deck[i].toString());
//        }

        //myQueen.shuffle()

//        for(int i = 0; i<ccount;i++){
//            System.out.println(myQueen.deck[i]);
//            //myQueen.deck[i].toString();
//        }

    }
}
