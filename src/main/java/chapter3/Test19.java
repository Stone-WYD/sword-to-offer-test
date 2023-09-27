package chapter3;

import java.util.Scanner;


/**
 * @program: sword-to-offer-test
 * @description: 删除一个字符是否能变成回文串，本题位于书中第 43 页
 * @author: Stone
 * @create: 2023-09-27 15:17
 **/
public class Test19 {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入的字符串为：");
            String inputStr = scanner.nextLine();

            // 计算结果
            boolean result = validPalindrome(inputStr);
            System.out.println("对多删除一个字符能否得到回文: " + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static boolean validPalindrome(String inputStr) {
        int left = 0;
        int right = inputStr.length() - 1;
        while (left < inputStr.length() / 2) {
            if (inputStr.charAt(left) != inputStr.charAt(right)){
                break;
            }
            left++;
            right--;
        }
        return left >= right || isPalindrome(inputStr ,left + 1, right)
                || isPalindrome(inputStr ,left, right - 1);
    }

    private static boolean isPalindrome(String inputStr, int left, int right) {
        while (left < right){
            if (inputStr.charAt(left) != inputStr.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
