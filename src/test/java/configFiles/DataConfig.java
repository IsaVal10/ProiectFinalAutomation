package configFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class DataConfig {

    private Properties properties;
    private String configFilePath = "src/main/resources/data.properties";

    public DataConfig() {
        properties = new Properties();
        loadProperties();
    }

    public static DataConfig loadConfig(String FilePath) {
        return null;
    }

    private void loadProperties() {
        try (InputStream input = new FileInputStream(configFilePath)) {
            // Încarcă fișierul de configurare
            properties.load(input);
        } catch (IOException ex) {
            System.out.println("Eroare la încărcarea fișierului de configurare: " + ex.getMessage());
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
    }




 