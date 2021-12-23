
package monitoringsystemforvehiclerenting;


 
import java.util.Scanner;    
public class Customer {

String custName;
String regNum;

Vehicle rentedVehicle[] = new Vehicle[3];
public int vCount = 0;

Scanner input = new Scanner(System.in);

public Customer(){

    System.out.println("Enter Customer Name:");
    this.custName = input.nextLine();

    System.out.println("Enter Reg Number:");
    this.regNum = input.nextLine();

}
}
