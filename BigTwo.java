import java.util.Scanner;

public class BigTwo {
    public static void main(String[] args) {
        //test hands
        Hand player1 = new Hand();
        Hand player2 = new Hand();
        Card mycard = new Card(4,1);
        Card mycard1 = new Card(5,1);
        Card mycard2 = new Card(4,2);
        Card mycard3 = new Card(9,3);
        //add some test hands

        player1.addCard(mycard);
        player1.addCard(mycard1);
        player1.addCard(mycard2);
        player1.addCard(mycard3);

        player2.addCard(mycard);
        player2.addCard(mycard1);
        player2.addCard(mycard2);
        player2.addCard(mycard3);

        boolean gameend = false;
        int p1cardvalue = 0;
        int p2cardvalue = 0;

        Deck mainDeck = new Deck();

        mainDeck.shuffle();

        //player 1 & 2 gets card from deck
        //compare the card values and print out a line saying who won and print out each players card suit & value
        //clear each players hands and restart game

        for (int i = 0; i < 13; i++) {
            player1.addCard(mainDeck.dealCard());
        }
        for (int i = 0; i < 13; i++) {
            player2.addCard(mainDeck.dealCard());
        }

        player1.sortByValue();
        player2.sortByValue();



        //////// actual game player 1 turn
        while (gameend == false) {

            if (player1.getCardCount() == 0) {
                gameend = true;
                System.out.print("Player 1 has won the game!!");
            }
            if (player2.getCardCount() == 0) {
                gameend = true;
                System.out.print("Player 2 has won the game!!");
            }
            if (gameend == true){
                System.exit(0);
            }



            System.out.print("Player 1 these are your cards" + "\r\n");
            int x = 1;
            for (int i = 0; i < player1.getCardCount(); i++) {
                String index = x + ".";
                System.out.print(index + player1.getCard(i) + "\r\n");
                x++;
            }

            System.out.print("Player 1 how many cards would you like to use today? Type a number from 1 - 4. Type 5 if you want to skip" + "\r\n");

            Scanner number = new Scanner(System.in);
            int cc = number.nextInt();



            switch (cc) {
                case 1: {
                    System.out.print("Type the card you want to use");
                    int oneCard = number.nextInt();
                    oneCard--;
                    p1cardvalue = player1.getCard(oneCard).getValue();
                    if (p1cardvalue > p2cardvalue) {
                        System.out.print("Player 1 used the card " + player1.getCard(oneCard) + "\r\n");
                        player1.removeCard(oneCard);
                    }

                    break;
                }
                case 2: {
                    System.out.print("Type the cards you want to use");
                    int firstCard = number.nextInt();
                    int secondCard = number.nextInt();
                    firstCard--;
                    secondCard--;
                    p1cardvalue = player1.getCard(firstCard).getValue();
                    if (p1cardvalue > p2cardvalue) {
                        System.out.print("Player 1 used the card " + player1.getCard(firstCard) + "& " + player1.getCard(secondCard) + "\r\n");
                        player1.removeCard(secondCard);
                        player1.removeCard(firstCard);
                    }
                    break;
                }
                case 4: {
                    System.out.print("Type the cards you want to use");
                    int firstCard = number.nextInt();
                    int secondCard = number.nextInt();
                    int thirdcard = number.nextInt();
                    int fourthcard = number.nextInt();
                    firstCard--;
                    secondCard--;
                    thirdcard--;
                    fourthcard--;
                    p1cardvalue = player1.getCard(firstCard).getValue();
                    if (p1cardvalue > p2cardvalue) {
                        System.out.print("Player 1 used the cards " + player1.getCard(firstCard) + "& " + player1.getCard(secondCard) + "&" + player1.getCard(thirdcard) + "&" + player1.getCard(fourthcard));
                        player1.removeCard(firstCard);
                        player1.removeCard(secondCard);
                    }
                    break;
                }
                case 5:
                {
                    int player1biggestcard1 = 0;
                    for (int i = 0; i < player1.getCardCount(); i++){
                        if (player1.getCard(i).getValue() > player1biggestcard1){
                            player1biggestcard1 = player1.getCard(i).getValue();
                        }
                    }

                    if (player1biggestcard1 <= p2cardvalue) {
                        System.out.print("Player 2 has won the round!" + "\r\n");
                        p1cardvalue = 0;
                        p2cardvalue = 0;
                        break;
                    }else{
                        System.out.print("Player 1 has won the round!" + "\r\n");
                        p1cardvalue = 0;
                        p2cardvalue = 0;
                    }
                }
            }

            if (player1.getCardCount() == 0) {
                gameend = true;
                System.out.print("Player 1 has won the game!!");
            }
            if (player2.getCardCount() == 0) {
                gameend = true;
                System.out.print("Player 2 has won the game!!");
            }
            if (gameend == true){
                System.exit(0);
            }
////player 1 turn ends


            /////// player 2's turn
            if (player1.getCardCount() == 0) {
                gameend = true;
                System.out.print("Player 1 has won the game!!");
            }
            if (player2.getCardCount() == 0) {
                gameend = true;
                System.out.print("Player 2 has won the game!!");
            }
            if (gameend == true){
                System.exit(0);
            }



            System.out.print("Player 2 these are your cards" + "\r\n");
            int y = 1;
            for (int i = 0; i < player2.getCardCount(); i++) {
                String index = y + ".";
                System.out.print(index + player2.getCard(i) + "\r\n");
                y++;
            }

            System.out.print("Player 2 how many cards would you like to use today? Type a number from 1 - 4. Type 5 if you want to skip" + "\r\n");

            Scanner otherNumber = new Scanner(System.in);
            int cc2 = otherNumber.nextInt();



            switch (cc2) {
                case 1: {
                    System.out.print("Type the card you want to use");
                    int twoCard = number.nextInt();
                    twoCard--;
                    p2cardvalue = player2.getCard(twoCard).getValue();
                    if (p2cardvalue > p1cardvalue) {
                        System.out.print("Player 2 used the card " + player2.getCard(twoCard) + "\r\n");
                        player2.removeCard(twoCard);
                    }break;

                }
                case 2: {
                    System.out.print("Type the cards you want to use");
                    int firstCard = number.nextInt();
                    int secondCard = number.nextInt();
                    firstCard--;
                    secondCard--;
                    p2cardvalue = player2.getCard(firstCard).getValue();
                    ;
                    if (p2cardvalue > p1cardvalue) {
                        System.out.print("Player 2 used the card " + player2.getCard(firstCard) + "& " + player2.getCard(secondCard) + "\r\n");
                        player2.removeCard(secondCard);
                        player2.removeCard(firstCard);
                    }
                    break;
                }
                case 4: {
                    System.out.print("Type the cards you want to use");
                    int firstCard = number.nextInt();
                    int secondCard = number.nextInt();
                    int thirdcard = number.nextInt();
                    int fourthcard = number.nextInt();
                    firstCard--;
                    secondCard--;
                    thirdcard--;
                    fourthcard--;
                    p1cardvalue = player1.getCard(firstCard).getValue();
                    if (p1cardvalue > p2cardvalue) {
                        System.out.print("Player 2 used the cards " + player2.getCard(firstCard) + "& " + player2.getCard(secondCard) + "&" + player2.getCard(thirdcard) + "&" + player2.getCard(fourthcard));
                        player1.removeCard(firstCard);
                        player1.removeCard(secondCard);
                    }
                    break;
                }
                case 5:
                {
                    int player2biggestcard2 = 0;
                    for(int i = 0; i < player2.getCardCount(); i++){
                        if (player2.getCard(i).getValue() > player2biggestcard2){
                            player2biggestcard2 = player2.getCard(i).getValue();
                        }
                    }

                    if (player2biggestcard2 <= p1cardvalue) {
                        System.out.print("Player 1 has won the round!" + "\r\n");
                        p1cardvalue = 0;
                        p2cardvalue = 0;
                        break;
                    }else{
                        System.out.print("Player 2 has won the round!" + "\r\n");
                        p1cardvalue = 0;
                        p2cardvalue = 0;
                    }
                }
            }

            if (player1.getCardCount() == 0) {
                gameend = true;
                System.out.print("Player 1 has won the game!!");
            }
            if (player2.getCardCount() == 0) {
                gameend = true;
                System.out.print("Player 2 has won the game!!");
            }
            if (gameend == true){
                System.exit(0);
            }


////end of player 2's turn
        }

    }
}



