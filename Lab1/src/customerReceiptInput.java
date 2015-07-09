/**
	 
    File name:  customerReceiptInput.java

    Program purpose: This program is to print a customer receipt from an ATM machine

    Revision history:

    Date                Programmer             Change ID               Description

    07/1/2015          Anthony Kawa                  1                 Initial creation



    @version 1.0
    @author  Anthony Kawa

    @since 07-1-2015

*/
import java.util.Scanner;

public class customerReceiptInput {
	
	public static void main (String [ ] args) {
	
	//declare variables and strings	
	Scanner userInput = new Scanner( System.in );
	String firstName = "";
	String lastName = "";
	int month = 0, day = 0, year = 0;
	String accountNumber = "";
	String transactionType = "";
	double transactionAmount = 0.0;
	double availableBalance = 0.0;
	
	 //request values from customer
	 System.out.print("Enter the month: ");
	 month = userInput.nextInt( ); 
	 System.out.print("Enter the day: ");
	 day = userInput.nextInt(); 
	 System.out.print("Enter the year: ");
	 year = userInput.nextInt();
	 System.out.print("Enter your first name: ");
	 firstName = userInput.next( );
	 System.out.print("Enter your last name: ");
	 lastName = userInput.next( );
	 System.out.print("Enter your account number: ");
	 accountNumber = userInput.next();
	 System.out.print("Enter your transaction type: ");
	 transactionType = userInput.next();
	 System.out.print("Enter your transaction amount: ");
	 transactionAmount = userInput.nextDouble();
	 System.out.print("Enter your available balance: ");
	 availableBalance = userInput.nextDouble();
	 
	 // Combine First Name and Last Name into one string
	 String fullName = firstName + " " + lastName;
	 
	 
	 //Suspend program for 3 seconds
	 System.out.println("Please wait for receipt to be printed...");
	 try {
         Thread.sleep(3000);   // suspend for 3 seconds
	 }
	 catch (Exception e) {}
	 
	 // Print receipt to customer
	 System.out.println("");
	 System.out.println("");
	 System.out.println("****************************************************************");
	 System.out.println("                      Bank of US");
	 System.out.println("         For Customer Service call 1-800-111-2222");
	 System.out.println("            CUSTOMER ATM TRANSACTION RECEIPT");
	 System.out.println("  " + month + "/" + day + "/" + year);
	 System.out.println("  Customer name:        " + fullName);
	 System.out.println("  Account number:       " + accountNumber);
	 System.out.println("  Transaction type:     " + transactionType);
	 System.out.println("  Transaction amount:   " + "$  " + transactionAmount);
	 System.out.println("  Available balance:    " + "$ " + availableBalance);
	 System.out.println("");
	 System.out.println("");
	 System.out.println("  Thanks for doing business with Bank of US. Have a great day!!!");
	 System.out.println("****************************************************************");
}
}