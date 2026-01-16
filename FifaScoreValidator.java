public class FifaScoreValidator {

    static class InvalidScoreException extends RuntimeException {
        public InvalidScoreException(String message) {
            super(message);
        }
    }

    public static void validateScore(int score) {

        System.out.println("Validating score: " + score);

        if (score < 0) {
            throw new InvalidScoreException("Invalid score! Score cannot be negative.");
        }

        System.out.println("Score is valid: " + score);
    }

    public static void main(String[] args) {

        System.out.println("Program started");

        try {
            validateScore(-1); // Expect failure
        } catch (InvalidScoreException e) {
            System.out.println("Exception caught!");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Validation attempt finished");
        }

        System.out.println("Program ended");
    }
}
