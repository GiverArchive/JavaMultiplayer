package me.giverplay.fascinante.protocol.packet.client;

import me.giverplay.fascinante.protocol.packet.PacketIn;
import me.giverplay.fascinante.protocol.packet.PacketType;
import me.giverplay.fascinante.server.player.PlayerProfile;
import org.json.JSONObject;

public class PacketInHandshake extends PacketIn
{
  private PlayerProfile profile;

  public PacketInHandshake(PlayerProfile profile)
  {
    super(PacketType.HANDSHAKE);

    this.profile = profile;

    JSONObject data = new JSONObject();
    data.put("nickname", profile.getNick());
    data.put("token", profile.getToken());

    this.data.put("data", data);
  }

  public PlayerProfile getProfile()
  {
    return profile;
  }
}
