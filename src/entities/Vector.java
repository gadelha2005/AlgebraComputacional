package entities;

public class Vector {
    private int dimension;
    private double[] elements;

    public Vector(int dimension, double[] elements) {
        this.dimension = dimension;
        this.elements = elements;
    }

    public int getDimension() {
        return dimension;
    }

    public double[] getElements() {
        return elements;
    }

    public double get(int i){
        if(i < 0 || i >= dimension){
            System.out.println("Posição não existente.");
        }
        return elements[i];
    }


    public void printVector(){
        for(int i = 0 ; i < dimension ; i++){
            System.out.println(elements[i] + " ");
        }
        System.out.println();
    }

    public void set(int i, double value) {
        if (i < 0 || i >= dimension) {
            System.out.println("Posição não existente.");
        }
        elements[i] = value;
    }


}
