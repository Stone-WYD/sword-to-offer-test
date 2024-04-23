package chapter6;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-23 16:27
 */

import java.util.Stack;

/**
 * 直方图最大矩形面积
* */
public class Test39 {

    public static void main(String[] args) {
        // int[] params = {3, 2, 5, 4, 6, 1, 4, 2};
        int[] params = {1,1,3,2,2};
        System.out.println(largestRectangleArea2(params));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        return helper(0, heights.length-1, heights);
    }

    private static int helper(int beginIndex, int endIndex, int[] heights) {
        // 如果只有一根柱子
        if (beginIndex == endIndex) return heights[beginIndex];

        int shortHeightIndex = beginIndex;
        for (int i = beginIndex; i <= endIndex; i++) {
            if (heights[shortHeightIndex] > heights[i]) {
                shortHeightIndex = i;
            }
        }
        // 计算以最小柱子形成的矩形面积
        int result = heights[shortHeightIndex] * (endIndex - beginIndex + 1);
        // 如果shortHeightIndex在最左边
        if (beginIndex == shortHeightIndex)  return Math.max(result, helper(beginIndex + 1, endIndex, heights));
        // 如果shortHeightIndex在最右边
        if (endIndex == shortHeightIndex)  return Math.max(result, helper(beginIndex, endIndex - 1, heights));
        // 如果在中间
        result = Math.max(result, helper(beginIndex, shortHeightIndex, heights));
        result = Math.max(result, helper(shortHeightIndex, endIndex, heights));
        return result;
    }

    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < heights.length; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if (heights[stack.peek()] == heights[i]) {
                stack.push(i);
                if (i != heights.length - 1) {
                    // 如果等于，则直接跳过，最后或者后面遇到更小的时候再处理
                    continue;
                }
            } else {
                while (heights[stack.peek()] > heights[i]) {
                    Integer index = stack.pop();
                    int length;
                    if (stack.isEmpty()) {
                        length = i;
                    } else {
                        length = i - stack.peek() - 1;
                    }
                    result = Math.max(result, length * heights[index]);
                    if (stack.isEmpty()) break;
                }
                stack.push(i);
            }
            // push 最后一个元素后要计算最后得到的 result
            if (i == heights.length - 1) {
                while (!stack.isEmpty()) {
                    Integer index = stack.pop();
                    int length;
                    if (!stack.isEmpty()) {
                        length = i - stack.peek();
                    } else {
                        length = heights.length - index;
                    }
                    int height = heights[index];
                    result = Math.max(result, length * height);
                }
            }
        }
        return result;
    }
}