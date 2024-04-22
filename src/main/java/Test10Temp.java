import java.util.HashMap;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-22 21:30
 */
public class Test10Temp {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumAndIndex = new HashMap<>();
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumAndIndex.containsKey(sum - k)) {
                // 以 i 结尾，sum-k 对应的 v开头的子数组和为 k
                int tempResult = 0;
                int begin = sumAndIndex.get(sum - k);
                int m = i;
                while (++begin == ++m) tempResult++;
                result = Math.max(tempResult, result);
            }
        }
        return result;
    }

}