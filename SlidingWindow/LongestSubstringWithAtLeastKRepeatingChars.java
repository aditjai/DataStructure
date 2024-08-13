/*
Difficulty : Medium
Category : Sliding Window.

Question Link: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

Question : Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character 
in this substring is greater than or equal to k.
if no such substring exists, return 0.
Example 1:
Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.

*/
class Solution {
    public int longestSubstring(String s, int k) {
        int start = 0, end = s.length()-1;
        int count[] = new int[26];
        for(int i = 0;i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        boolean isValid = true;

        for (int i = 0; i < count.length; i += 1) {
            if (count[i] < k && count[i] > 0) isValid = false;
        }

        if(isValid)
            return s.length();
        int cur = 0;
        int result = 0;
        while(cur < s.length()){
            if(count[s.charAt(cur) - 'a'] < k){
                //invalid
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));

        return result;
    }
}
