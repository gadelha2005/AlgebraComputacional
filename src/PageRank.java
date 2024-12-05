import entities.Matrix;
import entities.Vector;
import entities.LinearAlgebra;

public class PageRank {

    
    public static Matrix transposeMatrix(Matrix matriz) {
        return LinearAlgebra.transpose(matriz);
    }

    
    public static Vector dotVector(Matrix matriz, Vector vetor) {
        return LinearAlgebra.dot(matriz, vetor);
    }

    
    public static Matrix dotMatrix(Matrix matrizA, Matrix matrizB) {
        return LinearAlgebra.dot(matrizA, matrizB);
    }

    
    public static Vector mult(Vector vetor, double escalar) {
        double[] resultado = new double[vetor.getDimension()];
        for (int i = 0; i < vetor.getDimension(); i++) {
            resultado[i] = vetor.get(i) * escalar;
        }
        return new Vector(vetor.getDimension(), resultado);
    }

    public static double norma(Vector vetor) {
        double resultado = 0;
        for (int i = 0; i < vetor.getDimension(); i++) {
            resultado += vetor.get(i) * vetor.get(i);
        }
        return Math.sqrt(resultado);
    }

    public static void calculation(Matrix matrix, Vector autoridade, int repeticao) {
        Vector matrixAutoridade = dotVector(matrix, autoridade);
        double norma = norma(matrixAutoridade);
        Vector novaAutoridade = mult(matrixAutoridade, 1 / norma);
        if (repeticao > 1) {
            calculation(matrix, novaAutoridade, repeticao - 1);
        } else {
            printResposta(novaAutoridade);
        }
    }

    public static void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix.getColumns(); j++) {
                System.out.print(matrix.get(i, j));
                if (j < matrix.getColumns() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }

    public static void printResposta(Vector vector) {
        System.out.print("[ ");
        for (int i = 0; i < vector.getDimension(); i++) {
            System.out.printf("%.10f", vector.get(i)); 
            if (i < vector.getDimension() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
    

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Com 10 iterações");
        System.out.println("");

        // Questão 5
        System.out.println("Questão 5:");
        Matrix matrix1 = new Matrix(4, 4, new double[]{
                0, 0, 1, 0,
                1, 0, 0, 0,
                1, 1, 0, 0,
                0, 1, 0, 0
        });
        resolveQuestao(matrix1, 100);

        // Questão 6
        System.out.println("\nQuestão 6:");
        Matrix matrix2 = new Matrix(4, 4, new double[]{
                0, 1, 1, 0,
                0, 0, 1, 0,
                1, 0, 0, 1,
                1, 0, 0, 0
        });
        resolveQuestao(matrix2, 100);

        // Questão 7
        System.out.println("\nQuestão 7:");
        Matrix matrix3 = new Matrix(5, 5, new double[]{
                0, 1, 1, 1, 0,
                1, 0, 0, 0, 1,
                0, 0, 0, 0, 1,
                0, 1, 0, 0, 0,
                0, 1, 1, 0, 0
        });
        resolveQuestao(matrix3, 100);

        // Questão 8
        System.out.println("\nQuestão 8:");
        Matrix matrix4 = new Matrix(10, 10, new double[]{
                0, 1, 1, 0, 1, 1, 0, 0, 0, 1,
                0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                0, 1, 1, 0, 0, 1, 1, 0, 0, 1,
                0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
                0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
                0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
                0, 1, 1, 0, 0, 1, 0, 1, 0, 1,
                0, 0, 0, 0, 0, 1, 0, 0, 0, 0
        });
        resolveQuestao(matrix4, 100);
    }

    private static void resolveQuestao(Matrix matrix, int iteracoes) {
        printMatrix(matrix);

        Matrix transposta = transposeMatrix(matrix);

    
        double[] autoridadeInicial = new double[matrix.getColumns()];
        for (int i = 0; i < matrix.getColumns(); i++) {
            double soma = 0;
            for (int j = 0; j < matrix.getRows(); j++) {
                soma += matrix.get(j, i);
            }
            autoridadeInicial[i] = soma;
        }

        Vector autoridadeInicialVetor = new Vector(autoridadeInicial.length, autoridadeInicial);

       
        Matrix AtA = dotMatrix(matrix, transposta);

        System.out.println("\nResultado:");
        calculation(AtA, autoridadeInicialVetor, iteracoes);
    }
}
