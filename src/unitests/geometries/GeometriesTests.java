package unitests.geometries;

import geometries.*;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Geometries class methods
 * 
 * @author Ariels
 */
class GeometriesTests {

	/**
	 * Test method for
	 * {@link geometries.Geometries#findIntersections(primitives.Ray)}.
	 */
	@Test
	void testFindIntersections() {
		Sphere sphere = new Sphere(1, new Point(1, 1, 1));
		Plane plane = new Plane(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 2));
		Triangle triangle = new Triangle(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
		Geometries collection = new Geometries(sphere, plane, triangle);

		// ============ Equivalence Partitions Tests ==============
		// TC01: some geometries are intersected
		assertEquals(3, collection.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(1, 1, 1))).size(),
				"wrong number of points");

		// =============== Boundary Values Tests ==================
		// TC02: empty list
		Geometries emptyCollection = new Geometries();
		assertNull(emptyCollection.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0))),
				"list is not empty");

		// TC03: no geometry is intersected
		assertNull(collection.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(-1, -1, -1))),
				"no geometry should intersect");

		// TC04: one geometry is intersected
		assertEquals(1, collection.findIntersections(new Ray(new Point(2, 0, 2), new Vector(-1, -1, -1))).size(),
				"one geometry should intersect");

		// TC05: all geometries are intersected
		assertEquals(4, collection.findIntersections(new Ray(new Point(2, 2, 2.5), new Vector(-1, -1, -1))).size(),
				"all geometries should intersect");
	}

}
