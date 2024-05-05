package Int.InterfaceMehtod;

/**
 * Developer
 */
public interface Developer {

    void devlop();
    default void init(){
        System.out.println("i am default method");
    }
    static void staticfun(){
        System.out.println(" i am static from pareent");
    }
    
}