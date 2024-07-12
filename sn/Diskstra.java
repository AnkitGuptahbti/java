class Diskstra{
int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    int[] dist = new int[V];
    boolean[] visited = new boolean[V];
    
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[S] = 0;
    pq.add(new int[]{S, 0});

    while (!pq.isEmpty()) {
        int[] current = pq.poll();
        int node = current[0];
        int distance = current[1];

        if (visited[node]) {
            continue;
        }
        visited[node] = true;

        for (ArrayList<Integer> neighbor : adj.get(node)) {
            int adjNode = neighbor.get(0);
            int edgeWeight = neighbor.get(1);

            if (!visited[adjNode] && distance + edgeWeight < dist[adjNode]) {// && distance+edgeWeight<disappers[adjNode] can be adde if required
                dist[adjNode] = distance + edgeWeight;
                pq.add(new int[]{adjNode, dist[adjNode]});
            }
        }
    }
    return dist;
}

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
}
