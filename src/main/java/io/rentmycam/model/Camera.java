package io.rentmycam.model;

public class Camera {
  private int id;
  private String brand;
  private String model;
  private double price;
  private String status;

  private Camera() {}

  public Camera(int id, String brand, String model, double price, String status) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.price = price;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
