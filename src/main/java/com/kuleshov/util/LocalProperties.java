package com.kuleshov.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocalProperties {
    private Properties properties;

    public LocalProperties() {
        load();
    }

    private void load() {
        String path = LocalProperties.class.getClassLoader().getResource("local.properties").getPath();
        try (FileInputStream fis = new FileInputStream(path)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String get(String name) {
        return properties.getProperty(name);
    }
}