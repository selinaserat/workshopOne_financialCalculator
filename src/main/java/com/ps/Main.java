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
                double InterestRate = scanner.nextDouble();

                System.out.print("Loan length in years: ");
                short loanLength = scanner.nextShort();

                InterestRate = (InterestRate / 100); //convert from percentage to decimal
                int numberOfMonthlyPayments = (12 * loanLength);
                double monthlyRate = (InterestRate / 12);

                double monthlyPayment = (principal * (monthlyRate * Math.pow(1+monthlyRate, numberOfMonthlyPayments)) / (Math.pow(1+monthlyRate, numberOfMonthlyPayments)-1));
                double totalInterest = (monthlyPayment * numberOfMonthlyPayments) - principal ;

                System.out.printf("Expected monthly payment: $%.2f\n", monthlyPayment);
                System.out.printf("Total interest paid: $%.2f", totalInterest);
                break;

            case 2:
//               FV = P × (1 + (r / 365))^(365 × t)
//                 Future Value (FV)
//                 Principal (P): This is the initial deposit amount.
//                 Annual Interest Rate (r): The nominal annual interest rate in decimal form (e.g., 1.75% = 0.0175).
//                 Number of Years (t): The total number of years the deposit will earn interest.
//                 Days Per Year: Daily compounding assumes 365 days per year.
//                 Total Number of Days: This is 365 × t (because there are 365 days per year).
//                 Total Interest Earned = FV - P

                System.out.print("Deposit amount: ");
                double cdPrincipal = scanner.nextFloat();

                System.out.print("Annual interest rate (as a percentage, like 1.75): ");
                double cdInterestRate = scanner.nextDouble();

                System.out.print("Number of years: ");
                short cdYears = scanner.nextShort();

                cdInterestRate = cdInterestRate / 100;
                double totalDays = 365 * cdYears;

                double futureValue = cdPrincipal * (Math.pow(1+(cdInterestRate/365), totalDays));
                double totalInterestEarned =  futureValue - cdPrincipal;

                System.out.printf("Future value of CD: $%.2f\n", futureValue);
                System.out.printf("Total interest earned: $%.2f", totalInterestEarned);
                break;

            default:
                System.out.println("Invalid command, please try again");
        }
    }
}

