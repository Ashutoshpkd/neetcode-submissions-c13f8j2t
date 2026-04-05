class ZigzagIterator {

    private boolean[] hasElements;
    private List<List<Integer>> vectors;
    private int[] indices;
    private int iIdx;
    private final int VECTORS = 2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.vectors = new ArrayList<>();
        this.hasElements = new boolean[2];
        this.indices = new int[2];
        this.iIdx = 0;
        this.vectors.add(v1); this.vectors.add(v2);

        for (int i=0; i<2; i++) {
            if (this.vectors.get(i).size() > 0) this.hasElements[i] = true;
            this.indices[i] = 0;
        }
    }

    public int next() {
        iIdx = iIdx % VECTORS;
        int idx = iIdx;
        int element = -1, prevIdx = -1;

        while (prevIdx != idx) {
            idx = idx % VECTORS;
            if (prevIdx == -1) prevIdx = idx;
            
            if (!this.hasElements[idx]) {
                idx++;
                continue;
            }
            List<Integer> vector = this.vectors.get(idx);
            int currIdx = indices[idx];
            element = vector.get(currIdx++);
            indices[idx] = currIdx;

            if (currIdx >= vector.size()) {
                this.hasElements[idx] = false;
            }
            idx++; break;
        }
        iIdx = idx;    
        return element;
    }

    public boolean hasNext() {
        boolean hasElem = false;
        for (int i=0; i<VECTORS; i++) hasElem = hasElem || this.hasElements[i];

        return hasElem;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
