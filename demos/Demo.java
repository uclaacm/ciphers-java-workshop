package demos;

/* =============================================================================
 *
 * PROGRAM: Shift Cipher Demo
 * AUTHOR: Benson Liu
 * 
 * =============================================================================
 */

public class Demo {
    /*
     * 
     * DEMO: We want to implement a caesar shift by three on the following message.
     * this implementation does not need to be robust.
     * 
     */

    public static void main(String args[]) {

        // =============================================================================

        String alphabet = "abcdefghijklmopqrstuvwxyz";

        // =============================================================================

        String our_message = "ciphers are cool";
        String output = "";

        for (char c : our_message.toCharArray()){
            char adjusted = Character.toLowerCase(c);
            for(char letter : alphabet.toCharArray()){
                if(adjusted == letter) {
                    int ordinal = alphabet.indexOf(adjusted);
                    int shifted = ordinal + 3;
                    output += alphabet.charAt(shifted);
                }
                else {
                    output += adjusted;
                }
            }
        }

        System.out.println(output);
    }
}