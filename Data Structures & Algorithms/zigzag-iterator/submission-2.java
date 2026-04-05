class ZigzagIterator {

    private List<List<Integer>> vectors = new ArrayList<>();
    private LinkedList<Pair<Integer, Integer>> idxQueue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        vectors.add(v1); vectors.add(v2);

        for (int i=0; i<2; i++) {
            if (vectors.get(i).size() > 0) idxQueue.addLast(new Pair<>(i, 0));
        }
    }

    public int next() {
        Pair<Integer, Integer> currIdx = idxQueue.removeFirst();
        int vectorIdx = currIdx.getKey();
        int posIdx = currIdx.getValue();

        List<Integer> vector = this.vectors.get(vectorIdx);
        int nextElement = vector.get(posIdx++);

        if (posIdx < vector.size()) this.idxQueue.addLast(new Pair<>(vectorIdx, posIdx));

        return nextElement;
    }

    public boolean hasNext() {
        return idxQueue.size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
