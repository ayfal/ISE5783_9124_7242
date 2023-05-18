/**
 * 
 */
package unitests.renderer;


import org.junit.jupiter.api.Test;

import primitives.Color;
import renderer.ImageWriter;

/**
 * @author Ariels
 *
 */
class ImageWriterTest {

	/**
	 * Test method for
	 * {@link renderer.ImageWriter#ImageWriter(java.lang.String, int, int)}.
	 */
	@Test
	void testImageWriter() {

	}

	/**
	 * Test method for {@link renderer.ImageWriter#writeToImage()}.
	 */
	@Test
	void testWriteToImage() {
		int nX = 801;
		int nY = 501;

		Color yellow = new Color(255d, 255d, 0);
		Color red = new Color(255, 0, 0);

		ImageWriter imageWriter = new ImageWriter("yellow red grid", nX, nY);
		for (int i = 0; i < nX; i++) {
			for (int j = 0; j < nY; j++) {
				if (i % 50 == 0 || j % 50 == 0)
					imageWriter.writePixel(i, j, red);
				else
					imageWriter.writePixel(i, j, yellow);
			}
		}
		imageWriter.writeToImage();

	}

	/**
	 * Test method for
	 * {@link renderer.ImageWriter#writePixel(int, int, primitives.Color)}.
	 */
	@Test
	void testWritePixel() {

	}

}
