/**
 * 打印俩个有序链表的公共部分
 */
public class P34PrintNode {

    public static void printCommonPart(LinkNode head1, LinkNode head2){
        System.out.println("common part: ");
        while (head1 != null && head2 != null){
            if (head1.value < head2.value){
                head1 = head1.next;
            }else if (head1.value > head2.value) {
                head2 = head2.next;
            }else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

}

class LinkNode{
    public int value;
    public LinkNode next;
    public LinkNode(int value){
        this.value = value;
    }
}
