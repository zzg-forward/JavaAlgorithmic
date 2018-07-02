import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组的MaxTree
 * O(N)
 */

class Node{
    public int value;
    public Node left;
    public Node right;
    public Node(int value){
        this.value = value;
    }
}

public class P22MaxTree {

    public static Node getMaxTree(int[] arr){
        Node[] nArr = new Node[arr.length];
        for (int i = 0;i != arr.length;i++) {
            nArr[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        for (int i = 0;i != nArr.length; i++){
            while (!stack.isEmpty() && nArr[i].value > stack.peek().value){
                popStackSetMap(stack, lBigMap);
            }
            stack.push(nArr[i]);
        }
        while (!stack.isEmpty()){
            popStackSetMap(stack, lBigMap);
        }
        for (int i = nArr.length - 1;i != -1; i--){
            while (!stack.isEmpty() && nArr[i].value > stack.peek().value){
                popStackSetMap(stack, rBigMap);
            }
            stack.push(nArr[i]);
        }
        while (!stack.isEmpty()){
            popStackSetMap(stack, rBigMap);
        }
        Node head = null;
        for (int i = 0;i != nArr.length;i++){
            Node curNode = nArr[i];
            Node leftBig = lBigMap.get(curNode);
            Node rightBig = rBigMap.get(curNode);
            if (leftBig == null && rightBig == null){
                head = curNode;
            }else if (leftBig == null){
                if (rightBig.left == null){
                    rightBig.left = curNode;
                }else{
                    rightBig.right = curNode;
                }
            }else if (rightBig == null){
                if (leftBig.left == null){
                    leftBig.left = curNode;
                }else {
                    leftBig.right = curNode;
                }
            }else{
                Node parent = leftBig.value < rightBig.value ? leftBig : rightBig;
                if (parent.left == null){
                    parent.left = curNode;
                }else{
                    parent.right = curNode;
                }
            }

        }
        return head;
    }

    private static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map){
        Node popNode = stack.pop();
        if (stack.isEmpty())
            map.put(popNode, null);
        else
            map.put(popNode, stack.peek());
    }

    public static void main(String[] args){
        int[] testArr = new int[]{3,4,5,1,2};
        int result = P22MaxTree.getMaxTree(testArr).value;
        System.out.println(result);
    }

}
