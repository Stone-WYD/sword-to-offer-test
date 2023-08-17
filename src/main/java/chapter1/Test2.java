package chapter1;

import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 二进制加法，大致内容：输入两个二进制字符串，返回相加后结果的二进制字符串。本题在书中第 5 页
 * @author: Stone
 * @create: 2023-08-17 14:24
 **/
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入第一个加数二进制字符串为：");
            String m = scanner.next();
            System.out.print("输入第二个加数二进制字符串为：");
            String i = scanner.next();
            String result = addBinary(m, i);
            System.out.println("得到的结果为：" + result );

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    /**
    * @Description: 两个需要注意的点：1.如何将数字的char转变为数字的int 2.注意字符串的最后一位是最低位，注意计算起始位置和得到结果后要reverse倒转一下
    * @Author: Stone
    * @Date: 2023/8/17
    */
    private static String addBinary(String m, String n) {

        StringBuilder result = new StringBuilder();

        int a = m.length() - 1;
        int b = n.length() - 1;
        int carry = 0;

        while(a>=0 || b>=0){
            int digitM = a>=0 ? m.charAt(a) - '0'  : 0;
            int digitN = b>=0 ? n.charAt(b) - '0' : 0;
            int temp = digitN + digitM + carry;
            result.append( (temp == 1 || temp == 3) ? '1' : '0');
            carry = temp >= 2 ? 1 : 0;
            a--;
            b--;
        }
        if (carry == 1) result.append('1');
        return result.reverse().toString();
    }
}
