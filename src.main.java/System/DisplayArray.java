package System;

import java.util.Arrays;

public class DisplayArray implements Display{
    private int[] array;

    public DisplayArray(int[] a){
        array = a;
    }

    public int[] get(){
        return array;
    }

    public void setArray(int[] a){
        array = a;
    }

    public String validate(){
        if(array == null)
            return "Cannot traverse <null> array";
        return null;
    }

    public String show(){
        String errorMsg = validate();
        if(errorMsg != null)
            throw new AssertionError(errorMsg);

        return Arrays.toString(array);
    }
}
