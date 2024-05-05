package sn;

public class rev {
    
    static void reverse(long a[]) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            long t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

}
