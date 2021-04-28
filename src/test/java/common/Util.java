package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Util {

    public static Map<String, String> readPropertiesFile() {
        String location = "src/test/resources/config.properties";
        Map<String, String> properties = new HashMap<>();
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File(location)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        props.forEach((key, value) -> {
            properties.put(key.toString(), value.toString());
        });
        return properties;
    }

    public static URL getUrl(String url){
        try{
            return new URL(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
