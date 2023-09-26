package chapter3;

import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 字符串中的变位词，大意：判断一个字符串中是否包含另一个字符串的某个变位词，本题位于书中第 31 页
 * @author: Stone
 * @create: 2023-09-26 09:37
 **/
public class Test14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入的数组第一个字符串为（可能被包含的字符串）：");
            String firStr = scanner.next();
            System.out.print("输入的数组第二个字符串为：");
            String secStr = scanner.next();
            // 计算结果
            boolean result = checkInclusion(firStr, secStr);
            System.out.print("输入的结果为：" + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    // 基于hash法和双指针法
    public static boolean checkInclusion(String firStr, String secStr) {
        int firStrLength = firStr.length();
        int secStrLength = secStr.length();
        if (secStrLength < firStrLength) return false;
        // 初始化记录单词的 hash 表
        int[] result = new int[26];
        char[] firCharArray = firStr.toCharArray();
        char[] secCharArray = secStr.toCharArray();
        for (int i = 0; i < firStrLength; i++) {
            result[firCharArray[i] - 'a'] += 1;
            result[secCharArray[i] - 'a'] -= 1;
        }
        if (checkResult(result)) return true;
        // 遍历第二个字符串
        int left = 0;
        int right = firStrLength - 1;
        for (; right < secStrLength - 1;) {
            result[secCharArray[left] - 'a'] += 1;
            right++;
            left++;
            result[secCharArray[right] - 'a'] -= 1;
            if (checkResult(result)) return true;
        }
        return false;
    }

    private static boolean checkResult(int[] result) {
        for (int i : result) {
            if (i != 0) return false;
        }
        return true;
    }
}
