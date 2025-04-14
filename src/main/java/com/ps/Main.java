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
//                - Total Interest = (M×n)−P

                System.out.print("Principal loan amount: ");
                int principal = scanner.nextInt(); // "P" in the formula

                System.out.print("Annual interest rate (as a percentage, like 7.625): ");
                double InterestRate = scanner.nextDouble(); // "r"

                System.out.print("Loan length in years: ");
                short loanLength = scanner.nextShort(); // "y"

                InterestRate = (InterestRate / 100); //convert from percentage to decimal
                int numberOfMonthlyPayments = (12 * loanLength); // "n"
                double monthlyRate = (InterestRate / 12); // "i"

                double monthlyPayment = (principal * (monthlyRate * Math.pow(1+monthlyRate, numberOfMonthlyPayments)) / (Math.pow(1+monthlyRate, numberOfMonthlyPayments)-1)); // "M'
                double totalInterest = (monthlyPayment * numberOfMonthlyPayments) - principal ;

                System.out.printf("Expected monthly payment: $%.2f\n", monthlyPayment);
                System.out.printf("Total interest paid: $%.2f", totalInterest);
                break;

            case 2:
//               FV = P × (1 + (r / 365))^(365 × t)
//                 Future Value (FV)
//                 Total Interest Earned = FV - P

                System.out.print("Deposit amount: ");
                double cdPrincipal = scanner.nextFloat(); // "P"

                System.out.print("Annual interest rate (as a percentage, like 1.75): ");
                double cdInterestRate = scanner.nextDouble(); // "r"

                System.out.print("Number of years: ");
                short cdYears = scanner.nextShort(); // "t"

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

