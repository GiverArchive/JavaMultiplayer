package me.giverplay.fascinante.protocol.packet.client;

import me.giverplay.fascinante.protocol.packet.PacketIn;
import me.giverplay.fascinante.protocol.packet.PacketType;
import org.json.JSONObject;

public class PacketInPlayerMove extends PacketIn
{
  private int x;
  private int y;
  private boolean jump;

  public PacketInPlayerMove(int x, int y, boolean jump)
  {
    super(PacketType.PLAYER_MOVE);

    this.x = x;
    this.y = y;
    this.jump = jump;

    JSONObject data = new JSONObject();
    data.put("x", x);
    data.put("y", y);
    data.put("jump", jump);

    this.data.put("data", data);
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public boolean isJump()
  {
    return jump;
  }
}
