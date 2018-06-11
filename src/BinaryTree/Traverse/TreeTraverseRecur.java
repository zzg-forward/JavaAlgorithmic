package BinaryTree.Traverse;

/**
 * 递归遍历二叉树
 * @author zhaozigang
 */
public class TreeTraverseRecur {

    //test
    public TreeNode initNode(){
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        return A;   //返回根节点
    }
    //test

    /**
     * 先序遍历
     * @param root
     */
    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }

        System.out.print(root.getData());
        preOrder(root.getLeftNode());
        preOrder(root.getRightNode());
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }

        inOrder(root.getLeftNode());
        System.out.print(root.getData());
        inOrder(root.getRightNode());
    }

    /**
     * 后序遍历
     * @param root
     */
    public void posOrder(TreeNode root){
        if (root == null){
            return;
        }

        posOrder(root.getLeftNode());
        posOrder(root.getRightNode());
        System.out.print(root.getData());
    }

    public static void main(String[] args){
        //test
        TreeTraverseRecur tree = new TreeTraverseRecur();
        TreeNode root = tree.initNode();

        System.out.println("先序");
        tree.preOrder(root);
        System.out.println("中序");
        tree.inOrder(root);
        System.out.println("后序");
        tree.posOrder(root);

    }

}
