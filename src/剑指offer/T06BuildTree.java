package 剑指offer;

/**
 * 重建二叉树
 *
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 解题思路
 * 我们知道，前序遍历的第一个节点就是树的根节点，所以我们先根据前序遍历序列的第一个数字创建根结点，接下来在中序遍历序列中找到根结点的位置，根节点的左边就是左子树，右边就是右子树，这样就能确定左、右子树结点的数量。在前序遍历和中序遍历的序列中划分了左、右子树结点的值之后，就可以递归地去分别构建它的左右子树。
 *
 */

public class T06BuildTree {
    public static void main(String[] args) {

    }

    private static TreeNode buildTree(int[] preOrderArr, int[] inOrderArr) {
        if (preOrderArr.length == 0 || inOrderArr.length == 0)
            return null;
        return reBuildTree(preOrderArr, 0, preOrderArr.length - 1, inOrderArr, 0, inOrderArr.length - 1);
    }

    private static TreeNode reBuildTree(int[] preArr, int preFirst, int preLast, int[] inArr, int inFirst, int inLast) {
        if (preFirst > preLast || inFirst > inLast) {
            return null;
        }

        int rootValue = preArr[preFirst];
        TreeNode root = new TreeNode(rootValue);
        for (int i = inFirst; i <= inLast; i++) {
            if (inArr[i] == rootValue) {
                root.left = reBuildTree(preArr, preFirst+1, preFirst+i-inFirst, inArr, inFirst, i-1);
                root.right = reBuildTree(preArr, preFirst+i-inFirst+1, preLast, inArr, i+1, inLast);
                break;
            }
        }

        return root;
    }


}
