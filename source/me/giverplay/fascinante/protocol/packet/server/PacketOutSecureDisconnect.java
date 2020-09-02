package me.giverplay.fascinante.protocol.packet.server;

import me.giverplay.fascinante.protocol.packet.PacketOut;
import me.giverplay.fascinante.protocol.packet.PacketType;
import org.json.JSONObject;

public class PacketOutSecureDisconnect extends PacketOut
{
  private String reason;

  public PacketOutSecureDisconnect(String reason)
  {
    super(PacketType.SECURE_DISCONNECT);

    this.reason = reason;

    JSONObject data = new JSONObject();
    data.put("reason", reason);

    this.data.put("data", data);
  }

  public String getReason()
  {
    return reason;
  }
}
