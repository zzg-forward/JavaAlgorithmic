package 剑指offer;

import java.util.LinkedList;
import java.util.List;

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
        if (root == null){
            return;
        }

        List<TreeNode> list = new LinkedList<>();
        TreeNode node;
        //记录当前层节点的个数
        int current = 1;
        //记录下一层节点的个数
        int next = 0;
        list.add(root);

        while (list.size() > 0){
            node = list.remove(0);
            current--;
            System.out.print(node.value + " ");
            if (node.left != null){
                list.add(node.left);
                next++;
            }
            if (node.right != null){
                list.add(node.right);
                next++;
            }
            if (current == 0){
                System.out.println();
                current = next;
                next = 0;
            }

        }

    }

}

