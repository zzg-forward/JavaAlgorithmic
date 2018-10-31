package 剑指offer;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 *
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0…m-1报数….这样下去….直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 解题思路
 * 用环形链表模拟圆圈。创建一个总共有 n 个结点的环形链表，然后每次在这个链表中删除第 m 个结点。注意，起步是-1 不是 0。
 *
 * 环形链表的应用
 * 注意：每次index--
 */

import java.util.LinkedList;

public class T45LastRemaining {
    public static void main(String[] args) {

    }

    public static int getLastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            link.add(i);
        }

        int index = -1;
        while (link.size() > 1) {
            index = (index + m) % link.size();
            link.remove(index);
            index--;     //这是关键
        }
        return link.get(0);
    }

}
