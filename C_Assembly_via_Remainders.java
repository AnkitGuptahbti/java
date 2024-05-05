import java.util.Scanner;

/**
 * C_Assembly_via_Remainders
 */
public class C_Assembly_via_Remainders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[] v = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            v[i] = scanner.nextInt();
        }
        int[] a = new int[n];
        int k = (int) 1e8 + v[n - 2];
        a[n - 1] = k;
        for (int i = n - 2; i >= 0; i--) {
            int p = a[i + 1] - v[i];
            a[i] = p;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
            if (i < n - 1)
                System.out.print(" ");
        }
        System.out.println();
    }
}