package com.axity.dinosaurpark.config;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ParkConfig {

    private static ParkConfig instance;
    private final Properties props;

    // Constructor PRIVADO — nadie puede hacer "new ParkConfig()"
    private ParkConfig() {
        // Carga park.properties con getClass().getClassLoader().getResourceAsStream()
        props = new Properties();

        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("park.properties")) {

            if (input == null) {
                throw new RuntimeException("No se encontró el archivo park.properties");
            }

            props.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Error al cargar park.properties", e);
        }
    }

    // Punto de acceso global — crea la instancia solo si no existe
    // Punto de acceso global — crea la instancia solo si no existe
    public static ParkConfig getInstance() {

        if (instance == null) {
            instance = new ParkConfig();
        }

        return instance;
    }

    // Métodos de lectura
    public int getInt(String key, int defaultValue) {

        String value = props.getProperty(key);

        if (value == null) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public double getDouble(String key, double defaultValue) {

        String value = props.getProperty(key);

        if (value == null) {
            return defaultValue;
        }

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public String getString(String key, String defaultValue) {

        return props.getProperty(key, defaultValue);
    }

    public long getSeed() {

        String value = props.getProperty("simulation.seed");

        if (value == null || value.isBlank()) {
            return System.currentTimeMillis();
        }

        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return System.currentTimeMillis();
        }
    }

    public int getTotalSteps() {

        return getInt("simulation.totalSteps", 1000);
    }

    // Solo para tests — permite resetear la instancia entre tests
    static void resetForTesting() {
        instance = null;
    }
}
