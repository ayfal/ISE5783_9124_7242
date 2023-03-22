package geometries;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;

public class Cylinder extends Tube {
	
	double height;
 
	//constructor
	public Cylinder(double h, double radius, Ray axis) { super(radius, axis); this.height = h;}
	
	//getter
	public double getHeight() { return height;}

	//functions
	@Override
	public Vector gerNormal(Point p) { return null; }

}
