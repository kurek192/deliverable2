
public class Location {

    public static final Location SENNOTT = new Location("Sennott");
    public static final Location UNION = new Location("Union");
    public static final Location PRESBY = new Location("Presby");
    public static final Location HILLMAN = new Location("Hillman");
    public static final Location OUTSIDE_CITY = new Location("Outside City");

    public static final Location[] VALUES = new Location[]{
        SENNOTT,
        UNION,
        PRESBY,
        HILLMAN,
        OUTSIDE_CITY
    };

    public static final int COUNT = VALUES.length;

    static {
        SENNOTT.setOut(Route.FIFTH, Route.BILL);
        UNION.setOut(Route.FOURTH, Route.PHIL);
        PRESBY.setOut(Route.FOURTH, Route.BILL);
        HILLMAN.setOut(Route.FIFTH, Route.PHIL);
        OUTSIDE_CITY.setOut(Route.FIFTH, Route.FOURTH);
    }

    private final String name;
    private Location exit;
    private Route[] routesOut;

    private Location(String name) {
        this.name = name;
    }

    public int getNumberOfRoutes() {
        return routesOut.length;
    }

    public Route getRoute(int routeIndex) {
        return routesOut[routeIndex];
    }
    
    public void setExit(Location exit){
        this.exit = exit;
    }
    
    public String getExit(){
        return exit.toString();
    }

    @Override
    public String toString() {
        return name;
    }

    private void setOut(Route... routesOut) {
        this.routesOut = routesOut;
    }
}
