package com.mycompany.codealpha;

import java.util.ArrayList;
import java.util.Scanner;

class Destination 
{
    String name;
    String date;
    double budget;

    Destination(String name, String date, double budget) {
        this.name = name;
        this.date = date;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date + ", Budget: $" + budget;
    }
}

public class TravelItineraryPlanner 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();

        System.out.println("Welcome to the Travel Itinerary Planner!");
        boolean addMore = true;

       
        while (addMore) {
            System.out.print("Enter destination: ");
            String destination = scanner.nextLine();

            System.out.print("Enter travel date (e.g., 2025-02-15): ");
            String date = scanner.nextLine();

            System.out.print("Enter estimated budget for this destination: $");
            double budget = scanner.nextDouble();
            scanner.nextLine(); 

            itinerary.add(new Destination(destination, date, budget));

            System.out.print("Do you want to add another destination? (yes/no): ");
            String response = scanner.nextLine();
            addMore = response.equalsIgnoreCase("yes");
        }

       
        System.out.println("\nYour Travel Itinerary:");
        double totalBudget = 0;
        for (Destination dest : itinerary) {
            System.out.println(dest);
            totalBudget += dest.budget;
        }

        System.out.println("\nTotal Budget: $" + totalBudget);

        scanner.close();
    }
}
