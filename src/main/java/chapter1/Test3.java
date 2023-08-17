package chapter1;

import java.util.Scanner;


/**
 * @program: sword-to-offer-test
 * @description: 前n个数字二进制形式中1的个数，本题位于书中第 6 页
 * @author: Stone
 * @create: 2023-08-17 15:11
 **/
public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入n的值为：");
            Integer n = scanner.nextInt();
            int[] result = countBits3(n);
            StringBuilder resultStr = new StringBuilder("[");
            for (int i : result) {
                resultStr.append(i).append(",");
            }
            resultStr.replace(resultStr.length()-1, resultStr.length(), "]");
            System.out.println("返回结果为：" + resultStr);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    /**
    * @Description: 一种高效计算一个数字i二进制形式中 1 的数量，一次 i&(i-1) 运算可以去掉一个1，运算到最后会变成 0，运算次级即是结果，按照这个思路，就有了下面的解法，但是这个解法时间复杂度为 O(nk)
    * @Author: Stone
    * @Date: 2023/8/17
    */
    private static int[] countBits1(Integer n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int r = 0;
            int j = i;
            while(j != 0){
                j = j & (j-1);
                r ++;
            }
            result[i] = r;
        }
        return result;
    }

    private static int[] countBits2(Integer n) {
        int[] result = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            result[i] = result[i&(i-1)] + 1;
        }
        return result;
    }

    /**
    * @Description: 如果是偶数，那么数字 i 二进制形式中 1 的数量 与 i/2 的数量是相等的，如果是奇数，那么比 i/2 的数量多 1。 i>>1 比 i/2 高效，i&1 比 i%2 高效
    * @Author: Stone
    * @Date: 2023/8/17
    */
    private static int[] countBits3(Integer n){
        int[] result = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i] = result[i >> 1] + ( i & 1 );
        }
        return result;
    }
}
