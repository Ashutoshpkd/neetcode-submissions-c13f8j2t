class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        for (int i=0; i<nums.length; i++) {

            // [3]
            // [3,1]
            while (!dq.isEmpty() && (nums[i] > nums[dq.peek()]
            || (i - dq.peek() >= k))) dq.poll();

            while (!dq.isEmpty() && (nums[i] > nums[dq.peekLast()]
            || (i - dq.peekLast() >= k))) dq.pollLast();

            dq.offer(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peek()];
            }
        }

        return res;
    }
}
