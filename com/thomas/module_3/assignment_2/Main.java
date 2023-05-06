package com.thomas.module_3.assignment_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

@SuppressWarnings("all")
public class Main {
    public static ArrayList<PlayerBattingStats> players;

    /**
     * Takes in a comma sperated values file and parses the data.  It takes the data and
     * creates a PlayerBattingStats object and adds it to the players list.  The CSV file
     * must be in the format of:
     * Name,Team,Gamesplayed,At bats, runs, hits, doubles, triples, home runs, rbi's
     * @param file containg the data
     */
    public static void parseCSVData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splitter = line.split(",");
            String name = splitter[0];
            String team = splitter[1];
            int gamesPlayed = Integer.parseInt(splitter[2]);
            int atBats = Integer.parseInt(splitter[3]);
            int runs = Integer.parseInt(splitter[4]);
            int hits = Integer.parseInt(splitter[5]);
            int doubles = Integer.parseInt(splitter[6]);
            int triples = Integer.parseInt(splitter[7]);
            int homeRunes = Integer.parseInt(splitter[8]);
            int rbis = Integer.parseInt(splitter[9]);
            players.add(new PlayerBattingStats(name, team, gamesPlayed, atBats, runs, hits, doubles, triples, homeRunes, rbis));
        }

    }

    public static void main(String[] args) {
        players = new ArrayList<>();
        try {
            parseCSVData(new File(Objects.requireNonNull(Main.class.getResource("PlayerData.csv")).toURI()));
        } catch (FileNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }

        // Print the unsorted list of players to the console
        System.out.println("UNSORTED: ");
        printPlayers();

        // Sort the list of players by number of games played and print to the console
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("SORTED BY GAMES PLAYED: ");
        players = PlayerSorter.sort(players, PlayerSorter.GAMESPLAYED);
        printPlayers();

        // Sort the list of players by number of at-bats and print to the console
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("SORTED BY AT BATS: ");
        players = PlayerSorter.sort(players, PlayerSorter.ATBATS);
        printPlayers();

        // Sort the list of players by number of runs scored and print to the console
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("SORTED BY RUNS: ");
        players = PlayerSorter.sort(players, PlayerSorter.RUNS);
        printPlayers();

        // Sort the list of players by percentage of runs scored and print to the console
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("SORTED BY PERCENT RUNS: ");
        players = PlayerSorter.sort(players, PlayerSorter.PERCENTRUNS);
        printPlayers();

        // Sort the list of players by percentage of times on base and print to the console
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("SORTED BY PERCENT ON BASE: ");
        players = PlayerSorter.sort(players, PlayerSorter.PERCENTONBASE);
        printPlayers();
    }

    /**
     Prints the list of players to the console
     */
    private static void printPlayers() {
        // Loop through each player in the "players" list and print their stats to the console
        for (PlayerBattingStats player : players) {
            System.out.println(player);
        }
    }

}