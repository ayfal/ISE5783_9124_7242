package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * class for point light
 */
public class PointLight extends Light implements LightSource {
    private final Point position;
    private double kC=1;
    private double kL=0;
    private double kQ=0;

    // ***************** Constructors ********************** //
    
    /**
     * constructor for point light
     * @param intensity color of light
     * @param p position of light
     */
    public PointLight(Color intensity, Point p) {
        super(intensity);
        position = p;
    }

    // ***************** Setters ********************** //
    
    /**
     * setter for kC in phong model
     * @param kC constant attenuation factor
     * @return the light itself
     */
    public PointLight setkC(double kC) {
        this.kC = kC;
        return this;
    }

    /**
     * setter for kL in phong model
     * @param kL light's attenutation factor
     * @return the light itself
     */
    public PointLight setKl(double kL) {
        this.kL = kL;
        return this;
    }

    /**
     * setter for kQ in phong model
     * @param kQ qudratic attenutation factor
     * @return the light itself
     */
    public PointLight setKq(double kQ) {
        this.kQ = kQ;
        return this;
    }

    // ***************** Functions ********************** //

    @Override
    public Color getIntensity(Point p) {
        double d = p.distance(position);
        double denominator = kC + kL*d + kQ*d*d;
        return getIntensity().reduce(denominator);
    }
    
    @Override
    public Vector getL(Point p) {
        return p.subtract(position).normalize();
    }
    
}
