package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *推荐第一种做法
 * 1.对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点不为空时，在转化val所得的字符之后添加一个’,’作为分割; 对于空节点则以 ‘#,’ 代替。
 * 2.对于反序列化：将字符串按照“，”进行分割，插入到队列中，然后依次从队列中取出字符建立节点，递归创建一个二叉树。
 */

public class T62SerializeTree {
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
        n5.right = n9;

        String temp = serializeTree(n1);
        System.out.println(temp);
        System.out.println(deserializeTree(temp).left.right.right.value);
        System.out.println("---------------------");
//        ArrayList<Integer> list2 = serializeTree2(n1);
//        for(int i : list2) {
//            System.out.print(i + " ");
//        }
//        System.out.println(deserializeTree2(list2, 0).left.right.right.value);
    }

    //方法一（递归）：https://www.weiweiblog.cn/serialize/
    /**
     * 序列化
     * @param root
     * @return
     */
    private static String serializeTree(TreeNode root){
        if (root == null)
            return "#,";
        StringBuilder rootStrBuild = new StringBuilder(root.value + ",");
        rootStrBuild.append(serializeTree(root.left));
        rootStrBuild.append(serializeTree(root.right));
        return rootStrBuild.toString();
    }

    /**
     * 反序列化
     * 因为使用递归序列化的，所以用递归反序列化，类似于对称加减秘
     */
    private static TreeNode deserializeTree(String str){
        String[] strs = str.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0;i < strs.length; i++) {
            queue.offer(strs[i]);
        }
        return pre(queue);
    }

    private static TreeNode pre(Queue<String> queue){
        String val = queue.poll();
        if ("#".equals(val))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = pre(queue);
        node.right = pre(queue);
        return node;
    }


    //方法二（非递归）：https://blog.csdn.net/derrantcm/article/details/46857985

    /**
     * 序列化
     * @param root
     * @return
     */
    public static ArrayList<Integer> serializeTree2(TreeNode root){
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode temp = treeNodes.remove(0);
            if (temp != null){
//                result.add(null);
//            else {
                result.add(temp.value);
                treeNodes.add(temp.left);
                treeNodes.add(temp.right);
            }
        }
        return result;
    }

    /**
     * 反序列化
     */
    private static TreeNode deserializeTree2(ArrayList<Integer> result, int index) {
        if (result.size() == 0 || result.size() <= index || result.get(index) == null)
            return null;

        TreeNode root = new TreeNode(result.get(index));
        root.left = deserializeTree2(result, 2 * index + 1);
        root.right = deserializeTree2(result, 2 * index + 2);
        return root;
    }

}
