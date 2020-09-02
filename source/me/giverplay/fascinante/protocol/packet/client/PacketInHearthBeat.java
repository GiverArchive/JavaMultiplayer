package me.giverplay.fascinante.protocol.packet.client;

import me.giverplay.fascinante.protocol.packet.PacketIn;
import me.giverplay.fascinante.protocol.packet.PacketType;
import org.json.JSONObject;

public class PacketInHearthBeat extends PacketIn
{
  private long time;

  public PacketInHearthBeat(long time)
  {
    super(PacketType.KEEP_ALIVE);

    this.time = time;

    JSONObject data = new JSONObject();
    data.put("time", time);

    this.data.put("data", data);
  }

  public long getTime()
  {
    return time;
  }
}
