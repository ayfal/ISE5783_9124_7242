/**
 * 
 */
package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import primitives.Color;

/**
 * @author Ariel
 *
 */
public class Scene {
	public String name;
	public Color background = Color.BLACK;
	public AmbientLight ambientLight = AmbientLight.NONE;
	public Geometries geometries = new Geometries();

	// ***************** Constructors ********************** //
	/**
	 * constructs a scene with a given name
	 * 
	 * @param name name of the scene
	 */
	public Scene(String n) {
		name = n;
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * set the background color of the scene
	 * 
	 * @param c color
	 * @return the scene
	 */
	public Scene setBackground(Color c) {
		background = c;
		return this;
	}

	/**
	 * set the ambient light of the scene
	 * 
	 * @param a ambient light
	 * @return the scene
	 */
	public Scene setAmbientLight(AmbientLight a) {
		ambientLight = a;
		return this;
	}

	/**
	 * set the geometries of the scene
	 * 
	 * @param g geometries
	 * @return the scene
	 */
	Scene setGeometries(Geometries g) {
		geometries = g;
		return this;
	}
}
