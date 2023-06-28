package lighting;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import geometries.Intersectable.GeoPoint;
import primitives.*;

/**
 * class for point light
 */
public class PointLight extends Light implements LightSource {
	private final Point position;
	private double kC = 1;
	private double kL = 0;
	private double kQ = 0;
	private static final double SHADOW_PIXEL_SIZE = 1;
	private int shadowGridSize = 0;

	// ***************** Constructors ********************** //

	/**
	 * constructor for point light
	 * 
	 * @param intensity color of light
	 * @param p         position of light
	 */
	public PointLight(Color intensity, Point p) {
		super(intensity);
		position = p;
	}

	// ***************** Setters ********************** //

	/**
	 * setter for kC in phong model
	 * 
	 * @param kC constant attenuation factor
	 * @return the light itself
	 */
	public PointLight setkC(double kC) {
		this.kC = kC;
		return this;
	}

	/**
	 * setter for kL in phong model
	 * 
	 * @param kL light's attenutation factor
	 * @return the light itself
	 */
	public PointLight setKl(double kL) {
		this.kL = kL;
		return this;
	}

	/**
	 * setter for kQ in phong model
	 * 
	 * @param kQ qudratic attenutation factor
	 * @return the light itself
	 */
	public PointLight setKq(double kQ) {
		this.kQ = kQ;
		return this;
	}

	/**
	 * setter for shadow grid size
	 * 
	 * @param sgs shadow grid size
	 * @return the light itself
	 */
	public PointLight setShadowGridSize(int sgs) {
		shadowGridSize = sgs;
		return this;
	}

	// ***************** Functions ********************** //

	@Override
	public Color getIntensity(Point p) {
		double d = p.distance(position);
		double denominator = kC + kL * d + kQ * d * d;
		return intensity.reduce(denominator);
	}

	@Override
	public Vector getL(Point p) {
		return p.subtract(position).normalize();
	}

	@Override
	public double getDistance(Point point) {
		return position.distance(point);
	}

	@Override
	public List<Vector> getShadowGridVectors(GeoPoint gp, Vector vTo) {
		if (shadowGridSize <= 0)
			return List.of(vTo);
		// create a vector that is orthogonal to vTo
		Vector vRight = vTo.getNormalizedOrthogonalVector();
		// create a vector that is orthogonal to vTo and vRight
		Vector vUp = vTo.crossProduct(vRight);
		List<Vector> shadowGridVectors = new LinkedList<>();
		for (int i = -shadowGridSize; i < shadowGridSize; i++)
			for (int j = -shadowGridSize; j < shadowGridSize; j++)
				shadowGridVectors.add(constructShadowVector(vRight, vUp, i, j, gp));
		return shadowGridVectors;
	}

	Random rand = new Random();
	/**
	 * constructs a vector from the light source gird to a point on the geometry
	 * @param vRight vector orthogonal to vTo
	 * @param vUp vector orthogonal to vTo and vRight
	 * @param i index of the row
	 * @param j index of the column
	 * @param gp the point on the geometry
	 * @return the vector from the light source gird to the point on the geometry
	 */
	private Vector constructShadowVector(Vector vRight, Vector vUp, int i, int j, GeoPoint gp) {
		// randomize the coordinates of the point on the grid
		double xJ = (j - rand.nextDouble()) * SHADOW_PIXEL_SIZE;// these 3 fields are just for readability
		double yI = -(i - rand.nextDouble()) * SHADOW_PIXEL_SIZE;
		var pIJ = position.add(vRight.scale(xJ)).add(vUp.scale(yI));
		return gp.point.subtract(pIJ).normalize();
	}

}
