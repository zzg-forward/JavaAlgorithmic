package 剑指offer;

import java.util.Stack;

/**
 * 二叉搜索树与双向链表
 *
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 解题思路
 * 题目可能比较难理解，可以看如下的图，我们有一棵二叉搜索树，要求得右边的双向链表。
 *
 * 在二叉搜索树中，左子结点的值总是小于父结点的值，右子节点的值总是大于父结点的值。因此我们在转换成排序双向链表时，原先指向左子结点的指针调整为链表中指向前一个结点的指针，原先指向右子节点的指针调整为链表中指向后一个结点的指针。
 * 因为中序遍历是按照从小到大的顺序遍历二叉搜索树，所以我们用中序遍历树中的每一个节点得到的正好是要求的排好序的。遍历过程如下：
 * 每次遍历节点的左孩子、右孩子，把左孩子指向转换链表的尾节点，并把末尾指针的右孩子指向自己。右孩子指向节点的右孩子。如果没有右孩子就返回。这一过程可以用递归实现。
 *
 *
 * 中序遍历的应用
 */

public class T27ConvertBST {
    public static void main(String[] args) {

    }

    static TreeNode head = null;
    static TreeNode end = null;

    /**
     * 递归做法
     * @param root
     * @return
     */
    public static TreeNode convert(TreeNode root) {
        convertSub(root);
        return head;
    }

    //中序遍历做法，递归
    private static void convertSub(TreeNode root) {
        if (root == null)
            return;
        convertSub(root.left);
        if (end == null) {
            head = root;
            end = root;
        }else {
            end.right = root;
            root.left = end;
            end = root;
        }
        convertSub(root.right);
    }

    /**
     * 非递归做法
     */
    public static TreeNode convert2(TreeNode root) {
        TreeNode head = null;
        TreeNode pre = null;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (head == null) {
                head = root;
                pre = root;
            }else {
                pre.right = root;
                root.left = pre;
                pre = root;
            }
            root = root.right;
        }

        return head;

    }
}
