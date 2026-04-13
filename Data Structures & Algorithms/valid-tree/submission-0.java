class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = createAdj(edges, n);
        Set<Integer> visited = new HashSet<>();
        if (dfs(adj, visited, 0, -1)) return false;

        return visited.size() == n;
    }

    private boolean dfs(List<Integer>[] adj, Set<Integer> visited, int node, int parent) {
        if (visited.contains(node)) return true;

        visited.add(node);

        for (int i=0; i<adj[node].size(); i++) {
            int child = adj[node].get(i);

            if (child == parent) continue;

            if (dfs(adj, visited, child, node)) return true;
        }

        return false;
    }

    private List<Integer>[] createAdj(int[][] edges, int n) {
        List<Integer>[] adj = new List[n];

        for (int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        return adj;
    }
}
