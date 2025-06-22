package org.example;

import java.util.Arrays;

public class Vector {
    private final int dimensions;
    private final double[] array;

    public Vector(int dimensions) {
        if (dimensions < 0)
            throw new IllegalArgumentException("Vector must have positive number of dimensions");
        this.dimensions = dimensions;
        array = new double[dimensions];
        Arrays.fill(array, 0.0);
    }

    public int dimensions() {
        return dimensions;
    }

    public double get(int dimension){
        if(dimension < 0 || dimension >= dimensions)
            throw new IndexOutOfBoundsException("Trying to access dimension " + dimension +
                    " of a vector with " + dimensions + " dimensions");
        return array[dimension];
    }

    public void set(int dimension, double value){
        if(dimension < 0 || dimension >= dimensions)
            throw new IndexOutOfBoundsException("Trying to access dimension " + dimension +
                    " of a vector with " + dimensions + " dimensions");
        array[dimension] = value;
    }

    public static double dotProduct(Vector v1, Vector v2){
        if(v1.dimensions() != v2.dimensions())
            throw new IllegalArgumentException("Vectors must have the same number of dimensions");
        double res = 0;
        for(int i = 0; i < v1.dimensions(); i++){
            res += v1.get(i) * v2.get(i);
        }
        return res;
    }

    public static Vector sum(Vector v1, Vector v2){
        if(v1.dimensions() != v2.dimensions())
            throw new IllegalArgumentException("Vectors must have the same number of dimensions");
        Vector res = new Vector(v1.dimensions());
        for(int i = 0; i < v1.dimensions(); i++){
            res.set(i, v1.get(i) + v2.get(i));
        }
        return res;
    }

    public static Vector product(Vector v1, double coefficient){
        Vector res = new Vector(v1.dimensions());
        for(int i = 0; i < v1.dimensions(); i++){
            res.set(i, v1.get(i) * coefficient);
        }
        return res;
    }
}
