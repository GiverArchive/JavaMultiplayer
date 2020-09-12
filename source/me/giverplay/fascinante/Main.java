package me.giverplay.fascinante;

import java.util.Arrays;

public class Main
{
  private static Fascinante fascinante;

  public static void main(String[] args)
  {
    Main.fascinante = new Fascinante(Arrays.asList(args));
  }

  public static Fascinante getFascinante()
  {
    return Main.fascinante;
  }
}
