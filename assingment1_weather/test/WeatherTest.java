import org.junit.Before;
import org.junit.Test;
import weather.WeatherReading;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * A JUnit test class for the WeatherReading class.
 */
public class WeatherTest {

  private WeatherReading weather1;

  @Before
  public void setUp(){
    weather1 = new WeatherReading(23,12,3,12);
  }

  @Test
  public void testGetTemperature(){
    assertEquals(23,weather1.getTemperature());
  }

  @Test
  public void testGetDewPoint(){
    assertEquals(12,weather1.getDewPoint());
  }

  @Test
  public void testGetWindSpeed(){
    assertEquals(3,weather1.getWindSpeed());
  }

  @Test
  public void testGetTotalRain(){
    assertEquals(12,weather1.getTotalRain());
  }

  @Test
  public void testGetRelativeHumidity(){
    assertEquals(45,weather1.getRelativeHumidity());
  }

  @Test
  public void testGetHeatIndex(){
    assertEquals(25.112149608445005,weather1.getHeatIndex(),0.01);
  }

  @Test
  public void testGetWindChill(){
    assertEquals(76.14651430332569,weather1.getWindChill(),0.01);
  }

  @Test
  public void testToString(){
    assertTrue("Reading: T = 23, D = 12, v = 3, rain = 12".equals(weather1.toString()));
  }

  @Test
  public void testConstructor(){
    try {
      WeatherReading weather2 = new WeatherReading(23,45,3,12);
    } catch (IllegalArgumentException e) {
      assertTrue("Dew point should be less than temperature".equals(e.getMessage()));
    }
    try {
      WeatherReading weather3 = new WeatherReading(23,12,-5,12);
    } catch (IllegalArgumentException e) {
      assertTrue("Wind speed is non-negative".equals(e.getMessage()));
    }
    try {
      WeatherReading weather4 = new WeatherReading(23,12,3,-12);
    } catch (IllegalArgumentException e) {
      assertTrue("Total Rain is non-negative".equals(e.getMessage()));
    }
  }
}
