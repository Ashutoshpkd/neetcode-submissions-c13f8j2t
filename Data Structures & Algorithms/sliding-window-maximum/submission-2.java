class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        for (int i=0; i<nums.length; i++) {


            while (!dq.isEmpty() && (i - dq.peek() >= k)) dq.poll();
            while (!dq.isEmpty() && (nums[i] > nums[dq.peekLast()])) dq.pollLast();

            dq.offer(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
