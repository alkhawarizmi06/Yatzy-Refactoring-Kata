package engine;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class YatzyScoringStrategyLoader {

    public static Set<Object> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> {
                    try {
                        return getClass(line, packageName);
                    } catch (InstantiationException e) {
                        return null;
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                })
                .collect(Collectors.toSet());
    }

    private static Object getClass(String className, String packageName) throws InstantiationException, IllegalAccessException {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.'))).newInstance();
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}
