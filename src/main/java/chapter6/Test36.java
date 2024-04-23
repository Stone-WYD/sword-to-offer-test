package chapter6;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-23 15:05
 */

import java.util.Stack;

/**
 * 后缀表达式
 * */
public class Test36 {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "3", "*", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    Integer var1 = stack.pop();
                    Integer var2 = stack.pop();
                    stack.push(calculate(var2, var1, token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
       return stack.pop();
    }

    public static Integer calculate(Integer var1, Integer var2, String token) {
        switch (token) {
            case "+": return var1 + var2;
            case "-": return var1 - var2;
            case "*": return var1 * var2;
            case "/": return var1 / var2;
            default: return 0;
        }
    }
}