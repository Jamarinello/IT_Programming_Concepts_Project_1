/*
File: Project1-taxProgram
Programmer: Joseph Marinello
Date: Febuary 3, 2019
Purpose: Project 1 Main
 */

import java.util.Scanner;

public class taxAccountant {

    public static void main(String[] args) {

        // declare variables
        int customerID = 0;
        double totalEarnings = 0.0;
        double federalTaxesWH = 0.0;
        double stateTaxWH = 0.0;
        double deductions = 0.0;
        double taxableIncome = 0.0;
        double federalTax = 0.0;
        double stateRefund = 0.0;
        double stateTax = 0.0;
        double federalRefund = 0.0;
        String output = new String();

        // Create a Scanner input object
        Scanner myInput = new Scanner(System.in);

        // Create output string chart
        output = "Cust.                   Taxable Federal State Federal State Federal State\n";
        output += " ID   Income Deductions Income    Tax    Tax    W/H    W/H  Refund  Refund\n";
        output += "===== ====== ========== ======= ======= ===== ======= ===== ======= ======\n";

        // Begin first customer
        System.out.print("Enter the First Customer: ");
        customerID = myInput.nextInt();

        // Get first Customer ID
        while (customerID != -1) {
            // Get income and withholding information
            System.out.print("Enter the Total Earnings: ");
            totalEarnings = myInput.nextDouble();

            System.out.print("Enter the Deductions: ");
            deductions = myInput.nextDouble();

            System.out.print("Enter the Federal Taxes W/H: ");
            federalTaxesWH = myInput.nextDouble();

            System.out.print("Enter the State Taxes W/H: ");
            stateTaxWH = myInput.nextDouble();

            taxableIncome = totalEarnings - deductions;

            // Calculate taxes due/refunds
            if (taxableIncome <= 10000.0) {
                federalTax = 0.0;
            } else if (taxableIncome <= 20000.0) {
                federalTax = 0.15 * (taxableIncome - 10000.0);
            } else if (taxableIncome <= 40000.0) {
                federalTax = (10000.0 * 0.15) + ((taxableIncome - 20000.0) * 0.2);
            } else {
                federalTax = (10000.0 * 0.15) + (20000.0 * 0.2) + ((taxableIncome - 40000.0) * 0.3);
            }

            stateTax = federalTax * 0.07;
            federalRefund = federalTaxesWH - federalTax;
            stateRefund = stateTaxWH - stateTax;

            // Add data to output String
            output += String.format("%3d   $%5.0f   $%4.0f    $%5.0f  $%5.0f  $%3.0f  $%5.0f  $%4.0f  $%4.0f   $%3.0f\n", customerID, totalEarnings, deductions, taxableIncome, federalTax, stateTax, federalTaxesWH, stateTaxWH, federalRefund, stateRefund);

            // Get next Customer ID
            System.out.print("\n\nEnter the next Customer: ");
            customerID = myInput.nextInt();

        }

        // Print out table of data and end program
        System.out.println(output);

    }
}
