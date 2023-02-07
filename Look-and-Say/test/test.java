import org.junit.Test;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Random;

import lookandsay.LookAndSayIterator;
import lookandsay.RIterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test {

  @Test(timeout = 1000)
  public void testDefaultSeed() {
    Iterator<BigInteger> iterator = new LookAndSayIterator();
    BigInteger previous = new BigInteger("1");
    iterator.next(); // burn off the first one
    while (iterator.hasNext()) {
      BigInteger b = iterator.next();
      assertTrue("Number " + previous.toString() + " cannot be read as " + b.toString(),
              decode(previous, b));
      previous = b;
    }
    previous = iterator.next();
    assertTrue("The iterator ended but the last number was not more than " + "100 digits long",
            previous.toString().length() > 100);
  }
  @Test
  public void testBasicReverse() {
    BigInteger seed = new BigInteger("123");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
    BigInteger num1 = iterator.next();
    BigInteger num2 = iterator.next();
    BigInteger num3 = iterator.next();
    BigInteger num4 = iterator.next();
    iterator.prev();
    assertEquals("2nd call to prev() should return same as last call to next()",
            num4, iterator.prev());
    assertEquals("prev() not as expected", num3, iterator.prev());
    assertEquals("prev() not as expected", num2, iterator.prev());
    assertEquals("prev() not as expected", num1, iterator.prev());
    assertFalse("hasPrevious() should return false", iterator.hasPrevious());
  }

  @Test(timeout = 3000)
  public void testCustomValidSeed() {
    Random r = new Random(10);
    for (int j = 0; j < 200; j++) {
      int seed = r.nextInt(20000);
      if (Integer.toString(seed).indexOf('0') == -1) {
        Iterator<BigInteger> iterator = new LookAndSayIterator(new BigInteger("" + seed));
        BigInteger previous = new BigInteger("" + seed);
        iterator.next(); // burn off the first one
        while (iterator.hasNext()) {
          BigInteger b = iterator.next();
          assertTrue("Number " + previous.toString() + " cannot be read as " + b.toString(),
                  decode(previous, b));
          previous = b;
        }
        previous = iterator.next();
        assertTrue("The iterator ended but the last number was not more than " + "100 digits long",
                previous.toString().length() > 100);
      }
    }
  }

  private boolean decode(BigInteger previous, BigInteger current) {
    String currentString = current.toString();
    StringBuilder soln = new StringBuilder();

    for (int i = 0; i < currentString.length(); i += 2) {
      int freq = Character.digit(currentString.charAt(i), 10);
      int num = Character.digit(currentString.charAt(i + 1), 10);
      for (int j = 0; j < freq; j++) {
        soln.append(num);
      }
    }
    return soln.toString().equals(previous.toString());
  }
}
