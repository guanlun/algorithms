public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int numNuts = nuts.length;
        
        int[] ntDist = new int[numNuts];
        int[] nsDist = new int[numNuts];
        
        int maxTSDiff = -Integer.MAX_VALUE;
        int firstNutIdx = 0;
        
        for (int i = 0; i < numNuts; i++) {
            int[] nut = nuts[i];
            
            ntDist[i] = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
            nsDist[i] = Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1]);
            
            int diff = ntDist[i] - nsDist[i];
            
            if (diff > maxTSDiff) {
                maxTSDiff=  diff;
                firstNutIdx = i;
            }
        }
        
        int totalDist = 0;
        
        for (int i = 0; i < numNuts; i++) {
            int[] nut = nuts[i];
            
            if (i == firstNutIdx) {
                totalDist += ntDist[i] + nsDist[i];
            } else {
                totalDist += 2 * ntDist[i];
            }
        }
        
        return totalDist;
    }
}
