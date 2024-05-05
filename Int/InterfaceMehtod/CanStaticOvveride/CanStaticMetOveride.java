package Int.InterfaceMehtod.CanStaticOvveride;

class Parent {
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    // @Override//In Java, you cannot override static methods; you can only hide
    // them
    static void staticMethod() {
        System.out.println("Static method in Child");
    }
}

public class CanStaticMetOveride {
    public static void main(String[] args) {
        Parent.staticMethod(); 
        Child.staticMethod(); 
    }
}
// It is because the static method is bound with class whereas instance method
// is bound with an object.