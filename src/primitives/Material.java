package primitives;

public class Material {
	public Double3 kD = Double3.ZERO, kS = Double3.ZERO;// should this be in separate lines?
	public int nShininess = 1;

	// ***************** Setters ********************** //
	/**
	 * setter for kD in Phong model
	 * 
	 * @param kD diffuse attenuation factor
	 * @return the material itself
	 */
	public Material setKd(Double3 kD) {
		this.kD = kD;
		return this;
	}

	/**
	 * setter for kD in phong model
	 * 
	 * @param kD diffuse attenuation factor
	 * @return the material itself
	 */
	public Material setKd(double kD) {
		this.kD = new Double3(kD);
		return this;
	}

	/**
	 * setter for kS in Phong model
	 * 
	 * @param kS specular attenuation factor
	 * @return the material itself
	 */
	public Material setKs(Double3 kS) {
		this.kS = kS;
		return this;
	}

	/**
	 * setter for kS in phong model
	 * 
	 * @param kS specular attenuation factor
	 * @return the material itself
	 */
	public Material setKs(double kS) {
		this.kS = new Double3(kS);
		return this;
	}

	/**
	 * setter for nShininess in phong model
	 * 
	 * @param ns shininess factor
	 * @return the material itself
	 */
	public Material setShininess(int ns) {
		nShininess = ns;
		return this;
	}

}
