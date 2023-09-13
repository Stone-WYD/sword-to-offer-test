package chapter2;


/**
 * @program: sword-to-offer-test
 * @description: 二维子矩阵的数字之和，该题位于书中第26页
 * @author: Stone
 * @create: 2023-09-01 09:00
 **/
public class Test13 {

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{3, 0, 1, 4, 2};
        matrix[1] = new int[]{5, 6, 3, 2, 1};
        matrix[2] = new int[]{1, 2, 0, 1, 5};
        matrix[3] = new int[]{4, 1, 0, 1, 7};
        matrix[4] = new int[]{1, 0, 3, 0, 5};

        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }

    static class NumMatrix {
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

        // 求解题目，因为 sums 数组第一排第一列数据都是 0，所以计算的时候，如果涉及到 row2、col2都需要 ＋1
        public int sumRegion(int row1, int col1, int row2, int col2){
            return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
        }
    }
}
