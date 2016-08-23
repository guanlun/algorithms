import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        String line = stdin.nextLine();
        
        int numCases = Integer.parseInt(line);
        
        for (int i = 0; i < numCases; i++) {
            line = stdin.nextLine();
            String[] segs = line.split(" ");
            
            int n = Integer.parseInt(segs[0]);
            int m = Integer.parseInt(segs[1]);
            
            line = stdin.nextLine();
            
            solveCase(n, m, line);
        }
    }
    
    private static void solveCase(int n, int m, String str) {
        String[] arr = str.split(" ");
        int len = arr.length;
        boolean[] canReach = new boolean[len];
        
        for (int i = len - 1; i >= 0; i--) {
            String item = arr[i];
            
            if (item.equals("1")) {
                continue;
            }
                        
            int nextIdx = i + 1;
            int nextMIdx = i + m;
            
            if (i == len - 1 || nextMIdx >= len) { // m might be 0, so check if it's the last element as well
                canReach[i] = true;
            } else if (canReach[nextMIdx]) {
                canReach[i] = true;
            } else if (nextIdx < len && canReach[nextIdx]) {
                canReach[i] = true;
            }

            if (canReach[i]) {
                while ((nextIdx < len) && (arr[nextIdx].equals("0"))) {
                    canReach[nextIdx] = true;
                    nextIdx++;
                }
            }
        }
        
        System.out.println(canReach[0] ? "YES" : "NO");
    }
}