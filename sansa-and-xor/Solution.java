import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        
        for (int i = 0; i < numCases; i++) {
            int len = in.nextInt();
            int[] nums = new int[len];
            
            for (int j = 0; j < len; j++) {
                nums[j] = in.nextInt();
            }
            
            solveCase(len, nums);
        }
    }
    
    private static void solveCase(int len, int[] nums) {
        int result = 0;
        
        for (int i = 0; i < len; i++) {
            int count = (i + 1) * (len - i);
            
            if (count % 2 != 0) {
                result ^= nums[i];
            }
        }
        
        System.out.println(result);
    }
}
