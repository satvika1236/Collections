public class NasaMissionValidator {
    static class MissionAbortException extends Exception {
        public MissionAbortException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    public static void launchMission(int fuelPercentage, String weather)
            throws MissionAbortException {

        System.out.println("Starting mission checks...");

        try {

            try {
                System.out.println("Checking fuel level...");
                if (fuelPercentage < 80) {
                    throw new Exception("Fuel level too low: " + fuelPercentage + "%");
                }
                System.out.println("Fuel check passed");
            } catch (Exception fuelException) {
                throw new MissionAbortException("Mission aborted due to fuel issue",
                        fuelException);
            }
            try {
                System.out.println("Checking weather...");
                if (!"CLEAR".equals(weather)) {
                    throw new Exception("Weather not clear: " + weather);
                }
                System.out.println("Weather check passed");
            } catch (Exception weatherException) {
                throw new MissionAbortException("Mission aborted due to weather issue",
                        weatherException);
            }

            System.out.println("🚀 Mission launched successfully!");

        } catch (MissionAbortException e) {
            System.out.println("❌ Mission launch failed!");
            e.printStackTrace(); // Log stack trace
            System.out.println("🔁 Retrying mission preparation...");
            throw e; // re-throw exception
        }
    }
    public static void main(String[] args) {

        try {
            launchMission(70, "CLEAR"); // Expect failure (fuel)
        } catch (MissionAbortException e) {
            System.out.println("Mission terminated.");
        }
    }
}
