package 剑指offer;

/**
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 经典的双指针法。定义两个指针，第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动，从第k步开始，第二个指针也开始从链表的头指针开始遍历，由于两个指针的距离保持在k-1，当第一个指针到达链表的尾节点时，第二个指针刚好指向倒数第k个节点。
 *
 * 关注要点
 * 1. 链表头指针是否为空，若为空则直接返回回null
 * 2. k是否为0，k为0也就是要查找倒数第0个节点，由于计数一般是从1开始的，所有输入0没有实际意义，返回null
 * 3. k是否超出链表的长度，如果链表的节点个数少于k，则在指针后移的过程中会出现next指向空指针的错误，所以程序中要加一个判断
 */

public class T15FindKthToTail {
    public static void main(String[] args) {

    }

    private static LinkedNode findKthToTail(LinkedNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        LinkedNode p1 = head;
        LinkedNode p2 = head;
        //判断k是否超过链表节点的个数，注意是 i < k - 1
        for (int i = 0; i < k - 1; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            }else {
                return null;
            }
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
