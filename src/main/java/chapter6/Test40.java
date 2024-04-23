package chapter6;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-23 19:24
 */

import static chapter6.Test39.largestRectangleArea;
import static chapter6.Test39.largestRectangleArea2;

/**
 * 矩阵中的最大矩形
 * */
public class Test40 {
    public static void main(String[] args) {
        char[][] matrix = new char[4][5];
        init(matrix);
        System.out.println(maximalRectangle(matrix));
    }

    private static void init(char[][] matrix) {
        matrix[0] = new char[]{'1', '0', '0', '1', '0'};
        matrix[1] = new char[]{'1', '1', '1', '1', '1'};
        matrix[2] = new char[]{'0', '0', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '1', '0', '0'};
    }

    public static int maximalRectangle(char[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] params = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                int param = 0;
                for (int k = i; k < matrix.length; k++) {
                    if (matrix[k][j] == '1') {
                        param++;
                    } else break;
                }
                params[j] = param;
            }
            result = Math.max(result, largestRectangleArea(params));
        }
        return result;
    }
}