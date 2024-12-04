package entities;

public class Transformations {
   
   public static Vector translate2D(Vector vector, double dx, double dy) {
    double[] translationMatrixElements = {
        1, 0, dx,
        0, 1, dy,
        0, 0, 1
    };
    
    Matrix translationMatrix = new Matrix(3, 3, translationMatrixElements);

    double[] vectorHomogeneousElements = {
        vector.get(0),
        vector.get(1),
        1
    };
    Matrix vectorHomogeneous = new Matrix(3, 1, vectorHomogeneousElements);

    Matrix result = LinearAlgebra.dot(translationMatrix, vectorHomogeneous);
    double[] resultCartesian = {(int) result.get(0, 0), (int) result.get(1, 0)};

    return new Vector(2, resultCartesian);
}

    
    public static Vector translate3D(Vector vector, double dx, double dy, double dz) {
        double[] translationMatrixElements = {
            1, 0, 0, dx,
            0, 1, 0, dy,
            0, 0, 1, dz,
            0, 0, 0, 1
        };
        Matrix translationMatrix = new Matrix(4, 4, translationMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorHomogeneous = new Matrix(4, 1, vectorHomogeneousElements);

        Matrix result = LinearAlgebra.dot(translationMatrix, vectorHomogeneous);
        double[] resultCartesian = {(int) result.get(0, 0), (int) result.get(1, 0), (int) result.get(2, 0)};

        return new Vector(3, resultCartesian);
    }


    public static Vector rotation2D(Vector vector, double angle) {
        double rad = Math.toRadians(angle);
        double[] rotationMatrixElements = {
            Math.cos(rad), -Math.sin(rad), 0 ,
            Math.sin(rad), Math.cos(rad), 0 ,
            0 , 0 , 1

        };
        Matrix rotationMatrix = new Matrix(3, 3, rotationMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            1
        };
        Matrix vectorHomogeneous = new Matrix(3, 1, vectorHomogeneousElements);

        Matrix result = LinearAlgebra.dot(rotationMatrix, vectorHomogeneous);
        double[] resultCartesian = {(int) result.get(0, 0), (int) result.get(1, 0)};

        return new Vector(2, resultCartesian);
    }


    public static Vector rotation3DX(Vector vector, double angle) {
        double rad = Math.toRadians(angle);
        double[] rotationMatrixElements = {
            1, 0, 0, 0,
            0, Math.cos(rad), -Math.sin(rad), 0,
            0, Math.sin(rad), Math.cos(rad), 0,
            0, 0, 0, 1
        };
        Matrix rotationMatrix = new Matrix(4, 4, rotationMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorHomogeneous = new Matrix(4, 1, vectorHomogeneousElements);

        Matrix result = LinearAlgebra.dot(rotationMatrix, vectorHomogeneous);
        double[] resultCartesian = {(int) result.get(0, 0), (int) result.get(1, 0), (int) result.get(2, 0)};

        return new Vector(3, resultCartesian);
    }


    public static Vector rotation3DY(Vector vector, double angle) {
        double rad = Math.toRadians(angle);
        double[] rotationMatrixElements = {
            Math.cos(rad), 0, Math.sin(rad), 0,
            0, 1, 0, 0,
            -Math.sin(rad), 0, Math.cos(rad), 0,
            0, 0, 0, 1
        };
        Matrix rotationMatrix = new Matrix(4, 4, rotationMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorHomogeneous = new Matrix(4, 1, vectorHomogeneousElements);

        Matrix result = LinearAlgebra.dot(rotationMatrix, vectorHomogeneous);
        double[] resultCartesian = {(int) result.get(0, 0), (int) result.get(1, 0), (int) result.get(2, 0)};

        return new Vector(3, resultCartesian);
    }

    
    public static Vector rotation3DZ(Vector vector, double angle) {
        double rad = Math.toRadians(angle);
        double[] rotationMatrixElements = {
            Math.cos(rad), -Math.sin(rad), 0, 0,
            Math.sin(rad), Math.cos(rad), 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        };
        Matrix rotationMatrix = new Matrix(4, 4, rotationMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorHomogeneous = new Matrix(4, 1, vectorHomogeneousElements);

        Matrix result = LinearAlgebra.dot(rotationMatrix, vectorHomogeneous);
        double[] resultCartesian = {(int) result.get(0, 0), (int) result.get(1, 0), (int) result.get(2, 0)};

        return new Vector(3, resultCartesian);
    }

    public static Vector reflection2DX(Vector vector) {
        
        double[] reflectionMatrixElements = {
            1, 0,
            0, -1
        };
        Matrix reflectionMatrix = new Matrix(2, 2, reflectionMatrixElements);

        
        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            1
        };
        Matrix vectorMatrix = new Matrix(3, 1, vectorHomogeneousElements);

        
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, vectorMatrix);

        
        return new Vector(2, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0) });
    }

    public static Vector reflection2DY(Vector vector) {
        
        double[] reflectionMatrixElements = {
            -1, 0,
            0, 1
        };
        Matrix reflectionMatrix = new Matrix(2, 2, reflectionMatrixElements);
        
        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            1
        };
        Matrix vectorMatrix = new Matrix(3, 1, vectorHomogeneousElements);
        
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, vectorMatrix);
        return new Vector(2, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0) });
    }

   
    public static Vector reflection3DX(Vector vector) {
        double[] reflectionMatrixElements = {
            1, 0, 0,
            0, -1, 0,
            0, 0, -1
        };
        Matrix reflectionMatrix = new Matrix(3, 3, reflectionMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorMatrix = new Matrix(4, 1, vectorHomogeneousElements);
        
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, vectorMatrix);
        return new Vector(3, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0), (int) resultMatrix.get(2, 0) });
    }

    public static Vector reflection3DY(Vector vector) {
        double[] reflectionMatrixElements = {
            -1, 0, 0,
            0, 1, 0,
            0, 0, -1
        };
        Matrix reflectionMatrix = new Matrix(3, 3, reflectionMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorMatrix = new Matrix(4, 1, vectorHomogeneousElements);
        
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, vectorMatrix);
        return new Vector(3, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0), (int) resultMatrix.get(2, 0) });
    }

    public static Vector reflection3DZ(Vector vector) {
        double[] reflectionMatrixElements = {
            -1, 0, 0,
            0, -1, 0,
            0, 0, 1
        };
        Matrix reflectionMatrix = new Matrix(3, 3, reflectionMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorMatrix = new Matrix(4, 1, vectorHomogeneousElements);
        
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, vectorMatrix);
        return new Vector(3, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0), (int) resultMatrix.get(2, 0) });
    }

    public static Vector projection2DX(Vector vector) {
        double[] projectionMatrixElements = {
            1, 0,
            0, 0
        };
        Matrix projectionMatrix = new Matrix(2, 2, projectionMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            1
        };
        Matrix vectorMatrix = new Matrix(3, 1, vectorHomogeneousElements);
        
        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, vectorMatrix);
        return new Vector(2, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0) });
    }

    public static Vector projection2DY(Vector vector) {
        double[] projectionMatrixElements = {
            0, 0,
            0, 1
        };
        Matrix projectionMatrix = new Matrix(2, 2, projectionMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            1
        };
        Matrix vectorMatrix = new Matrix(3, 1, vectorHomogeneousElements);
        
        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, vectorMatrix);
        return new Vector(2, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0) });
    }

    
    public static Vector projection3DX(Vector vector) {
        double[] projectionMatrixElements = {
            1, 0, 0,
            0, 0, 0,
            0, 0, 0
        };
        Matrix projectionMatrix = new Matrix(3, 3, projectionMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorMatrix = new Matrix(4, 1, vectorHomogeneousElements);
        
        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, vectorMatrix);
        return new Vector(3, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0), (int) resultMatrix.get(2, 0) });
    }

    public static Vector projection3DY(Vector vector) {
        double[] projectionMatrixElements = {
            0, 0, 0,
            0, 1, 0,
            0, 0, 0
        };
        Matrix projectionMatrix = new Matrix(3, 3, projectionMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorMatrix = new Matrix(4, 1, vectorHomogeneousElements);
        
        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, vectorMatrix);
        return new Vector(3, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0), (int) resultMatrix.get(2, 0) });
    }

    public static Vector projection3DZ(Vector vector) {
        double[] projectionMatrixElements = {
            0, 0, 0,
            0, 0, 0,
            0, 0, 1
        };
        Matrix projectionMatrix = new Matrix(3, 3, projectionMatrixElements);

        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            vector.get(2),
            1
        };
        Matrix vectorMatrix = new Matrix(4, 1, vectorHomogeneousElements);
        
        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, vectorMatrix);
        return new Vector(3, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0), (int) resultMatrix.get(2, 0) });
    }

    public static Vector shearing(Vector vector, double kx, double ky) {
        double[] shearingMatrixElements = {
            1, kx,
            ky, 1
        };
        Matrix shearingMatrix = new Matrix(2, 2, shearingMatrixElements);
    
        double[] vectorHomogeneousElements = {
            vector.get(0),
            vector.get(1),
            1
        };
        
        Matrix vectorMatrix = new Matrix(3, 1, vectorHomogeneousElements);
    
        Matrix resultMatrix = LinearAlgebra.dot(shearingMatrix, vectorMatrix);
    
        return new Vector(2, new double[] { (int) resultMatrix.get(0, 0), (int) resultMatrix.get(1, 0) });
    }
}
