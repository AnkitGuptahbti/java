import java.util.Scanner;

public class D_Permutation_Game {
    static void solve(Scanner scanner) {

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int pos = scanner.nextInt();
        int pos2 = scanner.nextInt();

        long[] a = new long[n + 1];
        long[] p = new long[n + 1];
        long s = 0, s2 = 0, ansBo = 0, ansSasha = 0;

        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextLong();
        }

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
        }

        for (int i = 0; i < Math.min(k, n); i++) {
            s += a[pos];
            s2 += a[pos2];
            ansBo = Math.max(ansBo, s + a[pos] * (k - i - 1));
            ansSasha = Math.max(ansSasha, s2 + a[pos2] * (k - i - 1));
            pos = (int) p[pos];
            pos2 = (int) p[pos2];
        }
        System.out.println(ansBo+" n");

        if (ansBo < ansSasha) {
            System.out.println("Sasha");
            return;
        }
        if (ansSasha < ansBo) {
            System.out.println("Bodya");
            return;
        }
        System.out.println("Draw");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            solve(scanner);
        }
    }
}
