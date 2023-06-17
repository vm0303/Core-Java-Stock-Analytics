import java.math.BigDecimal;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

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

        //Using functional interfaces
        //Note: MultiplyInputs can be replaced by an BinaryOperator, as it takes 2 int inputs and returns an output.
        BinaryOperator<Integer> multiplyInputsBO = (number1, number2) -> number1*number2;

        System.out.println("Multiplication result of i and j using a binary operator is "+ multiplyInputsBO.apply(i,j));


        printMultiplicationOutput(i, j); //Calling code

        BiConsumer<Integer, Integer> printMultiplicationOutputBC = (input1, input2) ->
        {
            Integer result = input1* input2;
            System.out.println("Multiplication Output via a BiConsumer is " + result);
        };
        printMultiplicationOutputBC.accept(i,j);

        System.out.println("Square of j is "+calculateSquare(j));

        UnaryOperator<Integer> calculateSquareUO = num1 -> num1*num1;

        System.out.println("Square of j by using an unary operator is " +calculateSquareUO.apply(j));

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
        appleStock.setMarketCap(2500);
        appleStock.setCurrentRatio(2.76);
        System.out.println("Is Apple a good stock? "+appleStock.isGoodStock());
        appleStock.printStockDetails();

        System.out.println("Value coming from the Stock class is " + Stock.value);
        System.out.println("Value of someWords given to static method is " + Stock.printSomeWords("Whatever"));

        Stock microsoftStock = new Stock();
        microsoftStock.setTickerName("Microsoft Corp");
        microsoftStock.setTickerSymbol("MSFT");
        microsoftStock.setMarketCap(2300);
        microsoftStock.setCurrentRatio(2.1);
        System.out.println("Is Microsoft a good stock? "+microsoftStock.isGoodStock());
        microsoftStock.printStockDetails();



        Stock googleStock = new Stock("GOOGL");
        googleStock.setTickerName("Google");
//        googleStock.tickerSymbol = "GOOGL";
        googleStock.setMarketCap(1700);
        googleStock.setCurrentRatio(1.95);
        System.out.println("Is Google stock good?"+googleStock.isGoodStock());
        googleStock.printStockDetails();

        System.out.println("Print values of marketcap of Apple stock:"+ appleStock.getMarketCap());
        System.out.println("Print values of marketcap of Google stock:"+ googleStock.getMarketCap());
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

        String name = "Vishal";
        String anotherName = new String("Vishal");
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

