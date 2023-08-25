package chapter2;

import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 排序数组中的两数之和，题目大意：数组从小到大排好序，在数组中找到使得两数之和为k的下标。本题在书中第 15 页
 * @author: Stone
 * @create: 2023-08-18 17:11
 **/
public class Test6 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("输入的数组为（数组需要从小到大排序，数字用英文逗号隔开）：");
            String inStr = scanner.next();
            String[] inArray = inStr.split(",");
            int[] paramArray = new int[inArray.length];
            for (int i = 0; i < inArray.length; i++) paramArray[i] = Integer.parseInt(inArray[i]);
            System.out.print("输入的两数之和为：");
            int k = scanner.nextInt();
            int[] result = twoSum2(paramArray, k);
            System.out.println("得到的两数下标为：" + result[0] + "," + result[1]);

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }
    
    /**
    * @Description: 使用hash法解决（这里hash表用数组构成，这种情况下需要保证传参中的数据都是正数，否则需要特殊处理，而此处的方法并没有做特殊处理）。空间复杂度为 O(n)，时间复杂度为 O(n)
    * @Author: Stone
    * @Date: 2023/8/18
    */
    private static int[] twoSum(int[] paramArray, int k) {
        int[] result = new int[2];
        // 将数组放入一个 hash表（这里hash表用数组构成，这种情况下需要保证传参中的数据都是正数）中，hash表key为数组中元素的值，value 为数组下标
        Integer[] hash = new Integer[paramArray[paramArray.length-1] + 1];
        for (int i = 0; i < paramArray.length; i++) {
            int value = paramArray[i];
            // 填充hash表
            hash[value] = i;
        }
        // 查找需要的结果下标
        for (int j = 0; j < paramArray.length; j++) {
            int value1 = paramArray[j];
            int value2 = k - value1;
            if (value2 <= 0) {
                break;
            }
            if (value2 >= hash.length) continue;
            if (hash[value2] != null) {
                result[0] = j;
                result[1] = hash[value2];
                break;
            }
        }
        return result;
    }

    /**
    * @Description: 上面的解法只是为了熟悉哈希法，其实并不适用本题，下面的解法使用双指针法
    * @Author: Stone
    * @Date: 2023/8/18
    */
    private static int[] twoSum2(int[] paramArray, int k){
        int i = 0;
        int j = paramArray.length - 1;
        while( i < j && paramArray[i]+paramArray[j]!=k ){
            if (paramArray[i] + paramArray[j] < k) {
                i++;
            } else j--;
        }
        int[] result ;
        if (i < j){
            result = new int[]{i, j};
        } else result = new int[]{0, 0};
        return result;
    }
}
