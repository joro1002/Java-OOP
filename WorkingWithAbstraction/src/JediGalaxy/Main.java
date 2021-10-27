package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = dimentions[0];
        int m = dimentions[1];

        int[][] matrix = new int[n][m];

        fillMatrix(n, m, matrix);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] row = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] col = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int currentRow = col[0];
            int currentCol = col[1];

            while (currentRow >= 0 && currentCol >= 0) {
                if (isInBound(matrix, currentRow, currentCol)) {
                    matrix[currentRow][currentCol] = 0;
                }
                currentRow--;
                currentCol--;
            }

            int xI = row[0];
            int yI = row[1];

            while (xI >= 0 && yI < matrix[1].length) {
                if (isInBound(matrix, xI, yI)) {
                    sum += matrix[xI][yI];
                }

                yI++;
                xI--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static boolean isInBound(int[][] matrix, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[0].length;
    }

    private static void fillMatrix(int n, int m, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
