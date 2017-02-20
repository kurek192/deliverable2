

//WILLIAM KUREK
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;

public class LocationTest {

    //ensure that the methdo gets the correct number of routes
    @Test
    public void testGetNumberOfRoutes() throws Exception {
     
        final Constructor<Location> constructor = Location.class.getDeclaredConstructor(String.class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                constructor.setAccessible(true);
                return null;
            }
        });

   
        final Method method = Location.class.getDeclaredMethod("setOut", Route[].class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                method.setAccessible(true);
                return null;
            }
        });

        Location location = constructor.newInstance("blah");
        Route route1 = Mockito.mock(Route.class), route2 = Mockito.mock(Route.class), route3 = Mockito.mock(Route.class);
        method.invoke(location, new Object[]{new Route[]{route1, route2, route3}});

        assertEquals(location.getNumberOfRoutes(), 3);
    }

    //ensure that the method gets the route
    @Test
    public void testGetRoute() throws Exception {

        final Constructor<Location> constructor = Location.class.getDeclaredConstructor(String.class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                constructor.setAccessible(true);
                return null;
            }
        });


        final Method method = Location.class.getDeclaredMethod("setOut", Route[].class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                method.setAccessible(true);
                return null;
            }
        });

        Location location = constructor.newInstance("blah");
        Route route1 = Mockito.mock(Route.class), route2 = Mockito.mock(Route.class), route3 = Mockito.mock(Route.class);
        method.invoke(location, new Object[]{new Route[]{route1, route2, route3}});

        assertEquals(location.getRoute(1), route2);
    }

    //ensure that the method correctly sets the method
    @Test
    public void testSetExit() throws Exception {

        final Constructor<Location> constructor = Location.class.getDeclaredConstructor(String.class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                constructor.setAccessible(true);
                return null;
            }
        });

        Location location = constructor.newInstance("name");
        location.setExit(location);
        assertEquals(location.getExit(), location.toString());
    }

    //ensure that the method correctly gets the exit
    @Test
    public void testGetExit() throws Exception {
    
        final Constructor<Location> constructor = Location.class.getDeclaredConstructor(String.class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                constructor.setAccessible(true);
                return null;
            }
        });

        Location location = constructor.newInstance("name");
        location.setExit(location);
        assertEquals(location.getExit(), location.toString());
    }

    //ensure that the toString properly outputs the information
    @Test
    public void testToString() throws Exception {
   
        final Constructor<Location> constructor = Location.class.getDeclaredConstructor(String.class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                constructor.setAccessible(true);
                return null;
            }
        });

        Location location = constructor.newInstance("name");
        assertEquals("name", location.toString());
    }
}
