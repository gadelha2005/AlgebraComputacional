package entities;

import java.util.Arrays;

import entities.LinearAlgebra;
import entities.Matrix;
import entities.Vector;

public class PageRank {

    public static void main(String[] args) {
        // Exercício 5
        double[] adjMatrix5 = {
            0, 0, 1, 0,
            1, 0, 0, 0,
            1, 0, 0, 1,
            0, 1, 0, 0
        };
        processMatrix("Exercício 5", 4, adjMatrix5);

        // Exercício 6
        double[] adjMatrix6 = {
            0, 1, 0, 1,
            0, 0, 1, 0,
            0, 0, 0, 1,
            1, 0, 0, 0
        };
        processMatrix("Exercício 6", 4, adjMatrix6);

        // Exercício 7
        double[] adjMatrix7 = {
            0, 1, 1, 1, 0,
            1, 0, 0, 0, 1,
            0, 0, 0, 1, 0,
            0, 1, 0, 0, 0,
            0, 1, 0, 0, 0
        };
        processMatrix("Exercício 7", 5, adjMatrix7);

        // Exercício 8
        double[] adjMatrix8 = {
            0, 1, 1, 0, 1, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
            0, 1, 0, 0, 1, 0, 0, 0, 0, 0,
            0, 1, 0, 0, 0, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        };
        processMatrix("Exercício 8", 10, adjMatrix8);
    }

    private static void processMatrix(String exercise, int size, double[] adjMatrix) {
        // Inicializa a matriz de adjacência
        Matrix matrix = new Matrix(size, size, adjMatrix);

        // Inicializa o vetor PageRank com valores uniformes
        double[] initialRank = new double[size];
        Arrays.fill(initialRank, 1.0 / size);
        Vector rank = new Vector(size, initialRank);

        final double TOLERANCE = 1e-6;
        final double DAMPING_FACTOR = 0.85;
        final double ONE_MINUS_D = (1.0 - DAMPING_FACTOR) / size;

        boolean converged = false;
        Vector previousRank = null;

        while (!converged) {
            // Multiplica matriz pelo vetor
            Vector newRank = LinearAlgebra.dot(matrix, rank);

            // Aplica o fator de amortecimento
            for (int i = 0; i < size; i++) {
                newRank.set(i, DAMPING_FACTOR * newRank.get(i) + ONE_MINUS_D);
            }

            // Normaliza o vetor
            newRank = normalize(newRank);

            // Verifica convergência
            if (previousRank != null) {
                double error = calculateError(newRank, previousRank);
                if (error < TOLERANCE) {
                    converged = true;
                }
            }

            previousRank = rank;
            rank = newRank;
        }

        // Exibe os resultados finais
        System.out.println(exercise + " - PageRank Final:");
        for (int i = 0; i < size; i++) {
            System.out.printf("Site %d: %.6f\n", i + 1, rank.get(i));
        }
        System.out.println();
    }

    private static Vector normalize(Vector vector) {
        double sum = 0.0;
        for (int i = 0; i < vector.getDimension(); i++) {
            sum += vector.get(i);
        }
        double[] normalizedElements = new double[vector.getDimension()];
        for (int i = 0; i < vector.getDimension(); i++) {
            normalizedElements[i] = vector.get(i) / sum;
        }
        return new Vector(vector.getDimension(), normalizedElements);
    }

    private static double calculateError(Vector current, Vector previous) {
        double maxError = 0.0;
        for (int i = 0; i < current.getDimension(); i++) {
            maxError = Math.max(maxError, Math.abs(current.get(i) - previous.get(i)));
        }
        return maxError;
    }
}
