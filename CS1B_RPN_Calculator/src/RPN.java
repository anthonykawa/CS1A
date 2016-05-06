import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class RPN
{
   public static void main(String[] args)
   {
      // establish main frame in which program will run
      Calculator myCalculator 
            = new Calculator("CS 1B RPN Calculator");
      myCalculator.setSize(250, 300);
      myCalculator.setLocationRelativeTo(null);
      myCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // show everything to the user
      myCalculator.setVisible(true);
   }
}

//Calculator class is derived from JFrame class
class Calculator  extends JFrame
{
   private JButton btnPlus, btnMinus, btnMult, btnDiv, btnEnter;
   private JTextField txtNumber;
   private JLabel lblInstructions;
   private JPanel pnlButtons, pnlTextEnter;
   private MyStack stk;
   
   // Calculator constructor
   public Calculator(String title)
   {
      // pass the title up to the JFrame constructor
      super(title);
      
      // set up main components for the JFrame
      pnlTextEnter = new JPanel( new GridLayout(1, 2, 10, 10));
      pnlButtons = new JPanel( new GridLayout(2, 2, 20, 20));
      lblInstructions = new JLabel("Use Reverse Polish Noatation");

      // use border layout and put three above components in frame
      setLayout (new BorderLayout(20, 10));
      add(pnlTextEnter, BorderLayout.NORTH );
      add(pnlButtons, BorderLayout.CENTER);
      add(lblInstructions, BorderLayout.SOUTH);

      // set up the components for the pnlTextEnter Panel
      btnEnter = new JButton("Enter");
      txtNumber = new JTextField("0.0", 15);
      
   // register Enter listeners (for pushing numbers)
      ActionListener enterListener = new EnterListener();
      btnEnter.addActionListener( enterListener );
      txtNumber.addActionListener( enterListener );
      
      // add components to pnlTextEnter Panel
      pnlTextEnter.add(txtNumber);
      pnlTextEnter.add(btnEnter);
      
      // set up the components for the pnlButtons Panel
      btnPlus = new JButton("+");
      btnMinus = new JButton("-");
      btnMult = new JButton("*");
      btnDiv = new JButton("/");
     
      // add components to pnlButtons Panel
      pnlButtons.add(btnPlus);
      pnlButtons.add(btnMinus);
      pnlButtons.add(btnMult);
      pnlButtons.add(btnDiv);
      
      // place borders around three sub-panels
      pnlTextEnter.setBorder(new TitledBorder("Entry and Result"));
      pnlButtons.setBorder(new TitledBorder("Operator Buttons"));
      
      
   }
   class EnterListener implements ActionListener
   {

      @Override
      public void actionPerformed(ActionEvent arg0)
      {
         // TODO Auto-generated method stub
         double dblA = 0;
         String strA;

         // read value from text fields into local variables
         strA = txtNumber.getText();
         txtNumber.setText("");  // clear
         txtNumber.requestFocus();

         // try to convert from String to double, return if fail
         try
         {
            dblA = Double.parseDouble(strA);
         }
         catch (NumberFormatException error)
         {
            return;
         }
        
         if ( !stk.push(dblA) )
            txtNumber.setText( "Stack Overflow");
      }
   }
   
// inner class for OpListener
   class OpListener implements ActionListener
   {
      // event handler for JButton or Enter Key
      public void actionPerformed(ActionEvent e)
      {
         String strResult;
         Double dbl1, dbl2, dblResult;

         // pop two items
         if (!stk.testStack(2))
            return;
         dbl2 = stk.pop();
         dbl1 = stk.pop();

         // do the math
         if (e.getSource()== btnPlus)
            dblResult = dbl1 + dbl2;
         // else ... other operators ... ??

         // convert from double to  String
         NumberFormat tidy = NumberFormat.getInstance(Locale.US);
         tidy.setMaximumFractionDigits(10);
         strResult = tidy.format(dblResult);


         // write result back to TextA and push
         txtNumber.setText(strResult);
         stk.push(dblResult);
      }
   } // end inner class OpListener

} // end class Calculator

