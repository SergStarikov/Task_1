import java.math.BigInteger;
import java.util.Random;

/**
 * Created on 05.07.2016.
 */
public class Task_Matrix {
    public static void main(String[] args) {


        int size = 10;
        boolean label = true;
        BigInteger minMultiplication = BigInteger.valueOf(Long.MAX_VALUE);
        int minIndex = 0;                                //index of element where cross colmns
        int matrix [] [] [] = new int[size][size][size]; //new array 10x10x10

        //random filling an array
        Random random = new Random();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                for(int k = 0; k < matrix[i][j].length; k++){
                    matrix[i][j][k] =(random.nextInt(9));
                }
            }
        }

        //seach zero
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                for (int k = 0; k < matrix[i][j].length; k++){
                    if (matrix[i][j][k] == 0){
                        System.out.println("Min multiplication " + (i+1) + " x " + (j+1) + " x " + (k+1));
                        label = false;
                        return;                         //if need all - delete this row
                    }
                }
            }
        }

        //if we don't have zero in matrix
        if (label){
            for (int i = 0; i < (size*size*size); i++ ){
                int h = i /100;
                int d = i %100/10;
                int u = i % 10;
                BigInteger multiplication = BigInteger.valueOf(1L);
                for (int j = 0; j < size; j++){
                    multiplication = multiplication.multiply(BigInteger.valueOf((matrix[h][d][j] * matrix[h][j][u] * matrix[j][d][u])));
                }
                multiplication = multiplication.divide(BigInteger.valueOf(2 * matrix[h][d][u]));
                if (minMultiplication.compareTo(multiplication) > 0 ){
                    minMultiplication = multiplication;
                    minIndex = h * 100 + d * 10 + u;
                }
            }
            System.out.println("Min multiplication (" + minMultiplication + ") with index " + minIndex/100 +
                    " x " + minIndex%100/10 + " x " + minIndex%10 );
        }
    }
}
