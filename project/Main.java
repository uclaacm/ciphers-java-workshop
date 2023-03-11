package project;

public class Main {
    public static void main(String args[]){
        Solution solution = new Solution();

        // TEST #1: Basic encoding and decoding.
        String message = "Hello world";
        String encoded = solution.encode(message, -27);
        System.out.println(message);
        System.out.println(encoded);
        System.out.println(solution.decode(encoded, -27));

        // TEST #2: ROT13 encoding and decoding
        System.out.println(solution.rot13_encode_decode(message));
        System.out.println(solution.rot13_encode_decode(solution.rot13_encode_decode(message)));

        // TEST #3: Extended encoding and decoding
        String big_encoded = solution.big_encode(message,27);
        System.out.println(big_encoded);
        System.out.println(solution.big_decode(big_encoded, 27));

        // TEST #4: Brute forcing
        solution.brute_force(encoded);
    }
}