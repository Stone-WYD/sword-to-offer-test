package chapter3;

import java.util.*;

/**
 * @program: sword-to-offer-test
 * @description: 包含所有字符的最短字符串，本题位于书中第 39 页
 * @author: Stone
 * @create: 2023-09-26 15:08
 **/
public class Test17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入第一个字符串为(较小的字符串)：");
            String str1 = scanner.next();
            System.out.print("输入第二个字符串为：");
            String str2 = scanner.next();

            // 计算结果
            String shortSubStr = minWindow(str1, str2);
            System.out.println("包含所有字符的最短字符串为: " + shortSubStr);
            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static String minWindow(String str1, String str2) {
        int[] counts = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i)] += 1;
        }
        int num = 0;
        List<Map.Entry<Integer, Character>> entryList = new ArrayList<>();
        for (int j = 0; j < str2.length(); j++) {
            if (counts[str2.charAt(j)] >= 1) {
                entryList.add(num++, new AbstractMap.SimpleEntry<>(j, str2.charAt(j)));
            }
        }

        int left = 0;
        int right = 0;

        int minleft = 0;
        int minright = Integer.MAX_VALUE;
        int gap = Integer.MAX_VALUE;
        for (; right < entryList.size(); right++) {
            counts[entryList.get(right).getValue()] -= 1;
            while (noOneMoreThan0(counts)) {
                int newGap = entryList.get(right).getKey() - entryList.get(left).getKey();
                if (newGap < gap) {
                    gap = newGap;
                    minleft = entryList.get(left).getKey();
                    minright = entryList.get(right).getKey();
                }
                counts[entryList.get(left++).getValue()] += 1;
            }
        }
        if (minright != Integer.MAX_VALUE) {
            return str2.substring(minleft, minright + 1);
        }
        return "";
    }

    private static boolean noOneMoreThan0(int[] counts) {
        for (int count : counts) {
            if (count > 0) return false;
        }
        return true;
    }

}
