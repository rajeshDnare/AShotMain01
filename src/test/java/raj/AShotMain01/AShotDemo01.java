package raj.AShotMain01;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class AShotDemo01 {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://mvnrepository.com/");
		
		AShot ashot=new AShot();
		ShootingStrategy strategy=ShootingStrategies.viewportPasting(1000);
		
		ashot.shootingStrategy(strategy);
		Screenshot screen= ashot.takeScreenshot(driver);
		BufferedImage image= screen.getImage();
		ImageIO.write(image, "PNG", new File("firstScreen.png"));
		
	}

}
