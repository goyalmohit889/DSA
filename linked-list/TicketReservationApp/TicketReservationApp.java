import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservation {
    Ticket head = null, tail = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        System.out.println("Ticket booked successfully.");
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to cancel.");
            return;
        }

        Ticket current = head, prev = tail;
        do {
            if (current.ticketId == ticketId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Ticket cancelled successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Ticket ID not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String name) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(name) || current.movieName.equalsIgnoreCase(name)) {
                System.out.println("Ticket Found: ID: " + current.ticketId + ", Movie: " + current.movieName);
            }
            current = current.next;
        } while (current != head);
    }

    public void totalTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        System.out.println("Total Tickets: " + count);
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservation reservation = new TicketReservation();

        while (true) {
            System.out.println("\n1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Name/Movie");
            System.out.println("5. Total Booked Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String bookingTime = scanner.nextLine();
                    reservation.addTicket(ticketId, customerName, movieName, seatNumber, bookingTime);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    ticketId = scanner.nextInt();
                    reservation.removeTicket(ticketId);
                    break;
                case 3:
                    reservation.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name: ");
                    scanner.nextLine();
                    String search = scanner.nextLine();
                    reservation.searchTicket(search);
                    break;
                case 5:
                    reservation.totalTickets();
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
