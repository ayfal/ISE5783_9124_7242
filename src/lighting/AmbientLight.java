/**
 * 
 */
package lighting;

import primitives.Color;
import primitives.Double3;

/**
 * class AmbientLight represents the ambient light in the scene
 * 
 * @author Ariels
 *
 */
public class AmbientLight {
	private final Color intensity;
	public static final AmbientLight NONE = new AmbientLight(Color.BLACK, Double3.ZERO);

	// ***************** Constructors ********************** //

	/**
	 * constructs an ambient light with a given color and attenuation factor
	 * 
	 * @param iA color with base intensity
	 * @param kA attenuation factor
	 * 
	 */
	public AmbientLight(Color iA, Double3 kA) {
		intensity = iA.scale(kA);
	}

	public AmbientLight(Color iA, Double kA) {
		intensity = iA.scale(kA);
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * get the intensity of the color with ambient light
	 * 
	 * @return the intensity
	 */
	public Color getIntensity() {
		return intensity;
	}
}
