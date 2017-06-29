package pl.stepniak.maciej.javaeducation.properties;

import java.util.Properties;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class DefaultPropertiesSetter {

    private Properties properties;

    public DefaultPropertiesSetter() {
        this.properties = new Properties();
        prepareDefaultProperties();
    }

    private void prepareDefaultProperties() {
        this.properties.setProperty("author", "Maciej Stępniak");
        this.properties.setProperty("version", "1.0");
        this.properties.setProperty("backgroundColor", "blue");
    }

    public Properties getDefaultProperties() {
        return this.properties;
    }
}
