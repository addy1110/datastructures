package core.Collections;

import java.util.*;

public final class CollectionFactory {
    public static Collection<?> getInstance(CollectionType type){
        return switch (type) {
            case ARRAY_LIST -> new ArrayList<>();
            case LINKED_LIST -> new LinkedList<>();
            case HASH_SET -> new HashSet<>();
            case LINKED_HASH_SET -> new LinkedHashSet<>();
            default -> null;
        };
    }

    public static Collection<?> getInstance(CollectionType type, int capacity) {
        if(capacity <=0)
            return getInstance(type);

        return switch (type) {
            case ARRAY_LIST -> new ArrayList<>(capacity);
            case LINKED_LIST -> new LinkedList<>();
            case HASH_SET -> new HashSet<>(capacity);
            case LINKED_HASH_SET -> new LinkedHashSet<>(capacity);
            default -> null;
        };
    }


    public static int[] getIntArray( int capacity) {
        if(capacity <=0)
            throw new AssertionError("Please provide valid array size");

        return new int[capacity];
    }


}
