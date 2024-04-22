package chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 0 和 1 个数相同的子数组，该题思路和 Test10 类似，将 0 换为 -1，k = 0，就变成了 Test10，但是该题求的是子数组的最长长度。该题位于书中第24页
 * @author: Stone
 * @create: 2023-08-31 11:12
 **/
public class Test11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("输入只包含 0 和 1 的数组为（数字用英文逗号隔开）：");
            String inStr = scanner.next();
            String[] inArray = inStr.split(",");
            int[] paramArray = new int[inArray.length];
            for (int i = 0; i < inArray.length; i++) paramArray[i] = Integer.parseInt(inArray[i]);

            Integer result = findMaxLength2(paramArray);
            System.out.println("得到的结果为：" + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static Integer findMaxLength(int[] paramArray) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        Integer sum = 0;
        int result = 0;
        for (int i = 0; i < paramArray.length; i++) {
            sum += paramArray[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)) {
                result = Math.max(result, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return result;
    }

    private static int findMaxLength2(int[] nums) {
        HashMap<Integer, Integer> sumAndIndex = new HashMap<>();
        // sumAndIndex.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                maxLength = i + 1;
            } else {
                if (sumAndIndex.containsKey(sum)) {
                    // 不会再更新 key 为 sum 的 value，因为坐标要放最小的
                    // -1 1 1 1 -1 -1
                    maxLength = Math.max(maxLength, i - sumAndIndex.get(sum));
                } else {
                    sumAndIndex.put(sum, i);
                }
            }
        }
        return maxLength;
    }
}
