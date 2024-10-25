package entities;

public class Vector {
    private int dimension;
    private int[] elements;

    public Vector(int dimension, int[] elements) {
        this.dimension = dimension;
        this.elements = elements;
    }

    public int getDimension() {
        return dimension;
    }

    public int[] getElements() {
        return elements;
    }

    public int get(int i){
        if(i < 0 || i >= dimension){
            System.out.println("Posição não existente.");
        }
        return elements[i];
    }

    public void set(int i, int value) {
        if (i < 0 || i >= dimension) {
            System.out.println("Posição não existente.");
        }
        elements[i] = value;
    }

    public void printVector(){
        for(int i = 0 ; i < dimension ; i++){
            System.out.println(elements[i] + " ");
        }
        System.out.println();
    }


}
