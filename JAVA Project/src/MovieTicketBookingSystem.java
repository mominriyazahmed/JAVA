import java.util.*;

abstract class Ticket{

    public String ticketId;
    public String personName;
    public double ticketPrice;
    
    public Ticket(String ticketId, String passengerName, double ticketPrice) {
        this.ticketId = ticketId;
        this.personName = personName;
        this.ticketPrice = ticketPrice;
    }
    abstract void displayTicketDetails();
}

class MovieTicket extends Ticket{

    public String movieNumber;
    public String movieName;
    public String screenNumber;
    public MovieTicket(String ticketId, String parsonName, double ticketPrice, String movieNumber,
        String movieName, String screenNumber) {
        super(ticketId, parsonName, ticketPrice);
        this.movieNumber = movieNumber;
        this.movieName = movieName;
        this.screenNumber = screenNumber;
    }
    


    void displayTicketDetails(){
        System.out.println("Ticket Id : " +this.ticketId);
        System.out.println("Passenger Name : " + this.personName);
        System.out.println("Ticket Price : " + this.ticketPrice);
        System.out.println("Flight Number : " + this.movieName);
        System.out.println("Airline Name : " + this.movieNumber);
        System.out.println("Depature Airport : " + this.screenNumber);
    }
}

interface TicketBooking {

    void bookTicket();
    void displayTicket();
    
}

class TicketBookingImpl implements TicketBooking{
    public Ticket [] tickets = new Ticket[2];
    public int ticketCount=0;

    public void displayTicket() {
        int c = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Ticket Id : ");
        String ticket = sc.nextLine();
        for (int i = 0; i < ticketCount; i++) {
            if(ticket.equals(tickets[i].ticketId)){
                tickets[i].displayTicketDetails();
                c++;
            }
            if(c!=1){
                try {
                    throw new TicketNotFoundException("Ticket Not Found");
                } catch (TicketNotFoundException t) {
                    System.out.println(t);
                }
            }
        }        
    }

    public void bookTicket(){
        Scanner sc = new Scanner(System.in);
        // for (int i = 0; i < tickets.length; i++) {
            
            System.out.println("Welcome To R & K Ticket Booking");
            System.out.print("Enter Number Of Tickets : ");
            int count = sc.nextInt();
            if(count > 2 && ticketCount>= 2){
                    try {
                        throw new MaximumTicketReachedException("Not More Than 2 Allowed");
                }
                catch (MaximumTicketReachedException m) {
                    System.out.println(m);
                    return;
                }
            }
            else{
                System.out.println("1.Flight");
                System.out.println("2.Train");
                sc.nextLine();
                System.out.print("Enter Your Choice : ");
                int Choice = sc.nextInt();
                switch (Choice) {
                    case 1:
                    sc.nextLine();
                    System.out.print("Enter Ticket Id : " );
                    String ticketId = sc.nextLine();
                    System.out.print("Enter Passenger Name : ");
                    String passengerName = sc.nextLine();
                    System.out.print("Enter Flight Number : ");
                    String flightNumber = sc.nextLine();
                    System.out.print("Enter Airline Name : ");
                    String airlineName = sc.nextLine();
                    System.out.print("Enter Depature Airport : ");
                    String depatureAirport = sc.nextLine();
                    System.out.print("Enter Destination Airport : ");
                    String destinationAirport = sc.nextLine();
                    System.out.print("Enter Ticket Price : ");
                    double ticketPrice = sc.nextDouble();
                    tickets[0] = new FlightTicket(ticketId, passengerName, ticketPrice, flightNumber, airlineName, depatureAirport, destinationAirport);
                    ticketCount+=1;
                    break;
                    
                    case 2:
                    System.out.print("Enter Ticket Id : " );
                    String ticketId1 = sc.nextLine();
                    System.out.print("Enter Passenger Name : ");
                    String passengerName1 = sc.nextLine();
                    System.out.print("Enter Train Number : ");
                    String trainNumber = sc.nextLine();
                    System.out.print("Enter Depature Station : ");
                    String depatureStation = sc.nextLine();
                    System.out.print("Enter Destination Station : ");
                    String destinationStation = sc.nextLine();
                    System.out.print("Enter Seat Number : ");
                    int seatNumber = sc.nextInt();
                    System.out.print("Enter Ticket Price : ");
                    double ticketPrice1 = sc.nextDouble();
                    tickets[1] = new TrainTicket(ticketId1, passengerName1, ticketPrice1, trainNumber, depatureStation, destinationStation, seatNumber);
                    ticketCount+=1;
                    break;
                    
                    default:
                    try {
                        throw new InputMismatchException("Entered Choice is Not Valid");
                    } catch (InputMismatchException e) {
                        System.out.println("Entered Choice is Not Valid");
                    }
                    break;
                    // }
                }
            }
        }
        
    }

public class MovieTicketBookingSystem {

}
