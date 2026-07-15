class Solution {
    Map<Character, Set<Character>> adj = new HashMap<>();
    int[] indegree = new int[26];
    boolean exitEarly = false;
    public String foreignDictionary(String[] words) {
      buildAdjAndIndegree(words);
      if (exitEarly) return "";

      StringBuilder order = new StringBuilder();
      Queue<Character> q = new ArrayDeque<>();
      Set<Character> visited = new HashSet<>();

      for (Map.Entry<Character, Set<Character>> e : adj.entrySet()) {
        char c = e.getKey();
        if (indegree[c - 'a'] == 0) {
          visited.add(c);
          q.add(c);
        }
      }

      while (!q.isEmpty()) {
        Character c = q.poll();
        order.append(c);

        for (char nc : adj.getOrDefault(c, new HashSet<>())) {
            if (visited.contains(nc)) continue;

            indegree[nc - 'a']--;

            if (indegree[nc - 'a'] == 0) {
              visited.add(nc);
              q.add(nc);
            }
        }
      }

      if (order.length() != adj.size()) return "";

      return order.toString();
    }

    private void buildAdjAndIndegree(String[] words) {

      for (String word : words) {
        for (char w : word.toCharArray()) adj.computeIfAbsent(w, k -> new HashSet<>());
      }

      for (int i=1; i<words.length; i++) {
        String w1 = words[i - 1];
        String w2 = words[i];
        int minLen = Math.min(w1.length(), w2.length());

        if (w1.substring(0, minLen).equals(w2.substring(0, minLen)) 
        && w1.length() > w2.length()) {
          exitEarly = true;
          break;
        }

        int idx = 0;

        while (idx < w1.length() && idx < w2.length()) {
          char w1c = w1.charAt(idx), w2c = w2.charAt(idx);
          if (w1c != w2c) {
              adj.putIfAbsent(w1c, new HashSet<>());
              if (adj.get(w1c).add(w2c)) indegree[w2c - 'a']++;

              break;
          }
          idx++;
        }
      }
    }
}
