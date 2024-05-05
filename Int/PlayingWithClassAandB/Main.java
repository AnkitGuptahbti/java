package Int.PlayingWithClassAandB;

public class Main {
    public static void main(String[] args) {
        A obj1 = new B();
        obj1.m1();
        obj1.m2();
        obj1.ov();
        System.out.println();
        B obj4 = new B();
        obj4.m1();
        obj4.m2();
        obj4.m3();
        obj4.m4();
        obj4.ov();
        System.out.println();

        A obj2 = new A();//easy
        obj2.ov();
        System.out.println();

        // The third line would result in a compilation error because you're trying to assign a superclass object to a subclass reference without casting.
        // B obj3 = new A();//not possible 
        B obj3 = (B) obj1;
        obj3.m1();
        obj3.m3();
        obj3.ov();
    }
}


//diff
// B objB = (B) objA; 
// and B obj4 = new B(); any difference
// The first line involves casting an existing reference variable to a different type.
// The second line simply creates a new object of the specified type.

//B objB = (B) objA; // Casting objA to type B
//B objB = (B) objA; // Casting objA to type B