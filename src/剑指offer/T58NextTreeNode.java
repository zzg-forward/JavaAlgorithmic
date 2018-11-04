package 剑指offer;

/**
 * 二叉树的下一个结点
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 解题思路
 * 中序遍历：左 -> 根 -> 右
 * 分三种情况：
 *
 * 如果当前节点为空，直接返回空；
 * 如果当前节点有右子树，则返回右子树的最左子树；
 * 如果当前节点没有右子树，再分两种情况：
 * 看看当前节点是不是它的父节点的左子树，如果是，则返回它的父节点；
 * 如果当前节点不是它的父节点的左子树，则把父节点赋给当前节点，再判断当前节点是不是它的父节点的左子树，直到当前节点是不是它的父节点的左子树，返回它的父节点。
 *
 * 其实搞懂中序遍历顺序和规律就比较容易了
 */

public class T58NextTreeNode {
    public static void main(String[] args) {

    }

    public static TreeLinkedNode getTreeNext(TreeLinkedNode root) {
        if (root == null) {
            return null;
        }

        if (root.right != null) {
            TreeLinkedNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        while (root.next != null) {
            TreeLinkedNode temp = root.next;
            if (temp.left == root) {  // 可能是右节点
                return temp;
            }
            root = temp;
        }
        return null;
    }

}
