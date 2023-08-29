package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* @Description: 乘积小于k的数组，本地位于书中第21页
* @Author: Stone
* @Date: 2023/8/29
*/
public class Test9 {
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

            List<List<Integer>> result = numSubarrayProductLessThanK(paramArray, k);
            for (List<Integer> integers : result) {
                System.out.println(integers);
            }

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static List<List<Integer>> numSubarrayProductLessThanK(int[] paramArray, Integer k) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < paramArray.length;) {
            while (left == right && paramArray[left] >= k){
                left++;
                right++;
            }
            while (right > left && numSubarrayProduct(paramArray, left, right) >= k) {
                left++;
            }
            if (right >= left && numSubarrayProduct(paramArray, left, right) < k){
                // 符合题意的情况
                List<Integer> r = new ArrayList<>();
                result.add(r);
                for (int t = left; t <= right; t++) {
                    r.add(paramArray[t]);
                }
                right++;
            }
        }
        return result;

    }

    private static Integer numSubarrayProduct(int[] paramArray, int left, int right) {
        if (left == right) {
            return paramArray[left];
        }
        Integer result = paramArray[left];
        for (int i = left + 1; i <= right; i++) {
            result = result * paramArray[i];
        }
        return result;
    }
}
