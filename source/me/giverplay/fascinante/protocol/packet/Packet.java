package me.giverplay.fascinante.protocol.packet;

public interface Packet
{
  String serialize();

  void deserialize();
}
