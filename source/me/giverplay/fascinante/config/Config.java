package me.giverplay.fascinante.config;

import me.giverplay.fascinante.Main;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config
{
  private JSONObject json;
  private String fileName;
  private String raw;

  public Config(String name)
  {
    this.fileName = name + ".json";
  }

  public void load() throws IOException
  {
    File file = new File(fileName);

    if(!file.exists())
    {
      System.out.println(fileName + " not exists!");
      return;
    }

    BufferedReader reader = new BufferedReader(new FileReader(file));
    raw = reader.readLine();
    reader.close();

    json = new JSONObject(raw);
  }

  public void save() throws IOException
  {
    File file = new File(fileName);

    if(file.exists())
    {
      file.delete();
    }

    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    writer.write(json.toString());
    writer.flush();
    writer.close();
  }

  public String getRawData()
  {
    return this.raw;
  }

  public void saveDefault(boolean replace)
  {
    File file = new File(fileName);

    if(file.exists() && !replace)
    {
      try
      {
        load();
      } catch (IOException e)
      {
        e.printStackTrace();
      }

      return;
    }

    try
    {
      FileUtils.copyInputStreamToFile(Main.class.getResourceAsStream("/Settings.json"), file);
    }
    catch (IOException e)
    {
      System.out.println("Failed to save default settings...");
      e.printStackTrace();
    }

    try
    {
      load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public JSONObject getJsonData()
  {
    return this.json;
  }
}
