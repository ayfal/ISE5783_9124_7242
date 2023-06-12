/**
 * 
 */
package lighting;

import primitives.Color;
import primitives.Double3;

/**
 * class AmbientLight extends the class Light and represents the ambient light
 * in the scene
 * 
 * @author Ariels
 *
 */
public class AmbientLight extends Light {

	/**
	 * constant ambient light with no intensity, aka no ambient light
	 */
	public static final AmbientLight NONE = new AmbientLight(Color.BLACK, Double3.ZERO);

	// ***************** Constructors ********************** //

	/**
	 * constructs an ambient light with a given color and attenuation factor
	 * 
	 * @param iA color with base intensity
	 * @param kA attenuation factor (according to RGB)
	 */
	public AmbientLight(Color iA, Double3 kA) {
		super(iA.scale(kA));
	}

	/**
	 * constructs an ambient light with a given color and attenuation factor
	 * 
	 * @param iA color with base intensity
	 * @param kA attenuation factor
	 */
	public AmbientLight(Color iA, double kA) {
		super(iA.scale(kA));
	}

}
