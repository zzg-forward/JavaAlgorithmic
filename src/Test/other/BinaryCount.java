package Test.other;

/**
 * https://www.cnblogs.com/gleesu/p/6754513.html
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

public class BinaryCount {
    public static int numberOfOne1(int num){
        int count = 0;
        while (num != 0){
            if ((num & 1) == 1){
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }

    public static int numberOfOne2(int num){
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((num & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int numberOfOne3(int num){
        int count = 0;
        while (num != 0){
            num = (num -1) & num;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 200;
        System.out.println(numberOfOne1(num));
        System.out.println(numberOfOne2(num));
        System.out.println(numberOfOne3(num));
    }
}
