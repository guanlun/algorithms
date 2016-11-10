public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;

        for (int i = 1; i < n; i++) {
            if (knows(celeb, i)) {
                celeb = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == celeb) {
                continue;
            }

            if (!knows(i, celeb) || knows(celeb, i)) {
                return -1;
            }
        }

        return celeb;
    }
}
