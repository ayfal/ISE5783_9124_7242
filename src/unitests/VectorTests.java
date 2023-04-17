/**
 * 
 */
package unitests;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import primitives.Double3;
import primitives.Vector;

/**
 * Unit tests for primitives.Point class
 * 
 * @author Ariel David and Moshe Weisfish
 *
 */
class VectorTests {

	/**
	 * Test method for {@link primitives.Vector#Vector(double, double, double)}.
	 */
	@Test
	void testVectorDoubleDoubleDouble() {
		// =============== Boundary Values Tests ==================
		// TC01: a constructor test to check if the "vector zero" throws an exception.
		assertThrows(IllegalArgumentException.class, () -> new Vector(0, 0, 0), //
				"Constructed a zero vector that dosent exist");
	}

	/**
	 * Test method for {@link primitives.Vector#Vector(primitives.Double3)}.
	 */
	@Test
	void testVectorDouble3() {
		// =============== Boundary Values Tests ==================
		// TC01: a constructor test to check if the "vector zero" throws an exception.
		assertThrows(IllegalArgumentException.class, () -> new Vector(new Double3(0, 0, 0)), //
				"Constructed a zero vector that dosent exist");
	}

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	@Test
	void testAddVector() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: a simple test to check the result of the function
		assertEquals(new Vector(2, 2, 2), new Vector(1, 1, 1).add(new Vector(1, 1, 1)), "add function result is wrong");

		// =============== Boundary Values Tests ==================
		// TC02: a test to check if a boundary result of add throws an exception.
		assertThrows(IllegalArgumentException.class, () -> new Vector(1, 1, 1).add(new Vector(-1, -1, -1)), //
				"Created a zero vector that dosent exist");
	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test
	void testScale() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: a simple test to check the result of the function
		assertEquals(new Vector(2, 2, 2), new Vector(1, 1, 1).scale(2), "scale function result is wrong");

		// =============== Boundary Values Tests ==================
		// TC02: a test to check if a boundary result of scale throws an exception.
		assertThrows(IllegalArgumentException.class, () -> new Vector(1, 1, 1).scale(0), //
				"Created a zero vector that dosent exist");
	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	void testDotProduct() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: a simple test to check the result of the function
		assertEquals(10, new Vector(1, 2, 3).dotProduct(new Vector(3, 2, 1)), "dot product function result is wrong");

		// TC02: a simple test to check the result of the function when the result is
		// zero.
		assertEquals(0, new Vector(1, 0, 0).dotProduct(new Vector(0, 1, 1)), "dot product function result is wrong");
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	void testCrossProduct() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: a simple test to check the result of the function
		assertEquals(new Vector(-4, 8, -4), new Vector(1, 2, 3).crossProduct(new Vector(3, 2, 1)),
				"cross product function result is wrong");

		// =============== Boundary Values Tests ==================
		// TC02: a test to check if a boundary result of cross product with itself
		// throws an exception
		assertThrows(IllegalArgumentException.class, () -> new Vector(1, 1, 1).crossProduct(new Vector(1, 1, 1)), //
				"Created a zero vector that dosent exist");

		// TC03: a test to check if a boundary result of cross product with its opposite
		// throws an exception
		assertThrows(IllegalArgumentException.class, () -> new Vector(1, 1, 1).crossProduct(new Vector(-1, -1, -1)), //
				"Created a zero vector that dosent exist");
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	void testLengthSquared() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: a simple test to check the result of the function
		assertEquals(12, new Vector(2, 2, 2).lengthSquared(), "length squared function result is wrong");
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	void testLength() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: a simple test to check the result of the function
		assertEquals(3, new Vector(3, 0, 0).length(), "length function result is wrong");

		// TC02: a simple test to check the result of the function
		assertEquals(3, new Vector(-3, 0, 0).length(), "length function result is wrong");
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	void testNormalize() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: a simple test to check the result of the function
		assertEquals(new Vector(1, 0, 0), new Vector(3, 0, 0).normalize(), "length function result is wrong");

	}

}
