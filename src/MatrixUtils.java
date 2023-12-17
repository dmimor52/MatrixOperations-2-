import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class MatrixUtils {
    public static int[][] readMatrix(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        String[] rows = sb.toString().split("\n");
        int numRows = rows.length;
        int numCols = rows[0].split(" ").length;
        int[][] matrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            String[] row = rows[i].split(" ");
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) throws IllegalArgumentException {
        int numRows1 = matrix1.length;
        int numCols1 = matrix1[0].length;
        int numRows2 = matrix2.length;
        int numCols2 = matrix2[0].length;
        if (numRows1 != numRows2 || numCols1 != numCols2) {
            throw new IllegalArgumentException("Matrices have different sizes!");
        }
        int[][] result = new int[numRows1][numCols1];
        for (int i = 0; i < numRows1; i++) {
            for (int j = 0; j < numCols1; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    public static int[][] SubtractionMatrices(int[][] matrix1, int[][] matrix2) throws IllegalArgumentException {
        int numRows1 = matrix1.length;
        int numCols1 = matrix1[0].length;
        int numRows2 = matrix2.length;
        int numCols2 = matrix2[0].length;
        if (numRows1 != numRows2 || numCols1 != numCols2) {
            throw new IllegalArgumentException("Matrices have different sizes!");
        }
        int[][] result = new int[numRows1][numCols1];
        for (int i = 0; i < numRows1; i++) {
            for (int j = 0; j < numCols1; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) throws IllegalArgumentException {
        int numRows1 = matrix1.length;
        int numCols1 = matrix1[0].length;
        int numRows2 = matrix2.length;
        int numCols2 = matrix2[0].length;
        if (numCols1 != numRows2) {
            throw new IllegalArgumentException("Incompatible matrix dimensions for multiplication!");
        }
        int[][] result = new int[numRows1][numCols2];
        for (int i = 0; i < numRows1; i++) {
            for (int j = 0; j < numCols2; j++) {
                for (int k = 0; k < numCols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static int calculateDeterminant(int[][] matrix) throws IllegalArgumentException {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        if (numRows != numCols) {
            throw new IllegalArgumentException("Matrix is not square!");
        }
        if (numRows == 1) {
            return matrix[0][0];
        }
        int determinant = 0;
        for (int i = 0; i < numCols; i++) {
            int[][] subMatrix = new int[numRows - 1][numCols - 1];
            for (int j = 1; j < numRows; j++) {
                for (int k = 0, l = 0; k < numCols; k++) {
                    if (k != i) {
                        subMatrix[j - 1][l++] = matrix[j][k];
                    }
                }
            }
            int subDeterminant = calculateDeterminant(subMatrix);
            determinant += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * subDeterminant;
        }
        return determinant;
    }
}