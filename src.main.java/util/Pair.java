package util;

public class Pair<T,V> {
    private T first;
    private V second;

    public Pair(T firstItem, V secondItem){
        first = firstItem;
        second =  secondItem;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond(){
        return second;
    }

    public void setFirst(T t){
        first = t;
    }

    public void setSecond(V v){
        second = v;
    }
}
