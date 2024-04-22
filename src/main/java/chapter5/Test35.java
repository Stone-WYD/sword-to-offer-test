package chapter5;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-22 18:54
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 最小时间差：给定一组范围在00：00至23：59的时间，求任意两个时
 * 间之间的最小时间差。例如，输入时间数组["23：50"，"23：
 * 59"，"00：00"]，"23：59"和"00：00"之间只有1分钟的间隔，是最
 * 小的时间差。
* */
public class Test35 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("23：50");
        list.add("12：59");
        list.add("10：00");
        System.out.println(findMinDifference(list));
    }

    public static int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        boolean[] times = new boolean[1440];
        for (String timePoint : timePoints) {
            String[] timeStrs = timePoint.split("：");
            int mins = Integer.parseInt(timeStrs[0])  * 60 + Integer.parseInt(timeStrs[1]) ;
            if (times[mins]) return 0;
            times[mins] = true;
        }

        // 使用双指针法遍历数组
        int first = 1440, last = -1, pre = -1;
        int minDifference = 1440;
        for (int i = 0; i < times.length; i++) {
            if (times[i]) {
                // 最小的时间
                first = Math.min(first, i);
                // 最大的时间
                last = Math.max(last, i);
                if (pre == -1) {
                    pre = i;
                } else {
                    minDifference = Math.min(i - pre, minDifference);
                    pre = i;
                }
            }
        }
        minDifference = Math.min(first + 1440 - last, minDifference);
        return minDifference;
    }
}