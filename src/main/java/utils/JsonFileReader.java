package utils;

import java.io.InputStream;

public class JsonFileReader {
    private String fileName;


    public InputStream JsonFileReader(String fileName) {

        return getClass().getClassLoader()
                .getResourceAsStream(fileName);
    }
}
