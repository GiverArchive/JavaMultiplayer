package me.giverplay.fascinante.protocol.packet.server;

import me.giverplay.fascinante.protocol.packet.PacketOut;
import me.giverplay.fascinante.protocol.packet.PacketType;
import me.giverplay.fascinante.server.player.PlayerProfile;
import org.json.JSONObject;

public class PacketOutDisconnect extends PacketOut
{
  private PlayerProfile profile;

  public PacketOutDisconnect(PlayerProfile player)
  {
    super(PacketType.DISCONNECT);

    this.profile = player;

    JSONObject data = new JSONObject();
    data.put("nickname", player.getNick());

    this.data.put("data", data);
  }

  public PlayerProfile getPlayer()
  {
    return this.profile;
  }

  public String getNickname()
  {
    return profile.getNick();
  }
}
