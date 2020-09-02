package me.giverplay.fascinante.protocol.packet.server;

import me.giverplay.fascinante.protocol.packet.PacketOut;
import me.giverplay.fascinante.protocol.packet.PacketType;
import org.json.JSONObject;

public class PacketOutGameData extends PacketOut
{
  private JSONObject gameData;

  public PacketOutGameData(JSONObject gameData)
  {
    super(PacketType.GAME_DATA);

    this.gameData = gameData;
    this.data.put("data", gameData);
  }

  public JSONObject getGameData()
  {
    return gameData;
  }
}
