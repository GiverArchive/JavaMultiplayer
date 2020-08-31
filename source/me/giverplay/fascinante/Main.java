package me.giverplay.fascinante;

import me.giverplay.fascinante.Fascinante;

import java.util.Arrays;

public class Main
{
  private static Fascinante fascinante;

  public static void main(String[] args)
  {
    fascinante = new Fascinante(Arrays.asList(args));
  }
}
