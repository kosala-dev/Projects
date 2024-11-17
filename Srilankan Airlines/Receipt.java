import java.time.LocalDate;
import java.time.LocalTime;

class Receipt {
    String arrival;
    String depart;
    int numberOfPersons;
    String airClass;
    String bookingID;
    String plane;
    int total;
    String name;
    String idNo;
    String airport;

    LocalDate today = LocalDate.now();
    LocalTime now = LocalTime.now().withNano(0);

    public String generatePlaneNumber() {
        if (arrival.equals("Dubai")) {
            plane = "SL-DU123";
        } else if (arrival.equals("Australia")) {
            plane = "SL-AU234";
        } else if (arrival.equals("Canada")) {
            plane = "SL-CA345";
        } else if (arrival.equals("Srilanka")) {
            plane = "SL-SL456";
        } else {
            plane = "No airline available";
        }
        return plane;
    }

    public String generateAirport(){
        if (depart.equals("Dubai")){
            airport = "Dubai International Airport";
        }
        else if ( depart.equals("Australia")){
            airport = "Melbourne International Airport";
        }
        else if ( depart.equals("Canada")){
            airport = "Toronto Pearson International Airport";
        }
        else if ( depart.equals("Srilanka")){
            airport = "Bandaranaike International Airport";
        }
        return airport;
    }

    public String generateBookingID() {
        bookingID = "SL-" + arrival + (int) (Math.random() * 100000);
        return bookingID;
    }

    public int calculateTotal() {
        int ratePerPerson = 0;
        switch (arrival) {
            case "Dubai":
                ratePerPerson = airClass.equals("Business") ? 1250 : 950;
                break;
            case "Australia":
                ratePerPerson = airClass.equals("Business") ? 1550 : 1150;
                break;
            case "Canada":
                ratePerPerson = airClass.equals("Business") ? 2250 : 1250;
                break;
            case "Srilanka":
                if (depart.equals("Dubai")) {
                    ratePerPerson = airClass.equals("Business") ? 1250 : 950;
                } else if (depart.equals("Australia")) {
                    ratePerPerson = airClass.equals("Business") ? 1550 : 1150;
                } else if (depart.equals("Canada")) {
                    ratePerPerson = airClass.equals("Business") ? 2250 : 1250;
                }
                break;
        }
        total = numberOfPersons * ratePerPerson;
        return total;
    }
    
    public void printReceipt() {
        System.out.println("\n--------------- Receipt -------------------");
        System.out.println("Full name: " + name);
        System.out.println("NIC No: " + idNo);
        System.out.println("Arrival Country: " + arrival);
        System.out.println("Departure Country: " + depart);
        System.out.println("No. of persons: " + numberOfPersons);
        System.out.println("Air class: " + airClass);
        System.out.println("Airport: " + generateAirport());
        System.out.println("Plane NO: " + generatePlaneNumber());
        System.out.println("Booking Order ID: " + generateBookingID());
        System.out.println("Booking Total $: " + calculateTotal());
        System.out.print("Flight time: " + today.plusDays(5) + " " + now.plusHours(2).plusMinutes(20).plusSeconds(35));
    }
}
