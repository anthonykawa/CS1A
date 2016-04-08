

public class Card
{
   public enum Suit {clubs, diamonds, hearts, spades}
   
   // private data
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   
   // 4 overloaded constructors
   public Card(char value, Suit suit)
   {
      set(value, suit);
   }
   public Card(char value)
   {
      this(value, Suit.spades);
   }
   public Card()
   {
      this('A', Suit.spades);
   }
   // copy constructor
   public Card(Card card)
   {
      this.suit = card.suit;
      this.value = card.value;
   }
   
   public static void main(String[] args){
      Card card1 = new Card();
      Card card2 = new Card('B', Card.Suit.diamonds);
      Card card3 = new Card('5', Card.Suit.hearts);
      
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
      
      card1.set('C', Card.Suit.clubs);
      card2.set('5', Card.Suit.clubs);
      card3.set('T', Card.Suit.diamonds);
      System.out.println(" ");
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
   }
   
   // mutator
   public boolean set(char value, Suit suit)
   {
      char upVal;            // for upcasing char
      boolean valid = true;   // return value
      
      // filter out bad suit input:
   
     this.suit = suit;
   
      // convert to uppercase to simplify
      upVal = Character.toUpperCase(value);
      // check for validity
      if (
         upVal == 'A' || upVal == 'K'
         || upVal == 'Q' || upVal == 'J'
         || upVal == 'T'
         || (upVal >= '2' && upVal <= '9')
         ){
         this.value = upVal;
         errorFlag = true;
      }
      else
      {
         valid = false;
         this.value = 'A';
         errorFlag = false;
      }
      return valid;
   }
   
   // accessors
   public char getVal()
   {
      return value;
   }
   public Suit getSuit()
   {
      return suit;
   }
   public boolean getErr()
   {
      return errorFlag;
   }
   
   public boolean equals(Card card){
      return false;
   }
   // stringizer
   public String toString()
   {
      String retVal;
      String retErr;
      // convert from char to String
      retVal =  String.valueOf(value) + " of " + suit;
      
      retErr = "** illegal **";
      if (errorFlag == false){
         return retErr;
      }
      else{
         return retVal;
      }
   }
}


