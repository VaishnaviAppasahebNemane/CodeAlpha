package com.mycompany.codealpha;

import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String roomType; 
    boolean isAvailable;

    Room(int roomNumber, String roomType, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Type: " + roomType + ", Available: " + isAvailable;
    }
}

public class HotelReservationSystem 
{
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeRooms(); 

        System.out.println("Welcome to the Hotel Reservation System!");
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View All Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    
    public static void initializeRooms() {
        rooms.add(new Room(101, "Single", true));
        rooms.add(new Room(102, "Single", true));
        rooms.add(new Room(201, "Double", true));
        rooms.add(new Room(202, "Double", true));
        rooms.add(new Room(301, "Suite", true));
        rooms.add(new Room(302, "Suite", true));
    }

    
    public static void searchRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room);
            }
        }
    }

    
    public static void makeReservation(Scanner scanner) {
        System.out.print("Enter the room number to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                if (room.isAvailable) {
                    room.isAvailable = false;
                    System.out.println("Room " + roomNumber + " has been successfully booked!");
                    return;
                } else {
                    System.out.println("Room " + roomNumber + " is already booked.");
                    return;
                }
            }
        }
        System.out.println("Room " + roomNumber + " not found.");
    }
    public static void viewBookings() {
        System.out.println("\nRoom Bookings:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
    }
