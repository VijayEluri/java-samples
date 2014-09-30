package jp.canetrash.maven.plugin.bijint;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Before;
import org.junit.Test;

public class BujintMojoTest extends AbstractMojoTestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

	@Test
	public void testNowTimeImageUrl() throws Exception {
		BujintMojo target = new BujintMojo();
		String result = target.nowTimeImageUrl();
		System.out.println(result);
	}

	@Test
	public void testGetImagePath() throws Exception {
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				"test.html");
		String str = IOUtils.toString(is, "UTF-8");

		BujintMojo target = new BujintMojo();
		assertEquals("結果が不正です", "/jp/img/clk/6976221_31.jpg", target
				.getImagePath(str));

	}

	@Test
	public void testGetFittingImage() throws Exception {
		BujintMojo target = new BujintMojo();
		BufferedImage image = target.getFittingImage(target.nowTimeImageUrl());
		ImageIO.write(image, "jpg", new File("test.jpg"));
	}

	@Test
	public void testExecute() throws Exception {
		BujintMojo target = new BujintMojo();
		target.execute();

	}

}
