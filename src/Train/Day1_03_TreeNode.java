package Train;

import java.util.Arrays;

/**
 * Created by bwelco on 2016/11/27.
 */
public class Day1_03_TreeNode {

    /*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre.length == 0) return null;
        TreeNode mid = new TreeNode(pre[0]);
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == mid.val) {
                index = i;
                break;
            }
        }


        mid.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(in, 0, index));
        mid.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));

        return mid;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return HasSubtree(root1.left, root2) ||
                    HasSubtree(root1.right, root2);
        } else {

            if (HasSubtree2(root1, root2)) {
                return true;
            }
        }

        return false;
    }

    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        }

        if(root2 == null) return true;
        if(root1.val != root2.val) return false;

        return HasSubtree2(root1.left, root2.left) && HasSubtree2(root1.right, root2.right);
    }


    public static void main(String[] args) {
        Day1_03_TreeNode node = new Day1_03_TreeNode();
        node.reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
    }
}
