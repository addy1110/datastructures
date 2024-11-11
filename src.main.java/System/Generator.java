package System;

import util.Order;
import util.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Generator {

    private static List<Integer> initializeList(Integer size){
        return new ArrayList<>(size);
    }

    private static int[] initializeArray(int size){
        return new int[size];
    }

    public static List<Integer> generateList(){
        return generateList(Size.TINY, Order.NATURAL);
    }

    public static List<Integer> generateList(Size size, Order order){
        long start = System.currentTimeMillis();
        List<Integer> list = initializeList(size.value);
        //List<Integer> list = new ArrayList<>();
        Random random = new Random();
        /*for(int i=0; i<size.value; i++){
            switch (order){
                case RANDOM : { list.add(random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE)) break;}
                case NATURAL: { list.add(random.nextInt(0, Integer.MAX_VALUE)) break;}
                case NORMAL : { list.add(random.nextInt(0,1000)) break;}
                case SORTED : { list.add(i) break;}
            }
        }*/

        switch (order) {
            case RANDOM: {
                for (int i = 0; i < size.value; i++) list.add(random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
                break;
            }
            case NATURAL: {
                for (int i = 0; i < size.value; i++) list.add(random.nextInt(1, Integer.MAX_VALUE));
                break;
            }
            case NORMAL: {
                for (int i = 0; i < size.value; i++) list.add(random.nextInt(1, 1000));
                break;
            }

            case SORTED: {
                int prev = 0;
                for (int i = 0; i < size.value; i++) {
                    list.add(i, prev + random.nextInt(0, i+1));
                    prev = list.get(i);
                }
                break;
            }

        }

        long end = System.currentTimeMillis();
        long timeTaken = end - start;
        System.out.println("Time to generate a List: "+timeTaken+"ms");
        return list;
    }

    public static int[] generateArray(){
        return generateArray(Size.SMALL, Order.NORMAL);
    }

    public static int[] generateArray(Size size, Order order){
        long start = System.currentTimeMillis();
        int[] array = initializeArray(size.value);
        Random random = new Random();
        switch (order) {
            case RANDOM: {
                for (int i = 0; i < size.value; i++) array[i] = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
                break;
            }
            case NATURAL: {
                for (int i = 0; i < size.value; i++) array[i] = random.nextInt(1, Integer.MAX_VALUE);
                break;
            }
            case NORMAL: {
                for (int i = 0; i < size.value; i++) array[i] = random.nextInt(1, 1000);
                break;
            }

            case SORTED: {
                int prev = 0;
                for (int i = 0; i < size.value; i++) {
                    array[i] = prev + random.nextInt(0, i+1);
                    prev = array[i];
                }
                break;
            }
        }

        long end = System.currentTimeMillis();
        long timeTaken = end - start;
        System.out.println("Time to generate an array: "+timeTaken+"ms");
        return array;
    }

}
