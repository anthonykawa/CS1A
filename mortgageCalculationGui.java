/**
	 
    File name:  mortgageCalculation.java

    Program purpose: This program is to print a customer receipt from an ATM machine

    Revision history:

    Date                Programmer             Change ID               Description

    07/1/2015          Anthony Kawa                  1                 Initial creation



    @version 1.0
    @author  Anthony Kawa

    @since 07-1-2015

*/

import javax.swing.*;

public class mortgageCalculationGui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare variable and assign initial value
		String propertyAddress = "";
		double propertyValue = 0.00;
		double loanAmount = 0.0;
		double downPayment = 0.0;
		double annualInterestRate = 0.00;
		double monthlyInterestRate = 0.0;
		double mortgageMonthlyPayment = 0.0;
		double propertyTaxMonthlyPayment = 0.0;
		double monthlyPayment = 0.0;
		double totalPayment = 0.0;
		int loanDuration = 0;
		double downPaymentPercentage = 0.00;
		double propertyTaxRate = 1.5;
		
		getInput(propertyAddress, propertyValue, annualInterestRate, loanDuration, downPaymentPercentage);
		calculateLoanAmount(propertyValue, loanAmount, downPaymentPercentage);
		calculateDownPayment(propertyValue, downPayment, loanAmount);
		calculateMonthlyInterestRate(monthlyInterestRate, annualInterestRate);
		calculateMortgageMonthlyPayment(monthlyInterestRate, loanAmount, mortgageMonthlyPayment, loanDuration);
		calculatePropertyTaxMonthlyPayment(propertyTaxMonthlyPayment, propertyValue, propertyTaxRate);
		calculateMonthlyPayment( monthlyPayment,  mortgageMonthlyPayment,  propertyTaxMonthlyPayment);
		calculateTotalPayment( totalPayment,  mortgageMonthlyPayment,  loanDuration);
		print( propertyAddress,  propertyValue,  loanAmount,  downPayment,  monthlyInterestRate,  mortgageMonthlyPayment,  propertyTaxMonthlyPayment,  monthlyPayment,  totalPayment);
		
		}
	
	public static void getInput(String propertyAddress, double propertyValue, double annualInterestRate, int loanDuration, double downPaymentPercentage) {
		//Begin requesting user input
		String input = new String();
		try {
			input = JOptionPane.showInputDialog("Enter property address: ");
			propertyAddress = input;
			
			input = JOptionPane.showInputDialog("Enter property value: ");
			propertyValue = Double.parseDouble(input);
			
			input = JOptionPane.showInputDialog("Enter annual interest rate(%): ");
			annualInterestRate = Double.parseDouble(input);
			
			input = JOptionPane.showInputDialog("Enter number of loan duration (years): ");
			loanDuration = Integer.parseInt(input);
			
			input = JOptionPane.showInputDialog("Enter down payment in percentage(%): ");
			downPaymentPercentage = Double.parseDouble(input);

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
		
	public static double calculateLoanAmount(double propertyValue, double loanAmount, double downPaymentPercentage){
		// Performing calculations
			loanAmount = propertyValue * (1-downPaymentPercentage/100);
			
			return loanAmount;
	}
	
	public static double calculateDownPayment(double propertyValue, double downPayment, double loanAmount){
			downPayment = propertyValue - loanAmount;
	
			return downPayment;
	}
	
	public static double calculateMonthlyInterestRate(double monthlyInterestRate, double annualInterestRate){
			monthlyInterestRate = annualInterestRate/100/12;
	
			return monthlyInterestRate;
	}
	
	public static double calculateMortgageMonthlyPayment(double monthlyInterestRate, double loanAmount, double mortgageMonthlyPayment, int loanDuration){
			mortgageMonthlyPayment = loanAmount*monthlyInterestRate/(1-1/Math.pow(1+monthlyInterestRate,loanDuration*12));
			
			return mortgageMonthlyPayment;
	}
	
	public static double calculatePropertyTaxMonthlyPayment(double propertyTaxMonthlyPayment, double propertyValue, double propertyTaxRate){
			propertyTaxMonthlyPayment = propertyValue*propertyTaxRate/100/12;
			
			return propertyTaxMonthlyPayment;
	}
	
	public static double calculateMonthlyPayment(double monthlyPayment, double mortgageMonthlyPayment, double propertyTaxMonthlyPayment){
			monthlyPayment = mortgageMonthlyPayment+propertyTaxMonthlyPayment;
			
			return monthlyPayment;
	}
	
	public static double calculateTotalPayment(double totalPayment, double mortgageMonthlyPayment, int loanDuration){
			totalPayment = mortgageMonthlyPayment*12*loanDuration;
			
			return totalPayment;
	}
	
	public static void print(String propertyAddress, double propertyValue, double loanAmount, double downPayment, double monthlyInterestRate, double mortgageMonthlyPayment, double propertyTaxMonthlyPayment, double monthlyPayment, double totalPayment){
		//Print out receipt in console
		JOptionPane.showMessageDialog(null,"Mortgage calculator is processing your data ...  Please wait …\n"
				+ "     **********************************************\n"
				+ "         MORTGAGE CALCULATOR RESULTS\n"
				+ "     **********************************************\n"
				+ "Property address: " + propertyAddress + "\n"
				+ "Property value: " + String.format("$ %9.2f", propertyValue) + "\n"
				+ String.format("Down payment: $ %.2f\t\t\t", downPayment) + "\n"
				+ String.format("Loan amount: $ %.2f\t\t\t", loanAmount) + "\n"
				+ String.format("Mortgage monthly payment: $ %.2f\t\t\t", mortgageMonthlyPayment) + "\n"
				+ String.format("Monthly payment(property tax included): $ %.2f\t", monthlyPayment) + "\n"
				+ String.format("Total payment: $ %.2f", totalPayment));
	}
	
}
