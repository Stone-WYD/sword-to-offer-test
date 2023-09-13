package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 数组中和为0的3个数字。本题在书中第17页
 * @author: Stone
 * @create: 2023-08-18 18:04
 **/
public class Test7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入的数组为（数字用英文逗号隔开）：");
            String inStr = scanner.next();
            String[] inArray = inStr.split(",");
            int[] paramArray = new int[inArray.length];
            for (int i = 0; i < inArray.length; i++) paramArray[i] = Integer.parseInt(inArray[i]);
            List<List<Integer>> result = threeSum(paramArray);
            System.out.println("得到的结果为：");
            for (List<Integer> integers : result) {
                System.out.println(integers);
            }

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length >= 3){
            // 排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; ){
                // 化为求两数之和
                twoSum(nums, i, result);
                // 去重
                while (nums[i] == nums[i + 1]){
                    i ++;
                }
                i++;
            }
        }
        return result;
    }

    private static void twoSum(int[] nums, int i, List<List<Integer>> result) {
        // 求两数之和
        int m = i + 1;
        int n = nums.length - 1;
        while (m < n ){
            if (nums[m] + nums[n] + nums[i] == 0){
                result.add(Arrays.asList(nums[i], nums[m], nums[n]));
                // 去重
                while (nums[m] == nums[++m]){
                }
                while (nums[n] == nums[--n]){
                }
            } else {
                if (nums[m] + nums[n] + nums[i] < 0){
                    m++;
                } else {
                    n--;
                }
            }
        }
    }
}
