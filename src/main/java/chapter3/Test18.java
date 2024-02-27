package chapter3;

import java.util.Locale;
import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 有效回文，判断一个字符串是否是回文串，本题位于书中第 42 页
 * @author: Stone
 * @create: 2023-09-26 17:06
 **/
public class Test18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入的字符串为：");
            String inputStr = scanner.nextLine();

            // 计算结果
            boolean result = isPalindrome(inputStr);
            System.out.println("输入字符串是否为回文串: " + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    // 双指针
    private static boolean isPalindrome(String inputStr) {
        String lowerCase = inputStr.toLowerCase(Locale.ROOT);
        int left = 0;
        int right = lowerCase.length() - 1;
        while (right - left > 0) {
            while (!Character.isLetterOrDigit(lowerCase.charAt(left))) left++;
            while (!Character.isLetterOrDigit(lowerCase.charAt(right))) right--;
            if (lowerCase.charAt(left) != lowerCase.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
