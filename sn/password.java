package sn;

import java.util.*;

public class password {
    static long[] preHashArr;
    static long[] ithPow;
    static long mod = 1000000007;

    public static void main(String[] args) {
        int ans = -1;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();// fixprefixsuffix
        int n = s.length();
        preCalculation(s);
        for (int i = 0; i < n - 1; i++) {
            long pre = preHashArr[i];
            long suf = hashQuery(n - i - 1, n - 1);
            if ((pre * ithPow[n - i - 1]) % mod == suf) {
                for (int j = 1, k = i + 1; k < n - 1; k++, j++) {
                    long mid = hashQuery(j, k);
                    if ((preHashArr[i] * ithPow[j]) % mod == mid) {
                        ans = i + 1;
                        break;
                    }
                }
            }
        }
        if (ans == -1) {
            System.out.println("Just a legend");
            return;
        }
        System.out.println(s.substring(0, ans));
    }

    static long hashQuery(int l, int r) {
        long ans = preHashArr[r];
        if (l > 0) {
            ans = (ans - preHashArr[l - 1] + mod) % mod;
        }
        return ans;
    }

    static void preCalculation(String s) {
        int n = s.length();
        preHashArr = new long[n];
        ithPow = new long[n];
        long p = 31;
        long pow = 31;
        preHashArr[0] = s.charAt(0) - 'a' + 1;
        ithPow[0] = 1;
        for (int i = 1; i < n; i++) {
            preHashArr[i] = (preHashArr[i - 1] + (s.charAt(i) - 'a' + 1) * pow) % mod;
            ithPow[i] = pow;
            pow = (p * pow) % mod;
        }
    }
}