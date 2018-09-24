package 剑指offer;

/**
 * 合并两个排序的链表
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 两种解法：递归和非递归
 *
 */

public class T17MergeList {
    public static void main(String[] args) {

    }

    //递归做法
    private static LinkedNode mergeList(LinkedNode head1, LinkedNode head2) {
        if (head1 == null) {
            return head2;
        }else if (head2 == null) {
            return head1;
        }
        LinkedNode mergeHead;
        if (head1.value < head2.value) {
            mergeHead = head1;
            mergeHead.next = mergeList(head1.next, head2);
        }else {
            mergeHead = head2;
            mergeHead.next = mergeList(head1, head2.next);
        }
        return mergeHead;
    }

    //非递归做法
    private static LinkedNode mergeList2(LinkedNode head1, LinkedNode head2) {
        if (head1 == null) {
            return head2;
        }else if (head2 == null) {
            return head1;
        }
        LinkedNode mergeHead;

        if (head1.value < head2.value) {
            mergeHead = head1;
            head1 = head1.next;
        }else {
            mergeHead = head2;
            head2 = head2.next;
        }

        //mergeHead要记得赋值
        LinkedNode curNode = mergeHead;
        //注意while判断条件是head1 != null，而不是head1.next != null
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                curNode.next = head1;
                head1 = head1.next;
            }else {
                curNode.next = head2;
                head2 = head2.next;
            }
            //curNode 要记得往后移动
            curNode = curNode.next;
        }
        if (head1 != null)
            curNode.next = head1;
        if (head2 != null)
            curNode.next = head2;

        return mergeHead;
    }

}
