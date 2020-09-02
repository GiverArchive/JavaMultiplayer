package me.giverplay.fascinante.protocol.packet;

import org.json.JSONObject;

import java.util.HashMap;

public class Packet
{
  private final PacketType TYPE;

  protected HashMap<String, Object> data = new HashMap<>();

  public Packet(PacketType type)
  {
    this.TYPE = type;
    data.put("type", type.name());
  }

  public String serialize()
  {
    JSONObject json = new JSONObject();

    for(String s : data.keySet())
    {
      json.put(s, data.get(s));
    }

    return json.toString();
  }

  public void deserialize(JSONObject json)
  {
    for(String key : json.keySet())
    {
      data.put(key, json.get(key));
    }
  }
}
