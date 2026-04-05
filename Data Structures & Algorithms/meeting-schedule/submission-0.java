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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) return true;
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        Interval i1 = intervals.get(0);

        for (int i=1; i<intervals.size(); i++) {
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) return false;

            i1 = i2;
        }

        return true;
    }
}
