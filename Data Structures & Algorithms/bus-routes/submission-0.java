class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int numBuses = 0;
        Map<Integer, List<Integer>> stops = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> seenStops = new HashSet<>();
        Set<Integer> seenBuses = new HashSet<>();

        for (int bus=0; bus<routes.length; bus++) {
            for (int stop : routes[bus]) {
                stops.computeIfAbsent(stop, s -> new ArrayList<>()).add(bus);
            }
        }

        q.add(source);
        seenStops.add(source);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i=0; i<n; i++) {
                int stop = q.poll();

                if (stop == target) return numBuses;

                List<Integer> buses = stops.getOrDefault(stop, new ArrayList<>());

                for (int bus : buses) {
                    if (seenBuses.contains(bus)) continue;
                    seenBuses.add(bus);

                    for (int nextStop : routes[bus]) {
                        if (seenStops.contains(nextStop)) continue;

                        q.add(nextStop);
                        seenStops.add(nextStop);
                    }
                }
            }

            numBuses++;
        }

        return -1;
    }
}