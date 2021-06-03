/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Liam Pido
 */

/*
Exercise 10 - Self-Checkout

Working with multiple inputs and currency can introduce some tricky precision issues.

Create a simple self-checkout system. Prompt for the prices and quantities of three items. Calculate the subtotal of the items.
Then calculate the tax using a tax rate of 5.5%. Print out the line items with the quantity and total, and then print out the subtotal, tax amount, and total.

Example Output

Enter the price of item 1: 25
Enter the quantity of item 1: 2
Enter the price of item 2: 10
Enter the quantity of item 2: 1
Enter the price of item 3: 4
Enter the quantity of item 3: 1
Subtotal: $64.00
Tax: $3.52
Total: $67.52

Constraints

Keep the input, processing, and output parts of your program separate.
Collect the input, then do the math operations and string building,and then print out the output.
Be sure you explicitly convert input to numerical data before doing any calculations.

Challenges

Revise the program to ensure that prices and quantities are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
Alter the program so that an indeterminate number of items can be entered. The tax and total are computed when there are no more items to be entered.
 */

package base;

import java.util.Formatter;
import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        App myApp = new App();

        double subtotal = 0;

        for(int i = 1; i <= 3; i++) {
            subtotal += myApp.input(i);
        }

        double tax = myApp.processing(subtotal);

        myApp.output(subtotal, tax);
    }

    public void output(double subtotal, double tax) {
        System.out.format("Subtotal: $%.2f", subtotal);
        System.out.print("\n");
        System.out.format("Tax: $%.2f", tax);
        System.out.print("\n");
        System.out.format("Total: $%.2f", (subtotal + tax));
    }

    public double processing(double subtotal) {
        double rate = 0.055;
        return (subtotal * rate);
    }

    public double input(int i) {
        Formatter format = new Formatter();

        String d = String.format("%d", i);
        System.out.print("Enter the price of item " + d + ": ");
        String input = in.nextLine();
        double price = Double.parseDouble(input);

        System.out.print("Enter the quantity of item " + d + ": ");
        input = in.nextLine();
        double quantity = Double.parseDouble(input);

        double ret = (price * quantity);
        return ret;
    }
}
