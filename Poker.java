package project1_new;
/** Author: Hailey Kim 
 * Purpose: Print hand result of a single player
 * 
 * A poker player enters five cards in order to run this program. Each
 * card consists of two-character strings; the first character indicates
 * the rank of the card which would be one of ranks(A for Ace, K for King, 
 * Q for Queen, J for Jack, T for Ten, 2-9), and the second character
 * indicates the suit of the card which would be one of suits(C for Clubs,
 * D for Diamonds, H for Hearts, S for Spades). The entered cards can be
 * both upper and lower case characters. The computer prints the result 
 * of the player's hand with detailed rank description. 
 **/
                                                                  
import java.util.Arrays;

//inherit HandDesc class
public class Poker extends HandDesc{
        
        public static void main(String[] args) {
                int cardLen = args.length;      //the local variable
                
                //create array objects to keep strings/Rank/Suit of input
                String[] playerCardArr = new String[cardLen];   
                Rank[] playerRankArr = new Rank[cardLen]; 
                Suit[] playerSuitArr = new Suit[cardLen];   
                
                //the computer gets only 5 cards arguments for a player
                //catch invalid input size error, print error and exit 
                if(!(cardLen > 0 && cardLen %5 == 0)) {
                        //print error message when there is no argument or 
                        //the number of input is not a multiple of 5
                        System.out.println("Error: wrong number of arguments;"
                                        + " must be a multiple of 5");
                        System.exit(1);
                }
                //limit the number of player(only a single player)
                else if(cardLen > 5) {
                        System.out.println("NOT UNDERTAKEN");
                        System.exit(1);
                }
                
                //add elements and catch invalid card error
                for(int i = 0; i< cardLen; i++) {
                                     
                        //the program handles both upper and lower case
                        //add each card string from the card
                        playerCardArr[i] = args[i].toUpperCase();
                        
                        //add each card suit/rank from the converted card
                        Suit playerSuit = Suit.getSuit(playerCardArr[i]);
                        Rank playerRank = Rank.getRank(playerCardArr[i]);
                        
                        //print error if there is undefined suit/rank, and exit
                        if(playerSuit == null || playerRank == null) {
                                System.out.println("Error: invalid card name '"
                                                + playerCardArr[i] + "'");
                                System.exit(1);
                        }
                        //append each suit/rank, respectively 
                        playerSuitArr[i] = playerSuit;
                        playerRankArr[i] = playerRank;
                } 
                //sort array in the rank/suit order for comparison
                Arrays.sort(playerRankArr);
                Arrays.sort(playerSuitArr);
                
                //create a poker object
                HandDesc h = new HandDesc();
                Hand s = h.findHand(playerRankArr, playerSuitArr);    
                //print hand description result
                System.out.println(s.toString());
                
        }
      
        @Override
        //override toString() from HansDesc(super class)
        public String toString() {
                return "Player 1: " + super.toString();
        }        
}
            