package com.zipcodewilmington;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        //Use hash
        HashSet<String> hashset = new HashSet<>();
        // add each element in the string object array as values in hashmap
        for (String element: array){
            //if the element is not already in the set then add it
            hashset.add(element);
            }
            //when all unique elements have been added to the set
            //check to see if the parameter value is contained in the set
        // if the value is in the set return true otherwise return false
            return hashset.contains(value);
        }


    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        //start with an example
        //{"The", "quick","brown", "fox"}
        // make a copy of the parameter array (pArrayCopy)
        String[] pArrayCopy = new String[array.length];
        // reverse the order of the array in pArrayCopy
        for(int i = 0; i < array.length; i++){
            pArrayCopy[i] = array[(array.length - 1) - i];
        }
        return pArrayCopy;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String temp = null;
        //Describe how a solution would look
        // Start with an example
        //{"my", "oh","my"} -> {"my", "oh","my"}

        // find index of the middle element
        int lastElem = array.length - 1;
        int midIndex = 0 + (lastElem - 0)/2;
        String[] pArrayCopy = array.clone();

        // while we are not at the middle switch the last element with the first
        for (int i = 0; i != midIndex; i++){
            //swap function
            temp = array[i];
            array[i] = array[lastElem - i];
            array[lastElem - i] = temp;
        }
        // we know the parameter array is the same backward and forward if after it runs through
        //our swap method the output is the same as the input.
        return Arrays.equals(pArrayCopy, array);
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        /** Sample of solution
         * {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"}
         *  Brute force:
         *         We could combine every word in the array:
         *         {"thequickbrownfoxjumpsoverthelazydog"}
         *         sort the resulting combination so that it's in alphabetical order
         *         remove all duplicates (by using hashset)
         *         convert each letter to lowercase
         *         then for each letter in the lowercase alphabet
         *         if it's not present in the hashset return false
**/

        // optimize solution
        //We could combine every word in the array
        String pArrayX = Arrays.toString(array);
        char [] pArrayString = pArrayX.toCharArray();
        ////{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"} ->
        //"thequickbrownfoxjumpsoverthelazydog"

        //set every letter to lowercase and
        //add each letter to a hashset to remove all duplicates
        HashSet<Character> noDupes = new HashSet<>();
        for (char letter : pArrayString){
            if(Character.isLetter(letter)) {
                noDupes.add(Character.toLowerCase(letter));
            }
        }
        //if hashset size is == the number of letters in the alphabet
        // then it is Pangramic otherwise it is not
        int alphabetSize = 26;
        if (noDupes.size() == alphabetSize){
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        /**
         * Brute Force:
         * Sample Problem/Solution:
         * {"Will the ","real", "Slim Shady"," please stand up", " ... ",
         * "will the real" "Slim Shady"}
         * Value = "Slim Shady"
         * iterate through the String array and every time
         * the current element equals value then occurCount++
         */
        /**
         * Optimize
         * Take the String[] and place every element in a HashMap as the key.
         * if the key in the HashMap already exists upon trying to place
         * increment the value of the key by one
         */
        HashMap <String, Integer> frequency = new HashMap<>();
        frequency.put(value, 0);
        for(String word : array){
            if(word.equals(value)) {
                frequency.put(word, frequency.get(word) + 1);
            }
        }


        return frequency.get(value);
    }

    /**
     * @param array array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        /**
         * Brute force:
         * Count the number of times value to Remove appears in String array
         * set new array length to old array length w/ outcome of above step
         * iterate through the String[] if word.equals(valueToRemove) continue
         * otherwise add to new array until end of String[]
         */
        int elemToRemove = StringArrayUtils.getNumberOfOccurrences(array, valueToRemove);
        String[] newArray = new String[array.length - elemToRemove];
        int i = 0;
        for(String word : array){
            if(word.equals(valueToRemove)){
                continue;
            } else{
                newArray[i] = word;
                i++;
            }
        }
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        /**
         * Brute force:
         * Sample:
         * {"money", "money", "money", "must", "be", "funny", "in", "the", "rich", "man's", "world"}
         * Start from index 1, go through String[] if previous value is the same as current
         * then consecDupe++. Then create a new String[] of length array.length - consecDupe
         * iterate through the array once more if previous value is the !same as current
         * copy into newArray
         */
        int consecDupe = 0;
        for (int i = 1; i < array.length; i++){
            if (array[i].equals(array[i-1])){
                consecDupe++;
            }
        }
        String[] newArray = new String[array.length - consecDupe];
        String prev = null;
        int i = 0;
        for (String s : array){
            if (!s.equals(prev)){
                prev = s;
                newArray[i++] = s;
            }
        }

        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        /**
         * Brute force:
         * Sample:
         * {"money", "money", "money", "must", "be", "funny", "in", "the", "rich", "man's", "world"}
         * Solved with a lot of back and forth between testing and fiddling. Will refine
         * logic when I am less tired.
         */
        int consecDupe = 0;
        for (int i = 1; i < array.length; i++){
            if (array[i].equals(array[i-1])){
                consecDupe++;
            }
        }
        String[] newArray = new String[array.length - consecDupe];
        StringBuilder consecWords = new StringBuilder(30);
        int j = 0;
        String prev = array[0];
        consecWords.append(prev);

        for (int i = 1; i < array.length; i++){
         // aaabccaad -> aaa b cc aa d
            if (array[i].equals(array[i-1])){
                consecWords.append(array[i]);
            } else {
                newArray[j++] = consecWords.toString();
                consecWords.setLength(0);
                prev = array[i];
                consecWords.append(prev);
            }
            }
        newArray[j++] = consecWords.toString();

        return newArray;
    }


}
