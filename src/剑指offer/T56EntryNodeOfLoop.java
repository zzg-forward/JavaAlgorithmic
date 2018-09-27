package 剑指offer;

/**
 * 链表中环的入口结点
 *
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 解题思路
 * 一种方法是用 hashmap来存储和查找节点;
 * 另一种方法是双指针法。
 *
 * 假设环长度为n，进入环之前结点个数为x,slow在环内走了k个结点,fast绕环走了m圈,则有2(x+k)=x+mn+k 可以得出x = mn - k。此时slow距入口结点还剩 n-k个结点,x=(m−1)n+n−k，即一个指针从链表头节点走到环入口的长度等于另一个指针从相遇的位置走 m-1圈后再走n-k的长度，也就是说两个指针相遇后，让一个指针回到头节点，另一个指针不动，然后他们同时往前每次走一步，当他们相遇时，相遇的节点即为环入口节点。
 *
 * 所以，我们设置两个指针，一个是快指针fast，一个是慢指针slow，fast一次走两步，slow一次走一步，如果单链表有环那么当两个指针相遇时一定在环内。此时将一个指针指到链表头部，另一个不变，二者同时每次向前移一格,当两个指针再次相遇时即为环的入口节点。如果fast走到null则无环。
 */

public class T56EntryNodeOfLoop {
    public static void main(String[] args) {

    }

    public static LinkedNode findEntryNodeOfLoop(LinkedNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

}
