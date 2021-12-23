package monitoringsystemforvehiclerenting;
import java.util.Scanner;

        
        
public class MonitoringSystemForVehicleRenting {

        
    public static void main(String[] args) {
           Scanner input = new Scanner(System.in);

    System.out.println("********************Welcome to rent a ride!********************");
    System.out.println("              Please Select From The Following Options:               ");
    System.out.println("**********************************************************************");
    Vehicles ob = new Vehicles();
    Customers obCustomer = new Customers();
    int choice;
    int searchChoice;

    do{

        ob.dispMenu();
        choice = input.nextInt();

        switch(choice){

            case 1:
                Vehicle b = new Vehicle();
                ob.addVehicle(b);
                break;

            case 2:
                ob.upgradeVehicleQty();
                break;

            case 3:
                System.out.println("Enter 1 to Search with Serial No.");
                System.out.println("Enter 2 to Search with Author Name(Full Name).");
                searchChoice = input.nextInt();

                switch(searchChoice){

                    case 1:
                        ob.searchByYear();
                        break;
                    case 2:
                        ob.searchByType();

                }
                break;

            case 4:
                ob.showAllVehicle();
                break;
            case 5:
                Customer s = new Customer();
                obCustomer.addCustomer(s);
                break;
            case 6:
                obCustomer.showAllCustomer();
                break;
            case 7:
                obCustomer.checkOutVehicle(ob);
                break;
            case 8:
                obCustomer.checkInVehicle(ob);
                break;
            default:
                System.out.println("CHOICE SHOULD BE BETWEEN 0 TO 8.");

        }

    }
    while (choice!=0);
































}

}
    
    

