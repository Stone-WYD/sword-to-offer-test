package chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-22 15:28  RandomizedSet 可以随机读的集合（随机读、删除、添加时间复杂度都是O(1)）
 */
public class Test30 {

    private HashMap<Integer, Integer> map = new HashMap<>();

    private ArrayList<Integer> values = new ArrayList<>();

    public boolean insert(Integer value) {
        if (map.containsKey(value)) {
            return false;
        }
        map.put(value, values.size());
        return true;
    }

    public boolean remove(Integer value) {
        if (!map.containsKey(value)) return false;

        Integer index = map.get(value);
        // 把最后一位数据放入删除的位置
        Integer newV = values.get(values.size() - 1);
        map.remove(value);
        values.remove(index);
        map.put(newV, index);
        values.set(index, newV);
        return true;
    }

    public Integer getRandom() {
        int size = values.size();
        Random random = new Random();
        return values.get(random.nextInt(size));
    }


}