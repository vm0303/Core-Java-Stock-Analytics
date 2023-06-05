import java.math.BigDecimal;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World !!!!!");

        primitivesMethod();

        int i = 6; // This is example of variable definition/declaration and assignment
        int j = 8;

        i = 25; // This is example of an assignment where a value is assigned to a variable
        System.out.println("Sum of i and j is "+(i+j));

        int methodOutput =  multiplyInputs(i,j); //Calling code
        System.out.println("Multiplication result of i and j is "+methodOutput);
        printMultiplicationOutput(i, j); //Calling code

        System.out.println("Square of j is "+calculateSquare(j));

        // Write a method that takes 3 inputs and calculates the sum of all of them and prints their sum
        calculateSum(i, j, 4);
        // Write a method that takes 4 inputs and returns the multiplication output of all the inputs
        int output = multiplicationOf4Numbers(i,j,3,4);
        System.out.println("the multiplication of 4 numbers is "+ output);

        objectCreation();

    }

    private static void objectCreation() {
//        Stock appleStock = new Stock();
        Stock appleStock = new Stock("AAPL","Apple");
//        appleStock.tickerName = "Apple";
//        appleStock.tickerSymbol="AAPL";
        appleStock.marketCap = 2500;
        appleStock.currentRatio = 2.76;
        System.out.println("Is Apple a good stock? "+appleStock.isGoodStock());

        Stock microsoftStock = new Stock();
        microsoftStock.tickerName = "Microsoft Corp";
        microsoftStock.tickerSymbol = "MSFT";
        microsoftStock.marketCap = 2300;
        microsoftStock.currentRatio = 2.1;
        System.out.println("Is Microsoft a good stock? "+microsoftStock.isGoodStock());

        Stock googleStock = new Stock("GOOGL");
        googleStock.tickerName = "Google";
//        googleStock.tickerSymbol = "GOOGL";
        googleStock.marketCap = 1700;
        googleStock.currentRatio = 1.95;
        System.out.println("Is Google stock good?"+googleStock.isGoodStock());

        System.out.println("Print values of marketcap of Apple stock:"+appleStock.marketCap);
        System.out.println("Print values of marketcap of Google stock:"+googleStock.marketCap);
    }

    private static void primitivesMethod() {
        byte k = 84;
        byte l = 53;

        float number1 = 1.01f;
        float number2 = 1.52f;

        double n1 = 1.01, n2 = 1.54;
        System.out.println("Multiplication of 2 doubles is "+(n1*n2));

        BigDecimal num1 = new BigDecimal("1.01");
        BigDecimal num2 = new BigDecimal("1.54");
        System.out.println("Multiplication using Big Decimals, output is "+num1.multiply(num2));

        System.out.println("Sum of 2 bytes k and j is "+(k+l));
        System.out.println("Multiplication of 2 floats number 1 and number 2 is "+(number1*number2));

        boolean var1  = true;
        boolean var2 = false;
        System.out.println("Values of boolean variable var1 is "+var1);
        System.out.println("Values of boolean variable var2 is "+var2);

        String name = "Srikar";
        String anotherName = new String("Srikar");
        char value = 'c';
        System.out.println("Value of the string name is "+name);
    }

    private static int calculateSquare(int input) {
          return input*input;
    }

    public static int multiplyInputs(int input1,int input2){
        int output = input1*input2;
        float i = 154.56f;
        return output;
    }

    public static void printMultiplicationOutput(int input1, int input2){
        int output = input1*input2;
        System.out.println("Multiplication output in the print Multiply method is "+output);
    }

    public static void calculateSum(int input1, int input2, int input3){
        int sum = input1 + input2 + input3;
        System.out.println("The sum of three inputs is "+sum);
    }
    public static int multiplicationOf4Numbers(int input1, int input2, int input3, int input4){
        int output = (input1*input2*input3*input4);
        return output;
    }
}

