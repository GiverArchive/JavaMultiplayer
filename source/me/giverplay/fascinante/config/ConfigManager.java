package me.giverplay.fascinante.config;

import java.io.IOException;
import java.util.HashMap;

public class ConfigManager
{
  private HashMap<String, Config> configs = new HashMap<>();

  public ConfigManager()
  {
    Config settings = new Config("Settings");
    settings.saveDefault(false);
    configs.put("Settings", settings);

    try
    {
      settings.load();
    }
    catch (IOException e)
    {
      System.out.println("Failed to load server settings");
      e.printStackTrace();
    }
  }

  public Config getConfig(String configName)
  {
    return configs.get(configName);
  }

  public void registerConfig(String configName, Config config)
  {
    if(config == null)
    {
      throw new IllegalArgumentException("Config cannot be null!");
    }

    if(configName == null)
    {
      throw new IllegalArgumentException("Config name cannot be null!");
    }

    if(configs.containsKey(configName))
    {
      throw new IllegalStateException("Config " + configName + " is already registered!");
    }

    configs.put(configName, config);
  }
}
