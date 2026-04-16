class Solution {
    public int countComponents(int n, int[][] edges) {
        int numConnected = 0;
        List<Integer>[] adj = getAdj(edges, n);
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                numConnected++;
                q.add(i);
                visited[i] = true;
                bfs(q, visited, adj);
            }
        }

        return numConnected;
    }

    private void bfs(Queue<Integer> q, boolean[] visited, List<Integer>[] adj) {

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i=0; i<adj[node].size(); i++) {
                int neigh = adj[node].get(i);

                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(neigh);
                }
            }
        }
    }

    private List<Integer>[] getAdj(int[][] edges, int n) {
        List<Integer>[] adj = new List[n];

        for (int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        return adj;
    }
}
