package me.giverplay.fascinante;

public class Fascinante
{
  private static boolean clientSupport;

  public static void main(String[] args)
  {
    if(args.length > 0)
    {
      if(args[0].equalsIgnoreCase("--clientMode"))
      {
        clientSupport = true;
      }
    }
  }
}
