
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DriverTest
{
   
    //Ensures that the toString method outputs a String matching the expected format.
    
   @Test
   public void testToString() throws Exception
   {
      Driver driver = new Driver(4);
      assertEquals("Driver 5", driver.toString());
   }
}
