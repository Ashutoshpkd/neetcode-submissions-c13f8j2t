class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        int[] pMax = new int[n];
        int[] nMax = new int[n];

        pMax[0] = height[0];
        nMax[n - 1] = height[n - 1];

        for (int i=1; i<n; i++) pMax[i] = Math.max(pMax[i - 1], height[i]);
        for (int i=n-2; i>=0; i--) nMax[i] = Math.max(nMax[i + 1], height[i]);
        for (int i=0; i<n; i++) water += Math.min(pMax[i], nMax[i]) - height[i];
        
        return water;
    }
}