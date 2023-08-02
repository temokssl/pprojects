package main.java.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import aquality.selenium.core.utilities.JsonSettingsFile;

public class UploadFileUtil {
	
	private static JsonSettingsFile configurationFile = new JsonSettingsFile("config.json");
	
	
	
	public static void uploadFile(String FILE,int ROBOT_DELAY) {
		String filePath = configurationFile.getValue(FILE).toString();
		
		try {
			Robot robot = new Robot();
			File file = new File(filePath);
		    StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			robot.delay(ROBOT_DELAY);
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.delay(ROBOT_DELAY);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(ROBOT_DELAY);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	
}
