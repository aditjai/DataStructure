/*
Difficulty = Hard
Following solution is giving TLE.
Future improvement : instead of using one PQ, use two represending first and second. that will save some time of recreting temp Priority queue every time.

Problem link https://leetcode.com/problems/sliding-window-median/description/
*/
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int start = 0, end = 0;
        double result[] = new double[nums.length - k + 1];
        int resultIndex = 0;
        while(end < nums.length){
            if(end-start < k){
                pq.add(nums[end]);
                end++;
            }
            if (end-start == k){
                // Calculate Answer
                PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
                int popElements = k/2;
                int first = 0, second = 0;
                while(popElements >= 0){
                    first = second;
                    second = temp.poll();
                    popElements--;
                }
                if(k%2 == 0){
                    result[resultIndex++] = first + ((second - first) / 2.0);
                } else{
                    result[resultIndex++] = second;
                }

                // slide the window.
                pq.remove(nums[start++]);
            }
        }
        return result;
    }
}
