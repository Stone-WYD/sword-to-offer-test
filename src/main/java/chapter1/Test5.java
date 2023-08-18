package chapter1;

import java.util.*;

/**
 * @program: sword-to-offer-test
 * @description: 单词长度的最大乘积，大致内容：输入一个包含多个单词（单词由小写字母组成）的数组，求数组中没有相同字母的两个单词长度乘积的最大值。本题位于书中第 10 页
 * @author: Stone
 * @create: 2023-08-18 09:16
 **/
public class Test5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入的数组为（单词间英文逗号隔开）：");
            String inStr = scanner.next();
            String[] inArray = inStr.split(",");
            int result = maxProduct2(inArray);

            System.out.println("得到的结果为：" + result );
            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    /**
    * @Description: 解法1：利用hash表存储每个单词各个字母，比较两个单词时，通过hash表查询速度更快。此处使用二维数组表示hash表，占用空间更少
    * @Author: Stone
    * @Date: 2023/8/18
    */
    private static int maxProduct(String[] paramArray) {
        // 创建数组，根据单词字母情况填充数组第二维
        boolean[][] flags = new boolean[paramArray.length][26];
        for (int i = 0; i < flags.length; i++) {
            for (char c : paramArray[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }
        // 使用for嵌套for循环，找到没有重复的单词，得出乘积
        int result = 0;
        for (int i = 0; i < paramArray.length - 1; i++) {
            // 第一个单词
            for (int j = i + 1 ; j < paramArray.length; j++) {
                // 第二个单词
                int k = 0;
                for (; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        // 有相同的字符
                        break;
                    }
                }
                if (k == 26){
                    // 两个单词没有重复字母
                    int resultTemp = paramArray[i].length() * paramArray[j].length();
                    result = Math.max(result, resultTemp);
                }
            }
        }
        return result;
    }

    private static int maxProduct2(String[] paramArray){
        int length = paramArray.length;
        int[] flags = new int[length];
        for (int i = 0; i < length; i++) {
            for (char p : paramArray[i].toCharArray()) {
                flags[i] |= 1 << ( p -'a');
            }
        }
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    // 没有重复的字母
                    int resultTemp = paramArray[i].length() * paramArray[j].length();
                    result = Math.max(result, resultTemp);
                }
            }
        }
        return result;
    }

}
