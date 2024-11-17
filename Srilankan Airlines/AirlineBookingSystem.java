import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;

public class AirlineBookingSystem {
    static String arrival;
    static String depart;
    static int passWord;
    static String accountNumber;
    static String userName;
    static int numberOfPersons;
    static String airClass;
    static String bookingID;
    static String plane;
    static String name;
    static String idNo;
    static String bookingHistory;
    static String status;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        boolean exit = false;
        Receipt receipts = new Receipt();
       

        while (!exit) {
            System.out.println("\n------------- SriLankan Airlines -------------");
            System.out.println("\n\t\tNotice! ");
            System.out.println("SriLankan airlines flight only for the following countries until 2025.01.01");
            System.out.println("* Dubai");
            System.out.println("* Australia");
            System.out.println("* Canada");
            System.out.println();

            System.out.println("1. Register for the system");
            System.out.println("2. Pickup an airbus");
            System.out.println("3. Airline rates");
            System.out.println("4. Contact info");
            System.out.println("5. Booking History");
            System.out.println("6. Exit");
            System.out.println("\n----------------------------------------------");

            System.out.print("\nChoose an option: ");
            int option = reader.nextInt();
            reader.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter a username: ");
                    String usersName = reader.nextLine();
                    if (usersName.equals(userName)) {
                        System.out.println("Username already exists. Create a different username.");
                    } else {
                        userName = usersName;

                        System.out.print("Enter 4 digit password: ");
                        int password = reader.nextInt();
                        if (password == passWord) {
                            System.out.println("Password already exists. Create a different password.");
                        } else {
                            passWord = password;
                            System.out.println("Account created successfully!");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your username: ");
                    String loginUserName = reader.nextLine();
                    System.out.print("Enter your password: ");
                    int loginPassword = reader.nextInt();
                    reader.nextLine();  // Consume newline

                    if (loginUserName.equals(userName) && loginPassword == passWord) {
                        System.out.print("Enter Full Name: ");
                        name = reader.nextLine();

                        System.out.print("Enter NIC No: ");
                        idNo = reader.nextLine();

                        System.out.print("Enter Arrival Country: ");
                        arrival = reader.nextLine();

                        System.out.print("Enter Departure Country: ");
                        depart = reader.nextLine();

                        System.out.print("Enter number of persons(max:75): ");
                        numberOfPersons = reader.nextInt();
                        reader.nextLine(); 
                        if(numberOfPersons > 75){
                            System.out.println("Maximum number of persons exceed!");
                        }

                        System.out.print("Enter the class (Business/Local): ");
                        airClass = reader.nextLine();

                        //receipt generator
                        receipts.name = name;
                        receipts.idNo = idNo;
                        receipts.arrival = arrival;
                        receipts.depart = depart;
                        receipts.numberOfPersons = numberOfPersons;
                        receipts.airClass = airClass;
                        receipts.printReceipt();

                        //Booking confirming generator
                        boolean Confirm = false;
                        while(!Confirm){
                            System.out.print("\n\nConfirm the receipt(y/n): ");
                            String confirming = reader.nextLine();

                            if(confirming.equals("y")){
                                System.out.println("Booking Confirmed...");
                                status = "Active";
                                Confirm = true;
                            }
                            else{
                                System.out.println("Booking Cancelled...");
                                status = "Declined";
                                break;
                            }
                        }
                    } 
                    else {
                        System.out.println("Invalid username or password.Check your details again.");
                    }
                    break;

                case 3:
                    System.out.println("\nAirline rates per person...");
                    System.out.println("Sri Lanka - Dubai (Business class) : $1250");
                    System.out.println("Sri Lanka - Dubai (Local class) : $950");
                    System.out.println("Sri Lanka - Australia (Business class) : $1550");
                    System.out.println("Sri Lanka - Australia (Local class) : $1150");
                    System.out.println("Sri Lanka - Canada (Business class) : $2250");
                    System.out.println("Sri Lanka - Canada (Local class) : $1250");
                    break;

                case 4:
                    System.out.println("For more information visit www.srilankanairlines.com");
                    break;

                case 5:
                    System.out.println("Your Bookings..."); 
                    receipts.printReceipt();
                    if(status.equals("Active")){
                        System.out.println("\nStatus: Active");
                    } else {
                        System.out.println("\nStatus: Declined");
                    }
                    System.out.println("-------------------------------------------");
                    break;

                case 6:
                    System.out.println("Goodbye. Have a nice journey!");
                    exit = true;
                    break;
                  
                default:
                    System.out.println("Enter a valid number...");
            }
        }
        reader.close();
    }
}
