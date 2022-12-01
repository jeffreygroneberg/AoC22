package util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Utils {

    public File getFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}

