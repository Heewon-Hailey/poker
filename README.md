# The Winning Hands in Poker

## About the project

For this project, I write a program that will correctly characterise a poker hand. If more than one hand is given (multiple players) as input, it decides which hand wins. It has some multiple of 5 cards that will be entered as two-character strings, the first being an A for Ace, K for King, Q for Queen, J for Jack, T for Ten, or digit between 2 and 9 for ranks 2–9. The second character will be a C for Clubs (♣), D for Diamonds (♦), H for Hearts (♥), or S for Spades (♠). It is not case-sensitive. It will take Aces to be the highest rank for simplicity. Basically, the program outputs `Player_n:_description of hand` where n is 1 when describing the first 5 cards, 2 for the next 5, and so on, and space is shown as `_`. 

#### Standard Poker lingo
|Category|Description|Detail|
|---|---|---|
| Straight flush | r-high_straight_flush | r is highest rank in hand |
| Four of a kind | Four_rs | r is rank of 4 cards |
| Full house |  r1s_full_of_r2s | r1 is rank of 3 cards; r2 is rank of 2 |
| Flush |  r-high_flush | r is highest rank in hand |
| Straight | r-high_straight | r is highest rank in hand |
| Three of a kind | Three_rs | r is rank of 3 cards |
| Two pair | r1s_over_r2s | r1 is rank of higher pair; r2 is rank of lower pair |
| One pair | Pair_of_rs | r is rank of pair |
| High card | r-high | r is highest rank in hand |

*Ranks (r, r1 and r2 above) should be shown as numerals, or full capitalised rank names for face cards: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, or Ace. 
Note that this is different from the way ranks are specified on the command line. Also note that the information conveyed in these hand descriptions is not always enough to decide the winner; for example, in deciding the winner between two Queen-high hands, the secondhighest ranked cards in the two hands must be consulted, but these are not shown in the hand descriptions.  

#### Error-handling:
If the number of command line arguments is not greater than zero or not a multiple of five, your program will print out `Error: wrong number of arguments; must be a multiple of 5` and exit. If any of the command line arguments is not a valid card name, as specified above, the program will print out `Error: invalid card name ’c’` and exit, where c is the (first) invalid card entered on the command line.

## Background

Poker, a gambling card game, has many variations of the game, yet this project uses the simple 5-card game to make it simple. A poker hand consists of five cards from a standard 52-card deck w/o jokers. The ranks, in order of increasing value, are 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, and Ace, and the suits are Clubs (♣), Diamonds (♦), Hearts (♥), and Spades (♠). Each card is a combination of a rank and a suit. There are 9 classifications of hands, as follows, in order of decreasing value:

- Straight flush : 5 cards of the same suit whose ranks form a sequence, such as 7♥, 8♥, 9♥, 10♥, J♥. If two players both have a straight flush, the one with the highest card wins. If both players have the same ranks of cards (but different suits), the players draw. Suits are never used to decide the winner in poker.

- Four of a kind : a set of four cards of the same rank, and any other card, such as 3♥, 3♠, 3♦, 3♣, 7♥. If two players both have four of a kind, the one with the highest rank of their set of four wins. In some varieties of poker it is possible for two players to both have 4 of the same rank; in this case the one with the higher rank of their fifth card wins. If the fifth cards are also the same rank, it is a draw. 

- Full house : three cards of one rank and two of another; that is three of a kind plus a pair, for example Q♥, Q♣, Q♦, 7♠, 7♣. If two player both have a full house, the one with the higher rank of their set of three wins. If two players to each have three cards of the same rank, then the rank of the pair is used to decide. 

- Flush : any 5 cards of the same suit, regardless of their rank, for example K♣, 9♣, 3♣, J♣, 4♣. If two players both have a flush, then their highest ranking card is used to decide the winner. If their highest ranking cards have the same rank, then their second highest ranking cards, followed by their, third, fourth, and fifth highest ranking cards are used in turn.

- Straight : 5 cards whose ranks form a sequence, regardless of their suits, for example, 6♠, 7♣, 8♦, 9♠, 10♥. If two players both have a straight, the one with the highest ranking card wins. If two hands have the same highest ranking card, they draw.

- Three of a kind : 3 cards of the same rank, and any other 2 cards, for example, 6♦, 6♠, 6♥, 9♥, J♦. If two players both have three of a kind, the player whose three of a kind have the highest rank wins. If this is a tie, then the higher ranking other card is used, and if this, too, is a tie, then the rank of last card decides.

- Two pair : 2 cards of one rank, 2 cards of another rank, and any other card, such as 5♦, 5♠, 9♣, 9♠, A♥. If two players both have two pair, the ranks of their highest ranking pairs decide the winner; if their highest ranking pairs are the same rank, the second ranking pair decides; if they are also the same, the rank of the final cards decides.

- One pair : 2 cards of one rank, and any other 3 cards, for example, A♠, A♣, 6♠, J♥, 2♦. If two players both have one pair, the rank of the pair decides, with the ranks of their other cards, from high to low, used if their pairs are of the same rank. 

- High card : any 5 cards. If two players both have a high card hand, the ranks of the cards, from high to low, are used to decide the winner.

Always the best description of a hand is used. For example, a hand with three of a kind and a pair must always be classified as a full house, even though it could also be called three of a kind or a pair (or a high card hand). 

For more information, refer to http://en.wikipedia.org/wiki/List_of_poker_hands.
</div> 
  
## Expected outputs
Input(Args)<br>
`2H TH AS AD TC`<br>
Output <br>
`Player 1: Aces over 10s`

Input<br>
`2H TH 1S 1D TC`<br>
Output<br> 
`Error: invalid card name ’1S’`

Input<br>
`KS 9S QS AS JS 3D 7C 3S 3H 7S`<br>
Output<br> 
`Player 1: Ace-high flush`<br>
`Player 2: 3s full of 7s`<br>
`Player 2 wins.`

Input<br>`qc jc 2h 7s 9h qd jd 2s 7c 9s 9c 7d 2c jh qh 9d 7h 2d js qs`<br>
Output<br> 
`Player 1: Queen-high`<br>
`Player 2: Queen-high`<br>
`Player 3: Queen-high`<br>
`Player 4: Queen-high`<br>
`Players 1, 2, 3 and 4 draw.`

  
## Version 

Java 1.8.0 

----

Have fun! ♣ ♦ ♥ ♠
