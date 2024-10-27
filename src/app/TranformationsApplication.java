package app;

import entities.Transformations;
import entities.Vector;

public class TranformationsApplication {
    public static void main(String[] args) {
        // Criando um vetor 2D para testes
        Vector vector2D = new Vector(2, new int[]{3, 4});
        System.out.println("Vetor original 2D:");
        vector2D.printVector();

        // Testando Translação 2D
        Vector translated2D = Transformations.translate2D(vector2D, 2, 3);
        System.out.println("Após translação 2D (dx=2, dy=3):");
        translated2D.printVector();

        // Testando Rotação 2D
        Vector rotated2D = Transformations.rotation2D(vector2D, 90);
        System.out.println("Após rotação 2D (90 graus):");
        rotated2D.printVector();

        // Testando Reflexão 2D no eixo X
        Vector reflected2DX = Transformations.reflection2DX(vector2D);
        System.out.println("Após reflexão 2D no eixo X:");
        reflected2DX.printVector();

        // Testando Reflexão 2D no eixo Y
        Vector reflected2DY = Transformations.reflection2DY(vector2D);
        System.out.println("Após reflexão 2D no eixo Y:");
        reflected2DY.printVector();

        // Testando Projeção 2D no eixo X
        Vector projected2DX = Transformations.projection2DX(vector2D);
        System.out.println("Após projeção 2D no eixo X:");
        projected2DX.printVector();

        // Testando Projeção 2D no eixo Y
        Vector projected2DY = Transformations.projection2DY(vector2D);
        System.out.println("Após projeção 2D no eixo Y:");
        projected2DY.printVector();

        // Testando Cisalhamento 2D
        Vector sheared2D = Transformations.shearing(vector2D, 1.5, 0.5);
        System.out.println("Após cisalhamento 2D (kx=1.5, ky=0.5):");
        sheared2D.printVector();

       
        // Criando um vetor 3D para testes
        Vector vector3D = new Vector(3, new int[]{3, 4, 5});
        System.out.println("\nVetor original 3D:");
        vector3D.printVector();

        // Testando Translação 3D
        Vector translated3D = Transformations.translate3D(vector3D, 2, 3, 1);
        System.out.println("Após translação 3D (dx=2, dy=3, dz=1):");
        translated3D.printVector();

        // Testando Rotação 3D ao redor do eixo X
        Vector rotated3DX = Transformations.rotation3DX(vector3D, 90);
        System.out.println("Após rotação 3D em torno do eixo X (90 graus):");
        rotated3DX.printVector();

        // Testando Rotação 3D ao redor do eixo Y
        Vector rotated3DY = Transformations.rotation3DY(vector3D, 90);
        System.out.println("Após rotação 3D em torno do eixo Y (90 graus):");
        rotated3DY.printVector();

        // Testando Rotação 3D ao redor do eixo Z
        Vector rotated3DZ = Transformations.rotation3DZ(vector3D, 90);
        System.out.println("Após rotação 3D em torno do eixo Z (90 graus):");
        rotated3DZ.printVector();

        // Testando Reflexão 3D no eixo X
        Vector reflected3DX = Transformations.reflection3DX(vector3D);
        System.out.println("Após reflexão 3D no eixo X:");
        reflected3DX.printVector();

        // Testando Reflexão 3D no eixo Y
        Vector reflected3DY = Transformations.reflection3DY(vector3D);
        System.out.println("Após reflexão 3D no eixo Y:");
        reflected3DY.printVector();

        // Testando Reflexão 3D no eixo Z
        Vector reflected3DZ = Transformations.reflection3DZ(vector3D);
        System.out.println("Após reflexão 3D no eixo Z:");
        reflected3DZ.printVector();

        // Testando Projeção 3D no eixo X
        Vector projected3DX = Transformations.projection3DX(vector3D);
        System.out.println("Após projeção 3D no eixo X:");
        projected3DX.printVector();

        // Testando Projeção 3D no eixo Y
        Vector projected3DY = Transformations.projection3DY(vector3D);
        System.out.println("Após projeção 3D no eixo Y:");
        projected3DY.printVector();

        // Testando Projeção 3D no eixo Z
        Vector projected3DZ = Transformations.projection3DZ(vector3D);
        System.out.println("Após projeção 3D no eixo Z:");
        projected3DZ.printVector();


        }
    }

