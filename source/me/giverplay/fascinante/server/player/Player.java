package me.giverplay.fascinante.server.player;

import me.giverplay.fascinante.protocol.packet.Packet;

public class Player
{
  private PlayerHandle handle;
  private PlayerProfile profile;

  public Player(PlayerHandle handle, PlayerProfile profile)
  {
    this.handle = handle;
    this.profile = profile;
  }

  public PlayerHandle getHandle()
  {
    return handle;
  }

  public PlayerProfile getProfile()
  {
    return profile;
  }

  public void disconnect(String reason)
  {
    handle.disconnect(reason);
  }

  public void sendPacket(Packet packet)
  {
    handle.sendPacket(packet);
  }
}
