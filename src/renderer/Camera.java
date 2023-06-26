package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.*;

import java.util.MissingResourceException;

import primitives.Color;

/**
 * class Camera represents a camera in a 3D Cartesian coordinate system
 * 
 * @author Ariels
 */

public class Camera {
	private final Point p0;
	private final Vector vUp;
	private final Vector vTo;
	private final Vector vRight;
	double width;
	double height;
	double distance;
	private ImageWriter imageWriter;
	private RayTracerBase rayTracerBase;

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
	 * set image writer
	 * 
	 * @param iw image writer
	 * @return camera
	 */
	public Camera setImageWriter(ImageWriter iw) {
		imageWriter = iw;
		return this;
	}

	/**
	 * set ray tracer base
	 * 
	 * @param rtb ray tracer base
	 * @return camera
	 */
	public Camera setRayTracerBase(RayTracerBasic rtb) {
		rayTracerBase = rtb;
		return this;
	}

	// functions
	/**
	 * construct ray through pixel
	 * 
	 * @param nX number of columns
	 * @param nY number of rows
	 * @param j  column (X) index
	 * @param i  row (Y) index
	 * @return ray
	 */
	public Ray constructRay(int nX, int nY, int j, int i) {
		// pixel measurements
		double rY = height / nY;
		double rX = width / nX;

		// place pixel[i,j] in view grid center
		Point pIJ = p0.add(vTo.scale(distance));

		// calculate pixel[i,j] center
		double yI = -(i - ((nY - 1) / 2d)) * rY;
		double xJ = (j - ((nX - 1) / 2d)) * rX;

		// shift to center of pixel[i,j]
		if (!isZero(xJ))
			pIJ = pIJ.add(vRight.scale(xJ));
		if (!isZero(yI))
			pIJ = pIJ.add(vUp.scale(yI));

		// return ray from camera to viewPlane coordinate (i, j)
		return new Ray(p0, pIJ.subtract(p0));
	}

	/**
	 * renders an image
	 * 
	 * @return camera (for chaining)
	 */
	public Camera renderImage() {// this was void, and we changed it to Camera for chaining in the tests provided
		if (imageWriter == null)
			throw new MissingResourceException("imageWriter is not defined", "ImageWriter", "imageWriter");
		if (rayTracerBase == null)
			throw new MissingResourceException("rayTracerBase is not defined", "RayTracerBase", "rayTracerBase");
		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();
		for (int i = 0; i < nY; i++) {
			for (int j = 0; j < nX; j++) {
				imageWriter.writePixel(j, i, castRay(nX, nY, j, i));
			}
		}
		return this;
	}

	/**
	 * cast ray through pixel and get color
	 * 
	 * @param nX number of columns
	 * @param nY number of rows
	 * @param j  column (X) index
	 * @param i  row (Y) index
	 * @return color
	 */
	private Color castRay(int nX, int nY, int j, int i) {
		return rayTracerBase.traceRay(constructRay(nX, nY, j, i));
	}

	/**
	 * print grid on image in a given interval and color
	 * 
	 * @param interval interval between lines
	 * @param color    color of the grid
	 */
	public void printGrid(int interval, Color color) {
		if (imageWriter == null)
			throw new MissingResourceException("imageWriter is not defined", "ImageWriter", "imageWriter");

		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();
		for (int i = 0; i < nX; i++)
			for (int j = 0; j < nY; j++)
				if (i % interval == 0 || j % interval == 0)
					imageWriter.writePixel(i, j, color);
	}

	/**
	 * verifies that imageWriter isn't null, and calls writeToImage function from
	 * ImageWriter class
	 */
	public void writeToImage() {
		if (imageWriter == null)
			throw new MissingResourceException("imageWriter is not defined", "ImageWriter", "imageWriter");
		imageWriter.writeToImage();
	}

}