import java.util.Scanner;

/**
 * A_Maximize
 */
public class A_Maximize {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 

        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt(); 
            System.out.println(x - 1);
        }
    }
}