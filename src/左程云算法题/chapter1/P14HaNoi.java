import java.util.Stack;

/**
 * 用栈解决汉诺塔问题
 * 非递归的方法
 * 似懂非懂啊
 *原则：小压大；相邻不可逆
 * 第一步绝对是左 → 中
 */
public class P14HaNoi {

    public enum Action{
        No, LToM, MToL, RToM, MToR
    }

    public static int hanoiProblem2(int num, String left, String mid, String right){
        Stack<Integer> LS = new Stack<Integer>();
        Stack<Integer> MS = new Stack<Integer>();
        Stack<Integer> RS = new Stack<Integer>();
        LS.push(Integer.MAX_VALUE);
        MS.push(Integer.MAX_VALUE);
        RS.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--)
            LS.push(i);
        Action[] record = new Action[]{Action.No};
        int step = 0;
        while (RS.size() != num + 1) {
            step += fStackTotStack(record, Action.MToL, Action.LToM, LS, MS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, MS, LS, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, MS, RS, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, RS, MS, right, mid);
        }
        return step;
    }

    private static int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack, String from, String to){
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    //for test
    public static void main(String[] args){
        int steps = P14HaNoi.hanoiProblem2(5, "left", "mid", "right");
        System.out.println(steps);
    }

}
