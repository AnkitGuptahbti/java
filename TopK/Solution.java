import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    static class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) {
                return a.num - b.num;
            }
            return b.freq - a.freq;
        });

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> currentTopK = new ArrayList<>();
            int num = arr[i];

            if (!map.containsKey(num)) {
                map.put(num, 1);
                pq.add(new Pair(num, 1));
            } else {
                map.put(num, map.get(num) + 1);

                // Remove and add to update priority in the PriorityQueue
                pq.removeIf(pair -> pair.num == num);
                pq.add(new Pair(num, map.get(num)));
            }

            // Build the currentTopK array
            PriorityQueue<Pair> tempPQ = new PriorityQueue<>(pq);
            int temp = k;
            while (temp > 0 && !tempPQ.isEmpty()) {
                currentTopK.add(tempPQ.poll().num);
                temp--;
            }

            res.add(new ArrayList<>(currentTopK));
        }
        return res;
    }
}







// The time
// complexity of
// your kTop
// function is
// dominated by
// the loop
// that iterates
// over each
// element in
// the input array.Let's
// analyze the
// main operations
// within the loop:

// Inserting into

// the map (map.put) and the

// priority queue (pq.add) takes constant time on average: O(1).
// Removing from the priority queue (pq.poll) takes logarithmic time in the size of the priority queue:

// O(log k).
// Building the currentTopK array involves a loop that runs at most k times. In each iteration, you perform a tempPQ.poll, which is a logarithmic time operation: O(k * log k).
// Since the loop is executed n times, the overall time complexity of your function is O(n * (log k + k * log k)), which simplifies

// to O(n * k * log k).

// In practice, if k is significantly smaller than n, the time complexity can be close to O(n * log k), but it's important to consider both terms in the analysis.

// Note: The actual performance might also depend on the specific implementation details of the priority queue used in Java.