package sn;

import java.util.*;

public class wc385_4 {

}

class Solution {
    // most efficeint
    // public long countPrefixSuffixPairs(String[] words) {
    // long ans = 0;
    // HashMap<Long, Integer> cts = new HashMap<>();
    // HashMap<Long, Long> revs = new HashMap<>();
    // // long mod = 9999999900000001L;
    // long mod=1000000007;
    // for (String s : words) {
    // int n = s.length();
    // long p = 31;
    // long pow = 1;
    // long hash = 0;
    // long rhash = 0;
    // for (int i = 0; i < n; i++) {
    // hash = (hash + (s.charAt(i) - 'a' + 1) * pow) % mod;
    // rhash = (rhash + (s.charAt(n - i - 1) - 'a' + 1) * pow) % mod;
    // pow = (pow * p) % mod;
    // if (revs.containsKey(hash) && revs.get(hash) == rhash) {
    // ans += cts.get(hash);
    // }
    // }
    // revs.put(hash, rhash);
    // cts.put(hash, cts.getOrDefault(hash, 0) + 1);
    // }

    // return ans;
    // }

    // public long countPrefixSuffixPairs(String[] words) {
    // HashMap<Long, Long> map = new HashMap<>();
    // long ans = 0;
    // long mod = 1000000007;// not accepted 9999999900000001L,999999989L
    // accepted=999999989L ,1000000007

    // for (int k = words.length - 1; k >= 0; k--) {
    // String s = words[k];
    // int n = s.length();
    // long[] preHashArr = new long[n];
    // long[] ithPow = new long[n];
    // preHashArr[0] = s.charAt(0) - 'a' + 1;
    // ithPow[0] = 1;
    // long p = 31;
    // long pow = 31;

    // for (int i = 1; i < n; i++) {
    // preHashArr[i] = (preHashArr[i - 1] + (s.charAt(i) - 'a' + 1) * pow) % mod;
    // ithPow[i] = pow;
    // pow = (p * pow) % mod;
    // }
    // // System.out.println(Arrays.toString(preHashArr));
    // // System.out.println(Arrays.toString(ithPow));

    // for (int i = 0; i < n; i++) {
    // long pre = preHashArr[i];
    // long suf = 0;
    // if (n - i - 2 >= 0) {
    // suf = (preHashArr[n - 1] - preHashArr[n - i - 2] + mod) % mod;
    // pre = (pre * ithPow[n - i - 1]) % mod;
    // }
    // if (pre == suf || i == n - 1) {
    // if (i == n - 1 && map.containsKey(preHashArr[i]))
    // ans = ans + map.get(preHashArr[i]);
    // map.put(preHashArr[i], map.getOrDefault(preHashArr[i], 0L) + 1);
    // }
    // }
    // // System.out.println(" for k " +k+" "+map);
    // }
    // return ans;
    // }

    long[] preHashArr;
    long[] ithPow;
    long mod = 1000000007;

    void preCalculation(String s) {
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

    long hashQuery(int l, int r) {
        long ans = preHashArr[r];
        if (l > 0) {
            ans = (ans - preHashArr[l - 1] + mod) % mod;
        }
        return ans;
    }

    public long countPrefixSuffixPairs(String[] words) {
        HashMap<Long, Long> map = new HashMap<>();
        long ans = 0;
        for (int k = words.length - 1; k >= 0; k--) {
            String s = words[k];
            int n = s.length();
            preHashArr = new long[n];
            ithPow = new long[n];
            preCalculation(s);
            for (int i = 0; i < n; i++) {
                long pre = preHashArr[i];
                long suf = hashQuery(n - i - 1, n - 1);

                if ((pre * ithPow[n - i - 1]) % mod == suf) {
                    if (i == n - 1 && map.containsKey(preHashArr[i]))
                        ans = ans + map.get(preHashArr[i]);
                    map.put(preHashArr[i], map.getOrDefault(preHashArr[i], 0L) + 1);
                }
            }
        }
        return ans;
    }

}