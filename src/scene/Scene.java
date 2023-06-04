/**
 * 
 */
package scene;

import java.util.LinkedList;
import java.util.List;

import geometries.Geometries;
import lighting.AmbientLight;
import lighting.LightSource;
import primitives.Color;

/**
 * @author Ariel
 * //TODO doc every public and protected field. done
 * //TODO use finel wherever possible. done.
 * //TODO omit unnecessary {} in if/else/for/while
 * //TODO write private explicitly. done
 */
public class Scene {
	/**
	 * name of the scene
	 */
	public final String name;

	/**
	 * background color of the scene. default is black
	 */
	public Color background = Color.BLACK;

	/**
	 * ambient light of the scene. default is none
	 */
	public AmbientLight ambientLight = AmbientLight.NONE;

	/**
	 * geometries of the scene. default is empty
	 */
	public Geometries geometries = new Geometries();

	/**
	 * lights of the scene. default is empty
	 */
	public List<LightSource> lights=new LinkedList<LightSource>();

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

	/**
	 * set the lights of the scene
	 * @param l lights
	 * @return the scene
	 */
	public Scene setLights(List<LightSource> l) {
		lights = l;
		return this;
	}
}
