package LeetCode;

/**
 * 题意是给你 a1, a2, ..., an 这 n 个数，代表 (i, ai) 坐标，让你从中找两个点与 x 轴围成的容器可以容纳最多的水。
 *
 * 我们可以探索下是否有更巧妙的办法呢，题目的标签有双指针，是否就可以想到首尾各放一指针，然后根据条件来收缩。首先计算一次首尾构成的最大面积，然后分析下该移动哪个指针，如果移动大的那个指针的话，那样只会减小面积，所以我们要移动小的那个指针，小的那个指针移动到哪呢？当然是移动到大于之前的值的地方，否则面积不都比之前小么，然后继续更新最大值即可，借助如上分析写出如下代码应该不是什么难事了吧。
 *
 */

public class T011MaxArea {
    public static void main(String[] args) {
        System.out.println(getMaxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
//        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    private static int getMaxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(heights[left], heights[right]));
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0, h = 0;
        while (l < r) {
            h = Math.min(height[l], height[r]);
            max = Math.max(max, (r - l) * h);
            while (height[l] <= h && l < r) ++l;
            while (height[r] <= h && l < r) --r;
        }
        return max;
    }

}
