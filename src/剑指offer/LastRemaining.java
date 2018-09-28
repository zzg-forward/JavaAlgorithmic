package 剑指offer;

/**
 * 面试题 46：圆圈中最后剩下的数字
 *
 * 题目：
 *  *      0, 1, 2, ..., n-1 这 n 个数字排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字。
 *  *      求出这个圆圈里剩下的最后一个数字。
 *
 *  考查点：
 *  *      1. 约瑟夫环问题
 *
 *  思路：
 *  *      1. 圆形链表
 */

import java.util.LinkedList;

public class LastRemaining {
    public static void main(String[] args) {

    }

    public static int getLastRemain(int n,int m){
        if (n < 1 || m < 1)
            return -1;
        LinkedList<Integer> link = new LinkedList<>();

        for (int i = 0;i < n;i++){
            link.add(i);
        }
        int index = -1;
        while (link.size() > 1){
            index = (index + m) % link.size();
            link.remove(index);
            index--;
        }
        return link.get(0);
    }

}
