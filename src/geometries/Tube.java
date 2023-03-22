package geometries;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;

public class Tube extends RadialGeometry {
	 
   Ray axis;
   
   //constructor
   public Tube(double radius, Ray ax) { super(radius); this.axis = ax; }
   
   //getters
   public Ray getAxis() { return axis;}

   public double getRadius() { return radius;}

   //functions
   @Override
   public Vector gerNormal(Point p) { return null; }

}
