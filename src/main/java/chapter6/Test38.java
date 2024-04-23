package chapter6;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-23 16:00
 */

import java.util.Stack;

/**
 * 每日温度
* */
public class Test38 {

    public static void main(String[] args) {
        int[] temperatures = {35, 31, 33, 36, 34};
        int[] result = dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 没有之前的温度，则存入
            if (stack.isEmpty()){
                stack.push(i);
                continue;
            }
            // 取出温度进行计算
            while (temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                result[pop] = i - pop;
                if (stack.isEmpty()) break;
            }
            stack.push(i);
        }
        return result;
    }
}