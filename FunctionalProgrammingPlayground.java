import java.math.BigDecimal;
import java.util.function.*;

public class FunctionalProgrammingPlayground {
    public static void main(String[] args) {
        //Supplier: Takes no input and returns a result of Type T. Use to generate values like infinite streams
        System.out.println("Random value generated from a method is " + generateRandomValue());
        Supplier<Double> generateRandomValueBySupplier = () -> Math.random();
        System.out.println("Random value generated from a method using the Supplier Interface is " + generateRandomValueBySupplier.get());


        String str1 ="Vishal";
        System.out.println("Is " + str1 + " a long string? " + isThisALongString(str1));

        //Using functional interface Predicate - Takes a single input of type T and returns a boolean
        Predicate<String> isThisALongStringPredicate = s -> s.length() > 10;
        System.out.println("Is " + str1 + " a long string using a Predicate Interface? " + isThisALongStringPredicate.test(str1));
        BigDecimal testNumber = new BigDecimal("100");

        //Using functional interface BiPredicate - Takes 2 arguments of type T and U, returns a boolean
        System.out.println("Is the lame logic true or false? " + evaluateSomeLameLogic(str1, testNumber));
        BiPredicate<String, BigDecimal> lameLogicBPD = (inputString, inputBigDecimal) -> inputString.length()*Integer.parseInt(inputBigDecimal.toString()) > 1000;
        System.out.println("Is the lame logic true or false using BiPredicate? " + lameLogicBPD.test(str1, testNumber));


        System.out.println("The output of the doSomething function is " + doSomethingFunctionUsingString(str1));

        //Demo if doSomething function using Function Interfaces
        Function<String, Integer> stringLengthI = String::length;
        //Chain using andThen to pair two Function Interfaces
        Function<String, Integer> doSomethingFunction = stringLengthI.andThen(len -> len*10);
        System.out.println("The output of the doSomething function using chained Functional interfaces is " + doSomethingFunction.apply(str1));

        //Using Function interface - Takes a single input of type T and returns a result of another type R
        Function<String , Integer> doSomethingFuncViaFunc =s -> s.length()*10;
        System.out.println("Output of the doSomething using the Function interface is " + doSomethingFuncViaFunc.apply(str1));
        System.out.println("The output of the lame calculation is "  +  doSomeLameCalc(str1, testNumber));

        //Using Function interface - Takes 2 arguments of Type T and U, produces a result of type R
        BiFunction<String, BigDecimal, Integer> doLameCalcBiFunction = (inputString, inputBigDecimal) ->
        {
          Integer bigDecimalRep = Integer.parseInt(inputBigDecimal.toString());
          return inputString.length()*bigDecimalRep;
        };

        System.out.println("The output of the lame calculation using BiFunction is " + doLameCalcBiFunction.apply(str1,testNumber));


        printStringValue(str1);

        //Consumer using Lambda
        Consumer<String> printConsumerUsingLambda = s -> System.out.println("Output of my name using a consumer interface and lambda function: " + s);
        printConsumerUsingLambda.accept(str1);
        //Consumer using Functional Interface
        Consumer<String> printConsumerUsingFunctionInterface= System.out::println;
        printConsumerUsingFunctionInterface.accept("Output of my name using a consumer interface WITHOUT a lambda function: "+ str1);
    }

    private static void printStringValue(String inputStr1) {
        System.out.println("My name is " + inputStr1);
    }

    private static int doSomeLameCalc(String inputString, BigDecimal inputTestNumber) {
        return inputString.length()*Integer.parseInt(inputTestNumber.toString());
    }

    private static int doSomethingFunctionUsingString(String inputString)
    {
        return inputString.length()*10;
    }

    private static boolean evaluateSomeLameLogic(String inputStr1, BigDecimal inputTestNumber)
    {
        return inputStr1.length()*Integer.parseInt(inputTestNumber.toString()) > 1000;
    }

    private static boolean isThisALongString(String inputString)
    {
        return inputString.length() > 10;
    }

    private static double generateRandomValue() {

        return Math.random();
    }
}
