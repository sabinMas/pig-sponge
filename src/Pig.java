public class Pig {

    /*
    * Create a method "pigLatin" that takes a string consisting of one or more 
    * all-lowercase words separated by spaces. It should return a new string 
    * converted to "pig Latin," where each word has its first letter moved to 
    * the back and the letters "ay" are added to the end of the word. However, 
    * words starting with a vowel (a, e, i, o, or u) should not be altered.
    *
    * Examples:
    *
    * pigLatin("something")  should return "omethingsay"
    * pigLatin("awesome")    should return "awesome" (words starting with a vowel should not be altered)
    * pigLatin("latin is a hard language")  should return "atinlay is a ardhay anguagelay"
    * pigLatin("y")  should return "yay"
    * pigLatin("e")   should return "e"
    */
    public static void main(String[] args) {
        // Test cases
        assertEqual(1, pigLatin("something"), "omethingsay");
        assertEqual(2, pigLatin("awesome"), "awesome");
        assertEqual(3, pigLatin("latin is a hard language"), "atinlay is a ardhay anguagelay");
        assertEqual(4, pigLatin("y"), "yay");
        assertEqual(5, pigLatin("e"), "e");
    }

    // Implement your solution here!
    // Cracking the Coding Interview Notes
    // Big O notation this would be O(n) where n = sentence length
    // using StringBuilder (O(n)) rather than result += (O(n^2))
    // helperMethod should be constant O(1) time

    public static String pigLatin(String sentence) {
        String [] words = sentence.split(" "); //creates words array by using sentence 
        StringBuilder result = new StringBuilder(""); //create empty string builder to hold result 
        
        for(int i = 0; i< words.length; i++) {  // for each word in sentence array, using i for spacing
            result.append(helperMethod(words[i])); // adds the changed word from helper method to the string builder

            if(i < words.length - 1) { //if not last word add a space
                result.append(" "); 
            }
        }
        return result.toString();
    }
    // first = word.charAt(0)
    // if first ===> a,e,i,o,u then add word to result 
    private static String helperMethod (String word) {
        if (word.isEmpty()) return "";

        char first = word.charAt(0);
        if ("aeiou".indexOf(first)!= -1){ //if the first letter of the word we are checking is in the string 'aeiou' then return word
            return word; // -1 means character not found 
        }
        return word.substring(1) + first + "ay";
    }
    
    // Method to help with testing, you do not need to read this.
    public static void assertEqual(int testNumber, String actual, String expected) {
        if (!expected.equals(actual)) {
        System.out.println("Test " + testNumber + " failed! Expected: '" + expected + "', but got: '" + actual + "'");
        } else {
        System.out.println("Test " + testNumber + " passed!");
        }
    }
    }
  
  