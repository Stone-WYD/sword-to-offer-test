package chapter2;

import java.util.Scanner;

/**
* @Description: 和大于或等于k的最短子数组，该题位于书中第18页
* @Author: Stone
* @Date: 2023/8/26
*/
public class Test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入的正数数组为（数字用英文逗号隔开）：");
            String inStr = scanner.next();
            String[] inArray = inStr.split(",");
            int[] paramArray = new int[inArray.length];
            for (int i = 0; i < inArray.length; i++) paramArray[i] = Integer.parseInt(inArray[i]);

            System.out.print("请输入正整数：");
            Integer k = scanner.nextInt();

            Integer result = minSubArrayLen(paramArray, k);
            System.out.println("得到的结果为：" + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static Integer minSubArrayLen(int[] paramArray, Integer k) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < paramArray.length; right++) {
            sum += paramArray[right];
            if (sum >= k){
                while (sum >= k){
                    sum -= paramArray[left++];
                }
                int temp = right - left + 2;
                result = Math.min(temp, result);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
