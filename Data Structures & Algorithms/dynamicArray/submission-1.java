class DynamicArray {

    private int capacity;
    private int size;
    private int[] array;

    public DynamicArray(int capacity) {
        array = getArray(capacity);
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        if (i >= this.size) {
            this.size++;
        }

        this.array[i] = n;
    }

    public void pushback(int n) {
        if (this.capacity == this.size) {
            resize();
        }
        this.array[this.size] = n;
        this.size++;
    }

    public int popback() {
        final int lastEle = this.array[this.size - 1];
        this.size--;
        return lastEle;
    }

    private void resize() {
        int[] oldArray = Arrays.copyOf(this.array, this.capacity);
        this.array = getArray(this.capacity * 2);

        for (int idx=0; idx<this.capacity; idx++) {
            this.array[idx] = oldArray[idx];
        }
        this.capacity = 2 * this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private int[] getArray(final int size) {
        return new int[size];
    }
}
