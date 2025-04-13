package com.ps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("1) Mortgage Calculator");
        System.out.println("2) Future Value of CD Calculator");
        System.out.print("Please select a calculator: ");
        int given_command = scanner.nextInt();

        System.out.println("You have selected: " + given_command);
        
        switch (given_command){
            case 1:
//                M=P×(i*(1+i)^n / ((1+i)^n)-1)
//                - M = Monthly Payment
//                - P = Principal: This is the total amount of the loan.
//                - r = Annual Interest Rate: The nominal annual interest rate in decimal form (e.g., 7.625% = 0.07625).
//                - y = Loan Term in Years =  How many years the loan lasts.
//                - n = Number of Monthly Payments: This is 12×y (Because there are 12 monthly payments per year.)
//                - i = Monthly Interest Rate: This is the annual interest rate divided by 12, i.e. r/12
//                - Total Interest = (M×n)−P

                System.out.print("Principal loan amount: ");
                int principal = scanner.nextInt();

                System.out.print("Annual interest rate (as a percentage, like 7.625): ");
                double annualRate = scanner.nextFloat();

                System.out.print("Loan length in years: ");
                short years = scanner.nextShort();

                annualRate = (annualRate / 100); //convert from percentage to decimal
                int numberOfMonthlyPayments = (12 * years);
                double monthlyRate = (annualRate / 12);

                double monthlyPayment = (principal * (monthlyRate * Math.pow(1+monthlyRate, numberOfMonthlyPayments)) / (Math.pow(1+monthlyRate, numberOfMonthlyPayments)-1));
                double totalInterest = (monthlyPayment * numberOfMonthlyPayments) - principal ;

                System.out.printf("Expected monthly payment: $%.2f\n", monthlyPayment);
                System.out.printf("Total interest paid: $%.2f", totalInterest);

            case 2:

        }
    }
}

