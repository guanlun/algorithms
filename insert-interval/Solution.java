public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int len = intervals.size();

        if (len == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int insertIndex = len;

        for (int i = 0; i < len; i++) {
            Interval interval = intervals.get(i);

            if (interval.start > newInterval.start) {
                insertIndex = i;
                break;
            }
        }

        boolean isLast = true;

        if (insertIndex != len) {
            isLast = false;

            int endTime = newInterval.end;

            for (int i = insertIndex; i < intervals.size(); i++) {
                Interval nextInterval = intervals.get(i);

                if (nextInterval.start <= newInterval.end) {
                    if (nextInterval.end > endTime) {
                        endTime = nextInterval.end;
                    }

                    intervals.remove(insertIndex);
                    i--;
                }
            }

            newInterval.end = endTime;

            intervals.add(insertIndex, newInterval);
        }

        if (insertIndex != 0) {
            Interval prevInterval = intervals.get(insertIndex - 1);

            if (prevInterval.end >= newInterval.start) {
                if (newInterval.end > prevInterval.end) {
                    prevInterval.end = newInterval.end;
                }

                if (!isLast) {
                    intervals.remove(insertIndex);
                }
            } else {
                if (isLast) {
                    intervals.add(newInterval);

                }
            }
        }

        return intervals;
    }
}
