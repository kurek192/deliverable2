
import java.util.Random;

/**
 * Created by Matt on 10/13/2015.
 */
public class CitySim {

    private final Random random;
    int sennottFrequency;

    public CitySim(Random rand) {
        this.random = rand;
    }

    public static void printTravelSummaryString(Driver driver, Location start, Route route, Location end) {
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
    
    public int getSennottFrequency(){
        return sennottFrequency;
    }
    
    public void incrementSennotFrequency(){
        sennottFrequency++;
    }

    public Location travelToNextLocation(Driver driver, Location currentLocation) {
        if(currentLocation.toString().equals("Sennott")){
            incrementSennotFrequency();
        }
        int numPossibleRoutes = currentLocation.getNumberOfRoutes();
        Route chosenRoute = currentLocation.getRoute(random.nextInt(numPossibleRoutes));       
        Location destination = chosenRoute.getDestination(currentLocation);
        destination.setExit(currentLocation);
        printTravelSummaryString(driver, currentLocation, chosenRoute, destination);
        return destination;
    }

}
