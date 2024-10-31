import java.util.Scanner;
 
public class Main {
    public static void solution(String s1) {
        String st = updatedstring(s1);
        int[] lps = new int[st.length()];
        int c = 0;
        int r = 0;
 
        for (int i = 1; i < st.length() - 1; i++) {
            int mirr = c - (i - c);
            if (i < r) {
                lps[i] = Math.min(lps[mirr], r - i);
            }
 
            while (st.charAt(i + lps[i] + 1) == st.charAt(i - lps[i] - 1)) {
                lps[i]++;
            }
 
            if (i + lps[i] > r) {
                c = i;
                r = i + lps[i];
            }
        }
        int maxlen = 0;
        int maxidx = 0;
 
        for (int i = 1; i < lps.length - 1; i++) {
            if (lps[i] > maxlen) {
                maxlen = lps[i];
                maxidx = i;
            }
        }
 
        // System.out.println(maxlen);
 
        int firstidx = maxidx - maxlen + 1;
        int actidx = (firstidx - 2) / 2;
 
        System.out.println(s1.substring(actidx, actidx + maxlen));
    }
 
    public static String updatedstring(String st) {
        StringBuilder sb = new StringBuilder();
        sb.append("@");
        for (int i = 0; i < st.length(); i++) {
            sb.append("#");
            sb.append(st.charAt(i));
        }
 
        sb.append("#");
        sb.append("$");
 
        return sb.toString();
    }
 
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        solution(s1);
    }
}
