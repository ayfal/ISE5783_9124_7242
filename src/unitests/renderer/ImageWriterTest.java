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
	 * Test method for {@link renderer.ImageWriter#writeToImage()}.
	 */
	@Test
	void testWriteToImage() {

		final int nX = 801;
		final int nY = 501;

		final Color yellow = new Color(255d, 255d, 0);
		final Color red = new Color(255, 0, 0);

		final int step = 50;

		ImageWriter imageWriter = new ImageWriter("yellow red grid", nX, nY);
		for (int i = 0; i < nX; i++)
			for (int j = 0; j < nY; j++)
				imageWriter.writePixel(i, j, (i % step == 0 || j % step == 0) ? red : yellow);
		imageWriter.writeToImage();

	}

}
