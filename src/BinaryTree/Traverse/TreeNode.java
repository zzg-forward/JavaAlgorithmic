package BinaryTree.Traverse;

/**
 * 二叉树节点定义
 * @author zhaozigang
 */
public class TreeNode {
    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;
    public TreeNode(int data, TreeNode leftNode, TreeNode rightNode){
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public TreeNode getLeftNode(){
        return leftNode;
    }

    public TreeNode getRightNode(){
        return rightNode;
    }

    public void setLeftNode(TreeNode leftNode){
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode){
        this.rightNode = rightNode;
    }
}
