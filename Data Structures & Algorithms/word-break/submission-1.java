class Solution {
    Boolean[] cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        cache = new Boolean[s.length() + 1];
        return dfs(s, 0, wordSet);
    }

    private boolean dfs(String s, int idx, Set<String> wordSet) {
        if (idx >= s.length()) return true;
        if (cache[idx] != null) return cache[idx];

        for (int i=idx; i<=s.length(); i++) {
            if (wordSet.contains(s.substring(idx, i))
            && dfs(s, i, wordSet)) return cache[idx] = true;
        }

        return cache[idx] = false;
    }
}
