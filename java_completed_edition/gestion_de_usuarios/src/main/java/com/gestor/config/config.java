package com.gestor.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Config instancia;
    private Properties propiedades;

    private Config() {
        propiedades = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            propiedades.load(input);
        } catch (IOException e) {
            System.err.println("No se pudo cargar el archivo config.properties: " + e.getMessage());
        }
    }

    public static Config getInstance() {
        if (instancia == null) {
            instancia = new Config();
        }
        return instancia;
    }

    public String get(String clave) {
        return propiedades.getProperty(clave);
    }
}
