package pl.stepniak.maciej.javaeducation.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class PropertiesRunner {

    private static final String filename = "config.properties";

    public static void main(String[] args) {

        System.out.println("Ustawienie wartości początkowych");
        Properties properties = prepareDefaultProperties();

        System.out.println("Zapis do pliku config.properties");
        savePropertiesFileWriter(properties, PropertiesRunner.filename);

        System.out.println("Zapis do pliku config.properties.xml");
        properties.setProperty("newProperty", "newValue");
        properties.setProperty("sys", "Windows");
        savePropertiesFileOutputStream(properties, PropertiesRunner.filename, true);

        properties.setProperty("version", "3.0");

        System.out.println("\nOdczyt z pliku config.properties:");
        properties = loadPropertiesFileReader(PropertiesRunner.filename);
        properties.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\nOdczyt z pliku config.properties.xml");
        properties = loadPropertiesXML(PropertiesRunner.filename + ".xml");
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static Properties prepareDefaultProperties() {
        Properties properties = new Properties();
        properties.setProperty("sys", "Linux");
        properties.setProperty("version", "1.0");
        properties.setProperty("backgroundColor", "blue");
        return properties;
    }

    private static void savePropertiesFileWriter(Properties properties, String filename) {
        try (Writer writer = new FileWriter(filename)) {
            properties.store(writer, null);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesRunner.class.getSimpleName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void savePropertiesFileOutputStream(Properties properties, String filename, boolean xmlFormat) {
        filename = xmlFormat ? filename + ".xml" : filename;
        try (OutputStream os = new FileOutputStream(filename)) {
            if (xmlFormat) {
                properties.storeToXML(os, null, "UTF-8");
            } else {
                properties.store(os, null);
            }

        } catch (IOException ex) {
            Logger.getLogger(PropertiesRunner.class.getSimpleName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Properties loadPropertiesFileReader(String filename) {
        Properties properties = new Properties();
        try (Reader reader = new FileReader(filename)) {
            properties.load(reader);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesRunner.class.getSimpleName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }

    private static Properties loadPropertiesXML(String filename) {
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream(filename)) {
            properties.loadFromXML(is);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesRunner.class.getSimpleName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }
}
