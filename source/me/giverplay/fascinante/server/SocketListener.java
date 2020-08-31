package me.giverplay.fascinante.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener implements Runnable
{
  private ServerSocket socket;
  private Server server;

  public SocketListener(Server server, ServerSocket socket)
  {
    this.server = server;
    this.socket = socket;
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
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
