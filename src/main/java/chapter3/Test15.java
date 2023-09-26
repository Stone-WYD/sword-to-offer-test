package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 字符串中的所有变位词，本题位于书中第 35 页
 * @author: Stone
 * @create: 2023-09-26 13:43
 **/
public class Test15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入的数组第一个字符串为（可能被包含的字符串）：");
            String firStr = scanner.next();
            System.out.print("输入的数组第二个字符串为：");
            String secStr = scanner.next();
            // 计算结果
            List<Integer> result = findAnagrams(firStr, secStr);
            System.out.print("输入的结果为：" + result);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    // hash 法和双指针法，思路类似 Test14，再写一遍熟悉流程
    private static List<Integer> findAnagrams(String firStr, String secStr) {
        List<Integer> result = new ArrayList<>();
        char[] firStrCharArray = firStr.toCharArray();
        char[] secStrCharArray = secStr.toCharArray();
        int firStrLength = firStr.length();
        int secStrLength = secStr.length();
        if (firStrLength > secStrLength) {
            return result;
        }
        int[] counts = new int[26];
        // 初始化
        for (int i = 0; i < firStrLength; i++) {
            counts[firStrCharArray[i] - 'a'] += 1;
            counts[secStrCharArray[i] - 'a'] -= 1;
        }
        if (checkCounts(counts)) result.add(0);
        // 遍历 secStr
        for (int j = 0; j + firStrLength < secStrLength;) {
            counts[secStrCharArray[j] - 'a'] += 1;
            j++;
            counts[secStrCharArray[j + firStrLength - 1] - 'a'] -= 1;
            if (checkCounts(counts)) result.add(j);
        }
        return result;
    }

    private static boolean checkCounts(int[] result) {
        for (int i : result) {
            if (i != 0) return false;
        }
        return true;
    }
}
