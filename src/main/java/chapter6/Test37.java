package chapter6;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-23 15:18
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 小行星相撞问题，正数向右，负数向左
 * */
public class Test37 {

    public static void main(String[] args) {
        Integer[] integers = asteroidCollision(new int[]{4, 5, -6, 4, 8, -5});
        for (Integer i : integers) {
            System.out.print(i + ", ");
        }
    }

    public static Integer[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            putAsteroidInStack(asteroid, stack);
        }
        if (stack.size() == 0) return null;
        Stack<Integer> stackForResult = new Stack<>();
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            stackForResult.push(pop);
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stackForResult.isEmpty()) {
            result.add(stackForResult.pop());
        }
        return result.toArray(new Integer[result.size()]);
    }

    private static void putAsteroidInStack(int asteroid, Stack<Integer> stack) {
        if (asteroid == 0) return;
        if (asteroid > 0) {
            // 大于 0 的情况直接放入
            stack.push(asteroid);
        } else {
            if (stack.isEmpty() || stack.peek() < 0) {
                // 直接放入
                stack.push(asteroid);
            } else {
                // 这种情况要计算一下，这一颗向左，上一颗向右
                Integer now = stack.pop();
                if (asteroid + now < 0) {
                    now = asteroid;
                }
                putAsteroidInStack(now, stack);
            }
        }
    }


}