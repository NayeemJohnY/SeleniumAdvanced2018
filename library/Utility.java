package library;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;



import org.openqa.selenium.WebDriver;

public class Utility {

	


	public static void FullScreenshot(WebDriver driver, String screeshotName) throws Exception {
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		ImageIO.write(image, "png", new File("./Screenshots/" + screeshotName +".png"));
	}
}
