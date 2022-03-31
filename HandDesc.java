package project1_new;
/** Author: Hailey Kim 
 * Purpose: Classify poker hand of a single play
 * 
 * This class defines nine types of hand in poker game, and classify 
 * hand from given five cards. The computer returns hand out of 
 * 9 classification detailed rank description  **/

//super class of Poker 
public class HandDesc{
        //hand fields, assuming there are only nine classification
        enum Hand{
                STRAIGHT_FLUSH, FOUR_OF_A_KIND, FULL_HOUSE, FLUSH, 
                STRAIGHT, THREE_OF_A_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD;
        }
                                                                                
        //internal variables; get results to detail the result
        private String rank1, rank2;
        private Hand result = null;
        
        //compares each result from three different hand-type check 
        //if a card set has more than two result from each method, 
        //get the highest hand description 
        public Hand findHand(Rank[] cardRank, Suit[] cardSuit) {
                
                //create each variables for each check method 
                Hand straight = straightCheck(cardRank);
                Hand flush = flushCheck(cardSuit);
                Hand ofAKind = ofAKindCheck(cardRank);
               
                //check if the cards are straight (and/or) flush, 
                //and return hand
                if(straight != null && flush != null) {
                        
                        //cards have a sequence numbers and same suits
                        result = Hand.STRAIGHT_FLUSH;
                        
                }else if(flush != null) {
                        //cards have same suits, no sequence numbers
                        
                        if(flush.compareTo(ofAKind) < 0){
                                
                                //compare if flush ranks higher  
                                result = flush;
                        }
                }else if(straight != null) {
                        
                        //cards have a sequence number, no same suits
                        if(straight.compareTo(ofAKind) < 0){
                                
                                //compare if flush ranks higher
                                result = straight;
                        }
                }else result = ofAKind;
                return result;
        }
        
        //check if cards have five straight numbers
        public Hand straightCheck(Rank[] cardRank) {
                
                //compare indexes of a hand and the next hand
                //if all ranks are successive, return straight hand 
                for(int i = 0; i < cardRank.length -1 ; i++) {
                        
                        if(cardRank[i].ordinal() != 
                                        cardRank[i+1].ordinal() -1) {
                                result = null;
                                return result;
                        }
                }result = Hand.STRAIGHT;
                return result;             
        }
        
        //check if all cards have the same suits
        public Hand flushCheck(Suit[] cardSuit) {
                
                //compare the first and the last of card suit from sorted array
                result = (cardSuit[0].equals(cardSuit[4]) ? Hand.FLUSH : null);           
                return result;
        } 
                                                             
        //get hand result, rank1 and rank2 based on the number of the same ranks
        public Hand ofAKindCheck(Rank[] cardRank) {
                                                                      
                //create an array for counting same ranks
                int[] countArr = getCountArr(cardRank);
                
                //create integer variables for index of the given value 
                
                int right4 = findIndexRight(countArr,4);
                int right3 = findIndexRight(countArr,3);
                int right2 = findIndexRight(countArr,2);
                int left2 = findIndexLeft(countArr,2);
                
                //check if there are four same ranks 
                if(right4 > 0) {
                        
                        //get the highest rank among the four cards
                        rank1 = getRank(cardRank,right4);
                        result = Hand.FOUR_OF_A_KIND;
                
                //check if there are three same ranks       
                }else if(right3 > 0) { 
                        
                        //get the highest rank among the three cards
                        rank1 = getRank(cardRank,right3);
                        
                        //check if there are another two same ranks 
                        if(left2 != right2){
                                             
                                //comparing indexes to get rank2
                                rank2 = ((right2 == right3 -1) ? 
                                            getRank(cardRank,left2): 
                                                    getRank(cardRank,right2));
                                result = Hand.FULL_HOUSE;   
                        }else result = Hand.THREE_OF_A_KIND;                                                     
                }else if(right2 > 0) {     //check if there are two same ranks 
                        rank1 = getRank(cardRank,right2);
                        if(left2 != right2){    
                                rank2 = getRank(cardRank,left2);
                                result = Hand.TWO_PAIR;
                        }else result = Hand.ONE_PAIR;       
                }else {     //if there is not same rank, get the highest rank
                        rank1 = getRank(cardRank,4);   
                        result = Hand.HIGH_CARD;    
                }return result;
        }
        
        //get rank from getOutPut method in Rank class
        public String getRank(Rank[] cardRank, int index) {
                return Rank.getOutPutRank(cardRank[index]);
        }

        //get count array distinguishing same successive ranks
        public int[] getCountArr(Rank[] cardRank) {
                
                int[] count = {1, 1, 1, 1, 1};      //initialise count array
                
                //if same ranks are found increase by 1 from the previous count 
                for(int i = 0; i < cardRank.length-1; i++) {
                        if(cardRank[i].equals(cardRank[i+1])){
                                count[i+1] = count[i] +1;
                        }
                }return count;
        }
        
        //find an index from an array having the value 
        //from the left of the array, and return the index
        //if there is no matching value, return -1
        public int findIndexLeft(int[] countArr, int value) {
                int i = 0;
                while (i < countArr.length) { 
                        if (countArr[i] == value) { 
                                return i;
                        }else i++; 
                }return -1;       
        }
        
        //same function with findIndexLeft, but search the value from  
        //the right of the array
        public int findIndexRight(int[] countArr, int value) {
                int i = countArr.length -1;
                while (i >= 0) { 
                        if (countArr[i] == value) { 
                                return i;
                        }else i--; 
                }return -1; 
        }     
        
        @Override
        //override toString() to print hand description
        public String toString() {
                switch(result) {
                case STRAIGHT_FLUSH:
                        return rank1 + "-high straight flush";
                case FOUR_OF_A_KIND:
                        return "Four " + rank1 +"s";
                case FULL_HOUSE:
                        return rank1 +"s full of " + rank2 + "s";
                case FLUSH:
                        return rank1 + "-high flush";
                case STRAIGHT:
                        return rank1 + "-high straight";
                case THREE_OF_A_KIND:
                        return "Three " + rank1 +"s";
                case TWO_PAIR:
                        return rank1 +"s over " + rank2 + "s";
                case ONE_PAIR:
                        return "Pair of " + rank1 +"s";
                case HIGH_CARD:
                        return rank1 +"-high";
                default: 
                        return null;
                }
        }
}
