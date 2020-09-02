package me.giverplay.fascinante.server;

import me.giverplay.fascinante.protocol.packet.Packet;
import me.giverplay.fascinante.protocol.packet.server.PacketOutGameData;
import me.giverplay.fascinante.protocol.packet.server.PacketOutPlayerJoin;
import me.giverplay.fascinante.server.player.Player;
import me.giverplay.fascinante.server.player.PlayerHandle;
import me.giverplay.fascinante.server.player.PlayerProfile;
import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable
{
  private List<PlayerHandle> unauth = new ArrayList<>();
  private List<Player> players = new ArrayList<>();

  private Thread thread;
  private ServerSocket socket;

  private boolean running;

  private int ticks;

  public Server(int port)
  {
    try
    {
      socket = new ServerSocket(port);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    running = true;
    this.thread = new Thread(this);
    this.thread.start();
  }

  public boolean isRunning()
  {
    return this.running;
  }

  private void tick()
  {

  }

  public int getCurrentTicks()
  {
    return this.ticks;
  }

  @Override
  public void run()
  {
    long timer = System.currentTimeMillis();
    long lastTime = System.nanoTime();
    long now;

    double nsTick = 1000000000 / 60D;
    double unprocessed = 0D;

    int tk = 0;

    while(running)
    {
      now = System.nanoTime();
      unprocessed += (now - lastTime) / nsTick;
      lastTime = now;

      while(unprocessed >= 1)
      {
        tk++;
        tick();
        unprocessed--;

        if(timer >= 1000)
        {
          ticks = tk;
          timer += 1000;
        }
      }
    }
  }

  public void handleSocketConnect(Socket socket)
  {
    PlayerHandle han = new PlayerHandle(this, socket);
    unauth.add(han);
  }

  public void removeUnauth(PlayerHandle handle)
  {
    unauth.remove(handle);
  }

  public JSONObject getGameData()
  {
    return null; // TODO
  }

  public void auth(PlayerHandle handle, PlayerProfile profile)
  {
    if(!validateToken(profile.getToken()))
    {
      removeUnauth(handle);
      handle.disconnect("Invalid credentials");
    }

    broadcast(new PacketOutPlayerJoin(profile));

    Player player = new Player(handle, profile);
    players.add(player);
    player.sendPacket(new PacketOutGameData(getGameData()));
  }

  public void broadcast(Packet packet)
  {
    for(int i = 0; i < players.size(); i++)
    {
      players.get(i).getHandle().sendPacket(packet);
    }
  }

  public boolean validateToken(String token)
  {
    return false; // TODO verificar no banco de dados
  }
}
