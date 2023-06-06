import java.util.Arrays;

public class StringManipulations
{
    public static void main(String[] args) {
        String firstString = "Hello";
        String secondString = "World";
        String concatString = firstString + secondString; // String concatenation


        System.out.println("Concatenated string output of the first and second string is " + concatString);
        System.out.println("Uppercase Concatenated string output of the first and second string is " + concatString.toUpperCase()); //Create a new String object with the
        // uppercase values and does NOT change the original object.
        System.out.println("Concatenated string output of the first and second string is " + concatString); // Prints original value, as String is immutable
        System.out.println("Length of the string is " + concatString.length());
        System.out.println("The character at position 2 is " + concatString.charAt(2));
        System.out.println("The character at position 2 is " + concatString.charAt(5));
        System.out.println("Does the string starts with Hel? " + concatString.startsWith("Hel"));
        System.out.println("Does the string ends with ld? " + concatString.startsWith("ld"));
        System.out.println("Does the string ends with ld? " + concatString.startsWith("Ld")); //Case-sensitive - This will return false
        System.out.println("Does the string ends with ld? " + concatString.toUpperCase().endsWith("Ld".toUpperCase()));
        System.out.println("Does the string ends with ld? " + concatString.toUpperCase().endsWith("Ld".trim().toUpperCase()));
        System.out.println("First version of substring " +concatString.substring(4)); //begin index is always inclusive, counts from 0.
        System.out.println("Another version of Substring is" + concatString.substring(4,concatString.length()));
        System.out.println("Second version of subString " + concatString.substring(3,7)); //EndIndex is exclusive (counts from one)

        //Split strings with de-limiter

        String stockString  = "AAPL, GOOGL, MSFT,TSLA,V";
        String[] splitString = stockString.split(",");
        System.out.println("Values in Stocks string are "+ Arrays.toString(splitString));

        String specialCharacterString = "AAPL|GOOGL|MSFT|V|TSLA"; //Pipe symbol is the delimiter, and it will be interpreted as a special function.
        String[] splitCharArray = specialCharacterString.split("\\|"); // Adding two \\ to signify an escape character for | pipe.
        System.out.println("Values in Special Char String are " + Arrays.toString(splitCharArray));


    }
}
