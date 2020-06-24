package com.mattrios;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        float total = -1;
        float paid = -1;
        int change = 0;
        double[] currencies = new double[] {100, 50, 20, 10, 5, 1, .25, .1, .05, .01};

        System.out.println("This application calculates the change required.");
        System.out.println("Please enter a total cost.");

        while (total < 0) {
            try {
                System.out.print("$");
                total = sc.nextFloat();
            }
            catch (Exception e) {
                sc.nextLine();
            }
            if (total < 0) {
                System.out.println("Please enter a valid value");
            }
        }

        System.out.println("Please enter the amount paid.");
        while (paid < total) {
            try {
                System.out.print("$");
                paid = sc.nextFloat();
            }
            catch (Exception e) {
                sc.nextLine();
            }
            if (paid < total) {
                System.out.println("Please enter a valid value");
            }
        }

        System.out.println("Your change consists of: ");

        for(int i = 0; i < currencies.length; i++) {
            change = calcChange(paid, total, currencies[i]);
            System.out.println("$" + currencies[i] + " - " + change);
            paid -= change * currencies[i];
        }
    }

    public static int calcChange (float paid, float total, double currency) {
        int change = 0;
        while (paid - total > currency) {
            change++;
            paid -= currency;
        }
        return change;
    }
}
