import java.util.*;
class player{ //this class will hold the player data like player wins,ties and playerHand amount
    int playerWins,ties,playerHands;

    public int getPlayerWins() {
        return playerWins;
    }

    public int getTies() {
        return ties;
    }

    public int getPlayerHands() {
        return playerHands;
    }
    
}
class game{ //this class wil hold the game data like total games, games won by player and dealer and total ties.
    int gameCount=0,playerWins=0,dealerWins=0,ties=0; 
    boolean firstHand = true; //this values signifies the firstHand. 
    public int getGameCount() {
        return gameCount;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getDealerWins() {
        return dealerWins;
    }

    public int getTies() {
        return ties;
    }
    
}
public class BlackJava { //this is the main class which consists of the main game functions
    public static void dealHand(player p,game g){ //This function will deal a hand to the player
        P1Random rand = new P1Random();
        int card = rand.nextInt(13) + 1; //generating a random card from the deck using the fiven random number class
        System.out.println();
        if(2<=card && card<=10 ){ //if card is any number card
            System.out.println("Your Card is " + card + "!");
            p.playerHands += card; //adding value to the playerHand
        }
        else if(card == 11){ //Jack card
            System.out.println("Your card is Jack!");
//            System.out.println("Card Value: " + 10 + "\n...");
            p.playerHands += 10;
        }
        else if(card == 12){ //Queen card
            System.out.println("Your card is Queen!");
//            System.out.println("Card Value: " + 10 + "\n...");
            p.playerHands += 10;
        }
        else if(card == 13){ //King card
            System.out.println("Your card is king!");
            System.out.println("Card Value: " + 10 + "\n...");
            p.playerHands += 10;
        }
        else if(card == 1){ //card is Ace
            System.out.println("Your Card is Ace!");
//            System.out.println("Card Value: " + 1 + "\n...");
            p.playerHands += card;
        }
        System.out.println("Your hand is " + p.playerHands);
        if(p.playerHands == 21){ //if player hand is equal to 21,
            System.out.println("Black Jack!,You Win!");
            g.playerWins += 1; //incrementing in playerWins
            g.firstHand = !g.firstHand; //reversing the firstHand variable back to True to begin the game again from start
            g.gameCount += 1; //incrementing in number of games
        }
        else if(p.playerHands > 21){ //if player hand exceed 21
            System.out.println("You Lose!");
            g.dealerWins += 1; //Incrementing in dealer wins
            g.gameCount += 1; //incrementing in game count
            g.firstHand = !g.firstHand; //reversing the firstHand variable back to True to begin the game again from start
        }
        System.out.println();
    }
    public static void dealHandToDealer(player dealer,player p2,game g){
        P1Random rand = new P1Random();
        int card = rand.nextInt(11) + 16; //generating a random hand for the dealer
        dealer.playerHands += card; //putting hand value in dealer hand
        System.out.println("\nDealer's hand: " + dealer.playerHands);
        System.out.println("Your hand is: " + p2.playerHands + "\n");
        if(dealer.playerHands == 21){ //if dealer scores a Black Jack
            System.out.println("Black Jack!,Dealer Won!");
            g.dealerWins += 1; //incrementing in dealer wins
            g.firstHand = !g.firstHand; //reversing the firstHand variable back to True to begin the game again from start
            g.gameCount += 1;//incrementing in number of games
        }
        else if(dealer.playerHands > 21){ //if dealer exceed 21
            System.out.println("You Win!");
            g.playerWins += 1; //incrementing in player wins
            g.firstHand = !g.firstHand; //reversing the firstHand variable back to True to begin the game again from start
            g.gameCount += 1; //incrementing in total game count
        }
        else if(dealer.playerHands > p2.playerHands){ //if dealer has better hand than the player
            System.out.println("You Lose!");
            g.dealerWins += 1; //incrementing in dealer wins
            g.gameCount += 1; //incrementing in gaceCount
            g.firstHand = !g.firstHand; //reversing the firstHand variable back to True to begin the game again from start
        }
        else if(dealer.playerHands < p2.playerHands){ //if player has a better hand thsn the dealer
            System.out.println("You Win!"); 
            g.playerWins += 1;//incrementing in playerWins
            g.gameCount += 1; //inrementing in gameCount
            g.firstHand = !g.firstHand; //reversing the firstHand variable back to True to begin the game again from start
        }
        else if(dealer.playerHands == p2.playerHands){ //if both dealer and player has equal hands
            System.out.println("Its a tie. No one Wins!"); 
            g.ties += 1; //incrementing in tie count
            g.gameCount += 1; //incrementing in total games count
            g.firstHand = !g.firstHand; //reversing the firstHand variable back to True to begin the game again from start
        }
        System.out.println();
    }
    
    //this is the main function which drives the actual program
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Initializing Scanner to take user input
        player p = new player(); //making instance of player
        player dealer = new player(); //making instance of dealer
        game g = new game(); //making instance of the game
        while(true){ //this is the infinite while loop
            if(g.firstHand){ //checking if this is first hand or not
                //if this is first hand, then the player and dealer hand should be zero
                p.playerHands = 0;
                dealer.playerHands = 0; 
                System.out.println("\nStart Game #"+ (g.gameCount+1) + "\n");
                BlackJava.dealHand(p,g);
                g.firstHand = !g.firstHand; //putting firstHand to false
            }
            System.out.println("1. Get Another Card\n2. Hold Hand\n3. Print Statistics\n4. Exit"); //showing the main menu
            System.out.println("Choose an option: ");
            int choice = input.nextInt();
            if(choice == 1){
                BlackJava.dealHand(p,g); //dealing hand to the player
            }
            else if(choice == 2){
                BlackJava.dealHandToDealer(dealer, p,g); //dealing hand to the dealer
            }
            else if(choice == 3){
                double percentage = ((double)g.getPlayerWins()/(double)g.getGameCount());
                percentage *= 100;
                System.out.println( "\nNumber of Player Wins: " + g.getPlayerWins() + 
                        "\nNumber of Dealer Wins: " + g.getDealerWins() + "\nNumber of Tie Games: " + g.getTies()
                        + "\nTotal # of Games Played: " + g.getGameCount() + "\nPercentage of Player Wins: " + percentage + "%\n"); //showing statistics
            }
            else if(choice == 4){
//                System.out.println("The Game is exiting!"); //exiting the game
                break;
            }
            else{
                System.out.println("Please enter a correct choice");
            }
        }
    }
}

