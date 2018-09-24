package 剑指offer;

/**
 * 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 一种方法是利用栈来实现；
 * 另外一种方法是利用三个指针把链表反转，关键是 r 指针保存断开的节点。
 */

import java.util.ArrayList;

public class T05PrintNodeNodeFromTailToHead {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> printLinkedListFromTailToHead(LinkedNode head) {
        if (head == null)
            return new ArrayList<Integer>();
        LinkedNode headNode = head;
        LinkedNode curNode = headNode.next;

        while (curNode != null) {
            LinkedNode temp = curNode.next;
            curNode.next = headNode;
            headNode = curNode;
            curNode = temp;
        }
        headNode.next = null;

        ArrayList<Integer> result = new ArrayList<>();
        while (headNode != null) {
            result.add(headNode.value);
            headNode = headNode.next;
        }
        return result;
    }

}
