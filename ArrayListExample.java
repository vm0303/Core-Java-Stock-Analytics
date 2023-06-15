import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> myFirstArrayList = new ArrayList();
        myFirstArrayList.add("AAPL");
        myFirstArrayList.add("MSFT");
        myFirstArrayList.add("AMD");
        myFirstArrayList.add("SBUX");
        myFirstArrayList.add("MCD");
        myFirstArrayList.add("GOOGL");
        myFirstArrayList.add("TSLA");

        System.out.println(myFirstArrayList);

        myFirstArrayList.remove(3);

        System.out.println("ArrayList after removal of element in position 3 is " + myFirstArrayList);

        myFirstArrayList.remove("MSFT");

        System.out.println("ArrayList after removal of element by MSFT is " + myFirstArrayList);


        myFirstArrayList.remove(2);

        System.out.println("ArrayList after removal of element in position 2 is " + myFirstArrayList);

        System.out.println("Size of Arraylist is " + myFirstArrayList.size());

        if (myFirstArrayList.contains("AAPL"))
        {
            System.out.println("My First Arraylist contains AAPL stock at the position " + myFirstArrayList.indexOf("AAPL"));
        }

        List<String> testList = new ArrayList<>();

        if(testList.isEmpty())
        {
            System.out.println("Test list is empty");
        }

        if(!myFirstArrayList.isEmpty())
        {
            System.out.println("My First Arraylist is not empty.");
        }

        myFirstArrayList.add("V");
        myFirstArrayList.add("META");

        //Way one
        for (int i = 0; i < myFirstArrayList.size(); i++) {
            System.out.println(myFirstArrayList.get(i));
        }

        //Way two

        for (String eachElement : myFirstArrayList) {
            System.out.println("Printing using forEach loop: " + eachElement);
        }


        //Sorting
        Collections.sort(myFirstArrayList);
        System.out.println(myFirstArrayList);

        //DO NOT DO THIS
        //Make sure you add generics -> <String>, or <int>
        ArrayList badArrayList = new ArrayList();
        badArrayList.add("Some string");
        badArrayList.add(new BigDecimal("250"));
        badArrayList.add(Integer.parseInt("5"));

    }
}
