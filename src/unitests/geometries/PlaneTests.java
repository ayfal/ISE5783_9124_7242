/**
 * 
 */
package unitests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import geometries.Plane;

/**
 * @author Ariel David and Moshe Weisfish
 *
 */
class PlaneTests {

	/**
	 * Test method for
	 * {@link geometries.Plane#Plane(primitives.Point, primitives.Point, primitives.Point)}.
	 */
	@Test
	void testPlanePointPointPoint() { // constructor.
		// =============== Boundary Values Tests ==================
		// TC01: The first 2 point are the same
		assertThrows(IllegalArgumentException.class,
				() -> new Plane(new Point(1, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0)),
				"The first two points are the same");

		// TCO2: The points are on the same line
		assertThrows(IllegalArgumentException.class,
				() -> new Plane(new Point(1, 0, 0), new Point(2, 0, 0), new Point(3, 0, 0)),
				"The points are on the same line");

	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Plane plane = new Plane(new Point(1, 0, 1), new Point(3, 1, 7), new Point(2, 5, 3));
		Vector n = plane.getNormal();

		// TC01: making sure normal length = 1 'aka' a unit vector.
		assertEquals(1, n.length(), 0.00000001, "Plane's normal is not a unit vector");

		// TCO2: a simple test to check the result of the function
		//assertEquals(new Vector(-28, 2, 9).normalize(), n, "Plane's normal is wrong");

		 //check the positive and negative direction of the normal//
		 Vector testVector=new Vector(-28, 2, 9).normalize();
		 assertTrue(plane.getNormal().equals(testVector) ||
		 plane.getNormal().scale(-1).equals(testVector),
		 "ERROR: The calculation of normal to the plane is not calculated correctly");
	}

	@Test
	void testFindIntersections(){
		Plane plane = new Plane(new Point(0, 0, 1), new Vector(1, 1, 1));
		// ============ Equivalence Partitions Tests ==============
		// TC01: Ray intersects the plane
		Ray ray = new Ray(new Point(0, 0, 0.5), new Vector(0, 0, 4));
		assertEquals(List.of(new Point(0, 0, 1)), plane.findIntersections(ray),
				"intersection point is not correct");

		// TC02: Ray does not intersect the plane
		ray = new Ray(new Point(0, 0, 0.5), new Vector(0, 0, -1));
		assertNull(plane.findIntersections(ray), "Ray does not intersect the plane");

		// =============== Boundary Values Tests ==================
		// TC03: Ray is parallel to the plane and is outside the plane
		ray = new Ray(new Point(0, 0, 0.5), new Vector(0, 1, -1));
		assertNull(plane.findIntersections(ray), "Ray is parallel to the plane, so there is no intersection point");

		// TC04: Ray is parrallel to the plane and included in it
		ray = new Ray(new Point(0, 0, 1), new Vector(0, 1, -1));
		assertNull(plane.findIntersections(ray), "Ray is parrallel to the plane and included in it, so there is no intersection point");

		// TC05: Ray is orthogonal to the plane and starts before the plane
		ray = new Ray(new Point(0, 0, -0.5), new Vector(1, 1, 1));
		assertEquals(List.of(new Point(0.5, 0.5, 0)), plane.findIntersections(ray),
				"intersection point is not correct");

		// TC06: Ray is orthogonal to the plane and starts in the plane
		ray = new Ray(new Point(0, 0, 1), new Vector(1, 1, 1));
		assertNull(plane.findIntersections(ray), "Ray is orthogonal to the plane and starts in the plane, so there is no intersection point");

		// TC07: Ray is orthogonal to the plane and starts after the plane
		ray = new Ray(new Point(0, 0, 1.5), new Vector(1, 1, 1));
		assertNull(plane.findIntersections(ray), "Ray is orthogonal to the plane and starts after the plane, so there is no intersection point");

		// TC08: Ray is neither orthogonal nor parallel to and begins at the plane, but not in the reference point
		ray = new Ray(new Point(1, 0, 0), new Vector(1, 1, 0));
		assertNull(plane.findIntersections(ray), "Ray is neither orthogonal nor parallel to and begins at the plane, so there is no intersection point");

		// TC09: Ray is neither orthogonal nor parallel to the plane and begins in the same point which appears as reference point in the plane
		ray = new Ray(new Point(0, 0, 1), new Vector(1, 1, 0));
		assertNull(plane.findIntersections(ray), "Ray is neither orthogonal nor parallel to the plane and begins in the same point which appears as reference point in the plane, so there is no intersection point");
	}
}
