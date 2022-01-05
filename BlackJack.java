import java.util.Scanner;
public class BlackJack {
    public static void main(String[] args) {
        Hand dealer = new Hand();
        Hand player1 = new Hand();
        Hand player2 = new Hand();
        int player1score = 0;
        int player2score = 0;
        int dealerscore = 0;
        int roundrevolution = 0;

        boolean gameend = false;

        Deck mainDeck = new Deck();
        int dealerindex = 0;
        int player1index = 0;
        int player2index = 0;


        mainDeck.shuffle();
        /////// actual game
        dealer.addCard(mainDeck.dealCard());
        System.out.print("Dealer here is your card " + dealer.getCard(dealerindex) + "\r\n");
        dealerindex++;
        dealer.addCard(mainDeck.dealCard());
        System.out.print("Dealer here is your secret card" + "\r\n");

        player1.addCard(mainDeck.dealCard());
        System.out.print("Player 1 here is your card " + player1.getCard(player1index) + "\r\n");
        player1index++;
        player1.addCard(mainDeck.dealCard());
        System.out.print("Player 1 here is your card " + player1.getCard(player1index) + "\r\n");


        player2.addCard(mainDeck.dealCard());
        System.out.print("Player 2 here is your card " + player2.getCard(player2index) + "\r\n");
        player2index++;
        player2.addCard(mainDeck.dealCard());
        System.out.print("Player 2 here is your card " + player2.getCard(player2index) + "\r\n");


        //Main Game

        while (gameend == false) {


            ///player 1 turn
            System.out.print("Player 1 would you like to hit or stand. Press 1 for hit, press 2 for stand");
            Scanner number = new Scanner(System.in);
            int cc = number.nextInt();


            switch (cc) {
                case 1: {
                    while (cc == 1) {
                        player1.addCard(mainDeck.dealCard());
                        player1index++;
                        System.out.print("Player 1 has drawn a " + player1.getCard(player1index));
                        for (int i = 0; i < player1.getCardCount(); i++) {
                            if (player1.getCard(i).getValue() > 10) {
                                player1score += 10;
                            } else {
                                player1score += player1.getCard(i).getValue();
                            }
                        }
                        System.out.println(player1score);

                        if (player1score > 21) {
                            System.out.print("Player 1 you have busted!" + "\r\n");
                            System.exit(0);
                        }

                        if (player1score == 21) {
                            System.out.print("Player 1 has won the game!" + "\r\n");
                            System.exit(0);
                        }
                    System.out.print("Your current score is " + player1score + ". Press 1 to hit again or 2 to stand");
                    Scanner nnumber = new Scanner(System.in);
                    cc = nnumber.nextInt();
                    if(cc == 1){
                        player1score=0;
                    }

                    }
                }
                case 2: {
                    System.out.print("Player 1 has decided to stand!" + "\r\n");
                    break;
                }
            }

            //end of player1 turn

            //start of player 2 turn
            System.out.print("Player 2 would you like to hit or stand. Press 1 for hit, press 2 for stand");
            Scanner number2 = new Scanner(System.in);
            int cc2 = number2.nextInt();


            switch (cc2) {
                case 1: {
                    while (cc2 == 1) {
                        player2.addCard(mainDeck.dealCard());
                        player2index++;
                        System.out.print("Player 2 has drawn a " + player2.getCard(player2index));
                        for (int i = 0; i < player2.getCardCount(); i++) {
                            if (player2.getCard(i).getValue() > 10) {
                                player2score += 10;
                            } else {
                                player2score += player2.getCard(i).getValue();
                            }
                        }
                        System.out.println(player2score);

                        if (player2score > 21) {
                            System.out.print("Player 2 you have busted!" + "\r\n");
                            System.exit(0);
                        }

                        if (player2score == 21) {
                            System.out.print("Player 2 has won the game!" + "\r\n");
                            System.exit(0);
                        }
                        System.out.print("Your current score is " + player2score + ". Press 1 to hit again or 2 to stand");
                        Scanner nnumber2 = new Scanner(System.in);
                        cc2 = nnumber2.nextInt();
                        if(cc2 == 1){
                            player2score=0;
                        }

                    }
                }
                case 2: {
                    System.out.print("Player 2 has decided to stand!" + "\r\n");
                    break;
                }
            }
            roundrevolution++;

            // end of player 2 turn



                ///dealer turn


                if (roundrevolution == 1) {
                    System.out.print("Dealer secret card is " + dealer.getCard(dealerindex) + "\r\n");
                }
                for (int i = 0; i < dealer.getCardCount(); i++) {
                    if (dealer.getCard(i).getValue() > 10) {
                        dealerscore += 10;
                    } else {
                        dealerscore += dealer.getCard(i).getValue();
                    }
                }

                if (roundrevolution == 1) {

                    if (dealerscore < 17) {
                        System.out.print("Dealer's hand under 16 so you must draw!" + "\r\n");

                        while (dealerscore < 17){
                            dealer.addCard(mainDeck.dealCard());
                            dealerindex++;
                            System.out.print("Dealer your new card is " + dealer.getCard(dealerindex) + "\r\n");
                            dealerscore = 0;
                            for (int i = 0; i < dealer.getCardCount(); i++) {
                                if (dealer.getCard(i).getValue() > 10) {
                                    dealerscore += 10;
                                }
                                if (dealerscore > 21){
                                    System.out.print("Dealer has busted!");
                                    System.exit(0);
                                }
                                else {
                                    dealerscore += dealer.getCard(i).getValue();
                                }
                            }
                            if (dealerscore > 21) {
                                System.out.print("Dealer you have busted so you gave twice your bet to everyone!" + "\r\n");
                                gameend = true;
                                System.exit(0);
                            }

                        }
                        if (player1score > dealerscore){
                            gameend = true;
                            System.out.print("Player 1 has won twice the dealer's bet!" + "\r\n");
                        }
                        if (player2score > dealerscore){
                            gameend = true;
                            System.out.print("Player 2 has won twice the dealer's bet!" + "\r\n");
                        }
                        if (player1score == dealerscore){
                            gameend = true;
                            System.out.print("Player 1 has tied with the dealer!" + "\r\n");
                        }
                        if (player2score == dealerscore){
                            gameend = true;
                            System.out.print("Player 2 has tied with the dealer!" + "\r\n");
                        }
                        if (dealerscore > 21) {
                            System.out.print("Dealer you have busted so you gave twice your bet to everyone!" + "\r\n");
                            gameend = true;
                            System.exit(0);
                        }

                    }


                    if (dealerscore >= 17) {
                        System.out.print("Dealer's hand is " + dealerscore + " so you must stand!" + "\r\n");
                        if (player1score > dealerscore){
                            gameend = true;
                            System.out.print("Player 1 has won twice the dealer's bet!" + "\r\n");
                        }
                        if (player2score > dealerscore){
                            gameend = true;
                            System.out.print("Player 2 has won twice the dealer's bet!" + "\r\n");
                        }
                        if (player1score == dealerscore){
                            gameend = true;
                            System.out.print("Player 1 has tied with the dealer!" + "\r\n");
                        }
                        if (player2score == dealerscore){
                            gameend = true;
                            System.out.print("Player 2 has tied with the dealer!" + "\r\n");
                        }
                        if (dealerscore > player1score){
                            gameend = true;
                            System.out.print("Dealer has won the game!");
                        }
                        if (dealerscore > player2score){
                            gameend = true;
                            System.out.print("Dealer has won the game!");
                        }
                    }

                    if (gameend == true) {
                        System.exit(0);
                    }


                }



        }
    }
}

