/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        if (intervals.size() == 0) {
            return result;
        }

        sortInterval(intervals, 0, intervals.size() - 1);

        int lastStartTime = intervals.get(0).start;
        int lastEndTime = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if (interval.start <= lastEndTime) {
                if (interval.end > lastEndTime) {
                    lastEndTime = interval.end;
                }
            } else {
                result.add(new Interval(lastStartTime, lastEndTime));
                lastStartTime = interval.start;
                lastEndTime = interval.end;
            }
        }

        result.add(new Interval(lastStartTime, lastEndTime));

        return result;
    }

    private void sortInterval(List<Interval> intervals, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        int pivot = intervals.get(mid).start;

        int i = left, j = right;

        while (i < j) {
            while (intervals.get(i).start < pivot) {
                i++;
            }
            while (intervals.get(j).start > pivot) {
                j--;
            }

            if (i <= j) {
                Interval temp = intervals.get(i);
                intervals.set(i, intervals.get(j));
                intervals.set(j, temp);

                i++;
                j--;
            }
        }

        sortInterval(intervals, left, j);
        sortInterval(intervals, i, right);
    }
}
