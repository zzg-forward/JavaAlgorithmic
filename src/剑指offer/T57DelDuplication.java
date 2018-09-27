package 剑指offer;

/**
 * 删除链表中重复的结点
 *
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 解题思路
 * 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
 * 设置 first ，second 指针， first 指针指向当前确定不重复的那个节点，而second指针相当于工作指针，一直往后面搜索。
 *
 *
 * 引申：保留重复中的一个节点
 */

public class T57DelDuplication {
    public static void main(String[] args) {
        LinkedNode p1 = new LinkedNode(1);
        LinkedNode p2 = new LinkedNode(2);
        LinkedNode p3 = new LinkedNode(3);
        LinkedNode p4 = new LinkedNode(3);
        LinkedNode p5 = new LinkedNode(4);
        LinkedNode p6 = new LinkedNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        LinkedNode result = delDuplicationNode(p1);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    private static LinkedNode delDuplicationNode(LinkedNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        LinkedNode head = new LinkedNode(-1);
        head.next = pHead;
        LinkedNode first = head;
        LinkedNode second = first.next;

        while (second != null) {
            if (second.next != null && second.value == second.next.value) {
                while (second.next != null && second.value == second.next.value) {
                    second = second.next;
                }
                first.next = second.next;
            }
            else {
                first = first.next;
            }
            second = second.next;
        }
        return head.next;
    }

}
