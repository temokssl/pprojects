package main.java.Utilities;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class EncodingUtil {
	
	public static String getBase64EncodedImage(String attachmentPath) {
		File file = new File(attachmentPath);
        byte[] data;
        try {
			data = Files.readAllBytes(file.toPath());
			return Base64.getEncoder().encodeToString(data);
			
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}
	}	
	
}