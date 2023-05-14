package unitests.renderer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import primitives.*;
import primitives.Vector;
import renderer.Camera;
import geometries.*;
import java.util.*;

/**
 * Integration tests of Camera Ray construction with Geometries
 * 
 * @author Ariels
 */
public class IntegrationTests {

	/**
	 * Helper method for counting intersections
	 *
	 * @param camera   camera for the view plane
	 * @param geometry geometry to count the intersections with
	 * @return number of intersections
	 */
	private int CountIntersections(Camera camera, Intersectable geometry) {
		int counter = 0;
		int nX = 3;
		int nY = 3;
		camera.setVPSize(3, 3);
		camera.setVPDistance(1);

		for (int i = 0; i < nY; i++) {
			for (int j = 0; j < nX; j++) {
				List<Point> rayIntersections = geometry.findIntersections(camera.constructRay(nX, nY, j, i));
				counter += rayIntersections == null ? 0 : rayIntersections.size();
			}
		}
		return counter;
	}

	Camera camera = new Camera(new Point(0, 0, 0), new Vector(0, 0, -1), new Vector(0, -1, 0));
	int intersections;

	/**
	 * Integration test of camera rays with sphere
	 */
	@Test
	public void cameraSphereIntersections() {
		// TC01: a small sphere with 2 intersections
		intersections = CountIntersections(camera, new Sphere(1, new Point(0, 0, -3)));// for readability
		assertEquals(2, intersections, "number of sphere intersections is incorrect");

		// TC02: a large sphere with 18 intersections
		Camera camera2 = new Camera(new Point(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, -1, 0));
		intersections = CountIntersections(camera2, new Sphere(2.5, new Point(0, 0, -2.5)));
		assertEquals(18, intersections, "number of sphere intersections is incorrect");

		// TC03: a medium sphere with 10 intersections
		intersections = CountIntersections(camera2, new Sphere(2, new Point(0, 0, -2)));
		assertEquals(10, intersections, "number of sphere intersections is incorrect");

		// TC04: camera inside sphere with 9 intersections
		intersections = CountIntersections(camera2, new Sphere(4, new Point(0, 0, -1)));
		assertEquals(9, intersections, "number of sphere intersections is incorrect");

		// TC05: sphere behind camera with 0 intersections
		intersections = CountIntersections(camera, new Sphere(0.5, new Point(0, 0, 1)));
		assertEquals(0, intersections, "number of sphere intersections is incorrect");
	}

	/**
	 * Integration test of camera rays with plane
	 */
	@Test
	public void cameraPlaneIntersections() {
		// TC01: Plane parallel to view grid, 9 intersections
		intersections = CountIntersections(camera, new Plane(new Point(0, 0, -10), new Vector(0, 0, 1)));
		assertEquals(9, intersections, "number of plane intersections is incorrect");

		// TC02: Plane with a slight slope to the view grid, 9 intersections
		intersections = CountIntersections(camera, new Plane(new Point(0, 0, -10), new Vector(0, 1, 2)));
		assertEquals(9, intersections, "number of plane intersections is incorrect");

		// TC03: Plane parallel to the bottom ray, 6 intersections
		intersections = CountIntersections(camera, new Plane(new Point(0, 0, -10), new Vector(0, 1, 1)));
		assertEquals(6, intersections, "number of plane intersections is incorrect");
	}

	/**
	 * Integration test of camera rays with triangle
	 */
	@Test
	public void cameraTriangleIntersections() {
		// TC01: a small triangle with 1 intersection
		intersections = CountIntersections(camera,
				new Triangle(new Point(0, 1, -2), new Point(1, -1, -2), new Point(-1, -1, -2)));
		assertEquals(1, intersections, "number of trianlge intersections is incorrect");
		// TC02: a bigger triangle with 2 intersections
		intersections = CountIntersections(camera,
				new Triangle(new Point(0, 20, -2), new Point(1, -1, -2), new Point(-1, -1, -2)));
		assertEquals(2, intersections, "number of trianlge intersections is incorrect");
	}
}