package sn;

public class ZAlgo {

    public static void main(String[] args) {
        String txt = "abaaa";
        String pat = "aa";
        int matches = totalMatches(pat, txt);
        System.out.println("Total matches: " + matches); // Output: Total matches: 4
    }

    public static int[] zFunction(String s) {

        int n = s.length();
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r)
                z[i] = Math.min(r - i + 1, z[i - l]);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                ++z[i];
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        z[0] = n;
        return z;
    }

    public static int totalMatches(String pat, String txt) {
        int[] zArray = zFunction(pat + txt);
        int patLength = pat.length();
        int count = 0;
        for (int i = patLength; i < zArray.length; i++) {
            if (zArray[i] >= patLength) {
                count++;
            }
        }
        return count;
    }

}
