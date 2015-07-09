
/**
	 
    File name:  mortgageCalculation.java

    Program purpose: This program calculates your mortgage monthly payment.

    Revision history:

    Date                Programmer             Change ID               Description

    07/03/2015          Anthony Kawa                  1                 Initial creation



    @version 1.0
    @author  Anthony Kawa

    @since 07-3-2015

*/

import java.io.*; //import Java I/O library package

public class mortgageCalculation {
	public static void main (String[] args){
		
		//Declare variable and assign initial value
		String propertyAddress = "";
		double propertyValue = 0.00;
		double annualInterestRate = 0.00;
		int loanDuration = 0;
		double downPaymentPercentage = 0.00;
		double propertyTaxRate = 1.5;
		
		//Begin requesting user input
		BufferedReader br = null;
		String buffer = new String();
		try {
			br = new BufferedReader (new InputStreamReader (System.in));
			System.out.print("Enter property address: ");
			propertyAddress = br.readLine();
			
			System.out.print("Enter property value: ");
			buffer = br.readLine();
			propertyValue = Double.parseDouble(buffer);
			
			System.out.print("Enter annual interest rate(%): ");
			buffer = br.readLine();
			annualInterestRate = Double.parseDouble(buffer);
			
			System.out.print("Enter number of loan duration (years): ");
			buffer = br.readLine();
			loanDuration = Integer.parseInt(buffer);
			
			System.out.print("Enter down payment in percentage(%): ");
			buffer = br.readLine();
			downPaymentPercentage = Double.parseDouble(buffer);
			
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// Performing calculations
		double loanAmount = propertyValue * (1-downPaymentPercentage/100);
		double downPayment = propertyValue - loanAmount;
		double monthlyInterestRate = annualInterestRate/100/12;
		double mortgageMonthlyPayment = loanAmount*monthlyInterestRate/(1-1/Math.pow(1+monthlyInterestRate,loanDuration*12));
		double propertyTaxMonthlyPayment = propertyValue*propertyTaxRate/100/12;
		double monthlyPayment = mortgageMonthlyPayment+propertyTaxMonthlyPayment;
		double totalPayment = mortgageMonthlyPayment*12*loanDuration;
		
		//Print out receipt in console
		System.out.println("\nMortgage calculator is processing your data ...  Please wait …");
		try {
	         Thread.sleep(3000);   // suspend for 3 seconds
		 }catch (Exception e) {}
		System.out.println("            **************************************");
		System.out.println("                  MORTGAGE CALCULATOR RESULTS");
		System.out.println("            **************************************");
		System.out.println("Property address: " + propertyAddress);
		System.out.format("Property value:\t\t\t\t$ %9.2f%n", propertyValue);
		System.out.format("Down payment:\t\t\t\t$ %9.2f%n", downPayment);
		System.out.format("Loan amount:\t\t\t\t$ %9.2f%n", loanAmount);
		System.out.format("Mortgage monthly payment:\t\t$ %9.2f%n", mortgageMonthlyPayment);
		System.out.format("Monthly payment(property tax included):\t$ %9.2f%n", monthlyPayment);
		System.out.format("Total payment:\t\t\t\t$ %9.2f%n", totalPayment);
		
	}
}
