/*
Difficulty : Hard
[Amazing question]

https://leetcode.com/problems/binary-tree-cameras/description/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    /**
    0 -> Root is not monitored and nor have the camera.
    1 -> Root is monitored but doesn't have camera.
    2 -> Root has camera.
     */
    public int minCameraCover(TreeNode root) {
        int status = cameraRecur(root);

        return status == 0 ? count + 1 : count;
    }

    public int cameraRecur(TreeNode root){
        if(root == null){
            return 1;
        }

        int left = cameraRecur(root.left);
        int right = cameraRecur(root.right);

        if(left == 0 || right == 0){
            count ++;
            return 2;
        }

        if(left == 2 || right == 2){
            return 1;
        }
        return 0;
    }
}
