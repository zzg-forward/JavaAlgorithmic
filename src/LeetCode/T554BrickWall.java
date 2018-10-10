package LeetCode;

import java.util.*;

/**
 *
 * Brick Wall
 * Description
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 *
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 *
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 *
 * 题意根据图示已经描述得很清楚了，就是在从底部到顶部，求最少交叉的数量，我们可以把每堵墙可以穿过的地方保存到哈希表中，每次遇到哈希表中的值加一，代表就是这条路不用交叉的数量，最终我们可以算出不用交叉的最大值，让总墙数减去其值就是最少交叉的数量。
 *
 * map的使用
 */

public class T554BrickWall {
    public static void main(String[] args) {
        List<Integer> temp = Arrays.asList(1,3,1,1);
        List<Integer> temp1 = Arrays.asList(3,1,2);
        List<Integer> temp2 = Arrays.asList(2,4);
        List<Integer> temp3 = Arrays.asList(1,3,2);
        List<Integer> temp4 = Arrays.asList(3,1,2);
        List<Integer> temp5 = Arrays.asList(1,2,2,1);
        List<ArrayList<Integer>> myList = new ArrayList<>();
        myList.add(new ArrayList<Integer>(temp));
        myList.add(new ArrayList<Integer>(temp1));
        myList.add(new ArrayList<Integer>(temp2));
        myList.add(new ArrayList<Integer>(temp3));
        myList.add(new ArrayList<Integer>(temp4));
        myList.add(new ArrayList<Integer>(temp5));
        int result = crossLeastBricks(new ArrayList<>(myList));
        System.out.println(result);

    }

    private static int crossLeastBricks (List<List<Integer>> brickList) {
        if (brickList == null || brickList.size() == 0)
            return 0;
        Map<Integer, Integer> resultMap = new HashMap<>();
        int maxBlank = 0;
        for (List<Integer> rowList : brickList) {
            int p = 0;
            for (int i = 0, len = rowList.size() - 1; i < len; i++) {    //注意这里是小于len，因为不穿过墙的边缘
                p += rowList.get(i);
                Integer heightCount = resultMap.get(p);
                resultMap.put(p, (heightCount == null ? 0 : heightCount) + 1);
            }
        }
        for (Integer heightCount : resultMap.values()) {
            if (heightCount >= maxBlank)
                maxBlank = heightCount;
        }
        return brickList.size() - maxBlank;
    }
}
