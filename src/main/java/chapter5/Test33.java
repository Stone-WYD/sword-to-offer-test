package chapter5;

import java.util.*;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-22 16:20 变位词分组
 */
public class Test33 {

    public List<List<String>> groupAnagarms(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = charArray.toString();
            groups.putIfAbsent(sorted, new LinkedList<>());
            groups.get(sorted).add(str);
        }
        return new LinkedList<>(groups.values());
    }

}