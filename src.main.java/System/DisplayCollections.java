package System;

import java.util.Collection;
import java.util.List;

public class DisplayCollections implements Display {

    private final Collection<?> collection;

    public DisplayCollections(Collection<?> collection){
        this.collection = collection;
    }

    public Collection<?> get(){
        return this.collection;
    }

    @Override
    public String validate(){
        if (collection == null)
            return "Cannot traverse <null> collection ";
        if (collection.isEmpty())
            return "Cannot traverse empty collection";
        return null;
    }

    @Override
    public Collection<?> getCollection() {
        return collection;
    }

    @Override
    public int[] getArray() {
        return new int[0];
    }


    @Override
    public String show(){
        String errorMessage = validate();
        if(errorMessage != null)
            throw new AssertionError(errorMessage);

        int length = collection.size()-1;
        StringBuilder sb = new StringBuilder("[");

        for(Object o : collection){
            sb.append(o);
            length--;
            if(length == -1)
                return sb.append("]").toString();
            sb.append(",");
        }
        return sb.toString();
    }
}
