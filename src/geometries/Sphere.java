package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere extends RadialGeometry {

 
	final Point center;
	
	//constructor
	public Sphere(double r, Point c) {
		super(r);
		
		center = c;
	}

	//getters
	public Point getCenter() { return center;}

	public double getRadius() { return radius;}
	  
	//functions
	@Override
	public Vector gerNormal(Point p) { return null;	}
}
