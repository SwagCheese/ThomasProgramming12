package com.thomas.module_3.assignment_2;

import java.util.ArrayList;

/**
 * Class that takes in an ArrayList and sorts the players by various criteria
 * using a mergesort.
 */
@SuppressWarnings("all")
public class PlayerSorter {
    //The following fields are the different sort types:
    public static final int GAMESPLAYED = 0;
    public static final int ATBATS = 1;
    public static final int RUNS = 2;
    public static final int PERCENTRUNS = 3; // Calculated by: runs/atBats
    public static final int PERCENTONBASE = 4; // Calculated by (hits + doubles + triples) / atBats

    /**
     * This method is an interface that allows the sorting of a player given based on
     * certain criteria.  There are 5 options to sort a player which are by Games played,
     * at bats, runs, percent runs, percent on base.
     * The sort is in descending order (Largest to smallest)
     * This method calls one of 5 private methods that will do the sort based on the chosen criteria.
     * @param list List of players containing the statistics
     * @param sortType How the user wants the players sorted.  The value should be chosen from one of
     *                 the 5 static fields from the class.
     * @return A List that is sorted according to the user's specification.
     */
    public static ArrayList<PlayerBattingStats> sort(ArrayList<PlayerBattingStats> list, int sortType) {
        // If the size of the list is 1 or less, return the list (base case)
        if (list.size() <= 1) return list;

        // Calculate the midpoint index of the list
        int midpoint = list.size() / 2;

        // Split the list into two sublists using the midpoint
        ArrayList<PlayerBattingStats> left = new ArrayList<>(list.subList(0, midpoint));
        ArrayList<PlayerBattingStats> right = new ArrayList<>(list.subList(midpoint, list.size()));

        // Recursively sort the left and right sublists using the same sorting type
        left = sort(left, sortType);
        right = sort(right, sortType);

        // Merge the sorted left and right sublists and return the result
        return merge(left, right, sortType);
    }

    /**
     Merges two ArrayLists of PlayerBattingStats objects, and returns the result as a new ArrayList.

     @param left the first ArrayList of PlayerBattingStats to be merged.
     @param right the second ArrayList of PlayerBattingStats to be merged.
     @param sortType an integer indicating which field to use for sorting the merged array. 1 for games played, 2 for at bats, 3 for runs scored, 4 for percentage of runs scored per at bat, and 5 for percentage of times on base per at bat.
     @return the merged ArrayList of PlayerBattingStats objects.
     */
    private static ArrayList<PlayerBattingStats> merge(ArrayList<PlayerBattingStats> left, ArrayList<PlayerBattingStats> right, int sortType) {
        // Create a new ArrayList to store the merged result.
        ArrayList<PlayerBattingStats> merged = new ArrayList<>(left.size() + right.size());

        // Initialize pointers to the beginning of both input ArrayLists.
        int leftPointer, rightPointer;
        leftPointer = rightPointer = 0;

        // Continue looping while there are still elements in at least one of the input ArrayLists.
        while(leftPointer < left.size() || rightPointer < right.size()) {

            // If there are elements in both input ArrayLists, compare them based on the specified sorting type.
            if(leftPointer < left.size() && rightPointer < right.size()) {
                int compared = 0;
                switch (sortType) {
                    case 1 -> compared = compareGamesPlayed(left.get(leftPointer), right.get(rightPointer));
                    case 2 -> compared = compareAtBats(left.get(leftPointer), right.get(rightPointer));
                    case 3 -> compared = compareRuns(left.get(leftPointer), right.get(rightPointer));
                    case 4 -> compared = comparePercentRuns(left.get(leftPointer), right.get(rightPointer));
                    case 5 -> compared = comparePercentOnBase(left.get(leftPointer), right.get(rightPointer));
                }

                // Add the lower element to the merged result ArrayList and increment the appropriate pointer.
                if (compared > 0) {
                    merged.add(left.get(leftPointer++));
                } else {
                    merged.add(right.get(rightPointer++));
                }
            } else if(leftPointer < left.size()) {
                // Add the remaining elements from the left input ArrayList to the merged result ArrayList.
                merged.add(left.get(leftPointer++));
            } else {
                // Add the remaining elements from the right input ArrayList to the merged result ArrayList.
                merged.add(right.get(rightPointer++));
            }

        }

        // Return the merged result ArrayList.
        return merged;
    }

    /**
     Compares two PlayerBattingStats objects based on the number of games played.

     @param left the first PlayerBattingStats object to compare.
     @param right the second PlayerBattingStats object to compare.
     @return an integer indicating the order of the two input objects based on the number of games played.
     */
    private static int compareGamesPlayed(PlayerBattingStats left, PlayerBattingStats right) {
        return Integer.compare(left.getGames(), right.getGames());
    }

    /**
     Compares two PlayerBattingStats objects based on the number of at bats.

     @param left the first PlayerBattingStats object to compare.
     @param right the second PlayerBattingStats object to compare.
     @return an integer indicating the order of the two input objects based on the number of at bats.
     */
    private static int compareAtBats(PlayerBattingStats left, PlayerBattingStats right) {
        return Integer.compare(left.getAtBats(), right.getAtBats());
    }

    /**
     Compares two PlayerBattingStats objects based on the total number of runs scored.

     @param left the first PlayerBattingStats object to compare.
     @param right the second PlayerBattingStats object to compare.
     @return an integer indicating the order of the two input objects based on the total number of runs scored.
     */
    private static int compareRuns(PlayerBattingStats left, PlayerBattingStats right) {
        return Integer.compare(left.getRuns(), right.getRuns());
    }

    /**
     Compares two PlayerBattingStats objects based on the percentage of runs scored out of the total at-bats.

     @param left the first PlayerBattingStats object to compare.
     @param right the second PlayerBattingStats object to compare.
     @return an integer indicating the order of the two input objects based on the percentage of runs scored out of the total at-bats.
     */
    private static int comparePercentRuns(PlayerBattingStats left, PlayerBattingStats right) {
        double percentRunsLeft = (double) left.getRuns() / left.getAtBats();
        double percentRunsRight = (double) right.getRuns() / right.getAtBats();

        return Double.compare(percentRunsLeft, percentRunsRight);
    }

    /**
     Compares two PlayerBattingStats objects based on the percentage of times they reach base by hitting a single, double, or triple, out of their total at-bats.

     @param left the first PlayerBattingStats object to compare.
     @param right the second PlayerBattingStats object to compare.
     @return an integer indicating the order of the two input objects based on the percentage of times they reach base by hitting a single, double, or triple, out of their total at-bats.
     */
    private static int comparePercentOnBase(PlayerBattingStats left, PlayerBattingStats right) {
        double percentOnBaseLeft = (double) (left.getHits() + left.getDoubles() + left.getTriples()) / left.getAtBats();
        double percentOnBaseRight = (double) (right.getHits() + right.getDoubles() + right.getTriples()) / right.getAtBats();

        return Double.compare(percentOnBaseLeft, percentOnBaseRight);
    }
}