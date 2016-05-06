import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Foothill
{
   public static final int NUM_CARD_IMAGES = 57;
   static Icon icon[] = new Icon[NUM_CARD_IMAGES];
   static JLabel labels[] = new JLabel[NUM_CARD_IMAGES];
   
   public static final String card = "23456789TJQKAX";
   public static final String suit = "CDHS";
   public static void main(String[] args)
   {
      for (int i=0, count = 0; i<suit.length(); i++)
      {
         for(int j=0; j<card.length(); j++)
         {
            System.out.print(count);
            icon[count] = new ImageIcon("images/" 
                  + card.charAt(j)
                  +  suit.charAt(i) 
                  + ".gif");
            count++;
         } 
      }
      icon[NUM_CARD_IMAGES - 1] = new ImageIcon("images/BK.gif");
      
   // establish main frame in which program will run
      JFrame frmMyWindow = new JFrame("Card Room");
      frmMyWindow.setSize(1150, 650);
      frmMyWindow.setLocationRelativeTo(null);
      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set up layout which will control placement of buttons, etc.
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
      frmMyWindow.setLayout(layout);
      
      // prepare the image label array
      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
      for (int k = 0; k < NUM_CARD_IMAGES; k++){
         labels[k] = new JLabel(icon[k]);
      }
      // place your 3 controls into frame
      for (int k = 0; k < NUM_CARD_IMAGES; k++)
         frmMyWindow.add(labels[k]);

      // show everything to the user
      frmMyWindow.setVisible(true);
   }
}
