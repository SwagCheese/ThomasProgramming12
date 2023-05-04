package com.thomas.module_2.assignment_5;

import java.util.List;

/**
 * This class contains the main method for the Caesar Cipher program.
 */
@SuppressWarnings("SpellCheckingInspection")
public class Main {
    /**
     * This is the main method that runs the Caesar Cipher program. It encrypts and decrypts various famous quotes
     *
     * @param args The command line arguments. (ignored)
     */
    public static void main(String[] args) {
        printEncryptDecrypt(new CaesarCipher(5), "Be the change you wish to see in the world. - Mahatma Gandhi");
        printDecrypt("gj ymj hmfslj dtz bnxm yt xjj ns ymj btwqi. - rfmfyrf lfsimn");

        printEncryptDecrypt(new CaesarCipher(10), "I have not failed. I've just found 10,000 ways that won't work. - Thomas Edison");
        printDecrypt("s rkfo xyd pksvon. s'fo tecd pyexn 10,000 gkic drkd gyx'd gybu. - drywkc onscyx");

        printEncryptDecrypt(new CaesarCipher(7), "You miss 100% of the shots you don't take. - Wayne Gretzky");
        printDecrypt("fvb tpzz 100% vm aol zovaz fvb kvu'a ahrl. - dhful nylagrf");

        printEncryptDecrypt(new CaesarCipher(13), "To be, or not to be, that is the question. - William Shakespeare");
        printDecrypt("gb or, be abg gb or, gung vf gur dhrfgvba. - jvyyvnz funxrfcrner");

        printEncryptDecrypt(new CaesarCipher(8), "I have a dream that one day this nation will rise up and live out the true meaning of its creed. - Martin Luther King Jr.");
        printDecrypt("q pidm i lzmiu bpib wvm lig bpqa vibqwv eqtt zqam cx ivl tqdm wcb bpm bzcm umivqvo wn qba kzmml. - uizbqv tcbpmz sqvo rz.");

        printEncryptDecrypt(new CaesarCipher(21), "I can accept failure, everyone fails at something. But I can't accept not trying. - Michael Jordan");
        printDecrypt("d xvi vxxzko avdgpmz, zqzmtjiz avdgn vo njhzocdib. wpo d xvi'o vxxzko ijo omtdib. - hdxcvzg ejmyvi");

        printEncryptDecrypt(new CaesarCipher(4), "The greatest glory in living lies not in never falling, but in rising every time we fall. - Nelson Mandela");
        printDecrypt("xli kviexiwx kpsvc mr pmzmrk pmiw rsx mr riziv jeppmrk, fyx mr vmwmrk izivc xmqi ai jepp. - ripwsr qerhipe");

        printEncryptDecrypt(new CaesarCipher(17), "Education is the most powerful weapon which you can use to change the world. - Nelson Mandela");
        printDecrypt("vultrkzfe zj kyv dfjk gfnviwlc nvrgfe nyzty pfl tre ljv kf tyrexv kyv nficu. - evcjfe dreuvcr");
    }

    /**
     * This method encrypts and decrypts a message using the given Caesar Cipher object and prints the results.
     *
     * @param caesarCipher The Caesar Cipher object to use for encryption and decryption.
     * @param message      The message to encrypt and decrypt.
     */
    private static void printEncryptDecrypt(CaesarCipher caesarCipher, String message) {

        // Convert the message to lowercase to make it easier to work with
        message = message.toLowerCase();

        // Print the original message
        System.out.println("Original Message: " + message);

        // Encrypt the message using the Caesar Cipher object
        String encrypted = caesarCipher.encrypt(message);

        // Print the encrypted message
        System.out.println("Encrypted Message: " + encrypted);

        // Decrypt the encrypted message using the Caesar Cipher object
        String decrypted = caesarCipher.decrypt(encrypted);

        // Print the decrypted message
        System.out.println("Decrypted Message: " + decrypted);

        // Print a separator line to make the output easier to read
        System.out.println("----------------------------------------------------");
    }

    /**
     * This method decrypts a message using the given Caesar Cipher object and prints the results.
     *
     * @param message The message to decrypt.
     */
    private static void printDecrypt(String message) {

        // Convert the message to lowercase to make it easier to work with
        message = message.toLowerCase();

        // Print the encrypted message
        System.out.println("Encrypted Message: " + message);

        // Use the crackCipher method of the CaesarCipher class to get a list of possible shifts
        List<Integer> possibleShifts = CaesarCipher.crackCipher(message);

        // If there was an error in the crackCipher method, just return, CaesarCipher.crachCipher already will have printed an error message
        if (possibleShifts == null) {
            return;
        }

        // Print a list of the possible shifts (in characters)
        System.out.print("Possible Shifts (in characters): ");
        for (int i = 0; i < possibleShifts.size(); ++i) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(possibleShifts.get(i));
        }

        // Print a separator line to make the output easier to read
        System.out.println();

        // Print the possible messages for each of the possible shifts
        System.out.println("Possible Messages: ");
        for (int i : possibleShifts) {

            // Create a new Caesar Cipher object with the current shift
            CaesarCipher caesarCipher = new CaesarCipher(i);

            // Decrypt the message using the new Caesar Cipher object
            System.out.println(caesarCipher.decrypt(message));
        }

        // Print a separator line to make the output easier to read
        System.out.println("----------------------------------------------------");
    }
}