package lighting;

import primitives.Color;

/**
 * abstract class for light
 */
abstract class Light {
   private final Color intensity;

   // ***************** Constructors ********************** //
    /**
     * constructor for light
     * @param i color of light
     */
    protected Light(Color i) {
        intensity = i;
    }

    // ***************** Getters/Setters ********************** //
    /**
     * getter for intensity
     * @return intensity
     */
    public Color getIntensity() {
        return intensity;
    }
}
