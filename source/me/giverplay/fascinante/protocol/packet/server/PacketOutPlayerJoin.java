package me.giverplay.fascinante.protocol.packet.server;

import me.giverplay.fascinante.protocol.packet.PacketOut;
import me.giverplay.fascinante.protocol.packet.PacketType;
import me.giverplay.fascinante.server.player.PlayerProfile;
import org.json.JSONObject;

public class PacketOutPlayerJoin extends PacketOut
{
  private PlayerProfile profile;

  public PacketOutPlayerJoin(PlayerProfile profile)
  {
    super(PacketType.PLAYER_JOIN);

    this.profile = profile;

    JSONObject data = new JSONObject();
    data.put("nickname", profile.getNick());

    this.data.put("data", data);
  }

  public PlayerProfile getProfile()
  {
    return profile;
  }

  public String getNickname()
  {
    return profile.getNick();
  }
}
