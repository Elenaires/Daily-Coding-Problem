/* Daily coding problem #48
* Given pre-order and in-order traversals of a binary tree,
* write a function to reconstruct the tree
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helperMethod(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    public TreeNode helperMethod(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd)
    {
        if(preStart > preorder.length || inStart > inEnd)
        {
            return null;
        }
        
        TreeNode current = new TreeNode(preorder[preStart]);
        
	// look for index of current in inorder array
        int i = inStart;
        int index = 0;
        boolean found = false;
        while(i <= inEnd && !found)
        {
            if(inorder[i] == current.val)
            {
                index = i;
                found = true;
            }
            
            i++;
        }
        
        current.left = helperMethod(preorder, inorder, preStart+1, inStart, index-1);
        current.right = helperMethod(preorder, inorder, preStart + (index - inStart) + 1, index + 1, inEnd);
        
        return current;
            
    }
}
