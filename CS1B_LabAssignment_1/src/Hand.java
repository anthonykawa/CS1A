
public class Hand
{
   Card[] myCards;
   int numCards;
   private final static int MAX_CARDS = 50;
   
   public Hand(){
      myCards = new Card[MAX_CARDS-1];
      numCards = 0;
      Card card4 = new Card('6', Card.Suit.clubs);
      Card card5 = new Card('T', Card.Suit.hearts);
      Card card6 = new Card('K');
      Card card7 = new Card();
      Card card8 = new Card('B', Card.Suit.diamonds);
      for(int i = 0;i<MAX_CARDS-1;i++){
         if(takeCard(card4) == true){
            takeCard(card4);
         } else {
            System.out.println("Hand is full");
         }
         if(takeCard(card5) == true){
            takeCard(card5);
         }
         if(takeCard(card6) == true){
            takeCard(card6);
         }
         if(takeCard(card7) == true){
            takeCard(card7);
         }
         if(takeCard(card8) == true){
            takeCard(card8);
         }
         
      }
      
      
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
      System.out.println("");
      Hand handString = new Hand();
      System.out.println(handString.toString());
      
      

      
   }
   
   void resetHand(){
      for(int i = 0;i<numCards;i++){
	      this.myCards[i] = new Card();
	   }
   }
   
   public boolean takeCard(Card card) {
      if(numCards + 1 == MAX_CARDS){
         return false;
      }
      else
      {
      this.myCards[getNumCards()] = new Card(card.getVal(), card.getSuit());
      numCards++;
      System.out.println(getNumCards());
      return true;
      }
   }
   public int getNumCards(){
	   return numCards;
   }
   public Card playCard() {
      
	  return myCards[getNumCards()];
   }
   public Card inspectCard(int k){
	   return myCards[k];
   }
   public String toString(){
      String hand;
      hand = "hand = ( ";
      for(int i = 0;i<MAX_CARDS-1;i++){
         hand = hand + myCards[i] + ", ";
      }
      hand = hand + ")";
      return hand;
   }
}
