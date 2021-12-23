package monitoringsystemforvehiclerenting;


import java.util.Scanner;

public class Vehicles{

Vehicle theVehicle[] = new Vehicle[50];    
public static int count;    

Scanner input = new Scanner(System.in);




public int compareObjects(Vehicle v1, Vehicle v2){

    if (v1.vName.equalsIgnoreCase(v2.vName)){

        System.out.println("the Vehicle name already exist");
        return 0;

    }
    if (v1.year==v2.year){

        System.out.println("The manufactured year already existed.");
        return 0;
    }
    return 1;
}

public void addVehicle(Vehicle v){

    for (int i=0; i<count; i++){

        if (this.compareObjects(v, this.theVehicle[i]) == 0)
            return;

    }

    if (count<50){

        theVehicle[count] = v;
        count++;

    }
    else{

        System.out.println("No more space to add more vehicle .");

    }

}

public void searchByYear(){

    System.out.println("\t\t\t\tSEARCH BY MANUFACTURAL YEAR\n");

    int year;
    System.out.println("Enter year of Vehicle:");
    year = input.nextInt();

    int flag = 0;
    System.out.println("year\t\tV.Type\t\tV.Name\t");
    for (int i=0; i<count; i++){

        if (year == theVehicle[i].year){

            System.out.println(theVehicle[i].year + "\t\t" +theVehicle[i].vType + "\t\t" + theVehicle[i].vName);
            flag++;
            return;

        }

    }
    if (flag == 0)
        System.out.println("No vehicle manufactured in " + year + " Found.");

}

public void searchByType(){

    System.out.println("\t\t\t\tSEARCH BY TYPE");
    input.nextLine();
    System.out.println("Enter Vehicle Type:");
    String vType = input.nextLine();
    int flag = 0;
    System.out.println("year\t\tV.Name\t\tV.Type\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        if (vType.equalsIgnoreCase(theVehicle[i].vType)){

            System.out.println(theVehicle[i].year + "\t\t" + theVehicle[i].vName + "\t\t" + theVehicle[i].vType + "\t\t" + 
                theVehicle[i].bookQtyCopy + "\t\t" + theVehicle[i].vQty);
            flag++;
        }

    }
    if (flag == 0)
        System.out.println("No vehicle with type of " + vType + " Found.");

}


public void showAllVehicle(){

    System.out.println("\t\t\t\tSHOWING ALL VEHICLE\n");
    System.out.println("year\t\tVName\t\tVType\t\tAvailable Qty\t\tTotal Qty");

    for (int i=0; i<count; i++){

        System.out.println(theVehicle[i].year + "\t\t" + theVehicle[i].vName + "\t\t" + theVehicle[i].vType + "\t\t" + 
               theVehicle[i].bookQtyCopy + "\t\t" + theVehicle[i].vQty);
        
    }

}

public void upgradeVehicleQty(){

    System.out.println("\t\t\t\tUPGRADE QUANTITY OF A VEHICLE\n");
    System.out.println("Enter Name of Vehicle");
    int plateNum = input.nextInt();
    for (int i=0; i<count; i++){

        if (plateNum == theVehicle[i].year){

            System.out.println("Enter No of vehicle to be Added:");
            int addingQty = input.nextInt();
            theVehicle[i].vQty += addingQty;
           theVehicle[i].bookQtyCopy += addingQty;
            return;

        }

    }

}


public void dispMenu(){

    System.out.println("----------------------------------------------------------------------------------------------------------");
    System.out.println("Enter 0 to Exit Application.");
    System.out.println("Enter 1 to Add new Vehicle.");
    System.out.println("Enter 2 to Upgrade Quantity of a Vehicle.");
    System.out.println("Enter 3 to Search a Vehicle.");
    System.out.println("Enter 4 to Show All Vehicle.");
    System.out.println("Enter 5 to Register Customer.");
    System.out.println("Enter 6 to Show All Registered Customer.");
    System.out.println("Enter 7 to Check Out Vehicle. ");
    System.out.println("Enter 8 to Check In Vehicle");
    System.out.println("----------------------------------------------------------------------------------------------------------");

}

public int isAvailable(int year){



    for (int i=0; i<count; i++){

        if (year == theVehicle[i].year){
            if(theVehicle[i].bookQtyCopy > 0){

                System.out.println("Vehicle is Available.");
                return i;

            }
            System.out.println("Vehicle is Unavailable");
            return -1;

        }

    }

    System.out.println("No Vehilce of plate Number " + year + " Available in Library.");
    return -1;


}

public Vehicle checkOutVehicle(){

    System.out.println("Enter year of Vehilce to be Checked Out.");
    int plateNum = input.nextInt();

    int vIndex =isAvailable(plateNum);

    if (vIndex!=-1){

      
       theVehicle[vIndex].bookQtyCopy--;

        return theVehicle[vIndex];
    }

    return null;

}

public void checkInVehicle(Vehicle b){

    for (int i=0; i<count; i++){

        if (b.equals(theVehicle[i]) ){

            theVehicle[i].bookQtyCopy++;
            return;

        }

    }

}







 }
    
