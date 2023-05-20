package io.rentmycam.model;

public class User {
  private int id;
  private String username;
  private String password;
  private Wallet wallet;

  private User() {}

  public User(int id, String username, String password, Wallet wallet) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.wallet = wallet;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Wallet getWallet() {
    return wallet;
  }

  public void setWallet(Wallet wallet) {
    this.wallet = wallet;
  }
}
