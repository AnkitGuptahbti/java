package Int.LamdaExpression;

public class Main {
    public static void main(String[] args) {

        // 1st way
        // MyinterImp a=new MyinterImp();
        // a.sayHello();





        // 2nd way
        // // anonymous class ke case may no need to make extra class
        // // anonymss ka use basivally 2nd way
        // MyInter i = new MyInter() {

        // @Override
        // public void sayHello() {
        // System.out.println("this is our first anonymous class");

        // }
        // };
        // i.sayHello();



        

        // 3rd way using lamda expression
        // ye kaam krega only for fun interface(iF FUN>2 THEN USE ANONYMOUS CLASS)
        MyInter lam = () -> {
            System.out.println("this is first tiime i am using lamda");
        };
        lam.sayHello();

        MyInter lam2 = () -> System.out.println("this is second tiime i am using lamda");
        lam2.sayHello();

    }
}
