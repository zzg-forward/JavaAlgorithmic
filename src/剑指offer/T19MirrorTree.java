package 剑指offer;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 通过对以上两棵树的观察，我们可以总结出这两棵树的根节点相同，但它们的左、右两个子节点交换了位置。所以我们可以得出求一棵树的镜像的过程：先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点。当交换完所有非叶节点的左、右子节点之后，就得到了树的镜像。
 *
 */

public class T19MirrorTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        mirrorTree(n1);
        T61PrintTreeInLine.printTreeInLine(n1);
    }


    public static void mirrorTree(TreeNode root){
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null)
            mirrorTree(root.left);
        if (root.right != null)
            mirrorTree(root.right);
    }

}
