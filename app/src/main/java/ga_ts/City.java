package ga_ts;

import java.lang.Math;

public class City {

    public int x_coordinate;
    public int y_coordinate;

    /**
     * Constructor method which creates and initialise the object (a city).
     * @param x is the x coordinate of a city
     * @param y is the y coordinate of a city
     *
     **/
    public City(int x, int y){
        x_coordinate = x;
        y_coordinate = y;
    }

    /**
     * Method calculating the distance between two cities using their respective x and y coordinates.
     * This uses the mathematical formulea to calculate distance between two points d=√((x2 – x1)² + (y2 – y1)²).
     * @param city2
     * @return the distance between two cities.
     *
     **/
    public double getDistance(City city2){

        int x2 = city2.x_coordinate;
        int y2 = city2.y_coordinate;

        double x_pow = Math.pow((x2-this.x_coordinate),2);
        double y_pow = Math.pow((y2-this.y_coordinate),2);

        double distance = Math.sqrt(x_pow + y_pow);

        return distance;
    }

}