package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.*;

/**
 * class Camera represents a camera in a 3D Cartesian coordinate system
 * 
 * @author Ariels
 */

public class Camera {
	private Point p0;
	private Vector vUp;
	private Vector vTo;
	private Vector vRight;
	double width;
	double height;
	double distance;

	// constructors

	/**
	 * constructor for camera
	 * 
	 * @param p0  camera position
	 * @param vTo to vector
	 * @param vUp up vector
	 */
	public Camera(Point p0, Vector vTo, Vector vUp) {
		this.p0 = p0;
		this.vUp = vUp.normalize();
		this.vTo = vTo.normalize();
		if (vUp.dotProduct(vTo) != 0) {
			throw new IllegalArgumentException("vUp and vTo are not orthogonal");
		}
		this.vRight = (vTo.crossProduct(vUp)).normalize();
	}

	// getters
	/**
	 * get camera position
	 * 
	 * @return camera position
	 */
	public Point getP0() {
		return p0;
	}

	/**
	 * get up vector
	 * 
	 * @return up vector
	 */
	public Vector getvUp() {
		return vUp;
	}

	/**
	 * get to vector
	 * 
	 * @return to vector
	 */
	public Vector getvTo() {
		return vTo;
	}

	/**
	 * get right vector
	 * 
	 * @return right vector
	 */
	public Vector getvRight() {
		return vRight;
	}

	/**
	 * get width
	 * 
	 * @return width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * get height
	 * 
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * get distance
	 * 
	 * @return distance
	 */
	public double getDistance() {
		return distance;
	}

	// setters

	/**
	 * set camera position
	 * 
	 * @param width
	 * @param height
	 * @return camera
	 */
	public Camera setVPSize(double width, double height) {
		this.width = width;
		this.height = height;
		return this;
	}

	/**
	 * set distance
	 * 
	 * @param distance
	 * @return camera
	 */
	public Camera setVPDistance(double distance) {
		this.distance = distance;
		return this;
	}

	/**
	 * construct ray through pixel
	 * 
	 * @param nX number of columns
	 * @param nY number of rows
	 * @param j  column index
	 * @param i  row index
	 * @return ray
	 */
	public Ray constructRay(int nX, int nY, int j, int i) {
		// pixel measurments
		double rY = height / nY;
		double rX = width / nX;

		// place pixel[i,j] in view grid center
		Point pIJ = p0.add(vTo.scale(distance));
		;

		// calculate pixel[i,j] center
		double yI = -(i - ((nY - 1) / 2d)) * rY;
		double xJ = (j - ((nX - 1) / 2d)) * rX;
		;

		// shift to center of pixel[i,j]
		if (!isZero(xJ))
			pIJ = pIJ.add(vRight.scale(xJ));
		if (!isZero(yI))
			pIJ = pIJ.add(vUp.scale(yI));

		// return ray from camera to viewPlane coordinate (i, j)
		return new Ray(p0, pIJ.subtract(p0));
	}
}