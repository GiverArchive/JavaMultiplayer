package me.giverplay.fascinante.protocol.packet.server;

import me.giverplay.fascinante.protocol.packet.PacketOut;
import me.giverplay.fascinante.protocol.packet.PacketType;

public class PacketOutPing extends PacketOut
{
  public PacketOutPing()
  {
    super(PacketType.PING);
  }
}
