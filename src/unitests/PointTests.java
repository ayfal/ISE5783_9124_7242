/**
 * 
 */
package unitests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;

/**
 * Unit tests for primitives.Point class
 * 
 * @author Ariel David and Moshe Weisfish
 *
 */
class PointTests {

	/**
	 * Test method for {@link primitives.Point#distanceSquared(primitives.Point)}.
	 */
	@Test
	void testDistanceSquared() {
		// ============ Equivalence Partitions Tests ==============
		 // TC01: a simple test to check the result of the function
		 assertEquals(6 ,new Point(1,1,1).distanceSquared(new Point(2,2,2)), "distance Squared function result is wrong");
		 
		 // =============== Boundary Values Tests ==================
		 //  TC02: a test to check if the distance between a point and itself is zero.
		 assertEquals(0 ,new Point(1,1,1).distanceSquared(new Point(1,1,1)), "distance Squared function result for a point and itself is wrong");
	}

	/**
	 * Test method for {@link primitives.Point#distance(primitives.Point)}.
	 */
	@Test
	void testDistance() {
		// ============ Equivalence Partitions Tests ==============
			// TC01: a simple test to check the result of the function
		 assertEquals(3 ,new Point(1,1,1).distance(new Point(3,3,3)), "distance function result is wrong");
	}

	/**
	 * Test method for {@link primitives.Point#subtract(primitives.Point)}.
	 */
	@Test
	void testSubtract() {
		// ============ Equivalence Partitions Tests ==============
		 // TC01: a simple test to check the result of the function
	   assertEquals(new Point(1,1,1),new Point(2,2,2).subtract((new Point(1,1,1))), "subtract function result is wrong");
	   
	  // do we need to check if the result is vector 0?
	}

	/**
	 * Test method for {@link primitives.Point#add(primitives.Vector)}.
	 */
	@Test
	void testAdd() {
		// ============ Equivalence Partitions Tests ==============
		 // TC01: a simple test to check the result of the function
	   assertEquals(new Point(1,1,1),new Point(0,0,0).add(new Vector(1,1,1)), "add function result is wrong");
	   
	}

}
