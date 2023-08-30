package chapter2;

import java.util.Scanner;

/**
* @Description: 乘积小于k的数组，本地位于书中第21页。思路：本题的关键在于：每当 right 右移后，新增的结果数是 right - left + 1。right 右移一次后。新增的结果数是在之前已经计算过的连续数组增加一个新数后新增的结果数。
* @Author: Stone
* @Date: 2023/8/29
*/
public class Test9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("输入的正数数组为（数字用英文逗号隔开）：");
            String inStr = scanner.next();
            String[] inArray = inStr.split(",");
            int[] paramArray = new int[inArray.length];
            for (int i = 0; i < inArray.length; i++) paramArray[i] = Integer.parseInt(inArray[i]);

            System.out.print("请输入正整数：");
            Integer k = scanner.nextInt();

            Integer result = numSubarrayProductLessThanK(paramArray, k);
            System.out.println("得到的结果为：" + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static Integer numSubarrayProductLessThanK(int[] paramArray, Integer k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int right = 0; right < paramArray.length; right++) {
            product *= paramArray[right];
            while (left <= right && product >= k){
                product /= paramArray[left++];
            }
            count += left <= right ? right - left + 1 : 0;
        }
        return count;
    }
}
