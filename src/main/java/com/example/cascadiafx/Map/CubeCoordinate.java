package com.example.cascadiafx.Map;
// Cube coordinates are used to represent the position of a MapTile (Hexagon) on a hexagonal grid
public class CubeCoordinate {
    // top left to bottom right diagonal q remains the same (q = 0)
    private int q;
    // left to right horizontal r remains the same (r = 0)
    private int r;
    // top right to bottom left diagonal s remains the same (s = 0) also q + r + s = 0 and s = -q - r
    private int s;

    //Constructor for CubeCoordinate that takes in the q, r as parameters and calculates the s value that satisfies the equation q + r + s = 0 with an Exception if the equation is not satisfied
    public CubeCoordinate(int q, int r) {
        this.q = q;
        this.r = r;
        this.s = -q - r;
        if (q + r + s != 0) {
            throw new IllegalArgumentException("q + r + s must be 0");
        }
    }

    //Getters for the q value
    public int getQ() {
        return q;
    }

    //Getters for the r value
    public int getR() {
        return r;
    }

    //Getters for the s value
    public int getS() {
        return s;
    }

    //Setter for the q value that takes in an integer value and checks if the equation q + r + s = 0 is satisfied
    public void setQ(int q) {
        this.q = q;
        this.s = -q - r;
        if (q + r + s != 0) {
            throw new IllegalArgumentException("q + r + s must be 0");
        }
    }

    //Setter for the r value that takes in an integer value and checks if the equation q + r + s = 0 is satisfied
    public void setR(int r) {
        this.r = r;
        this.s = -q - r;
        if (q + r + s != 0) {
            throw new IllegalArgumentException("q + r + s must be 0");
        }
    }

    //Setter for the s value that takes in an integer value and checks if the equation q + r + s = 0 is satisfied
    public void setS(int s) {
        this.s = s;
        this.q = -r - s;
        if (q + r + s != 0) {
            throw new IllegalArgumentException("q + r + s must be 0");
        }
    }

    //Method that adds two CubeCoordinates together and returns a new CubeCoordinate
    public CubeCoordinate add(CubeCoordinate b) {
        return new CubeCoordinate(this.q + b.q, this.r + b.r);
    }

    //Method that returns the distance between two CubeCoordinates
    public int distance(CubeCoordinate b) {
        return (Math.abs(this.q - b.q) + Math.abs(this.r - b.r) + Math.abs(this.s - b.s)) / 2;
    }

    //Method that returns the CubeCoordinate as a string
    public String toString() {
        return "CubeCoordinate{" +
                "q=" + q +
                ", r=" + r +
                ", s=" + s +
                '}';
    }

}
