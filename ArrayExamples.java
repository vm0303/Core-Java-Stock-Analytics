import java.util.Arrays;

public class ArrayExamples {
    public static void main(String[] args) {
        int [] firstArr = new int[]
                {
                        1,2,3,4,5,6,7,8,9
                };
        int [] squareArray = new int[10];

        for (int i = 0; i< firstArr.length; i++)
        {
            System.out.println("Value in position " + i + " in firstArr " + firstArr[i]);
        }
        for (int i = 0; i< firstArr.length; i++)
        {
          squareArray[i] = firstArr[i]*firstArr[i];
        }
        for (int i = 0; i < squareArray.length; i++) {
            System.out.println(squareArray[i]);
        }

        System.out.println("Contents of the square array are: " + Arrays.toString(squareArray));

        String[] stockArray = new String[]
                {
                "AAPL","MSFT", "TSLA", "GOOGL", "AMZN"
                };


        for (String eachItem : stockArray) {
            System.out.println(eachItem);

        }

        String[] anotherStringArray = new String[10];

        for (int i = 0; i < firstArr.length; i++) {
            anotherStringArray[i] = "Test " + firstArr[i];
        }
        System.out.println("Contents of the anotherString array are: " + Arrays.toString(anotherStringArray));
    }
}
