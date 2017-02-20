//WILLIAM KUREK

import java.util.Random;

public class CitySim {

    private final Random random;
    int sennottFrequency;

    public CitySim(Random rand) {
        this.random = rand;
    }

    public static void travelSummary(Driver driver, Location start, Route route, Location end) {
        System.out.println(driver.toString()
                + " heading from "
                + start.toString()
                + " to "
                + end.toString()
                + " via "
                + route.toString());
    }

    public Location getStartLocation() {
        return Location.VALUES[random.nextInt(Location.COUNT)];
    }

    public int getSennottFrequency() {
        return sennottFrequency;
    }

    public void incrementSennotFrequency() {
        sennottFrequency++;
    }

    public Location nextLocation(Driver driver, Location currentLocation) {
        if (currentLocation.toString().equals("Sennott")) {
            incrementSennotFrequency();
        }
        int numPossibleRoutes = currentLocation.getNumberOfRoutes();
        Route chosenRoute = currentLocation.getRoute(random.nextInt(numPossibleRoutes));
        Location destination = chosenRoute.getDestination(currentLocation);
        destination.setExit(currentLocation);
        travelSummary(driver, currentLocation, chosenRoute, destination);
        return destination;
    }

}
