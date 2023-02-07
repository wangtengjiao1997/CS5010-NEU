import org.junit.Before;
import org.junit.Test;
import transmission.Transmission;
import transmission.AutomaticTransmission;
import static org.junit.Assert.*;

public class TestTransmission {
  private Transmission trans;
  @Before
  public void setUp() {
    Transmission transmission = new AutomaticTransmission(10,20,30,40,50);
    this.trans = transmission;
  }

  @Test
  public void constructorTest(){
    try{
      Transmission transmission1 = new AutomaticTransmission(10,20,-10,40,50);
    }catch (IllegalArgumentException e){
      assertEquals("Gear speed can't be zero or negative",e.getMessage());
    }

    try{
      Transmission transmission2 = new AutomaticTransmission(10,20,5,40,50);
    }catch (IllegalArgumentException e){
      assertEquals("Higher gear speed can't be lower than lower gear speed",e.getMessage());
    }
  }

  @Test
  public void increaseSpeedTest(){
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    assertEquals(12,trans.getSpeed());
  }
  @Test
  public void decreaseSpeedTest(){
    try{
      trans = trans.decreaseSpeed();
    }catch (IllegalStateException e){
      assertEquals("Speed can't be lower than 0",e.getMessage());
    }
    trans = trans.increaseSpeed();
    trans = trans.decreaseSpeed();
    assertEquals(0,trans.getSpeed());
  }
  @Test
  public void setGearTest(){
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    assertEquals(2,trans.getGear());
  }
  @Test
  public void soStringTest(){
    trans = trans.increaseSpeed();
    trans = trans.increaseSpeed();
    assertEquals("Transmission (speed = 4, gear = 1)",trans.toString());
  }
}
