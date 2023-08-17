package chapter1;

import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 只出现一次的数字。题目位于书中第 8 页
 * @author: Stone
 * @create: 2023-08-17 17:45
 **/
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入的数组为（数字间英文逗号隔开）：");
            String inStr = scanner.next();
            String[] inArray = inStr.split(",");
            int[] paramArray = new int[inArray.length];
            for (int i = 0; i < inArray.length; i++) paramArray[i] = Integer.parseInt(inArray[i]);
            int result = singleNumber(paramArray);

            System.out.println("得到的结果为：" + result );
            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    /**
    * @Description: 思路：除了要找的那个数字，其他数字在数组中都出现过三次，对数组中所有数字二进制的每一位进行加法操作，如果和是三的倍数或者0，说明所求数字在该位的值为0，否则说明所求数字在该位的值为1
    * @Author: Stone
    * @Date: 2023/8/17
    */
    private static int singleNumber(int[] paramArray) {
        // 模拟所求值的32位
        int[] bitSums = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int param : paramArray) {
                // 注意 bitSums 数组的第一位为最高位
                bitSums[i] += (param >> (31-i)) & 1;
            }
        }
        int result = 0;
        for (int bitSum : bitSums) {
            result = (result << 1) + bitSum % 3;
        }
        return result;
    }
}
