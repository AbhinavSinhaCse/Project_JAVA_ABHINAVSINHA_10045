class Passenger {
    private String name;
    private int id;

    public Passenger(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
}

class Flight {
    private final int MAX_SEATS;
    private Passenger[] seats;

    public Flight(int capacity) {
        this.MAX_SEATS = capacity;
        this.seats = new Passenger[MAX_SEATS];
        System.out.println("Flight Created with " + MAX_SEATS + " seats.");
    }

    public boolean bookSeat(Passenger p) {
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = p;
                System.out.println("Passenger " + p.getName() + " booked successfully.");
                return true;
            }
        }
        System.out.println("Flight Full! Booking failed for: " + p.getName());
        return false;
    }

    public void displayStatus() {
        System.out.println("\nSeat Status:");
        for (int i = 0; i < MAX_SEATS; i++) {
            String status = (seats[i] == null) ? "Empty" : seats[i].getName();
            System.out.println("Seat " + (i + 1) + ": " + status);
        }
    }
}

public class FlightReservationSystem {
    public static void main(String[] args) {
        Flight f = new Flight(5);

        f.bookSeat(new Passenger("Aman", 101));
        f.bookSeat(new Passenger("Rahul", 102));
        
        f.displayStatus();
        
        f.bookSeat(new Passenger("Riya", 103));
        f.bookSeat(new Passenger("Test1", 104));
        f.bookSeat(new Passenger("Test2", 105));
        f.bookSeat(new Passenger("Overflow", 106));
    }
}