package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 二维子矩阵的数字之和，该题位于书中第26页
 * @author: Stone
 * @create: 2023-09-01 09:00
 **/
public class Test13 {



    class NumMatrix {
        private int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            // 初始化 sums 数组
            sums = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                // 当前行元素值累加值
                int rowSum = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    rowSum += matrix[i][j];
                    sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
                }
            }
        }
    }
}
