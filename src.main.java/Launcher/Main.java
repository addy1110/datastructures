package Launcher;

import util.*;
import System.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Display list = new DisplayCollections(Generator.generateList(Size.SMALL, Order.SORTED));
        System.out.println(list.show());

        Display array = new DisplayArray(Generator.generateArray(Size.SMALL, Order.SORTED));
        System.out.println(array.show());

    }
}