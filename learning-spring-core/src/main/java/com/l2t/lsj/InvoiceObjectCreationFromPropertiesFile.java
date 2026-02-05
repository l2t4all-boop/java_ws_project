package com.l2t.lsj;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class InvoiceObjectCreationFromPropertiesFile {

    public static void main(String[] args) {
        try {
            Properties properties = loadProperties("/invoice.properties");
            Object obj = createAndPopulateObject(properties);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Properties loadProperties(String resourcePath) throws IOException {
        Properties properties = new Properties();
        try (InputStream is = InvoiceObjectCreationFromPropertiesFile.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            properties.load(is);
        }
        return properties;
    }

    private static Object createAndPopulateObject(Properties properties) throws Exception {
        String clsName = properties.getProperty("clsName");
        Class<?> cls = Class.forName(clsName);
        Object obj = cls.getDeclaredConstructor().newInstance();
        populateFields(obj, properties);
        return obj;
    }

    private static void populateFields(Object obj, Properties properties) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String value = properties.getProperty(field.getName());
            if (value != null) {
                field.set(obj, value);
            }
        }
    }
}