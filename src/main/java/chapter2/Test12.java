package chapter2;

import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 左右两边子数组的和相等，此题仍是使用累加法，位于书中第25页
 * @author: Stone
 * @create: 2023-09-01 08:50
 **/
public class Test12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("输入数组为（数字用英文逗号隔开）：");
            String inStr = scanner.next();
            String[] inArray = inStr.split(",");
            int[] paramArray = new int[inArray.length];
            for (int i = 0; i < inArray.length; i++) paramArray[i] = Integer.parseInt(inArray[i]);

            Integer result = pivotIndex(paramArray);
            System.out.println("得到的结果为：" + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static Integer pivotIndex(int[] paramArray) {
        // 计算数组元素总和
        int paramArraySum = 0;
        for (int i : paramArray) paramArraySum += i;
        // 开始求目标下标
        int sum = 0;
        for (int i = 0; i < paramArray.length; i++) {
            if (sum == (paramArraySum - sum - paramArray[i])) return i;
            sum += paramArray[i];
        }
        return -1;
    }
}
