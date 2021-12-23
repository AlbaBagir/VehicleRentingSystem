package monitoringsystemforvehiclerenting;
import java.util.Scanner;


public class Customers {

Scanner input = new Scanner(System.in);

Customer theCustomers[] = new Customer[50];




public static int count = 0;

public void addCustomer(Customer c){

    for (int i=0; i<count; i++){

        if(c.regNum.equalsIgnoreCase(theCustomers[i].regNum)){

            System.out.println("Customer of Reg Num " + c.regNum + " is Already Registered.");
            return;
        }

    }

    if (count<=50){

        theCustomers[count] = c;
        count++;

    }

}

public void showAllCustomer(){

    System.out.println("Customer Name\t\tReg Number");
  
    for (int i=0; i<count; i++){

        System.out.println(theCustomers[i].custName + "\t\t" + theCustomers[i].regNum);

    }


}

public int isCustomers(){
 

    System.out.println("Enter Reg Number:");
    String regNum = input.nextLine();

    for (int i=0; i<count; i++){

        if (theCustomers[i].regNum.equalsIgnoreCase(regNum)){

            return i;

        }

    }
    System.out.println("Customer is not Registered.");
    System.out.println("Get Registered First.");


    return -1;

}
public void checkOutVehicle(Vehicles Vehicle){
    int custIndex =this.isCustomers();

    if (custIndex!=-1){
        System.out.println("checking out");

        Vehicle.showAllVehicle();
        Vehicle b = Vehicle.checkOutVehicle();
        System.out.println("checking out");
        if (b!= null){

            if (theCustomers[custIndex].vCount<=3){
                System.out.println("adding book");
                theCustomers[custIndex].rentedVehicle[theCustomers[custIndex].vCount] = b;
                theCustomers[custIndex].vCount++;
                return;

            }
            else {

                System.out.println("Customer Can not rent more than 3 Vehicle.");
                return;

            }
        }
        System.out.println("Vehicle is not Available.");
   
    }

}

public void checkInVehicle(Vehicles Vehicle){

    int custIndex = this.isCustomers();
    if (custIndex != -1){
        System.out.println("P.No\t\t\tVehicle Name\t\t\tVehicle Type");
        Customer s = theCustomers[custIndex];
        for (int i=0; i<s.vCount; i++){

            System.out.println(s.rentedVehicle[i].year+ "\t\t\t" + s.rentedVehicle[i].vType + "\t\t\t"+
                    s.rentedVehicle[i].vName);

        }
        System.out.println("Enter year of vehicle to be Checked In:");
        int year = input.nextInt();
        for (int i=0; i<s.vCount; i++){

            if (year == s.rentedVehicle[i].year){

                Vehicle.checkInVehicle(s.rentedVehicle[i]);
                s.rentedVehicle[i]=null;
                return;

            }


        }
        System.out.println("vehicle manufacrtured in "+year+"not Found");

    }



}


}