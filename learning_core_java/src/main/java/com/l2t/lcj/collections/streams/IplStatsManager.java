package com.l2t.lcj.collections.streams;

import java.util.Scanner;

public class IplStatsManager {

    public static void main(String[] args) {

        IplStatsService iplStatsService = null;

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== IPL Stats Menu ===");
            System.out.println("1. Show all team names");
            System.out.println("2. Show ipl stats");
            System.out.println("3. Get max paid players by team");
            System.out.println("4. Get max paid players by role for team");
            System.out.println("5. Get all players by team");
            System.out.println("6. Get team stats");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Team Names: " + iplStatsService.getTeamNames());
                    break;
                case 2:
                    IplStatsDto stats = iplStatsService.getTeamAmountStats();
                    System.out.println("Team Amount Stats: " + stats.getTeamAmount());
                    System.out.println("Team Player Count: " + stats.getTeamPlayerCount());
                    System.out.println("Role Player Count: " + stats.getRolePlayerCount());
                    break;
                case 3:
                    System.out.print("Enter team name: ");
                    String team1 = scanner.nextLine();
                    System.out.println("Max Paid Players: " + iplStatsService.getMaxPaidPlayers(team1));
                    break;
                case 4:
                    System.out.print("Enter team name: ");
                    String team2 = scanner.nextLine();
                    System.out.println("Max Paid Players by Role: " + iplStatsService.getMaxPaidPlayersOfEachRole(team2));
                    break;
                case 5:
                    System.out.print("Enter team name: ");
                    String team3 = scanner.nextLine();
                    System.out.println("All Players: " + iplStatsService.getAllPlayers(team3));
                    break;
                case 6:
                    System.out.print("Enter team name: ");
                    String team4 = scanner.nextLine();
                    System.out.println("Team Stats: " + iplStatsService.getTeamStats(team4));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();

    }
}
