package me.giverplay.fascinante;

import me.giverplay.fascinante.config.Config;
import me.giverplay.fascinante.config.ConfigManager;
import me.giverplay.fascinante.server.Server;

import java.util.List;
import java.util.Locale;

public class Fascinante
{
  private ConfigManager configManager;
  private Config config;
  private Server server;

  private boolean clientSupport;
  private boolean showGui;

  Fascinante(List<String> args)
  {
    this.clientSupport = args.contains("--clientSupport");
    this.showGui = args.contains("--showGui");

    long now = System.currentTimeMillis();
    System.out.println("Starting server load");

    configManager = new ConfigManager();
    config = configManager.getConfig("Settings");

    int port = config.getJsonData().getInt("port");
    server = new Server(port);

    System.out.format(Locale.US, "Done (%.3fs)!%n", (float) ((System.currentTimeMillis() - now) / 1000));
  }
}
