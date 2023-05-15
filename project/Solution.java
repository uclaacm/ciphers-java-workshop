package project;

/* =============================================================================
 *
 * PROGRAM: Caeser Cipher Encoder-Decoder
 * AUTHOR: Benson Liu
 * 
 * =============================================================================
 */

public class Solution {

    // =============================================================================

    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // =============================================================================

    // PROJECT FUNCTIONS

    /* 
     * 
     * FUNCTION #1: CAESAR CIPHER ENCODER. Write a function that acts as an encoder
     * for a Caesar Cipher! Your function should be able to encode a string,
     * ignoring characters that do not appear in the alphabet. It should covert all
     * upper case characters to lower case in the alphabet. It should be able to
     * handle and possible types of values for msg and should handle both positive
     * and negative values for shift.
     * 
     */

    public String encode(String plaintext, int shift) {
        String output = "";
        for (char c : plaintext.toCharArray()){
            char adjusted = Character.toLowerCase(c);
            if(alphabet.indexOf(adjusted) != -1) {
                int ordinal = alphabet.indexOf(adjusted);
                int shifted = (ordinal + shift + alphabet.length()) % alphabet.length();
                output += alphabet.charAt(shifted);
            }
            else {
                output += adjusted;
            }
        }
        return output;
    }

    /*
     * 
     * FUNCTION #2: CAESAR CIPHER DECODER. Write a function that acts as an decoder
     * for a Caesar Cipher! Your function should be able to encode a string,
     * ignoring characters that do not appear in the alphabet. It should covert all
     * upper case characters to lower case in the alphabet. It should be able to
     * handle and possible types of values for msg and should handle both positive
     * and negative values for shift.
     * 
     */
     
     public String decode(String ciphertext, int shift) {
        String output = "";
        for (char c : ciphertext.toCharArray()){
            char adjusted = Character.toLowerCase(c);
            if(alphabet.indexOf(adjusted) != -1) {
                int ordinal = alphabet.indexOf(adjusted);
                int shifted = (ordinal - shift + alphabet.length()) % alphabet.length();
                output += alphabet.charAt(shifted);
            }
            else {
                output += adjusted;
            }
        }
        return output;
    }

    /*
     * 
     * FUNCTION #3: ROT13 ENCODER-DECODER. ROT13 is a shift cipher where you perform
     * a shift by 13. Write a function that acts as both an encoder and decoder for
     * ROT 13. Why can the same function be used for encoding and decoding?
     * 
     * HINT: This can be done in one line if you use one of your previous functions.
     * 
     */

    public String rot13_encode_decode(String text){
        return encode(text, 13);
    }
     
     /*
     * 
     * FUNCTION #4: VINÈGERE CIPHER ENCODER. Write a function that acts as an encoder
     * for a Vinègere Cipher! Yoour function should be able to encode a string, given 
     * a message and key. It should ignore characters that do not appear in the
     * alphabet. It should covert allupper case characters to lower case in the 
     * alphabet.
     * 
     */
    
    public String encrypt(String plaintext, final String key) {
        String output = "";
        int i = 0;
        for (char c : plaintext.toCharArray()){
            char adjusted = Character.toLowerCase(c);
            if(alphabet.indexOf(adjusted) != -1) {
		        int ordinal = alphabet.indexOf(adjusted);
		        int shifted = alphabet.indexOf(key.charAt(i%key.length()));
                i++;
                output += alphabet.charAt((ordinal + shifted + alphabet.length()) %  alphabet.length());
	        } else {
		        output += adjusted;
            }
        }
        return output;
    }
    
    /*
     * 
     * FUNCTION #5: VINÈGERE CIPHER DECODER. Write a function that acts as an decoder
     * for a Vinègere Cipher! Your function should be able to decode a string, given 
     * the encrypted message and key. It should ignore characters that do not appear 
     * in the alphabet. It should covert allupper case characters to lower case in the 
     * alphabet.
     *
     * HINT: This can be done by changing one character of the encrypt function.
     * 
     */
    
    public String decrypt(String plaintext, final String key) {
        String output = "";
        int i = 0;
        for (char c : plaintext.toCharArray()){
            char adjusted = Character.toLowerCase(c);
            if(alphabet.indexOf(adjusted) != -1) {
		        int ordinal = alphabet.indexOf(adjusted);
		        int shifted = alphabet.indexOf(key.charAt(i%key.length()));
                i++;
                output += alphabet.charAt((ordinal - shifted + alphabet.length()) %  alphabet.length());
	        } else {
		        output += adjusted;
	        }
        }
        return output;
    }

    // =============================================================================

    // CHALLENGE FUNCTIONS

    String big_alphabet = " !\"#$%&'()*+',-./013456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    
    /* 
     * 
     * CHALLENGE FUNCTION #1: ASCII CAESAR CIPHER ENCODER. Write a function that
     * acts as an encoder for a Caesar Cipher of all the printable ASCII characters!
     * Your function should be able to encode a string for any printable ASCII
     * character. It should be able to handle and possible types of values for msg
     * and should handle both positive and negative values for shift.
     * 
     */

    public String big_encode(String plaintext, int shift) {
        String output = "";
        for (char c : plaintext.toCharArray()){
            char adjusted = Character.toLowerCase(c);
            if(big_alphabet.indexOf(adjusted) != -1) {
                int ordinal = big_alphabet.indexOf(adjusted);
                int shifted = (ordinal + shift  + big_alphabet.length()) % big_alphabet.length();
                output += big_alphabet.charAt(shifted);
            }
            else {
                output += adjusted;
            }
        }
        return output;
    }

    /* 
     * 
     * CHALLENGE FUNCTION #2: ASCII CAESAR CIPHER DECODER. Write a function that
     * acts as an decoder for a Caesar Cipher of all the printable ASCII characters!
     * Your function should be able to decode a string for any printable ASCII
     * character. It should be able to handle and possible types of values for msg
     * and should handle both positive and negative values for shift.
     * 
     */

    public String big_decode(String ciphertext, int shift) {
        String output = "";
        for (char c : ciphertext.toCharArray()){
            char adjusted = Character.toLowerCase(c);
            if(big_alphabet.indexOf(adjusted) != -1) {
                int ordinal = big_alphabet.indexOf(adjusted);
                int shifted = (ordinal - shift + big_alphabet.length()) % big_alphabet.length();
                output += big_alphabet.charAt(shifted);
            }
            else {
                output += adjusted;
            }
        }
        return output;
    }

    /* 
     * 
     * CHALLENGE FUNCTION #3: CAESAR BRUTE FORCE. Write a function that acts as a
     * brute force solver for a Caesar Cipher (you can chose whether to use alphabet
     * or big_alphabet in your function). Your function should print out all possible
     * combinations of shifts in the given alphabet and the user should be able to find
     * their plaintext message in the cipher.
     * 
     */
    
    public void brute_force(String ciphertext){
        for(int i = 0; i < alphabet.length(); i++){
            String decoded = decode(ciphertext, i);
            System.out.print("Shift: " + i + " ");
            System.out.println("Decoded: " + decoded);
        }
    }
}
