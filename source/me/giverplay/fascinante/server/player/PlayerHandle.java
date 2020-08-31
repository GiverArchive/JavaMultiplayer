package me.giverplay.fascinante.server.player;

import me.giverplay.fascinante.server.Server;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class PlayerHandle implements Runnable
{
  private Socket socket;
  private Server server;

  private BufferedReader input;
  private BufferedWriter output;

  private boolean authenticated = false;

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
    JSONObject json;
    try
    {
      json = new JSONObject(entry);
    }
    catch (JSONException e)
    {
      try
      {
        System.out.println("Disconnecting for bad packet");
        socket.close();
        server.removeUnauth(this);
      }
      catch (IOException e2)
      {
        e.printStackTrace();
      }
    }
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
