package ru.itis.jdbc_repository.util;

import lombok.experimental.UtilityClass;
import ru.itis.jdbc_repository.Main;

import java.io.IOException;
import java.util.Properties;

@UtilityClass
public class PropertyReader {

    private final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(Main.class
                    .getClassLoader()
                    .getResourceAsStream("app.properties"));
        } catch (IOException e) {
            System.err.println("Unable to load properties: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
