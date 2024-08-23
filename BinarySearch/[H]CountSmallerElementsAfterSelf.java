/*
Difficulty : Hard
Great question : 

Here the code is incomplete. But we are using merge sort to implement the solution. 

problem link: https://leetcode.com/problems/count-of-smaller-numbers-after-self/
*/
class Solution {
    List<Integer> result = new LinkedList<>();
    public List<Integer> coundSmaller(int[] nums){
        List<Pair<Integer, Integer>>  list = new LinkedList<>();
        for(int num : nums){
            list.add(new Pair<Integer, Integer>(i, num));
            result.add(0);
        }

        mergeSort(list, 0, nums.length);

        return result;

    }

    private void mergeSort(List<Pair<Integer, Integer>> list, int start, int end){
        if(start > end || end >= list.size()){
            return;
        }

        int mid = start + (end-start)/2;

        mergeSort(list, start, mid);
        mergeSort(list, mid+1, end);

        merge(list, start, mid, end);
    }

    private void merge(List<Pair<Integer, Integer>> list, int start, int mid, int end){
        int i = start, j = mid+1;
        List<Pair<Integer, Integer>> newLis = new LinkedList<>();
        
        while(i <= mid && j <= end){
            if(list.get(i).getValue() > list.get(j).getValue()){
                int fIndex = list.get(i).getKey();
                int sIndex = list.get(j).getKey();
                if(fIndex < sIndex){
                    result.put(fIndex, result.get(fIndex) + 1);
                }
                newLis.add(list.get(i).getValue());
                i++;
            }
            else{
                newLis.add(list.get(j).getValue());
                j++;
            }
        }

        while(i <= mid){
            newLis.add(list.get(i).getValue());
            i++;
        }

        while(j <= end){
            newLis.add(list.get(j).getValue());
        }

        for(int k=start; k<end; k++){
            list.put()
        }
    }

    public List<Integer> countSmallerDintWork(int[] nums) {
        // wont work fo rtest case : 7, 5, 2, 6, 1
        List<Integer> lis = new LinkedList<>();
        int[] ans =  new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length-1; i>=0; i--){
            if(stack.size() == 0){
                ans[i] = 0;
                stack.push(i);
            }
            else if(nums[stack.peek()] < nums[i]){
                ans[i] = ans[stack.peek()] + 1;
                stack.push(i);
            } else {
                while(stack.size() > 0 && nums[stack.peek()] > nums[i]){
                    stack.pop();
                }
                ans[i] = stack.size() > 0 ? (ans[stack.peek()] + 1) : 0;
                stack.push(i);
            }
        }

        for(int i =0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }

        return lis;
    }
}
