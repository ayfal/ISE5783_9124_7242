package primitives;

import static primitives.Util.isZero;

import java.util.Objects;

/**
* Class Point is the basic class representing a … of Euclidean geometry in Cartesian
* 3-Dimensional coordinate system.
* @author Ariel David and Moshe
*/
public class Point { 
	
	final Double3 point;

	//constructors
    public Point(Double3 d) {  this(d.d1, d.d2, d.d3);   }
    
    public Point(double d1, double d2, double d3) {
    	point = new Double3(d1, d2, d3);
    }
    
    //functions
    
    @Override
    public boolean equals(Object obj) {
       if (this == obj) return true;
       if (!(obj instanceof Point other))
  	         return false;
  	      return this.point.equals(other.point);
    }
    
    public double distanceSquared(Point other) {
    	
    	double x, y, z;
    	x = this.point.d1 - other.point.d1;
    	y = this.point.d2 - other.point.d2;
    	z = this.point.d3 - other.point.d3;
    	
    	return x*x + y*y + z*z;
    }
    
    public double distance(Point other) {
    	return Math.sqrt(this.distanceSquared(other));
    }
    
    public Vector subtract(Point other) {
    	return new Vector(point.subtract(other.point));
    }
    
    public Point add(Vector v) {
    	return new Point(this.point.add(v.point));
    }
    
    @Override
    public  String toString() {   return  "Point: " + point + '\n'; }
}