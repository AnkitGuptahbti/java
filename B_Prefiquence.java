import java.util.Scanner;

/**
 * B_Prefiquence
 */
public class B_Prefiquence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String a = scanner.next();
            String b = scanner.next();
            int result = maxPrefixSubsequence(n, m, a, b);
            System.out.println(result);
        }
        scanner.close();
    }

    private static int maxPrefixSubsequence(int n, int m, String a, String b) {
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i;
    }
}