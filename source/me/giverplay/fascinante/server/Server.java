package me.giverplay.fascinante.server;

import me.giverplay.fascinante.server.player.PlayerHandle;
import me.giverplay.fascinante.server.player.PlayerProfile;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable
{
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
  }

  public void auth(PlayerHandle handle, PlayerProfile profile)
  {

  }
}
