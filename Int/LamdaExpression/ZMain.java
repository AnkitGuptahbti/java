package Int.LamdaExpression;

public class ZMain {
    public static void main(String[] args) {
        // ZSumInter i = (int a, int b) -> {
        //     return a + b;
        // };
        //ZSumInter i = (int a, int b) ->   a + b:
        ZSumInter i = ( a,  b)->a + b;
       System.out.println( i.sum(10, 10));

       ZlengthInter j=a->a.length();
       System.out.println(j.len("asdfdg"));

    }
}
