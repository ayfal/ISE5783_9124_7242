package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * 
 */
public interface LightSource {
    /**
     * calculates the intensity of light at a point
     * @param p point to calculate intensity at
     * @return intensity of light at point
     */    
    public Color getIntensity(Point p); 
    
    /**
     * calculates the direction of light at a point
     * @param p point to calculate direction at
     * @return direction of light at point
     */
    public Vector getL(Point p);
    
}
