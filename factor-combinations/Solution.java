public class Solution {
    public List<List<Integer>> getFactors(int n) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();

        ArrayList<Integer> currResult = new ArrayList<Integer>();

        factorIter(results, currResult, n, 2);

        return results;
    }

    private void factorIter(List<List<Integer>> results, List<Integer> currResult, int n, int min) {
        if (currResult.size() >= 1 && n >= min) {
            currResult.add(n);
            results.add(new ArrayList<Integer>(currResult));
            currResult.remove(currResult.size() - 1);
        }

        for (int denom = min; denom <= n / 2; denom++) {
            if (n % denom != 0) {
                continue;
            }

            int rem = n / denom;

            if (rem < min) {
                continue;
            }

            currResult.add(denom);
            factorIter(results, currResult, rem, denom);
            currResult.remove(currResult.size() - 1);
        }
    }
}
