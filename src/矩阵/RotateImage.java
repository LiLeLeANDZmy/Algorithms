package 矩阵;

import java.util.*;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        System.out.println("原始矩阵：");
        printMatrix(matrix);

        // 第一步：对角线翻转（转置）
        System.out.println("\n开始对角线翻转...");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println("交换 matrix[" + i + "][" + j + "] 和 matrix[" + j + "][" + i + "]");
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("\n转置后矩阵：");
        printMatrix(matrix);

        // 第二步：水平翻转每一行（即左右交换）
        System.out.println("\n开始每一行水平反转...");
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                System.out.println("行 " + i + "：交换 matrix[" + i + "][" + left + "] 和 matrix[" + i + "][" + right + "]");
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

        System.out.println("\n最终旋转后矩阵：");
        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // 测试入口
    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        solution.rotate(matrix);
    }
}
