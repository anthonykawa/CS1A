

public class Card
{
   public enum Suit {clubs, diamonds, hearts, spades}
   
   // private data
   private char value;
   private Suit suit;
   private static boolean  errorFlag;
   
   
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
   
   
   
   // mutator
   public void set(char value, Suit suit)
   {
      char upVal;            // for upcasing char
   
      this.suit = suit;
   
      // convert to uppercase to simplify
      upVal = Character.toUpperCase(value);
      
      this.errorFlag = isValid(upVal, suit);
      if (errorFlag == false){
    	  this.value = upVal;
      }
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
   public static boolean getErr()
   {
      return errorFlag;
   }
   
   private static boolean isValid(char value, Suit suit){
	   boolean inValid;
	   
	   if (
		         value == 'A' || value == 'K'
		         || value == 'Q' || value == 'J'
		         || value == 'T'
		         || (value >= '2' && value <= '9')
		         ){
		         inValid = false;
		      }
		      else
		      {
		         inValid = true;
		      }
	   
	   return inValid;
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
      if (getErr() == true){
         return retErr;
      }
      else{
         return retVal;
      }
   }
}


