package sn;

import java.util.ArrayList;
import java.util.HashMap;

public class RK {
    public static long hashCode(String s) {
        long p = 31;// prime number greater than 31
        long pow = 31;
        long mod = 1000000007;
        long ans = s.charAt(0) - 'a' + 1;
        for (int i = 1; i < s.length(); i++) {
            ans = (ans + (s.charAt(i) - 'a' + 1) * pow) % mod;
            pow = (p * pow) % mod;// pow = (p % mod * pow % mod) % mod; // Prevent overflow
        }
        return ans;
    }

    ArrayList<Integer> search(String pat, String text) {
        long p = 31;// prime number greater than 31
        long pow = 31;
        long mod = 1000000007;
        long hvPat = pat.charAt(0) - 'a' + 1;
        for (int i = 1; i < pat.length(); i++) {
            hvPat = (hvPat + (pat.charAt(i) - 'a' + 1) * pow) % mod;
            pow = (p * pow) % mod;// pow = (p % mod * pow % mod) % mod; // Prevent overflow
        }

        // Rabin karp
        long preHashArr[] = new long[text.length()];
        long ithPow[] = new long[text.length()];
        preHashArr[0] = text.charAt(0) - 'a' + 1;
        ithPow[0] = 1;
        p = 31;
        pow = 31;
        for (int i = 1; i < text.length(); i++) {
            preHashArr[i] = (preHashArr[i - 1] + (text.charAt(i) - 'a' + 1) * pow) % mod;
            ithPow[i] = pow;
            pow = (p * pow) % mod;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int sp = 0, ep = pat.length() - 1;
        while (ep < text.length()) {
            long win = preHashArr[ep];
            if (sp > 0)
                win = (win - preHashArr[sp - 1] + mod) % mod;
            if (win == (hvPat * ithPow[sp]) % mod)
                list.add(sp + 1);
            sp++;
            ep++;
        }

        return list;
    }
    // wc385_4.java

    // longest prefix and suffix using no space
    int lps(String s) {
        int ans = 0;
        int n = s.length();
        if (n == 1)
            return 0;
        long p = 31;
        long pow = 1;
        int mod = 1000000007;
        long ph = 0, sh = 0;
        for (int i = 0; i < n - 1; i++) {
            ph = ((ph * p) + s.charAt(i) - 'a' + 1) % mod;
            sh = (sh + (s.charAt(n - i - 1) - 'a' + 1) * pow) % mod;
            if (ph == sh)
                ans = i + 1;
            pow = (p * pow) % mod;
        }
        return ans;
    }

}