public class PotionBrewing {

    static class PotionExplosionException extends Exception {
        public PotionExplosionException(String message) {
            super(message);
        }
    }

    public static void brewPotion(int dragonBloodDrops)
            throws PotionExplosionException {

        if (dragonBloodDrops > 5) {
            throw new PotionExplosionException(
                    "Potion exploded! Too much Dragon Blood: " + dragonBloodDrops
            );
        }


        System.out.println("Potion brewed successfully with "
                + dragonBloodDrops + " drops.");
    }

    public static void main(String[] args) {
        try {
            brewPotion(6); // Expect failure
        } catch (PotionExplosionException e) {

            System.out.println("Brewing failed!");
            System.out.println(e.getMessage());
        }
    }
}
