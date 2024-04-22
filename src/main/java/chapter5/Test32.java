package chapter5;

import java.sql.SQLOutput;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-22 16:00 有效的变位词
 */
public class Test32 {

    public static void main(String[] args) {
        Test32 test32 = new Test32();
        System.out.println(test32.check("abcde", "Acdeb"));
    }

    public boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] nums = new int[52];
        for (char c : s1.toCharArray()) {
            nums[c - 'A']++;
        }
        for (char c : s2.toCharArray()) {
            if (--nums[c - 'A'] != 0) {
                return false;
            }
        }
        return true;
    }
}