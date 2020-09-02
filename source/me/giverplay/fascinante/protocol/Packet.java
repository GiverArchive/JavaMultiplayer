package me.giverplay.fascinante.protocol;

public interface Packet
{
  String serialize();

  void deserialize();
}
