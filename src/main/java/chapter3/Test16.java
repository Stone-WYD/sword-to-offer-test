package chapter3;

import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 不含重复字符的最长子字符串，本题位于书中第 36 页
 * @author: Stone
 * @create: 2023-09-26 14:05
 **/
public class Test16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入一个字符串为：");
            String inputStr = scanner.next();
            // 计算结果
            Integer result = lengthOfLongestSubstring2(inputStr);
            System.out.println("最长子字符串的长度为: " + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    // 解法 1：使用hash法和双指针法解，但需要遍历多遍hash表
    private static Integer lengthOfLongestSubstring(String inputStr) {
        if (inputStr.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        // 遍历字符数组
        int right = 0;
        int left = -1;
        int result = 0;
        for (; right < inputStr.length(); right++) {
            counts[inputStr.charAt(right)] += 1;
            while (oneNumMoreThan1(counts)) {
                counts[inputStr.charAt(++left)] -= 1;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

    // 解法 2：优化解法 1 需要遍历 hash 表的缺点
    private static Integer lengthOfLongestSubstring2(String inputStr) {
        if (inputStr.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        // 遍历字符数组
        int right = 0;
        int left = -1;
        int countDup = 0;
        int result = 0;
        for (; right < inputStr.length(); right++) {
            counts[inputStr.charAt(right)] += 1;
            if (counts[inputStr.charAt(right)] > 1) {
                countDup++;
            }
            while (countDup > 0){
                left++;
                counts[inputStr.charAt(left)] -= 1;
                if (inputStr.charAt(left) == inputStr.charAt(right)){
                    countDup--;
                }
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

    private static boolean oneNumMoreThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
