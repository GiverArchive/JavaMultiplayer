package me.giverplay.fascinante.server.player;

public class PlayerProfile
{
  private String nick;
  private String token;

  public PlayerProfile(String nick, String token)
  {
    this.nick = nick;
    this.token = token;
  }

  public String getNick()
  {
    return nick;
  }

  public void setNick(String nick)
  {
    this.nick = nick;
  }

  public String getToken()
  {
    return token;
  }

  public void setToken(String token)
  {
    this.token = token;
  }
}
