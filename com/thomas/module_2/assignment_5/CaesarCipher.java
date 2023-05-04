package com.thomas.module_2.assignment_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * This class provides a simple implementation of the Caesar cipher encryption and decryption algorithm.
 */
public class CaesarCipher {
    /**
     * A map that stores the encryption mappings between characters. The key is the original character and the value
     * is the encrypted character.
     */
    private final Map<Character, Character> encryptionMap = new HashMap<>(26);

    /**
     * A map that stores the decryption mappings between characters. The key is the encrypted character and the value
     * is the original character.
     */
    private final Map<Character, Character> decryptionMap = new HashMap<>(26);

    /**
     * A set that stores the words in the English language dictionary. This set is used to help crack the cipher.
     */
    private static Set<String> dictionary;

    /**
     * Creates a new instance of the CaesarCipher class with the specified offset.
     *
     * @param offset the number of characters by which to shift each letter for encryption and decryption.
     */
    public CaesarCipher(int offset) {
        // Initialize the encryption and decryption maps by shifting each letter by the specified offset.
        for (int i = 'a'; i < 'z' + 1; ++i) {
            encryptionMap.put((char) i, (char) ((char) (((i - 'a') + offset) % 26) + 'a'));
            decryptionMap.put((char) ((char) (((i - 'a') + offset) % 26) + 'a'), (char) i);
        }
    }

    /**
     * Decrypts the specified message using the decryption map of this instance.
     *
     * @param message the message to be decrypted.
     * @return the decrypted message.
     */
    public String decrypt(String message) {
        return convert(message, decryptionMap);
    }

    /**
     * Encrypts the specified message using the encryption map of this instance.
     *
     * @param message the message to be encrypted.
     * @return the encrypted message.
     */
    public String encrypt(String message) {
        return convert(message, encryptionMap);
    }

    /**
     * Converts the specified message using the specified character map. This method is used by both the encrypt and
     * decrypt methods.
     *
     * @param message       the message to be converted.
     * @param characterMap  the map to use for the conversion.
     * @return the converted message.
     */
    private String convert(String message, Map<Character, Character> characterMap) {
        // Convert the message to lowercase so that it matches the keys in the character map.
        message = message.toLowerCase();

        // Use a StringBuilder to build the converted message.
        StringBuilder converted = new StringBuilder();

        // Iterate over each character in the message.
        for (char c : message.toCharArray()) {
            // If the character is in the character map, replace it with its corresponding value.
            if (characterMap.containsKey(c)) {
                c = characterMap.get(c);
            }

            // Append the character to the converted message.
            converted.append(c);
        }

        // Return the converted message as a string.
        return converted.toString();
    }

    /**
     * Attempts to crack the cipher used to encrypt the specified message by trying all possible offsets and checking
     * which one produces the most English words in the decrypted message.
     *
     * @param message the message to be cracked.
     * @return a list of probable cipher values (offsets) that could have been used to encrypt the message.
     */
    public static List<Integer> crackCipher(String message) {
        // Check if the dictionary has been initialized. If not, initialize it.
        if (dictionary == null || dictionary.isEmpty()) {
            try {
                initializeDictionary();
            } catch (Exception e) {
                // Print an error message if the initialization fails
                System.err.println("THE DICTIONARY COULD NOT BE INITIALIZED: \n" + e.getMessage());
                return null;
            }
        }

        int mostMatches = -1;
        List<Integer> probableCipherValues = new ArrayList<>();

        // Loop through all possible offsets
        for (int i = 0; i < 26; ++i) {
            // Decrypt the message using the current offset
            String decrypted = new CaesarCipher(i).decrypt(message);

            int matches = 0;

            // Count how many words in the decrypted message are present in the dictionary
            for (String word : decrypted.split("[^A-Za-z]")) {
                if (dictionary.contains(word)) ++matches;
            }

            // If there are fewer matches than the current maximum, skip to the next offset
            if (matches < mostMatches) continue;

            // If there are more matches than the current maximum, clear the list of probable cipher values
            if (matches > mostMatches) probableCipherValues.clear();

            // Add the current offset to the list of probable cipher values and update the current maximum
            probableCipherValues.add(i);
            mostMatches = matches;
        }

        return probableCipherValues;
    }

    /**
     * Initializes the dictionary by reading in a list of words from a file.
     *
     * @throws URISyntaxException if the file path is invalid.
     */
    private static void initializeDictionary() throws URISyntaxException {
        // If the dictionary has not been initialized, create a new HashSet
        if (dictionary == null) dictionary = new HashSet<>();

        // Load the list of words from the file
        File file = new File(Objects.requireNonNull(CaesarCipher.class.getResource("words_alpha.txt")).toURI());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Add each word to the dictionary
                dictionary.add(line);
            }
        } catch (IOException e) {
            // Throw a runtime exception if there is an error reading the file
            throw new RuntimeException(e);
        }
    }
}
