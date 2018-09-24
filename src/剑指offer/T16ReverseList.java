package 剑指offer;

/**
 * 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 设置三个指针，head为当前节点，pre为当前节点的前一个节点，next为当前节点的下一个节点，需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2的过程中，用pre让节点反转所指方向，next节点保存next1节点防止链表断开
 *
 * 需要注意的点：
 * 1、如果输入的头结点是null，则返回null
 * 2、链表断裂的考虑
 */

public class T16ReverseList {
    public static void main(String[] args) {

    }

    private static LinkedNode reverseList(LinkedNode head) {
        if (head == null)
            return null;
        LinkedNode pre = null;
        LinkedNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
