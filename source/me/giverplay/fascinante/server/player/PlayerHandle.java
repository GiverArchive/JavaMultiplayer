package me.giverplay.fascinante.server.player;

import me.giverplay.fascinante.server.Server;

import java.io.*;
import java.net.Socket;

public class PlayerHandle implements Runnable
{
  private Socket socket;
  private Server server;

  private BufferedReader input;
  private BufferedWriter output;

  public PlayerHandle(Server server, Socket conn)
  {
    this.server = server;
    this.socket = conn;

    try
    {
      setup();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void setup() throws IOException
  {
    input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
  }

  private void processEntry(String entry)
  {

  }

  public void sendMessage(String message)
  {
    try
    {
      output.write(message);
      output.flush();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void run()
  {
    String line;

    while (server.isRunning())
    {
      try
      {
        if ((line = input.readLine()) != null)
        {
          processEntry(line);
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
