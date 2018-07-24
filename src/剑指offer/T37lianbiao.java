package 剑指offer;

public class T37lianbiao {

    public static <T> Node<T> getFirstCommonNode(Node<T> first1, Node<T> first2){
        if (first1 == null || first2 == null){
            System.out.println("链表为空");
            return null;
        }

        int len1 = 0;
        Node<T> p = first1;
        while (p != null){
            len1++;
            p = p.next;
        }

        int len2 = 0;
        p = first2;
        while (p != null){
            len2++;
            p = p.next;
        }

        int diffLen = len1 - len2;
        int i = 0;
        if (diffLen > 0){
            while (i < diffLen){  //小于，没有等于
                first1 = first1.next;
                i++;
            }
        }else {
            while (i < -diffLen){  //小于，没有等于
                first2 = first2.next;
                i++;
            }
        }

        while (first1 != null && first2 != null && first1 != first2) {
            first1 = first1.next;
            first2 = first2.next;
        }
        return first1;

    }

    public static void main(String[] args) {
        //创建两个链表
        Node<Integer> first1 = new Node<Integer>(111);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> first2 = new Node<Integer>(4);
        Node<Integer> node4 = new Node<Integer>(5);
        Node<Integer> node5 = new Node<Integer>(222);

        first1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        first2.next = node3;

        System.out.println(getFirstCommonNode(first1, first2).date);

    }

}

class Node<T>{
    public T date;
    public Node<T> next;

    public Node(T date) {
        this.date = date;
    }

}
