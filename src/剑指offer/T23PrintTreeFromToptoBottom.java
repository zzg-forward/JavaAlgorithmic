package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上往下打印二叉树
 *
 *题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 解题思路
 * 就是二叉树的层序遍历。借助一个队列就可以实现。
 * 使用两个队列一个存放节点，一个存放值。先将根节点加入到队列中，然后遍历队列中的元素，遍历过程中，访问该元素的左右节点，再将左右子节点加入到队列中来。
 */

public class T23PrintTreeFromToptoBottom {
    public static void main(String[] args) {

    }

    private static List<Integer> printTreeFromTop(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            TreeNode temp = nodeList.poll();
            result.add(temp.value);
            if (temp.left != null)
                nodeList.add(temp.left);
            if (temp.right != null)
                nodeList.add(temp.right);
        }
        return result;
    }

}
