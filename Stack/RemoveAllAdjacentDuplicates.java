/*
Difficulty : Medium [14mins]
Solved with 2 different approaches.

https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/
*/

class Solution {
    public String removeDuplicates1(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        char[] arr = s.toCharArray();
        stack.push(new Pair<Character, Integer>(arr[0], 1));
        for(int i = 1; i < arr.length; i++){
            Pair<Character, Integer> top = stack.size() > 0 ? stack.peek() : new Pair<Character, Integer>(' ', 0);
            if(top.getKey() == arr[i]){
                stack.pop();
                if(top.getValue() + 1 < k){
                    stack.push(new Pair<Character, Integer>(top.getKey(), top.getValue() + 1));
                }
            } else{
                stack.push(new Pair<Character, Integer>(arr[i], 1));
            }
        }

        String result = "";
        while(stack.size() > 0){
            char ch = stack.peek().getKey();
            int ctr = stack.peek().getValue();
            while(ctr-- > 0){
                result = ch + result;
            }
            stack.pop();
        }

        return result;
    }

    public String removeDuplicates(String s, int k) {
        char[] arr = s.toCharArray();
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        int i = 0, j = 0;
        while(j < arr.length){

            if(arr[i] == arr[j] && i != j){
                j++;
                if(j-i+1 == k){
                    i = j;
                    j++;
                }
            } else{
                Pair<Character, Integer> top = stack.size() > 0 ? stack.peek() : new Pair<Character, Integer>(' ', 0);
                if(top.getKey() == arr[i]){
                    stack.pop();
                    if(top.getValue() + 1 < k)
                        stack.push(new Pair<Character, Integer>(top.getKey(), top.getValue() + 1));
                }
                else{
                    stack.push(new Pair<Character, Integer>(arr[i], j-i+1));

                }
                j++;
                i = j;
            }
        }

        String result = "";
        while(stack.size() > 0){
            char ch = stack.peek().getKey();
            int ctr = stack.peek().getValue();
            while(ctr-- > 0){
                result = ch + result;
            }
            stack.pop();
        }

        return result;
    }
}
