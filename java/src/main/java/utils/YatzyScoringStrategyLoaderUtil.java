package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

import exceptions.ScoringStrategyLoadingException;
import scorings.ScoringStrategy;

public class YatzyScoringStrategyLoaderUtil {

    public static Set<ScoringStrategy> loadScoringStrategies(String packageName) {

        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageToPath(packageName));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> loadScoringStrategyClass(line, packageName))
                .collect(Collectors.toSet());

    }

    private static String packageToPath(String packageName) {
        return packageName.replaceAll("[.]", "/");
    }

    private static ScoringStrategy loadScoringStrategyClass(String className, String packageName) throws ScoringStrategyLoadingException {
        try {
            String fullClassName = packageName + "." + className.substring(0, className.lastIndexOf('.'));
            Class<?> scoringStrategyClass = Class.forName(fullClassName);
            return (ScoringStrategy) scoringStrategyClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException exception) {
            throw new ScoringStrategyLoadingException("Failed to load scoring strategy class: " + className, exception);
        }
    }
}