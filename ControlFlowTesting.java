import java.math.BigDecimal;

public class ControlFlowTesting {
    public static void main(String[] args) {

        //The statements below checks if i is either ever or not
        int i = 5;
        boolean isEven = ((i&2)==0);
        System.out.println("Is " + i + " even? " + isEven);

        if (i%2==0)
        {
            System.out.println("The number " + i + " is even.");
        }
        else
        {
            System.out.println("The number " + i + " is odd.");
        }

        if(i%2==0|| i>10) // Or statement
        {
            System.out.println("The number " +i + " is even or greater than 10");
        }
        else
        {
            System.out.println("The number " +i + " is not even or less than 10");
        }

        int j = 3;
        if(j==3)
        {
            System.out.println("Value of j is 3");
        }
        else
        {
            System.out.println("Value of j is NOT 3");
        }

        String str1 = "Vishal";
        String str2 = "Vishal";

        if(str1 == str2)
        {
            System.out.println("Both strings are equal");
        }
        else {
            System.out.println("Both strings are not equal");
        }

        String str3 = "Vishal";
        String str4 = new String("Vishal");

        if(str3 == str4)
        {
            System.out.println("Both strings are equal");
        }
        else {
            System.out.println("Both strings are not equal");
        }

        Stock appleStock1 = new Stock("MSFT", "Apple Inc.");
        Stock appleStock2 = new Stock("AAPL", "Apple Inc.");

        if (appleStock1 == appleStock2)
        {
            System.out.println("Both stocks are the same");
        }
        else
        {
            System.out.println("Both stocks are different.");
        }
        // using .equals()
        if (appleStock1.equals(appleStock2))
        {
            System.out.println("Both stocks are the same using .equals()");
        }
        else
        {
            System.out.println("Both stocks are different using .equals().");
        }
        if (appleStock1.equals(null))
        {
            System.out.println("Apple Stock2 is equal to null.");
        }
        else
        {
            System.out.println("Apple stock 1 is not equal to null");
        }

        if (appleStock2.equals(appleStock1))
        {
            System.out.println("Both stocks are the same using .equals()");
        }
        else
        {
            System.out.println("Both stocks are different using .equals().");
        }
        if (appleStock2.equals(new BigDecimal(100)))
        {
            System.out.println("Apple Stock 2 is equal to Big Decimal 100.");
        }
        else
        {
            System.out.println("Apple Stock 2 is not equal to Big Decimal 100.");
        }

        int z=0;
        while(z<10)
        {
            System.out.println("Printing this with value of z: " + z);
            z++;
        }

        Stock appleStock = new Stock("AAPL", "Apple Inc.");
        Stock microsoftStock = new Stock("MSFT", "Microsoft Corp.");
        Stock googleStock = new Stock("GOOGL", "Google Inc.");

        stockBuyingSuggestion(appleStock);
        stockBuyingSuggestion(microsoftStock);
        stockBuyingSuggestion(googleStock);


        printPrimeNumbers(10);

        String ifValue;
        int roundedNumber;
        double originalRandomNumber = Math.random();
        if(originalRandomNumber> 0.5)
        {
           roundedNumber = 1;
           ifValue = "Greater than 0.5";
        }
        else
        {
            roundedNumber = 0;
            ifValue = "Less than 0.5";
        }
        //Using Ternary operator (format would be (boolean expression)? Value if true: Value if false
        int roundedTernaryNumber =(originalRandomNumber > 0.5)?1:0;

        String ifTernaryValue = (originalRandomNumber > 0.5)? "Greater than 0.5": "Less than 0.5";
        System.out.println("The rounded number is " + roundedNumber+ " and the original random number is " + originalRandomNumber);
        System.out.println("The rounded ternary number is " + roundedTernaryNumber+ " and the original random number is " + originalRandomNumber);
        System.out.println("The string value from the original random number " + originalRandomNumber + " is: " + ifTernaryValue);


    }

    /**
     * Using this method to demonstrate how continue and break statements work in loops.
     * @param limit - Helps determine where to break or continue the method
     */
    private static void printPrimeNumbers(int limit)
    {
        boolean isPrime;
        for (int i = 1; i < limit ; i++)
        {
            if(i==1)
            {
                isPrime=false;
                continue; //Continues statement skips all the code after it, and jumps to the next iteration of the loop
            }
            isPrime = true;
            for (int j = 2; j < i ; j++) {
                if (i%j ==0)
                {
                    isPrime = false;
                    break; //Breaks statement out of the entire loop without running any next iteration at all.
                }
            }
            if (isPrime)
            {
                System.out.println("The number " + i + " is a prime." );
            }
        }
    }


    private static void stockBuyingSuggestion(Stock inputStock) {

        //using if else blocks
        if (inputStock.getTickerSymbol().equals("AAPL"))
        {
            System.out.println("Buy this stock");
        }
        else if (inputStock.getTickerSymbol().equals("MSFT"))
        {
            System.out.println("Hold this stock");
        }
        else if (inputStock.getTickerSymbol().equals("GOOGL"))
        {
            System.out.println("Sell this stock");
        }

        //Using switch statements
        switch (inputStock.getTickerSymbol())
        {
            case ("AAPL") -> System.out.println("Buy this stock from switch.");
            case ("MSFT") -> System.out.println("Hold this stock from switch.");
            case ("GOOGL") -> System.out.println("Sell this stock from switch.");
        }
    }
}
