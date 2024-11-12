package Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ArraysDS;
import util.Order;
import util.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import System.Generator;
import util.SortType;

class ArraysDSTest {

    private static final int[] array = new int[]{1,25,63,78,96,46,25,33,156,96};
    private static final int[] sorted_array = new int[]{
            1, 3, 5, 9, 12, 45, 89, 99, 123, 654,
            987, 1234, 2589, 3214, 3654, 5469, 4789, 5687, 6987, 8945,
            32145, 35468, 45612, 56412, 98745, 123456, 321456, 546123, 987456, 1234567};


    private static void printTimeTaken(long time, String msg){
        System.out.println(msg+time+"ms");
    }

    @Test
    @DisplayName("Testing single search array")
    void searchTest() {
        Assertions.assertEquals(3, ArraysDS.search(array,78));
    }

    @Test
    @DisplayName("Test search with duplicates array")
    void searchWithDuplicatesTest(){
        int element = 25;
        int[] expected = new int[]{1,6};
        int[] actual = ArraysDS.searchWithDuplicates(array,element);
        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    @DisplayName("Testing insert multi positions array")
    void insertTest() {
        int[] local_array = Arrays.copyOf(array, array.length);
        int element = 5;
        int randomPosition = 3;
        int midPosition = array.length/2;
        int[] positionArray = new int[]{0,randomPosition,midPosition, array.length-1};
        Assertions.assertAll(()-> {
            for (int j : positionArray) {
                int elementAtInsertedPosition = ArraysDS.insert(array, element, j)[j];
                //System.out.println("element/position: "+element+"/"+j+" element found: "+elementAtInsertedPosition);
                Assertions.assertEquals(element, elementAtInsertedPosition);
            }
        });
    }

    @Test
    @DisplayName("Testing single delete array")
    void deleteSingleTest(){
        int[] local_array = Arrays.copyOf(array, array.length);
        int element = 156;
        Assertions.assertEquals(-1, ArraysDS.search(ArraysDS.deleteSingle(local_array,element),element));
    }

    @Test
    @DisplayName("Test duplicate delete array")
    void deleteTest(){
        int [] local_array = Arrays.copyOf(array, array.length);
        int elementToDelete = 25;
        int[] actual = ArraysDS.delete(local_array, elementToDelete);
        int[] expected = new int[]{1,63,78,96,46,33,156,96};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test List reverse in-place")
    void reverseListTest(){
        List<Integer> original = Generator.generateList(Size.GIGANTIC, Order.RANDOM);

        List<Integer> expectedCopy = new ArrayList<>(original);
        Collections.reverse(expectedCopy);

        //ArraysDS.reverse(original); // brute force HUGE(29ms), GIGANTIC(91ms)
        Collections.reverse(original); // took HUGE(26ms), GIGANTIC(67)ms
        Assertions.assertIterableEquals(expectedCopy, original);
    }

    @Test
    @DisplayName("Testing array reverse")
    void reverseArrayTest(){
        int[] original = Generator.generateArray();
        int[] originalCopy = Arrays.copyOf(original,original.length);
        ArraysDS.reverse(original);
        ArraysDS.reverse(original);
        Assertions.assertArrayEquals(originalCopy,original);

    }

    @Test
    @DisplayName("Testing array sorting")
    void sortTest(){
        long start = System.currentTimeMillis();

        int[] original = Generator.generateArray(Size.HUGE, Order.NORMAL);

        int[] originalCopy = Arrays.copyOf(original,original.length);

        long s1 = System.currentTimeMillis();
        Arrays.sort(originalCopy);
        long s2 = System.currentTimeMillis();
        ArraysDS.sort(original, SortType.BUBBLE_SORT);
        long s3 = System.currentTimeMillis();

        printTimeTaken(s2-s1,"Time to sort System.Quick: ");
        printTimeTaken(s3-s2, "Time to sort using bubble: ");

        Assertions.assertArrayEquals(originalCopy, original);
    }

}