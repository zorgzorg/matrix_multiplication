package labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Finn on 08.06.2017.
 */
public class MatrixMultiplication {
    private static final int RANDOM_LIMIT = 5;

    public static void main(String[] args) {
        int rowMatrix1;
        int columnMatrix1;
        int rowMatrix2;
        int columnMatrix2;

        System.out.println("Умножение двух двумерных матриц");
        System.out.println("(количество столбцов первой матрицы должно быть равно количеству строк второй матрицы)");

        rowMatrix1 = getUserInput("Укажите количество строк (матрица 1):");
        columnMatrix1 = getUserInput("Укажите количество столбцов (матрица 1):");
        rowMatrix2 = getUserInput("Укажите количество строк (матрица 2):");
        columnMatrix2 = getUserInput("Укажите количество столбцов (матрица 2):");;

        if(columnMatrix1==rowMatrix2){
            int[][] matrix1;
            int[][] matrix2;
            int[][] matrixResult;

            matrix1 = makeMatrix(rowMatrix1, columnMatrix1);
            matrix2 = makeMatrix(rowMatrix2, columnMatrix2);

            System.out.println("Матрица 1");
            printMatrix(matrix1);

            System.out.println("Матрица 2");
            printMatrix(matrix2);

            System.out.println("Результат умножения матриц 1 и 2");
            matrixResult = multiplyMatrix(matrix1, matrix2);
            printMatrix(matrixResult);
        } else {
            System.out.println("Количество столбцов матрицы 1 не равно количеству строк матрицы 2. Умножение матриц невозможно.");
        }

    }

    public static int getUserInput(String prompt){
        int number = 0;
        boolean isNumber = false;

        System.out.print(prompt + " ");

        while(!isNumber) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                number = Integer.parseInt(reader.readLine());
                if(number > 0) {
                    isNumber = true;
                } else {
                    System.out.println("Ошибка ввода. Число должно быть больше нуля.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Укажите число.");
            } catch (IOException e) {
                System.out.println("IOException: " + e);
            }
        }
        return number;
    }

    public static int[][] makeMatrix(int row, int column){
        Random random = new Random();
        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextInt(RANDOM_LIMIT);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2){
        int sum;
        int[][] matrixResult = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                sum = 0;
                for (int k = 0; k < matrix2.length; k++) {
                    sum += matrix1[i][k]*matrix2[k][j];
                }
                matrixResult[i][j] = sum;
            }
        }
        return matrixResult;
    }
}
