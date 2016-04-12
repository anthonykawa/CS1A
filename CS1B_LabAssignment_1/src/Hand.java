
public class Hand
{
   Card[] myCards;
   int numCards;
   
   public Hand(){
      
   }
   public static void main(String[] args){
   
   System.out.println("----------------------------------------------------------");
   System.out.println("----------------------- Phase 1 --------------------------");
   System.out.println("----------------------------------------------------------");
   System.out.println(" ");
   Card card1 = new Card();
   System.out.println(card1.toString());
   Card card2 = new Card('B', Card.Suit.diamonds);
   System.out.println(card2.toString());
   Card card3 = new Card('5', Card.Suit.hearts);
   System.out.println(card3.toString());
  
  
  
   System.out.println(" ");
   card1.set('C', Card.Suit.clubs);
   System.out.println(card1.toString());
   card2.set('5', Card.Suit.clubs);
   System.out.println(card2.toString());
   card3.set('T', Card.Suit.diamonds);
   System.out.println(card3.toString());
   System.out.println(" ");
   System.out.println("----------------------------------------------------------");
   System.out.println("----------------------- Phase 2 --------------------------");
   System.out.println("----------------------------------------------------------");
   
   }
   
   void resetHand(){
	   
   }
   
   public boolean takeCard(Card card) {
      return false;
   }
   public int getNumCards(){
	   return numCards;
   }
   public Card playCard() {
      
	  return myCards[myCards.length-1];
   }
   public Card inspectCard(int k){
	   return myCards[k];
   }
}
