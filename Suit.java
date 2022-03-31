package project1_new;
/** Author: Hailey Kim 
 * Purpose: Declare four types of suit and a method
 * 
 * Each card will be declared with one of suits (Clubs, Diamonds,
 * Hearts, Spades), if the input value is valid. It will be used
 * to compare all suits of five cards and classify flush-type hands. **/

//enum class 
public enum Suit{
        //suit field
        CLUBS, DIAMONDS, HEARTS, SPADES;
        
        //get the second character from a card, then return a suit
        //if there is no matching character, it is an invalid card
        public static Suit getSuit(String card) {
                char suit = card.charAt(1);
                switch(suit) {
                case 'C':
                        return Suit.CLUBS;
                case 'D':
                        return Suit.DIAMONDS;
                case 'H':
                        return Suit.HEARTS;
                case 'S':
                        return Suit.SPADES;
                default: 
                        return null;
                }

        }
}