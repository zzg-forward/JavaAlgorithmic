package 剑指offer;

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
