package entities;

public class Matrix {
    private int rows;  
    private int columns;  
    private double[][] elements;  

    public Matrix(int rows, int columns, double[] elements) {
        this.rows = rows;
        this.columns = columns;
        this.elements = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.elements[i][j] = elements[i * columns + j];
            }
        }
    }
    
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double get(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= columns) {
            System.out.println("Posição não existente");
        } 
        return this.elements[i][j];
    }

    public void set(int i, int j, double elements) {
        if (i < 0 || i >= rows || j < 0 || j >= columns) {
            System.out.println("Posição não existente");
        }       
        this.elements[i][j] = elements;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(this.elements[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
    
}
