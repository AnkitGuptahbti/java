package Int.GenericsClass;

public class Main {
    public static void main(String[] args) {
        //Box obj=new Box("ankit");
        // System.out.println(obj.getClass());class Int.GenericsClass.Box
        //System.out.println(obj.getValue());


        //Box obj2=new Box(10);//abhi int hai
        //obj2.container="ankit";//ab tumne strinf pass kr diya ||type  safety ki mkc

        //thats why we are using generic 



        Box<Integer> obj2=new Box<Integer>(10);//abhi int hai
        //obj2.container="ankit";//not possible now
        System.out.println(obj2.getValue());

    }
}
