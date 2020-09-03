package me.giverplay.fascinante;

import me.giverplay.fascinante.config.Config;
import me.giverplay.fascinante.config.ConfigManager;
import me.giverplay.fascinante.server.Server;

import java.util.List;

public class Fascinante
{
  private ConfigManager configManager;
  private Config config;
  private Server server;

  private boolean clientSupport;
  private boolean showGui;

  public Fascinante(List<String> args)
  {
    if(args.contains("--clientSupport"))
    {
      this.clientSupport = true;
    }

    if(args.contains("--showGui"))
    {
      this.showGui = true;
    }

    configManager = new ConfigManager();
    config = configManager.getConfig("Settings");

    int port = config.getJsonData().getInt("port");
    server = new Server(port);
  }
}
