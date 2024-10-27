package entities;

    public class LinearAlgebra {
        public static Matrix transpose(Matrix matrix) {
            int newRows = matrix.getColumns();
            int newCols = matrix.getRows();
            double [] result = new double[newRows * newCols];
            
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    result[j * newCols + i] = matrix.get(i, j);
                }
            }
    
            return new Matrix(newRows, newCols, result);
        }

        public static Matrix transpose(Vector vector){
            double[] transposedElements = new double[vector.getDimension()];

            for(int i = 0 ; i < vector.getDimension() ; i++){
                transposedElements[i] = vector.get(i);
            }

            return new Matrix(vector.getDimension(), 1, transposedElements);


        }

        public static Matrix sum(Matrix a, Matrix b) {
            if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
                System.out.println("Matrizes de tamanhos diferentes.");
            }

            int rows = a.getRows();
            int columns = a.getColumns();
            double[] result = new double[rows * columns];
    
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i * columns + j] = a.get(i, j) + b.get(i, j);
                }
            }
    
            return new Matrix(rows, columns, result);
        }

        public static Vector sum(Vector a , Vector b){
            if(a.getDimension() != b.getDimension()){
                System.out.println("Vetores de tamanhos diferentes: ");
            }
            int dimension = a.getDimension();
            int [] result =  new int[dimension];

            for(int i = 0 ; i < dimension ; i++){
                result[i] = a.get(i) + b.get(i);
            }

            return new Vector(dimension, result);
        }

        public static Matrix times(Matrix a , Matrix b){
            if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
                System.out.println("Matrizes de tamanhos diferentes.");
            }
            
            int rows = a.getRows();
            int columns = a.getColumns();
            double[] result = new double[rows * columns];

            for(int i = 0 ; i < rows ; i++){
                for(int j = 0 ; j < columns ; j++){
                    result[i * columns + j] = a.get(i, j) * b.get(i, j);
                }
            }
            return new Matrix(rows, columns, result);
        }

        public static Vector times(Vector a , Vector b){
            if(a.getDimension() != b.getDimension()){
                System.out.println("Vetores de tamanhos diferentes: ");
            }
            int dimension = a.getDimension();
            int [] result =  new int[dimension];

            for(int i = 0 ; i < dimension ; i++){
                result[i] = a.get(i) * b.get(i);
            }

            return new Vector(dimension, result);
        } 

        public static Matrix dot(Matrix a , Matrix b){
            int rows = a.getRows();
            int columns = b.getColumns();
            int communDimension = a.getColumns();
            double[] result = new double[rows * columns];

            for(int i = 0 ; i < rows ; i++){
                for(int j = 0 ; j < columns ; j++){
                    int sum = 0;
                    for(int x = 0 ; x < communDimension ; x++){
                        sum += a.get(i, x) * b.get(x , j);
                    }
                    result[i * columns + j] = sum;
                }
            }
            return new Matrix(rows, columns, result);
        }

        public static Matrix gauss(Matrix a){
            int rows = a.getRows();
            int columns = a.getColumns();
            double [][] result = new double[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = a.get(i, j);
                }
            }

            for(int i = 0 ; i < rows ; i++){
                int row = i;
                for(int x = i + 1 ; x < rows ; x++){
                    if(Math.abs(result[x][i]) > Math.abs(result[row][i])){
                        row = x;
                    }
                }

                double[] temp = result[i];
                result[i] = result[row];
                result[row] = temp;

                for(int x = i + 1 ; x < rows ; x++){
                    double factor = result[x][i] / result[i][i];
                    for(int j = i ; j < columns ; j++){
                        result[x][j] -= factor * result[i][j];
                    }
                    result[x][i] = 0;
                }
            }
            double[] result2 = new double[rows * columns];
            for(int i = 0 ; i < rows ; i++){
                for(int j = 0 ; j < columns ; j++){
                    result2[i * columns + j] = result[i][j];
                }
            }
            return new Matrix(rows, columns, result2);
        }

        public static Matrix solve(Matrix a){
            Matrix gaussMatrix = LinearAlgebra.gauss(a);
            int rows = gaussMatrix.getRows();
            int columns = gaussMatrix.getColumns();

            double [] solutions = new double[rows];

            for(int i = rows - 1 ; i >= 0 ; i--){
                solutions[i] = gaussMatrix.get(i, columns - 1);
                for(int j = i + 1 ; j < columns - 1 ; j++){
                    solutions[i] -= gaussMatrix.get(i, j) * solutions[j];
                }
                solutions[i] /= gaussMatrix.get(i, i);
            }
            
            double[] result = new double[rows];
            for(int i = 0 ; i < rows ; i++){
                result[i] = solutions[i];
            }

            return new Matrix(rows, 1, result);
        }
                
}

