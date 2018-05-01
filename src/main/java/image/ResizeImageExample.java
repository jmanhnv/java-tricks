package image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResizeImageExample {

	public static void main(String[] args) throws IOException {
		File input = new File("src\\main\\java\\image\\mkyong.jpg");
		BufferedImage image = ImageIO.read(input);

		BufferedImage resized = resize(image, 500, 500);

		File output = new File("c:\\image\\mkyong-resized-500x500.jpg");
		ImageIO.write(resized, "jpg", output);
	}

	private static BufferedImage resize(BufferedImage img, int height, int width) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}
}
