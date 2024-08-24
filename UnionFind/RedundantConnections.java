/*
Difficulty : Medium
Trivia : We use union find algorithm places where we want to find connected components in a graph.

Question : https://leetcode.com/problems/redundant-connection/description/
*/
class Solution {
    /*
    Union Find
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] ans = new int[2];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }

        for(int i=0; i<edges.length; i++){
            int p1 = find(edges[i][0], parent);
            int p2 = find(edges[i][1], parent);
            if(p1 == p2){
                return edges[i];
            }
            else{
                union(parent, p1, p2);
            }

        }
        return ans;
    }

    private void union(int[] parent, int p1, int p2){
        parent[p1] = p2;
    }

    private int find(int n, int[] parent){
        int i = n;
        while(i != parent[i]){
            i = parent[i];
        }
        return i;
    }

}
