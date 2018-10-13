package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 题意是给你一组区间，让你把区间合并成没有交集的一组区间。我们可以把区间按 start 进行排序，然后遍历排序后的区间，如果当前的 start 小于前者的 end，那么说明这两个存在交集，我们取两者中较大的 end 即可；否则的话直接插入到结果序列中即可。
 *
 */
public class T056MergeIntervals {
    public static void main(String[] args) {

    }

    private static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)
            return intervals;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                if (o1.start > o2.start) return  1;
                return 0;
            }
        });

        List<Interval> ans = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end)
                end = Math.max(end, interval.end);
            else {
                ans.add(new Interval(
                        start,
                        end
                ));
                start = interval.start;
                end = interval.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}



class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }