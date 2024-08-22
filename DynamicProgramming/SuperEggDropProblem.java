/*

Please note : code is resulting in some error, but the code idea is gonna be same. Can be taken up in next run.


Idea is to use binary search to find the floor (k) for which we can see if the egg breaks or not. Since we need to find worst case we will move towards more number of floors.
Also, once k is calculated, we have two possibilities either the egg breaks(egg-1, k-1) or egg doesnt break (egg, floor-k).
we will take max of both and return min of all possibilities in result.
*/
class Solution {
    int dp[][];
    public int superEggDrop(int eggs, int floors) {
        dp = new int[eggs+1][floors+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j] = -1;
            }
        }
        return solve(eggs, floors);
    }

    public int solve(int eggs, int floors){
        if(floors == 0 || floors == 1)
            return floors;
        if(eggs == 1){
            return floors;
        }

        if(dp[eggs][floors] != -1){
            return dp[eggs][floors];
        }

        int ans = Integer.MAX_VALUE;

        int start = 1, end = floors;
        int k = 0;
        while(start < end){
            k = start + (end - start) / 2;
            int low = solve(eggs-1, k-1);
            int high = solve(eggs, floors-k);
            int temp = 1 + Math.max(low, high);
            ans = Math.min(ans, temp);

            if(low < high){
                start = k + 1;
            } 
            else {
                end = k - 1;
            }
        }
        dp[eggs][floors] = ans;
        return ans;
    }
}
