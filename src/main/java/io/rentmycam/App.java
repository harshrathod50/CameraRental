package io.rentmycam;

import java.util.ArrayList;
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
    this.cameraList = new ArrayList<Camera>(List.of(
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
    ));
    this.user = new User(1, "admin", "admin123", new Wallet(50));
    this.scanner = new Scanner(System.in);
  }

  private void listAllCameras() {
    System.out.println("\nFOLLOWING IS THE LIST OF ALL CAMERA(S)");
    System.out.println("=========================================================================================");
    System.out.println("ID\t\t\t\tBRAND\t\t\t\tMODEL\t\t\t\tPRICE(PER DAY)\t\t\t\tSTATUS");
    System.out.println("=========================================================================================");
    for (Camera c: this.cameraList) {
      System.out.printf(
              "%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t%s\n",
              c.getId(), c.getBrand(), c.getModel(), c.getPrice(), c.getStatus()
      );
    }
    System.out.println("=========================================================================================\n");
  }

  private void myCameraMenu() {
    System.out.println("\n1. ADD");
    System.out.println("2. REMOVE");
    System.out.println("3. VIEW");
    System.out.println("4. MAIN MENU");
    int option = Integer.parseInt(this.scanner.nextLine());
    switch (option) {
      case 1 -> {
        System.out.print("BRAND NAME: ");
        String b = this.scanner.nextLine();
        System.out.print("MODEL: ");
        String m = this.scanner.nextLine();
        System.out.print("PRICE PER DAY: ");
        double p = Double.parseDouble(this.scanner.nextLine());
        this.cameraList.add(new Camera(this.cameraList.size() + 1, b, m, p, "Available"));
        System.out.println("\nCAMERA ADDED!!\n");
        this.myCameraMenu();
      }
      case 2 -> {
        System.out.print("CAMERA ID: ");
        int id = Integer.parseInt(this.scanner.nextLine());
        for (int i = 0; i < this.cameraList.size(); ++i) {
          if (this.cameraList.get(i).getId() == id) {
            this.cameraList.remove(i);
            System.out.printf("\nCAMERA WITH %d HAS BEEN REMOVED!!\n", id);
            this.myCameraMenu();
          }
        }
        System.out.printf("\nCAMERA WITH ID %d WAS NOT FOUND!!\n", id);
        this.myCameraMenu();
      }
      case 3 -> {
        this.listAllCameras();
        this.myCameraMenu();
      }
      case 4 -> this.mainMenu();
    }
  }

  private void rentCameraMenu() {
    System.out.println("\nFOLLOWING IS THE LIST OF AVAILABLE CAMERA(S)");
    System.out.println("=========================================================================================");
    System.out.println("ID\t\t\t\tBRAND\t\t\t\tMODEL\t\t\t\tPRICE(PER DAY)\t\t\t\tSTATUS");
    System.out.println("=========================================================================================");
    this.cameraList.forEach((Camera c) -> {
      if (c.getStatus().equals("Available")) {
        System.out.printf(
                "%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t%s\n",
                c.getId(), c.getBrand(), c.getModel(), c.getPrice(), c.getStatus()
        );
      }
    });
    System.out.println("=========================================================================================");
    System.out.print("RENT CAMERA ID: ");
    int id = Integer.parseInt(this.scanner.nextLine());
    for (int i = 0; i < this.cameraList.size(); ++i) {
      Camera c = this.cameraList.get(i);
      if (id == c.getId()) {
        double t = this.user.getWallet().getBalance() - c.getPrice();
        if (t > 0) {
          c.setStatus("Rented");
          this.user.getWallet().setBalance(t);
          System.out.println("\nTRANSACTION SUCCESSFUL!!\n");
        } else {
          System.out.println("\nTRANSACTION FAILED!! INSUFFICIENT BALANCE!!\n");
          return;
        }
      }
    }
    System.out.printf("\nCAMERA WITH ID %d WAS NOT FOUND!!\n", id);
  }

  private void walletMenu() {
    System.out.printf("\nCURRENT WALLET BALANCE: %f\n", this.user.getWallet().getBalance());
    System.out.println("DO YOU WANT TO DEPOSIT:");
    System.out.println("1. YES");
    System.out.println("2. NO");
    int option = Integer.parseInt(this.scanner.nextLine());
    if (option == 1) {
      System.out.print("\nDEPOSIT AMOUNT: ");
      double amount = Double.parseDouble(this.scanner.nextLine());
      if (amount > 0.0) {
        Wallet w = this.user.getWallet();
        w.setBalance(w.getBalance() + amount);
        System.out.println("\nAMOUNT DEPOSITED!!\n");
        this.walletMenu();
      } else {
        System.out.println("\nINVALID AMOUNT!!\n");
        this.walletMenu();
      }
    }
  }

  private void mainMenu() {
    System.out.println("\n1. MY CAMERA");
    System.out.println("2. RENT A CAMERA");
    System.out.println("3. VIEW ALL CAMERA");
    System.out.println("4. MY WALLET");
    System.out.println("5. EXIT");
    int option = Integer.parseInt(this.scanner.nextLine());
    switch (option) {
      case 1 -> this.myCameraMenu();
      case 2 -> {
        this.rentCameraMenu();
        this.mainMenu();
      }
      case 3 -> {
        this.listAllCameras();
        this.mainMenu();
      }
      case 4 -> {
        this.walletMenu();
        this.mainMenu();
      }
      case 5 -> System.out.println("\nBYE!!");
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
