package io.rentmycam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import io.rentmycam.model.Camera;
import io.rentmycam.model.User;
import io.rentmycam.model.Wallet;

public class App {
  private List<Camera> cameraList;
  private Scanner scanner;
  private User user;

  private App() {
    this.cameraList = Arrays.asList(
      new Camera(1, "Samsung", "DS123", 500, "Available"),
      new Camera(2, "Sony", "HDS214", 500, "Available"),
      new Camera(3, "Panasonic", "XC", 500, "Available"),
      new Camera(4, "Canon", "XLR", 500, "Available"),
      new Camera(5, "Fujitsu", "J5", 500, "Available"),
      new Camera(6, "Sony", "HD226", 500, "Available"),
      new Camera(7, "Samsung", "DS246", 500, "Rented"),
      new Camera(8, "LG", "L123", 500, "Available"),
      new Camera(9, "Canon", "XPL", 500, "Available"),
      new Camera(10, "Chroma", "CT", 500, "Available"),
      new Camera(11, "Nikon", "DSLR-D7500", 500, "Available"),
      new Camera(12, "Sony", "DSLR12", 200, "Available"),
      new Camera(13, "Samsung", "SM123", 200, "Rented"),
      new Camera(14, "Sony", "SONY1234", 123, "Available"),
      new Camera(15, "Canon", "5050", 25000, "Available"),
      new Camera(16, "Nikon", "2030", 500, "Available")
    );
    this.user = new User(1, "admin", "admin123", new Wallet(500000));
    this.scanner = new Scanner(System.in);
  }

  private void mainMenu() {
    System.out.println("1. MY CAMERA");
    System.out.println("2. RENT A CAMERA");
    System.out.println("3. VIEW ALL CAMERA");
    System.out.println("4. MY WALLET");
    System.out.println("5. EXIT");
    int option = Integer.parseInt(this.scanner.nextLine());
    switch (option) {
      case 1 -> {

      }
      case 2 -> {

      }
      case 3 -> {
        System.out.println("FOLLOWING IS THE LIST OF ALL CAMERA(S)");
        System.out.println("=========================================================================================");
        System.out.println("ID\t\t\t\tBRAND\t\t\t\tMODEL\t\t\t\tPRICE(PER DAY)\t\t\t\tSTATUS");
        System.out.println("=========================================================================================");
        for (Camera c: this.cameraList) {
          System.out.printf(
            "%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t%s\n",
            c.getId(), c.getBrand(), c.getModel(), c.getPrice(), c.getStatus()
          );
        }
        System.out.println("=========================================================================================");
      }
      case 4 -> {

      }
      case 5 -> System.out.println("BYE!!");
    }
  }

  public static void start() {
    App app = new App();
    System.out.println("+--------------------------------+");
    System.out.println("|  WELCOME TO CAMERA RENTAL APP  |");
    System.out.println("+--------------------------------+");
    System.out.println("PLEASE LOGIN TO CONTINUE");
    System.out.print("USERNAME: ");
    if (app.scanner.nextLine().equals("admin")) {
      System.out.print("PASSWORD: ");
      if (app.scanner.nextLine().equals("admin123")) {
        app.mainMenu();
      } else {
        System.out.println("\nINCORRECT PASSWORD!!\n");
      }
    } else {
      System.out.println("\nUSER NOT FOUND!!\n");
    }
  }
}
