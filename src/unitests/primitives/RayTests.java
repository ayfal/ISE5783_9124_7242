package unitests.primitives;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Unit tests for primitives.Ray class
 * 
 * @author Ariels
 *
 */
public class RayTests {

	/**
	 * Test method for {@link primitives.Ray#getPoint(double)}.
	 */
	@Test
	void testDistanceSquared() {
		// ============ Equivalence Partitions Tests ==============
		Ray ray = new Ray(new Point(1, 0, 0), new Vector(1, 0, 0));
		// TC01: the scalar is positive
		assertEquals(new Point(2, 0, 0), ray.getPoint(1), "ERROR: getPoint() wrong value");

		// TC02: the scalar is negative
		assertEquals(new Point(-1, 0, 0), ray.getPoint(-2), "ERROR: getPoint() wrong value");

		// =============== Boundary Values Tests ==================
		// TC03: the scalar is zero
		assertEquals(new Point(1, 0, 0), ray.getPoint(0), "ERROR: getPoint() wrong value");
	}

	/**
	 * Test method for {@link primitives.Ray#findClosestPoint(java.util.List)}.
	 */
	@Test
	void testFindClosestPoint() {
		// ============ Equivalence Partitions Tests ==============
		Ray ray = new Ray(new Point(1, 0, 0), new Vector(1, 0, 0));
		// TC01: point in the middle of the list
		assertEquals(new Point(2, 0, 0),
				ray.findClosestPoint(List.of(new Point(3, 0, 0), new Point(2, 0, 0), new Point(4, 0, 0))),
				"ERROR: findClosestPoint() wrong value");
		// ==================== Boundary Values Tests ==================
		// TC02: point in the beginning of the list
		assertEquals(new Point(2, 0, 0),
				ray.findClosestPoint(List.of(new Point(2, 0, 0), new Point(3, 0, 0), new Point(4, 0, 0))),
				"ERROR: findClosestPoint() wrong value");
		// TC03: point in the end of the list
		assertEquals(new Point(2, 0, 0),
				ray.findClosestPoint(List.of(new Point(4, 0, 0), new Point(3, 0, 0), new Point(2, 0, 0))),
				"ERROR: findClosestPoint() wrong value");
		// TC04: empty list
		assertNull(ray.findClosestPoint(List.of()), "ERROR: findClosestPoint() should return null");
	}
}
