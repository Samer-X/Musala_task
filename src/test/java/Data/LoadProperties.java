package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {


    public static Properties useData = loadProperties("src\\main\\java\\properties\\userData.properties");

    private static Properties loadProperties(String path) {

        Properties pro = new Properties();

        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
            stream.close();
        } catch (IOException e) {
            System.out.println("Error Occurred " + e.getMessage());
        }
        return pro;
    }
}
