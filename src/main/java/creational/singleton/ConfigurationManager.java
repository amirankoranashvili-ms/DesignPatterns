package creational.singleton;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum ConfigurationManager {

    INSTANCE;

    private final Map<String, String> configsCache = new ConcurrentHashMap<>();

    public void setConfig(String key, String value) {
        configsCache.put(key, value);
    }

    public String getConfig(String key) {
        return configsCache.get(key);
    }

    public void printAllConfigs() {
        configsCache.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public record ConfigurationSnapshot(int size, boolean isEmpty) {
    }

    public ConfigurationSnapshot getSnapshot() {
        return new ConfigurationSnapshot(configsCache.size(), configsCache.isEmpty());
    }

    public static void main(String[] args) {
        ConfigurationManager manager = ConfigurationManager.INSTANCE;
        manager.setConfig("config1", "value1");
        manager.setConfig("config2", "value2");
        manager.setConfig("config3", "value3");
        manager.printAllConfigs();


        System.out.println(">>> --- <<<");
        ConfigurationManager alsoManager = ConfigurationManager.INSTANCE;
        alsoManager.setConfig("config4", "value4");
        alsoManager.printAllConfigs();

        System.out.println(manager == alsoManager);


    }

}
