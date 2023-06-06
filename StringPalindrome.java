public class StringPalindrome
{
    public static void main(String[] args) {
        String wordOne= "Ababa";
        String wordTwo = "Vishal";
        String wordThree = "NaAn";

        wordOne = wordOne.toLowerCase();
        boolean isWordOne = isPalindrome(wordOne);
        System.out.println("Is " + wordOne + " a palindrome? " + isWordOne);

        wordTwo = wordTwo.toLowerCase();
        boolean isWordTwo = isPalindrome(wordTwo);
        System.out.println("Is " + wordTwo + " a palindrome? " + isWordTwo);

        wordThree = wordThree.toLowerCase();
        boolean isWordThree = isPalindrome(wordThree);
        System.out.println("Is " + wordThree + " a palindrome? " + isWordThree);


    }

    public static boolean isPalindrome(String word)
    {
        //The variable below will store the reverse part of the original string
        String reverseWord = "";

        //Initialize a boolean to determine if the string is a palindrome or not
        boolean result = false;

        //The for loop will read the original string word in reverse order based on what string index it is at.
        for (int i = word.length()-1; i >= 0; i--) {
            reverseWord = reverseWord + word.charAt(i);
        }
        // The if statement determines whether the string word and the reversed string word are the same or not
        // For a palindrome, it needs to be the same
        if(word.equals(reverseWord))
        {
            result = true;
        }
        return result;
    }
}
