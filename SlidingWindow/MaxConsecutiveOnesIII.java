/*
Difficulty Medium
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*/

class Solution {
    public int longestOnes(int[] A, int K) {
        int countZero = 0, len = 0, maxLen = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for(int i=0;i< A.length;i++){
            if(A[i] == 0){
                countZero++;
            }
            end++;
            if(countZero > K){
                while(countZero > K){
                    if(A[start] == 0){
                        countZero --;
                    }
                    start++;
                }
            }
            
            len = end - start;
            
            if(len > maxLen){
                maxLen = len;
            }
        }
        return maxLen;
    }
}
