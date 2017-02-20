
import java.util.Random;

public class CitySim9004 {


    public static long parse(String[] args)
            throws NullPointerException, IllegalArgumentException {
        if (args.length == 0) {
            System.out.println("1 command line argument (the PRNG seed) is required!");
            throw new IllegalArgumentException("0 arguments given");
        } else if (args.length > 1) {
            System.out.println("Only 1 command line argument (the PRNG seed) is allowed!");
            throw new IllegalArgumentException("More than 1 arguments given");
        } else {
            try {
                return Long.parseLong(args[0], 10);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid seed given.  Must be an integer in the range [-2^63, 2^63 - 1]");
                throw new IllegalArgumentException(nfe);
            }
        }
    }

    public static void main(String[] args) {
        long seed;
        try {
            seed = parse(args);
        } catch (IllegalArgumentException iae) {
            System.exit(-1);
            return;
        }

        Random random = new Random(seed);

        for (int i = 0; i < 5; i++) {
            Driver driver = new Driver(i);
            CitySim simulation = new CitySim(random);
            Location currentLocation = simulation.getStartLocation();
            do {
                currentLocation = simulation.travelToNextLocation(driver, currentLocation);
            } while (currentLocation != Location.OUTSIDE_CITY);
            if (currentLocation.getExit().equals("Sennott")) {
                System.out.println(driver.toString() + " has gone to Cleveland!");
            } else if (currentLocation.getExit().equals("Union")) {
                System.out.println(driver.toString() + " has gone to Philadelphia!");
            }

            System.out.println(driver.toString() + " met with Professor Laboon " + simulation.getSennottFrequency() + " time(s).");
            if (simulation.getSennottFrequency() > 0) {
                if (simulation.getSennottFrequency() >= 3) {
                    System.out.println("Wow, that driver needed lots of CS help!");
                }

            } else {
                System.out.println("That student missed out!");
            }

            System.out.println("-----");

        }

    }
}
