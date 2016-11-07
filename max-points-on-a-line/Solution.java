public class Solution {
    public int maxPoints(Point[] points) {
        int len = points.length;

        if (len == 0) {
            return 0;
        }

        int maxOverall = 1;

        for (int i = 0; i < len; i++) {
            int samePointCount = 1;

            Point p1 = points[i];
            ArrayList<Double> slopes = new ArrayList<Double>();

            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                Point p2 = points[j];

                double slope;

                int xDiff = p2.x - p1.x;
                int yDiff = p2.y - p1.y;

                if (xDiff == 0) {
                    if (yDiff == 0) {
                        samePointCount++;
                    } else {
                        slopes.add(Double.MAX_VALUE);
                    }
                } else {
                    slopes.add((double)(yDiff) / xDiff);
                }
            }

            Collections.sort(slopes);

            int sameSlopeCount = samePointCount;

            int max = 0;

            for (int j = 0; j < slopes.size(); j++) {
                double slope = slopes.get(j);

                if (j == 0 || slope != slopes.get(j - 1)) {
                    sameSlopeCount = 1;
                } else {
                    sameSlopeCount++;
                }

                if (sameSlopeCount > max) {
                    max = sameSlopeCount;
                }
            }

            int total = max + samePointCount;

            if (total > maxOverall) {
                maxOverall = total;
            }
        }

        return maxOverall;
    }
}
