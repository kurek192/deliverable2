//WILLIAM KUREK

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class CitySimTest {

    //ensure the method retrieves the correct frequency of sennott
    @Test
    public void testGetSennottFrequency() throws Exception {
        Random random = Mockito.mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(1);
        CitySim sim = new CitySim(random);
        assertEquals(sim.getSennottFrequency(), sim.sennottFrequency);
    }

    //ensure tha the method correctly increments the sennot frequency
    @Test
    public void testIncrementSennottFrequency() throws Exception {
        Random random = Mockito.mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(1);
        CitySim sim = new CitySim(random);
        sim.incrementSennotFrequency();
        assertEquals(sim.getSennottFrequency(), sim.sennottFrequency);
    }

    //ensure that the method correctly generates the next location
    @Test
    public void testNextLocation() throws Exception {
        Random random = Mockito.mock(Random.class);
        Driver driver = Mockito.mock(Driver.class);
        Location currLoc = Mockito.mock(Location.class);
        Route chosenRoute = Mockito.mock(Route.class);
        Location destination = Mockito.mock(Location.class);

        when(currLoc.getRoute(anyInt())).thenReturn(chosenRoute);
        when(chosenRoute.getDestination(currLoc)).thenReturn(destination);

        CitySim cs = new CitySim(random);

        assertEquals(destination, cs.nextLocation(driver, currLoc));
    }

    //ensure that the method correctly outputs the travel summary strings
    @Test
    public void testTravelSummary() throws Exception {
        Random random = Mockito.mock(Random.class);
        Driver d = Mockito.mock(Driver.class);
        Location s = Mockito.mock(Location.class);
        Route r = Mockito.mock(Route.class);
        Location e = Mockito.mock(Location.class);

        Mockito.when(d.toString()).thenReturn("driver");
        Mockito.when(s.toString()).thenReturn("start");
        Mockito.when(r.toString()).thenReturn("route");
        Mockito.when(e.toString()).thenReturn("end");

        CitySim.travelSummary(d, s, r, e);

        assertEquals("driver heading from start to end via route", CitySim.getTravelSummary());
    }

    //ensure that the method returns the correct travel summary
    @Test
    public void testGetTravelSummary() throws Exception {
        Random random = Mockito.mock(Random.class);
        Driver d = Mockito.mock(Driver.class);
        Location s = Mockito.mock(Location.class);
        Route r = Mockito.mock(Route.class);
        Location e = Mockito.mock(Location.class);

        Mockito.when(d.toString()).thenReturn("driver");
        Mockito.when(s.toString()).thenReturn("start");
        Mockito.when(r.toString()).thenReturn("route");
        Mockito.when(e.toString()).thenReturn("end");

        CitySim.travelSummary(d, s, r, e);

        assertEquals("driver heading from start to end via route", CitySim.getTravelSummary());
    }
}

