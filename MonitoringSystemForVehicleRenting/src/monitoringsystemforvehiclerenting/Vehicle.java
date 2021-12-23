package monitoringsystemforvehiclerenting;


import java.util.Scanner;



public class Vehicle {

public int year;
public String vName;
public String vType;
public int vQty;
public int bookQtyCopy;

Scanner input = new Scanner(System.in);

public Vehicle(){

    System.out.println("Enter manufacture year of the vehicle :");
    this.year = input.nextInt();
    input.nextLine();
    System.out.println("Enter vehicle type :");
    this.vType = input.nextLine();
    System.out.println("Enter vehicle name :");
    this.vName = input.nextLine();
    System.out.println("Enter Quantity of Vehicle:");
    this.vQty = input.nextInt();
    bookQtyCopy = this.vQty;

}

}