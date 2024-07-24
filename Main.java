
//cnt char
// PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
//    Scanner sc=new Scanner(System.in);
// for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
//                  int num = entry.getKey();
//                  int frequency = entry.getValue();
// }

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {

    int[] dx2 = { 1, 0, -1, 0 };
    int[] dy2 = { 0, -1, 0, 1 };

    int[] dx4 = { 1, 1, 0, -1, -1, -1, 0, 1 };
    int[] dy4 = { 0, -1, -1, -1, 0, 1, 1, 1 };

    private ArrayList<ArrayList<ArrayList<Integer>>> buildGraph(int n, int[][] edges) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], time = edge[2];
            graph.get(u).add(new ArrayList<>(Arrays.asList(v, time)));
            graph.get(v).add(new ArrayList<>(Arrays.asList(u, time)));
        }
        return graph;
    }
 private ArrayList<ArrayList<Integer>> buildGraph(int n, int[][] edges) {
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int it[] : edges) {
            int u = it[0] - 1;
            int v_ = it[1] - 1;
            adj.get(u).add(v_);
            adj.get(v_).add(u);
        }
     return adj;
 }
    // start>>// finding diameter of graph og given edges
     private int getDiameter(ArrayList<ArrayList<Integer>> adj, int n) {
        int depth[] = new int[n];
        boolean vis[] = new boolean[n];
        dfs(adj, n, 0, depth, vis);
        int max_d = -1;
        int thatnode = -1;
        for (int i = 0; i < n; i++) {
            if (max_d < depth[i]) {
                max_d = depth[i];
                thatnode = i;
            }
        }
        Arrays.fill(depth, 0);
        Arrays.fill(vis, false);
        dfs(adj, n, thatnode, depth, vis);
        max_d = -1;
        for (int i = 0; i < n; i++) {
            if (max_d < depth[i]) {
                max_d = depth[i];
            }
        }
        return max_d;

    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int n, int node, int depth[], boolean vis[]) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                depth[it] = depth[node] + 1;
                dfs(adj, n, it, depth, vis);
            }
        }
    }

    //end >>/////// finding diameter of graph og given edges


    //start>>// finding lcs of given edegs tree

    int lcs(adj,int a,int b,int n){
        int parent[]=new int[n];
        dfs(adj,-1,vis,parent[]);
        ArrayList<> list1=path(int a,parent[])
        
    }
    void dfs(adj,int parent,boolean vis[],int parent[]){
        vis[nod]=true;
        parent[node]=parent;
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(adj, node, vis, parent);
            }
        }
    }

    ArrayList<> path(int node,int parent[]){
      ArrayList  list=new ...;
        while(node!=-1){
            list.add(node);
            node=parent[node];
        }
        Collections.reverse(list)//1 3 5 7
            return list;
    )}
    
    
     //end>>// finding lcs of given edegs tree


    /////////////lowerbound and uppar bound/////////////


private static int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }






    ///////////////////////////////////////////
    

    

    public boolean[] findAnswer(int n, int[][] edges) {

        ArrayList<ArrayList<ArrayList<Integer>>> adj = buildGraph(n, edges);
        boolean[] res = new boolean[edges.length];

        // rest code
        return res;
    }

    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num <= 3)
            return true;

        if (num % 2 == 0 || num % 3 == 0)
            return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    int[] fillPrime(int tilln) {
        int isP[] = new int[tilln];
        for (int i = 1; i <= tilln; i++) {
            if (isPrime(i))
                isP[i] = 1;
        }
        return isP;
    }

    int[] pref(int arr[]) {
        int n = arr.length;
        int pre[] = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        return pre;
    }

    int que(int pre[], int l, int r) {
        int sum = pre[r];
        if (l > 0) {
            sum = sum - pre[l - 1];
        }
        return sum;
    }

    long[] pref(long arr[]) {
        int n = arr.length;
        long pre[] = new long[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }
        return pre;
    }

    long que(long pre[], int l, int r) {
        long sum = pre[r];
        if (l > 0) {
            sum = sum - pre[l - 1];
        }
        return sum;
    }

    // reverse prefix
    long[] rpref(int arr[]) {
        int n = arr.length;
        long pre[] = new long[n];
        pre[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            pre[i] = pre[i + 1] + arr[i];
        }
        return pre;
    }

    public String findLatestTime(String s) {
        String res = "";
        int n = s.length();
        int ch1 = s.charAt(0);
        int ch2 = s.charAt(1);
        int ch3 = s.charAt(3);
        int ch4 = s.charAt(4);

        if (ch1 == '?') {
            res = "0";
            if (ch2 == '?') {
                res += "9";
            } else {
                res += ch2;
            }
        } else {
            res = ch1 + "";
            if (ch2 == '?') {
                res += 2;
            } else {
                res += ch2;
            }
        }

        return res;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }

        return maxHeap.peek();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        
    }

}
