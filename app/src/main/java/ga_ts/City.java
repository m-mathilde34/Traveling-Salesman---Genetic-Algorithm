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
     * @param city1
     * @param city2
     * @return distance, which is the distance between the two cities.
     *
     **/
    public double getDistance(City city1, City city2){
        int x1 = city1.x_coordinate;
        int y1 = city1.y_coordinate;

        int x2 = city2.x_coordinate;
        int y2 = city2.y_coordinate;

        double x_pow = Math.pow((x2-x1),2);
        double y_pow = Math.pow((y2-y1),2);

        double distance = Math.sqrt(x_pow + y_pow);

        return distance;
    }

}