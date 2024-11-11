package util;

public enum Size {
    GALACTIC(10000000),
    GIGANTIC(1000000),
    HUGE(100000),
    LARGE(10000),
    MEDIUM(1000),
    REGULAR(100),
    SMALL(25),
    TINY(10);

    public final int value;

    private Size(int value){
        this.value = value;
    }
}
