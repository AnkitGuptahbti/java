

// User function Template for Java
//😊😊😊 PRIMS ALGO
// class Solution{
//  int spanningTree(int V, int E, int edges[][]) {
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//         for (int i = 0; i < V; i++)
//             adj.add(new ArrayList<Pair>());

//         boolean vis[] = new boolean[V];
//         for (int it[] : edges) {
//             int u = it[0];
//             int v = it[1];
//             int d = it[2];
//             adj.get(u).add(new Pair(v, d));
//             adj.get(v).add(new Pair(u, d));
//         }
//         int sum = 0;
//         PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dis - y.dis);
//         pq.add(new Pair(0, 0));
//         while (!pq.isEmpty()) {
//             int node = pq.peek().node;
//             int dis = pq.peek().dis;
//             pq.poll();
//             if(vis[node])continue;
//             vis[node]=true;
//             sum = sum + dis;
            
//             for (Pair it : adj.get(node)) {
//                 int adjNode = it.node;
//                 int wei = it.dis;
//                 if (!vis[adjNode]) {
//                     pq.add(new Pair(adjNode, wei));
//                 }
//             }
//         }
//         return sum;
//     }
// }

// class Pair {
//     int node;
//     int dis;

//     public Pair(int node, int dis) {
//         this.node = node;
//         this.dis = dis;
//     }
// }









// //😊😊kruskal using unionByRank
// class Solution {
//     int spanningTree(int V, int E, int edges[][]) {

//         ArrayList<Triple> list = new ArrayList<>();
//         for (int i = 0; i < E; i++) {
//             list.add(new Triple(edges[i][0], edges[i][1], edges[i][2]));
//         }
//         Collections.sort(list, (x, y) -> x.dis - y.dis);
//         int sum = 0;
//         DisjointSet ds = new DisjointSet(V);
//         for (Triple it : list) {
//             int u = it.start;
//             int v = it.end;
//             int wei = it.dis;
//             if (ds.findParent(u) != ds.findParent(v)) {
//                 sum = sum + wei;
//                 ds.unionByRank(u, v);
//             }
//         }
//         return sum;
//     }
// }

//  class DisjointSet {
//     int parent[];
//     int rank[];

//     DisjointSet(int n) {
//         parent = new int[n + 1];// n+1 for working 0 and 1 based indexing
//         for (int i = 0; i < n + 1; i++)
//             parent[i] = i;
//         rank = new int[n + 1];
//     }

//     int findParent(int node) {
//         if (parent[node] == node)
//             return node;
//         return parent[node] = findParent(parent[node]);// path compression.
//     }

//     void unionByRank(int u, int v) {
//         int ulp_u = findParent(u);
//         int ulp_v = findParent(v);
//         if (ulp_u == ulp_v)
//             return;

//         if (rank[ulp_u] < rank[ulp_v]) {
//             parent[ulp_u] = ulp_v;
//         } else if (rank[ulp_u] > rank[ulp_v]) {
//             parent[ulp_v] = ulp_u;
//         } else {
//             parent[ulp_v] = ulp_u;
//             rank[ulp_u]++;
//         }
//     }
// }

// class Triple {
//     int start;
//     int end;
//     int dis;

//     Triple(int start, int end, int dis) {
//         this.start = start;
//         this.end = end;
//         this.dis = dis;
//     }
// }










//😊😊kruskal using unionBySize
class Solution {
    int spanningTree(int V, int E, int edges[][]) {

        ArrayList<Triple> list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            list.add(new Triple(edges[i][0], edges[i][1], edges[i][2]));
        }
        Collections.sort(list, (x, y) -> x.dis - y.dis);
        int sum = 0;
        DisjointSet ds = new DisjointSet(V);
        for (Triple it : list) {
            int u = it.start;
            int v = it.end;
            int wei = it.dis;
            if (ds.findParent(u) != ds.findParent(v)) {
                sum = sum + wei;
                ds.unionBySize(u, v);
            }
        }
        return sum;
    }
}

 class DisjointSet {
    int parent[];
    int rank[];
    int size[];
    

    DisjointSet(int n) {
        parent = new int[n + 1];// n+1 for working 0 and 1 based indexing
        for (int i = 0; i < n + 1; i++)
            parent[i] = i;
        rank = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);
    }

    int findParent(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = findParent(parent[node]);// path compression.
    }

    void unionByRank(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;

        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
    void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] = size[ulp_u] + size[ulp_v];
        }
        // equal and greater
        else {
            size[ulp_u] = size[ulp_u] + size[ulp_v];
            parent[ulp_v] = ulp_u;

        }
    }
}

class Triple {
    int start;
    int end;
    int dis;

    Triple(int start, int end, int dis) {
        this.start = start;
        this.end = end;
        this.dis = dis;
    }
}
