package 剑指offer;

/**
 * 顺时针打印矩阵
 *
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
 * 解题思路
 * 先得到矩阵的行和列数，然后依次旋转打印数据，一次旋转打印结束后，往对角分别前进和后退一个单位。
 * 要注意单行和单列的情况。
 */

import java.util.ArrayList;

public class T20PrintMatrix {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        if (row == 0 && col == 0)
            return res;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        while (left <= right && top <= bottom) {
            for (int i = left;i <= right;i++)
                res.add(matrix[top][i]);
            for (int i = top+1;i<= bottom;i++)
                res.add(matrix[i][right]);
            if (top != bottom) {
                for (int i = right - 1;i >= left;i--)
                    res.add(matrix[bottom][i]);
            }
            if (left != right) {
                for (int i = bottom - 1;i >top;i--)
                    res.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

}
