/**
 * 
 */
package unitests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import geometries.Sphere;

/**
 * @author Ariel David and Moshe Weisfish
 *
 */
class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Sphere sphere = new Sphere(3, new Point(0, 0, 0));
		Vector n = sphere.getNormal(new Point(3, 0, 0));

		// TC01: a simple test to check the result of the function
		assertEquals(new Vector(1, 0, 0), n, "Shpere's normal is wrong");
	}

	/**
	 * Test method for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntersections() {
		Sphere sphere = new Sphere(1d, new Point(1, 0, 0));
		// ============ Equivalence Partitions Tests ==============
		// TC01: Ray's line is outside the sphere (0 points)
		assertNull(sphere.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0))),
				"Ray's line out of sphere");

		// TC02: Ray starts before and crosses the sphere (2 points)
		Point p1 = new Point(0.0651530771650466, 0.355051025721682, 0);
		Point p2 = new Point(1.53484692283495, 0.844948974278318, 0);
		List<Point> result = sphere.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(3, 1, 0)));
		assertEquals(2, result.size(), "Wrong number of points");
		if (result.get(0).getX() > result.get(1).getX())
			result = List.of(result.get(1), result.get(0));
		assertEquals(List.of(p1, p2), result, "Wrong Intersections");

		// TC03: Ray starts inside the sphere (1 point)
		result = sphere.findIntersections(new Ray(new Point(0.5, 0.5, 0), new Vector(3, 1, 0)));
		assertEquals(1, result.size(), "Wrong number of points");
		assertEquals(List.of(p2), result, "Wrong Intersections");

		// TC04: Ray starts after the sphere (0 points)
		result = sphere.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(-3, -1, 0)));
		assertNull(result, "Wrong number of points");

		// =============== Boundary Values Tests ==================
		// **** Group: Ray's line crosses the sphere (but not the center)
		// TC11: Ray starts at sphere and goes inside (1 points)
		result = sphere.findIntersections(new Ray(p1, new Vector(3, 1, 0)));
		assertEquals(1, result.size(), "Wrong number of points");
		assertEquals(List.of(p2), result, "Wrong Intersections");

		// TC12: Ray starts at sphere and goes outside (0 points)
		result = sphere.findIntersections(new Ray(p2, new Vector(3, 1, 0)));
		assertNull(result, "Wrong number of points");

		// **** Group: Ray's line goes through the center
		// TC13: Ray starts before the sphere (2 points)
		result = sphere.findIntersections(new Ray(new Point(0, 1, 0), new Vector(1, -1, 0)));
		p1 = new Point(0.2928932188135d, 0.7071067811865d, 0d);
		p2 = new Point(1.7071067811865d, -0.7071067811865d, 0d);
		assertEquals(2, result.size(), "Wrong number of points");
		if (result.get(0).getX() > result.get(1).getX())
			result = List.of(result.get(1), result.get(0));
		assertEquals(List.of(p1, p2), result, "Wrong Intersections");

		// TC14: Ray starts at sphere and goes inside (1 points)
		result = sphere.findIntersections(new Ray(p1, new Vector(1, -1, 0)));
		assertEquals(1, result.size(), "Wrong number of points");
		assertEquals(List.of(p2), result, "Wrong Intersections");

		// TC15: Ray starts inside (1 points)
		result = sphere.findIntersections(new Ray(new Point(0.5, 0.5, 0), new Vector(1, -1, 0)));
		assertEquals(1, result.size(), "Wrong number of points");
		assertEquals(List.of(p2), result, "Wrong Intersections");

		// TC16: Ray starts at the center (1 points)
		result = sphere.findIntersections(new Ray(new Point(1, 0, 0), new Vector(1, -1, 0)));
		assertEquals(1, result.size(), "Wrong number of points");
		assertEquals(List.of(p2), result, "Wrong Intersections");

		// TC17: Ray starts at sphere and goes outside (0 points)
		result = sphere.findIntersections(new Ray(p2, new Vector(1, -1, 0)));
		assertNull(result, "Wrong number of points");

		// TC18: Ray starts after sphere (0 points)
		result = sphere.findIntersections(new Ray(new Point(2, -1, 0), new Vector(1, -1, 0)));
		assertNull(result, "Wrong number of points");

		// **** Group: Ray's line is tangent to the sphere (all tests 0 points)
		// TC19: Ray starts before the tangent point
		result = sphere.findIntersections(new Ray(new Point(0, -1, 0), new Vector(1, 0, 0)));
		assertNull(result, "Wrong number of points");

		// TC20: Ray starts at the tangent point
		result = sphere.findIntersections(new Ray(new Point(1, -1, 0), new Vector(1, 0, 0)));
		assertNull(result, "Wrong number of points");

		// TC21: Ray starts after the tangent point
		result = sphere.findIntersections(new Ray(new Point(2, -1, 0), new Vector(1, 0, 0)));
		assertNull(result, "Wrong number of points");

		// **** Group: Special cases
		// TC22: Ray's line is outside, ray is orthogonal to ray start to sphere's
		// center line
		result = sphere.findIntersections(new Ray(new Point(1, -2, 0), new Vector(1, 0, 0)));
		assertNull(result, "Wrong number of points");
	}
}
