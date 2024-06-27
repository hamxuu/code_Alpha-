import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;
    double price;

    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
        this.price = price;
    }
}

class Reservation {
    String guestName;
    Room room;
    int nights;
    double totalCost;

    Reservation(String guestName, Room room, int nights) {
        this.guestName = guestName;
        this.room = room;
        this.nights = nights;
        this.totalCost = room.price * nights;
    }

    void viewDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Number: " + room.roomNumber);
        System.out.println("Category: " + room.category);
        System.out.println("Nights: " + nights);
        System.out.println("Total Cost: $" + totalCost);
    }
}

public class hotel_reservation_system {
    static List<Room> rooms = new ArrayList<>();
    static List<Reservation> reservations = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to Hotel Reservation System");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            System.out.println();
        }
    }

    static void initializeRooms() {
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Single", 100.0));
        rooms.add(new Room(201, "Double", 150.0));
        rooms.add(new Room(202, "Double", 150.0));
        rooms.add(new Room(301, "Suite", 300.0));
    }

    static void searchRooms() {
        System.out.print("Enter room category (Single/Double/Suite): ");
        String category = scanner.nextLine();
        System.out.println("Available " + category + " rooms:");

        for (Room room : rooms) {
            if (room.isAvailable && room.category.equalsIgnoreCase(category)) {
                System.out.println("Room Number: " + room.roomNumber + ", Price: $" + room.price);
            }
        }
    }

    static void makeReservation() {
        System.out.print("Enter room number to reserve: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Room selectedRoom = null;

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Room is not available or does not exist.");
            return;
        }

        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter number of nights: ");
        int nights = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Reservation reservation = new Reservation(guestName, selectedRoom, nights);
        reservations.add(reservation);
        selectedRoom.isAvailable = false;

        System.out.println("Reservation successful! Total cost: $" + reservation.totalCost);
    }

    static void viewBookingDetails() {
        System.out.print("Enter guest name to view booking details: ");
        String guestName = scanner.nextLine();

        for (Reservation reservation : reservations) {
            if (reservation.guestName.equalsIgnoreCase(guestName)) {
                reservation.viewDetails();
                return;
            }
        }

        System.out.println("No booking found for the given guest name.");
    }
}