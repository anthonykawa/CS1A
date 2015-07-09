/**
	 
    File name:  customerReceipt.java

    Program purpose: This program is to print a customer receipt from an ATM machine

    Revision history:

    Date                Programmer             Change ID               Description

    07/1/2015          Anthony Kawa                  1                 Initial creation



    @version 1.0
    @author  Anthony Kawa

    @since 07-1-2015

*/
public class customerReceipt {
	
	public static void main (String [ ] args) {
	
	//declare variables and strings	
	String customerName = "";
	String accountNumber = "";
	int month = 0, day = 0, year = 0;
	String transactionType = "";
	double transactionAmount = 0.0;
	double availableBalance = 0.0;
	
	 //assign values to the variables and strings  
	 month = 07; 
	 day = 5; 
	 year = 2016;
	 customerName = "Teddy Roosevelt";
	 accountNumber = "766213665";
	 transactionType = "W";
	 transactionAmount = 1300;
	 availableBalance = 1400;
	
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
	 System.out.println("  Customer name:        " + customerName);
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