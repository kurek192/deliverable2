//WILLIAM KUREK

import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RouteTest {

    //ensure that the method gets the destintation from ONE WAY
    @Test
    public void testGetDestination_oneWay() throws Exception {
        // use reflection to access the private constructor
        final Constructor<Route> constructor = Route.class.getDeclaredConstructor(String.class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                constructor.setAccessible(true);
                return null; 
            }
        });

        // use reflection to access the private method setConnections
        final Method method = Route.class.getDeclaredMethod("setConnections", boolean.class, Location[].class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                method.setAccessible(true);
                return null; 
            }
        });

        Route route = constructor.newInstance("blah");
        Location loc1 = Mockito.mock(Location.class), loc2 = Mockito.mock(Location.class);
        method.invoke(route, false, new Location[]{loc1, loc2});

        assertEquals("loc1 ---> loc2", route.getDestination(loc1), loc2);
        assertNull("loc2 -X-> loc1", route.getDestination(loc2));
    }

    //ensure that the method gets the destination from TWO WAY
    @Test
    public void testGetDestination_twoWay() throws Exception {
        // use reflection to access the private constructor
        final Constructor<Route> constructor = Route.class.getDeclaredConstructor(String.class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                constructor.setAccessible(true);
                return null; // nothing to return
            }
        });

        // use reflection to access the private method setConnections
        final Method method = Route.class.getDeclaredMethod("setConnections", boolean.class, Location[].class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                method.setAccessible(true);
                return null; // nothing to return
            }
        });

        Route route = constructor.newInstance("blah");
        Location loc1 = Mockito.mock(Location.class), loc2 = Mockito.mock(Location.class);
        method.invoke(route, true, new Location[]{loc1, loc2});

        assertEquals("loc1 ---> loc2", route.getDestination(loc1), loc2);
        assertEquals("loc2 ---> loc1", route.getDestination(loc2), loc1);
    }

    //ensure the toString outputs the correct string
    @Test
    public void testToString() throws Exception {
        // use reflection to access the private constructor
        final Constructor<Route> constructor = Route.class.getDeclaredConstructor(String.class);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                constructor.setAccessible(true);
                return null; // nothing to return
            }
        });

        Route route = constructor.newInstance("name");
        assertEquals("name", route.toString());
    }
}
