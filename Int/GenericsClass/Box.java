// package Int.GenericsClass;

// public class Box {

//     // Object class is top most parent class of all java cl

//     Object container;

//     public Box(Object container) {
//         this.container = container;

//     }

//     public Object getValue() {
//         return this.container;

//     }

// }


///////////////////////////////////////////////////////////////

//USE GENERIC FOR TYPE SAFETY NOW

package Int.GenericsClass;
public class Box <T> {

    // Object class is top most parent class of all java cl
    
    T container;
    
    public Box(T container) {
    this.container = container;
    
    }
    
    public T getValue() {
    return this.container;
    
    }
    
}