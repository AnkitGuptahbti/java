package sn;
import java.util.ArrayList;

/**
 * kmp
 */
public class kmp {

    int totalMatches(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        int lps[] = lps(pat);
        int cnt = 0;
        int i = 0, j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    cnt++;
                    j = lps[j - 1];
                }
            } else {
                if (j == 0)
                    i++;
                else {
                    j = lps[j - 1];
                }
            }
        }
        return cnt;
    }
    int[] lps(String pat) {
        int n = pat.length();
        int lps[] = new int[n];
        int prevLPS = 0;
        int i = 1;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(prevLPS)) {
                lps[i++] = prevLPS + 1;
                prevLPS++;
            } else {
                if (prevLPS == 0)
                    lps[i++] = 0;
                else
                    prevLPS = lps[prevLPS - 1];
            }
        }
        return lps;
    }

    ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        int lps[] = lps(pat);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    list.add(i - j + 1);
                    j = lps[j - 1];
                }
            } else {
                if (j == 0)
                    i++;
                else {
                    j = lps[j - 1];
                }
            }
        }
        if (list.isEmpty())
            list.add(-1);
        return list;

    }

}