package testGit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestGit {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("config.properties");
            properties.load(input);
            String token = properties.getProperty("github.token");
            System.out.println("GitHub Token: " + token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}