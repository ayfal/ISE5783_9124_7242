/**
 * 
 */
package unitests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;

/**
 * @author Ariel David and Moshe
 *
 */
class RayTests {

	/**
	 * Test method for
	 * {@link primitives.Ray#Ray(primitives.Point, primitives.Vector)}.
	 */
	@Test
	void testRay() {
		// =============== Boundary Values Tests ==================
		// TC01: a constructor test to check if the "vector zero" throws an exception.
		try {
			new Ray(new Point(0, 0, 0), new Vector(0, 0, 0));
		} catch (IllegalArgumentException e) {
			fail(e);
		}
	}

}
