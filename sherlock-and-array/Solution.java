import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int numCases = in.nextInt();
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int len = in.nextInt();
            
            int[] nums = new int[len];
            
            for (int i = 0; i < len; i++) {
                nums[i] = in.nextInt();
            }
            
            solveCase(nums);
        }
    }
    
    private static void solveCase(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        
        while (true) {
            int mid = (left + right) >> 1;
            
            int leftSum = 0;
            for (int i = 0; i < mid; i++) {
                leftSum += nums[i];
            }
            
            int rightSum = 0;
            for (int i = mid + 1; i < len; i++) {
                rightSum += nums[i];
            }
            
            if (leftSum == rightSum) {
                System.out.println("YES");
                return;
            }
            
            if (left == right) {
                System.out.println("NO");
                return;
            }
                
            if (leftSum < rightSum) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
    }
}
