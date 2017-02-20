
import java.util.HashMap;
import java.util.Map;


public class Route {

    public static final Route BILL = new Route("Bill St.");
    public static final Route PHIL = new Route("Phil St.");
    public static final Route FOURTH = new Route("Fourth Ave.");
    public static final Route FIFTH = new Route("Fifth Ave.");

    static {
        BILL.setConnections(true, Location.PRESBY, Location.SENNOTT);
        PHIL.setConnections(true, Location.UNION, Location.HILLMAN);
        FOURTH.setConnections(false, Location.OUTSIDE_CITY, Location.PRESBY, Location.UNION, Location.OUTSIDE_CITY);
        FIFTH.setConnections(false, Location.OUTSIDE_CITY, Location.HILLMAN, Location.SENNOTT, Location.OUTSIDE_CITY);
    }

    private final String name;
    private Map<Location, Location> connections;

    private Route(String name) {
        this.name = name;
    }

    public Location getDestination(Location comingFrom) {
        return connections.get(comingFrom);
    }

    @Override
    public String toString() {
        return name;
    }

    private void setConnections(boolean twoWay, Location... connects) {
        this.connections = new HashMap<>(connects.length);
        if (connects.length >= 2) {
            for (int i = 0, j = 1; j < connects.length; i++, j++) {
                connections.put(connects[i], connects[j]);
                if (twoWay) {
                    connections.put(connects[j], connects[i]);
                }
            }
        }
    }
}
