package chapter3;

import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 给定一个字符串，请问该字符串中有多少个回文连续子字符串
 * @author: Stone
 * @create: 2024-02-23 10:46
 **/
public class Test20 {

    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入的字符串为：");
            String inputStr = scanner.nextLine();

            // 计算结果
            int result = countSubstrings(inputStr);
            System.out.println("该字符串中有回文连续子字符串的个数为: " + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static int countSubstrings(String inputStr) {
        // null 情况

        if (inputStr == null || inputStr.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            count += countPalindrome(inputStr, i, i);
            count += countPalindrome(inputStr, i, i + 1);
        }
        return count;
    }

    private static int countPalindrome(String inputStr, int left, int right) {
        int length = inputStr.length();
        if (left >= length || right >= length) return 0;

        int count = 0;
        while (true) {
            if (left < 0 || right > length - 1) {
                break;
            }
            if (inputStr.charAt(left--) == inputStr.charAt(right++)) {
                count++;
            } else {
                break;
            }
        }
        return count;

    }
}



