package me.giverplay.fascinante.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener implements Runnable
{
  private ServerSocket socket;
  private Server server;
  private Thread thread;

  public SocketListener(Server server, ServerSocket socket)
  {
    this.server = server;
    this.socket = socket;

    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run()
  {
    Socket client;

    while(server.isRunning())
    {
      try
      {
        client = socket.accept();
        server.handleSocketConnect(client);
        Thread.sleep(300);
      }
      catch (IOException | InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
