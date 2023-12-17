import java.io.IOException;
public class MatrixOperations {
    public static void main(String[] args) {
        try {
            int[][] matrix1 = MatrixUtils.readMatrix("matrix1.txt");
            int[][] matrix2 = MatrixUtils.readMatrix("matrix2.txt");
            System.out.println("Matrix 1:");
            MatrixUtils.printMatrix(matrix1);

            System.out.println("Matrix 2:");
            MatrixUtils.printMatrix(matrix2);

            int[][] sum = MatrixUtils.addMatrices(matrix1, matrix2);
            System.out.println("Sum:");
            MatrixUtils.printMatrix(sum);

            int[][] subtraction = MatrixUtils.SubtractionMatrices(matrix1, matrix2);
            System.out.println("Substrction:");
            MatrixUtils.printMatrix(subtraction);

            int[][] product = MatrixUtils.multiplyMatrices(matrix1, matrix2);
            System.out.println("Product:");
            MatrixUtils.printMatrix(product);

            int determinant1 = MatrixUtils.calculateDeterminant(matrix1);
            int determinant2 = MatrixUtils.calculateDeterminant(matrix2);
            System.out.println("Determinant of Matrix 1: " + determinant1);
            System.out.println("Determinant of Matrix 2: " + determinant2);
        } catch (IOException e) {
            System.out.println("Error reading matrix files: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid matrix operation: " + e.getMessage());
        }
    }
}