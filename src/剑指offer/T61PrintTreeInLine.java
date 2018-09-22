package 剑指offer;

import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印一行。
 * 用一个队列来保存将要打印的结点。为了把二叉树的每一行单独打印到一行里，我们需要两个变量：一个变量表示在当前的层中还没有打印的结点数，另一个变量表示下一次结点的数目。
 */

public class T61PrintTreeInLine {
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

        printTreeInLine(n1);
    }

    public static void printTreeInLine(TreeNode root){
        if (root == null)
            return;

        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        int currnt = 0;
        int totalLayer = 1;
        treeNodeList.offer(root);  //将元素放在队尾

        while (!treeNodeList.isEmpty()) {
            TreeNode temp = treeNodeList.poll();  //弹出队头元素
            System.out.print(temp.value + " ");
            currnt++;
            if (temp.left != null)
                treeNodeList.offer(temp.left);
            if (temp.right != null)
                treeNodeList.offer(temp.right);
            if (currnt == totalLayer){
                System.out.println();
                currnt = 0;
                totalLayer = treeNodeList.size();
            }
        }


    }

}

