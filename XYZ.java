public class XYZ {
    public static int maxCountSubarrays(int N, int[] A) {
        int evenCount = 0;
        int maxCount = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] % 2 == 0) {
                evenCount++;
                maxCount = Math.max(maxCount, i - start + 1);
            } else {
                if (evenCount > 0) {
                    evenCount--;
                    maxCount = Math.max(maxCount, i - start + 1);
                } else {
                    start = i + 1;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 7, 9, 11 };
        System.out.println(maxCountSubarrays(arr.length, arr));
    }
}
