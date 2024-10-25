package app;

import entities.Vector;

import entities.LinearAlgebra;
import entities.Matrix;

public class LinearAlgebraApllication {
        public static void main(String[] args) { 

        // Transposição de matrizes
        double [] matrixElements = {5 , 10 , 15 , 20 , 25 , 30 , 35 , 40 , 45};
        Matrix matrix = new Matrix(3, 3, matrixElements);

        System.out.println("Matriz normal: ");
        matrix.printMatrix();

        System.out.println();

        Matrix transposedMatrix = LinearAlgebra.transpose(matrix);
        System.out.println("Matriz Transposta: ");
        transposedMatrix.printMatrix();

        System.out.println();

        // Transposição de vetores
        int[] vectorElements = {10 , 20 , 30 , 40};
        Vector vector = new Vector(4, vectorElements);
        System.out.println("Vetor normal: ");
        vector.printVector();

        Matrix linearAlgebra = LinearAlgebra.transpose(vector);
        System.out.println("Vetor transposto: ");
        linearAlgebra.printMatrix();

        System.out.println();

        // Soma de matrizes
        double[] elements1 = {5 , 10 , 15 , 20};
        double[] elements2 = {10 , 20 , 30 , 40};
        Matrix matrix2 = new Matrix(2, 2, elements1);
        Matrix matrix3 = new Matrix(2, 2, elements2);

        Matrix sumMatrix = LinearAlgebra.sum(matrix2, matrix3);
        System.out.println("Soma das matrizes: ");
        sumMatrix.printMatrix();

        System.out.println();

        // Soma de vetores
        int[] elements3 = {20 , 40 , 60};
        int[] elements4 = {100 , 200 , 300};
        Vector vector2 = new Vector(3, elements3);
        Vector vector3 = new Vector(3, elements4);

        Vector sumVector = LinearAlgebra.sum(vector2, vector3);
        System.out.println("Soma dos vetores: ");
        sumVector.printVector();

        System.out.println();

        // Multiplicação de matrizes
        double[] elements5 = {2 , 4 , 6 , 8};
        double[] elements6 = {1 , 2 , 3 , 4};
        Matrix matrix4 = new Matrix(2, 2, elements5);
        Matrix matrix5 = new Matrix(2, 2, elements6);
        
        Matrix timesMatrix = LinearAlgebra.times(matrix4 , matrix5);
        System.out.println("Multiplicação de matrizes: ");
        timesMatrix.printMatrix();

        System.out.println();

        // Multiplicação de vetores
        int[] elements7 = {5 , 10 , 20};
        int[] elements8 = {10 , 20 , 30};
        Vector vector4 = new Vector(3, elements7);
        Vector vector5 = new Vector(3, elements8);

        Vector timesVector = LinearAlgebra.times(vector4, vector5);
        System.out.println("Multiplicação de vetores: ");
        timesVector.printVector();

        // Multiplicação matricial de matrizes
        double[] elements9 = {2 , 4 , 6 , 8 , 10 , 12};
        double[] elements10 = {1 , 2 , 3 , 4 , 5 , 6 };
        Matrix matrix6 = new Matrix(2, 3, elements9);
        Matrix matrix7 = new Matrix(3, 2, elements10);

        Matrix dotMatrix = LinearAlgebra.dot(matrix6, matrix7);
        System.out.println("Multiplicação matricial de matrizes :");
        dotMatrix.printMatrix();

        System.out.println();

        //Gauus

        double[] elements11 = { 2, -1 , 3,1 , 2 , -1, 3 , 1 , 1};
        
        Matrix matrix8 = new Matrix(3, 3, elements11);

        System.out.println("Matriz original: ");
        matrix8.printMatrix();

        Matrix gaussMatrix = LinearAlgebra.gauss(matrix8);
        System.out.println("Nova matriz com eliminação gaussiana: ");
        gaussMatrix.printMatrix();

        System.out.println();
        
        //Solve

        double [] elements12 = { 2 , 3 , -1 , 5, -1 , 7 , 6 , 13, 4};

        Matrix matrix9 = new Matrix(3, 3, elements12);
        System.out.println("Matriz original: ");
        matrix9.printMatrix();

        Matrix solveMatrix = LinearAlgebra.solve(matrix9);

        System.out.println("Soluções do sistema linear: ");
        solveMatrix.printMatrix();

    }

    
    }

