package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 用前序遍历的方式访问到某一结点时，把该结点添加到路径上，并用目标值减去该节点的值。如果该结点为叶结点并且目标值减去该节点的值刚好为0，则当前的路径符合要求，我们把加入res数组中。如果当前结点不是叶结点，则继续访问它的子结点。当前结点访问结束后，递归函数将自动回到它的父结点。因此我们在函数退出之前要在路径上删除当前结点，以确保返回父结点时路径刚好是从根结点到父结点的路径。
 */

public class T25FindPath {
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
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(10);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        n6.right = n10;
//        n6.left = n11;

        T25FindPath myPathWay = new T25FindPath();
        ArrayList<ArrayList<Integer>> result1 = myPathWay.findPath(n1, 20);
        for(ArrayList<Integer> myList : result1){
            for (int i : myList)
                System.out.println(i);
        }
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){

        if (root == null)
            return result;
        target -= root.value;
        temp.add(root.value);
        if (target == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(temp));
        }else {
            findPath(root.left, target);
            findPath(root.right, target);
        }
        //移除当前节点，返回父节点上，计算其他的值，之所以要移除，是因为和加上当前节点的值与target不符，这个只适用在子节点？
        temp.remove(temp.size() - 1);
        return result;
    }

}
