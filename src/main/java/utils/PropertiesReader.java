package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public String fileName;
    public String propertiesValue;
    Properties p;

    public PropertiesReader(){}

    public PropertiesReader(String fileName) throws IOException {

        FileReader file = new FileReader(fileName);
        p = new Properties();
        p.load(file);

    }


    public String getProperty(String propertiesValue)  {

        return p.getProperty(propertiesValue);

    }
}
