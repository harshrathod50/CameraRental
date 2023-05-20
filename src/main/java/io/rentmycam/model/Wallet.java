package io.rentmycam.model;

public class Wallet {
  private double balance;

  private Wallet() {}

  public Wallet(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
