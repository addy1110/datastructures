package util;

import java.util.*;
import java.util.stream.IntStream;

public class ArraysDS {
    public static int search(int[] array, int element){
        /*
         * Performs element search in O(n) time complexity
         */

        int position = -1;
        for(int i=0; i<array.length; i++){
            if(array[i] == element)
                return i;
        }
        return -1;
    }

    public static int[] searchWithDuplicates(int[] array, int element){
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<array.length;i++){
            if(array[i] == element){
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] insert(int[] array, int element, int position){
        // create a new array with increased size
        int[] newArray = new int[array.length+1];

        // 1. first copy elements < position
        // 2. insert new element
        // 3. copy remaining elements

        /*
          for(int i=position+1; i<array.length;i++){
            newArray[i] = array[i];
          }
         */
        if (position >= 0) System.arraycopy(array, 0, newArray, 0, position);
        newArray[position] = element;
        for(int i=position+1; i<array.length;i++) newArray[i] = array[i];

        return newArray;
    }


    public static int[] deleteSingle(int[] array, int element){
        int[] newArray = new int[array.length-1];

        // retrieve the index of element which needs to be deleted
        // copy elements to newArray having index < deleted element's index
        // copy rest of elements with immediately next index

        int index = search(array, element);

        if(index<0)
            throw new AssertionError();

        int j=0;
        for(int i=0;i<array.length;i++){
            if(i==index)
                continue;
            newArray[j]=array[i];
            j++;
        }

        return newArray;
    }

    /**
     * 1. Create an empty List
     * 2. loop over array and skip if array[i] == element
     * 3. Convert List to array
     * */
    public static int[] delete(int[] array, int element){
        List<Integer> result = new ArrayList<>();

        for(int i : array){
            if(i== element)
                continue;
            result.add(i);
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    public static int[] reverse(int[] array){
        return null;
    }

    public static void reverse(List<Integer> list){
        if (list == null || list.isEmpty()) return;
        // Time complexity : O(n log(n))
        //Collections.reverse(list);

        // brute force
        reverseBruteForce(list);

        return;
    }

    /**
     * native way to reverse a List
     * Time complexity  : O(n)
     * Space complexity : O(n)  <---> Expensive  </--->
      */
    private static void reverseBruteForce(List<Integer> list){
        List<Integer> reverseCopy = new ArrayList<>(list.size());
        for(int i=list.size()-1; i>=0; i--){
            reverseCopy.add(list.get(i));
        }

        for(int i=0; i<reverseCopy.size(); i++){
            list.set(i,reverseCopy.get(i));
        }
    }

}

