/**
 * 
 */
package unitests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import primitives.Vector;
import primitives.Point;
import primitives.Ray;
import geometries.Plane;
import geometries.Triangle;

/**
 * Test Triangle class methods
 * 
 * @author Ariels
 *
 */
class TriangleTests {

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Triangle triangle = new Triangle(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));

		// TC01: a simple test to make sure the function does not throw an exception.
		assertDoesNotThrow(() -> triangle.getNormal(new Point(0, 1, 0)),
				"Triangle threw an exeption while attempting getNormal function");
		Vector n = triangle.getNormal(new Point(0, 1, 0));

		// TC02: making sure normal length = 1 'aka' a unit vector.
		assertEquals(1, n.length(), 0.00000001, "Triangle's normal is not a unit vector");
	}

	/**
	 * Test method for {@link geometries.Polygon#findIntersections(primitives.Ray)}.
	 */
	@Test
	void testFindIntersections() {
		// ============ Equivalence Partitions Tests ==============
		Triangle triangle = new Triangle(new Point(1, 0, 1), new Point(0, 1, 1), new Point(-1, -1, 1));
		Plane plane = new Plane(new Point(1, 0, 1), new Point(0, 1, 1), new Point(-1, -1, 1));
		// TC01: Ray intersects the triangle
		Ray ray = new Ray(new Point(0, 0, 0.5), new Vector(0, 0, 1));
		List<Point> result = plane.findIntersections(ray);
		assertNotNull(result, "plane's findIntersections() returned null");
		result = triangle.findIntersections(ray);
		assertNotNull(result, "triangle's findIntersections() returned null");
		assertEquals(new Point(0, 0, 1), result.get(0), "triangle's findIntersections() wrong value");

		// TC02: Ray does not intersect the triangle and is against the edge of the
		// triangle
		ray = new Ray(new Point(1, -1, 0), new Vector(0, 0, 1));
		assertNotNull(plane.findIntersections(ray), "plane's findIntersections() returned null");
		assertNull(triangle.findIntersections(ray), "triangle's findIntersections() wrong value");

		// TC03: Ray does not intersect the triangle and is against the vertex of the
		// triangle
		ray = new Ray(new Point(2, 0, 0), new Vector(0, 0, 1));
		assertNotNull(plane.findIntersections(ray), "plane's findIntersections() returned null");
		assertNull(triangle.findIntersections(ray), "triangle's findIntersections() wrong value");

		// =============== Boundary Values Tests ==================
		// TC04: Ray intersects the triangle on the edge of the triangle
		ray = new Ray(new Point(0, -0.5, 0), new Vector(0, 0, 1));
		assertNotNull(plane.findIntersections(ray), "plane's findIntersections() returned null");
		assertNull(triangle.findIntersections(ray), "triangle's findIntersections() wrong value");

		// TC05: Ray intersects the triangle on the vertex of the triangle
		ray = new Ray(new Point(1, 0, 0), new Vector(0, 0, 1));
		assertNotNull(plane.findIntersections(ray), "plane's findIntersections() returned null");
		assertNull(triangle.findIntersections(ray), "triangle's findIntersections() wrong value");

		// TC06: Ray intersects the triangle on the edge's continuation of the triangle
		ray = new Ray(new Point(2, -1, 0), new Vector(0, 0, 1));
		assertNotNull(plane.findIntersections(ray), "plane's findIntersections() returned null");
		assertNull(triangle.findIntersections(ray), "triangle's findIntersections() wrong value");
	}
}
