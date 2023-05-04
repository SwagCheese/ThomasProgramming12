package com.thomas.module_2.assignment_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

// This class represents a program that reads a text file and extracts unique words from it, ignoring any disallowed characters.
@SuppressWarnings({"SpellCheckingInspection", "GrazieInspection"})
public class Word {
    public static void main(String[] args) {
        try {
            // Get the file "illiad.txt" from the same directory as the Word class.
            File file = new File(Objects.requireNonNull(Word.class.getResource("illiad.txt")).toURI());


            // Create a new scanner to read the contents of the file.
            Scanner scanner = new Scanner(file);

            // Create a set to store unique words.
            Set<String> words = new HashSet<>();

            // Define a regular expression that matches any character that is not a letter, apostrophe or hyphen.
            String disallowedCharacters = "[^A-z'-]";

            // Loop through each word in the file.
            while (scanner.hasNext()) {
                // Read the next word and remove any disallowed characters.
                // Convert the word to lowercase to ensure all identical words are treated as the same.
                String word = scanner.next().replaceAll(disallowedCharacters, "").toLowerCase();

                /*
                 If the word ends with a hyphen, remove it.
                 This is because some words in the text, such as on line 50 "the tenth day Achilles called them in assembly- moved thereto by Juno,", seem to end with a hyphen unnecissaraly
                */
                if (word.endsWith("-")) {
                    word = word.substring(0, word.length()-1);
                }

                // Add the cleaned word to the set of unique words.
                words.add(word);
            }

            // Print out the total number of unique words found in the file.
            System.out.println("Total number of unique words: " + words.size());
        } catch (FileNotFoundException | URISyntaxException e) {
            // If there is an error reading the file, print an error message.
            System.out.println("An error occurred while reading the file.");
        }
    }
}