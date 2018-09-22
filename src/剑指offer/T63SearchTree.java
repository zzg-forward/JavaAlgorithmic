package 剑指offer;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * 因为二叉搜索树按照中序遍历的顺序打印出来就是排好序的，所以，我们按照中序遍历找到第k个结点就是题目所求的结点。
 */
public class T63SearchTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(kthNode(n1, 5).value);
    }

    static int index = 0;
    private static TreeNode kthNode(TreeNode root, int k){
        if (root != null) {
            TreeNode node = kthNode(root.left, k);
            if (node != null)
                return node;
            index++;
            if (index == k)
                return root;
            node = kthNode(root.right, k);
            if (node != null)
                return node;
        }
        return null;
    }

}
