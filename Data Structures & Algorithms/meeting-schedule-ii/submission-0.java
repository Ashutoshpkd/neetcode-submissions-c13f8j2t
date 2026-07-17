/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        int onGoing = 0, maxOnGoing = 0;
        int sIdx = 0, eIdx = 0;

        for (int i=0; i<intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        // s = [0, 5, 15]
        // e = [10, 20, 40]
        while (sIdx < start.length && eIdx < end.length) {
            if (start[sIdx] < end[eIdx]) {
                sIdx++;
                onGoing++;

                maxOnGoing = Math.max(maxOnGoing, onGoing);
            } else {
                eIdx++;
                onGoing--;
            }
        }

        return maxOnGoing;
        
    }
}
