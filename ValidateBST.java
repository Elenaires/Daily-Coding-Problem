/* daily coding problem #89 */
/* left child must be less than or equal to the root
*  right child must be greater than or equal to the root
* Since left and right child can have same value as parent
* it's safe to use Integer.MIN/MAX_VALUE
* otherwise, we need to do
* if(node.val >= max || node.val <= min) and when 
* node.val = Integer.MAX_VALUE (2147483647), the code fails
* in that case we need to use Long.MAX_VALUE
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
    public boolean isValidBST(TreeNode root) {
        
        return BSTCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    
    public boolean BSTCheck(TreeNode node, int min, int max)
    {
        boolean isBST = true;
        
        if(node != null)
        {
            if(node.val > max || node.val < min)
            {
                isBST = false;
            }
            else
            {
                isBST = BSTCheck(node.left, min, node.val) && BSTCheck(node.right, node.val, max);
            }         
        }
        return isBST;
    }
}

