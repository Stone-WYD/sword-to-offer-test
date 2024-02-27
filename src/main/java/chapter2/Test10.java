package chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 和为 k 的子数组，数组中的数字有正有负，不能用双指针法，使用累加法解决，此题需要特别注意初始化操作的原因。此题位于书中第22页
 * @author: Stone
 * @create: 2023-08-31 09:06
 **/
public class Test10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("输入的数组为（数字用英文逗号隔开）：");
            String inStr = scanner.next();
            String[] inArray = inStr.split(",");
            int[] paramArray = new int[inArray.length];
            for (int i = 0; i < inArray.length; i++) paramArray[i] = Integer.parseInt(inArray[i]);

            System.out.print("请输入一个整数：");
            Integer k = scanner.nextInt();

            Integer result = subarraySum(paramArray, k);
            System.out.println("得到的结果为：" + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static Integer subarraySum(int[] paramArray, Integer k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        // 空集是任何集合的子集，所以 null 也是 paramArray 的子数组，null 中元素集合的和为 0，
        // 所以这里需要进行 put(0, 1) 操作。如果没有该初始化操作，得到第一个符合条件的子数组就会向后推移，出现错误
        sumToCount.put(0, 1);
        // 和为 k 的次数
        Integer count = 0;
        Integer sum = 0;
        for (int j : paramArray) {
            sum += j;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
