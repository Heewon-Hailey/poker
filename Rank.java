package project1_new;
/** Author: Hailey Kim 
 * Purpose: Declare 13 types of rank and methods
 * 
 * Each card will be declared with one of ranks (A for Ace, K for King, 
 * Q for Queen, J for Jack,  T for Ten, 2-9), if the input value is valid. 
 * It will be used to distinguish whether the five ranks are a sequence 
 * for classifying straight-type hands, how many same ranks are there 
 * for classifying other hands, and which card is the highest rank for 
 * printing out detailed description. 
 **/

//enum class
public enum Rank{
        //rank fields with its output value
        //assuming Ace is the highest rank
        TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), 
        SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), 
        JACK("Jack"), QUEEN("Queen"), KING("King"), ACE("Ace");
                                                                        
        //internal state variable 
        private String output;
        
        //constructor
        Rank(String output) {
                this.output = output;
        }
        
        //get output value from each rank
        static String getOutPutRank(Rank rank) {
                return rank.output;
        }
                                                                                
        //get the first character from a card, and return a rank
        //if there is no matching character, it is an invalid card
        public static Rank getRank(String card) {
                char rank = card.charAt(0);
                switch(rank) {
                case '2': 
                        return Rank.TWO;
                case '3':
                        return Rank.THREE;
                case '4':
                        return Rank.FOUR;
                case '5':
                        return Rank.FIVE;
                case '6':
                        return Rank.SIX;
                case '7':
                        return Rank.SEVEN;
                case '8':
                        return Rank.EIGHT;
                case '9':
                        return Rank.NINE;                      
                case 'T':
                        return Rank.TEN;
                case 'J':
                        return Rank.JACK;
                case 'Q':
                        return Rank.QUEEN;
                case 'K':
                        return Rank.KING;
                case 'A':
                        return Rank.ACE;
                default:
                        return null;
                }
        }
}
