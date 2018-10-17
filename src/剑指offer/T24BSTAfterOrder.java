package 剑指offer;

/**
 * 二叉搜索树的后序遍历序列
 *
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 解题思路
 * 二叉搜索树: 左子树<根<=右子树
 *
 * 对于后序遍历来说，序列数组的最后一个元素一定是根节点, 根据这个元素，将前面的数组分为左、右两个部分，左侧部分都比该元素小，右侧部分都比该元素大，如果右侧部分有比该根节点小的元素，那么就不是后序遍历，如此递归进行。
 *
 */

public class T24BSTAfterOrder {
    public static void main(String[] args) {

    }

    private static boolean isBST(int[] testArr) {
        if (testArr == null || testArr.length == 0)
            return false;
        if (testArr.length == 1)
            return true;
        return judge(testArr, 0, testArr.length - 1);
    }

    private static boolean judge(int[] testArr, int start, int root) {
        if (start >= root)
            return true;
        int leftStart = start;
        while (testArr[leftStart] < testArr[root] && leftStart < root)
            leftStart++;
        int rightStart = leftStart;
        for (;rightStart < root; rightStart++) {
            if (testArr[rightStart] < testArr[root])
                return false;
        }

        return (judge(testArr, start, leftStart - 1) && judge(testArr, leftStart, root - 1));

    }

}
