package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

import scorings.ScoringStrategy;

public class YatzyScoringStrategyLoaderUtil {

    public static Set<ScoringStrategy> loadScoringStrategies(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName)
                )
                .collect(Collectors.toSet());
    }

    private static ScoringStrategy getClass(String className, String packageName) {
        try {
            return (ScoringStrategy) Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.'))).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            // handle the exception
        }
        return null;
    }
}
