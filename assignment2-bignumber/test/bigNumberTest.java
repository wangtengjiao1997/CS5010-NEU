import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

import bignumber.BigNumber;
import bignumber.BigNumberImpl;

import static org.junit.Assert.assertEquals;

public class bigNumberTest {

  private BigNumber num;

  @Test(timeout = 3000)
  public void testNumberCreationByShiftingAndAdding() {
    Random r = new Random(200);
    for (int trial = 0; trial < 3; trial++) {
      BigNumber number = new BigNumberImpl();
      StringBuilder expected = new StringBuilder();
      for (int i = 0; i < 10; i++) {
        int digit = Math.abs(r.nextInt()) % 10;
        if ((i == 0) && (digit == 0)) {
          digit = Math.abs(r.nextInt()) % 9 + 1;
        }
        if ((expected.toString().length() != 0) || (digit != 0)) {
          expected.append(digit);
        }
        number.shiftLeft(1);
        number.addDigit(digit);
      }
      assertEquals(expected.toString(), number.toString());
    }
  }

  /** Testing. */

  @Test(timeout = 3000)
  public void testAddNumbers() {
    Random r = new Random(200);
    BigNumber num1;
    BigNumber num2;
    BigNumber result;

    BigInteger n1;
    BigInteger n2;
    BigInteger expectedResult;

    for (int trial = 0; trial < 20; trial++) {

      StringBuilder expected = new StringBuilder();
      int l = r.nextInt(500);
      for (int i = 0; i < l; i++) {
        int digit = Math.abs(r.nextInt()) % 10;
        if ((i == 0) && (digit == 0)) {
          digit = Math.abs(r.nextInt()) % 9 + 1;
        }
        if ((expected.toString().length() != 0) || (digit != 0)) {
          expected.append(digit);
        }

        // assertEquals(expected.toString(),number.toString());
      }
      num1 = new BigNumberImpl(expected.toString());
      assertEquals(expected.toString(), num1.toString());
      if (expected.toString().length() > 0) {
        n1 = new BigInteger(expected.toString());
      } else {
        n1 = new BigInteger("0");
      }
      expected = new StringBuilder();
      l = r.nextInt(5000);
      for (int i = 0; i < l; i++) {
        int digit = Math.abs(r.nextInt()) % 10;
        if ((i == 0) && (digit == 0)) {
          digit = Math.abs(r.nextInt()) % 9 + 1;
        }
        if ((expected.toString().length() != 0) || (digit != 0)) {
          expected.append(digit);
        }

        // assertEquals(expected.toString(),number.toString());
      }
      num2 = new BigNumberImpl(expected.toString());
      assertEquals(expected.toString(), num2.toString());
      if (expected.toString().length() > 0) {
        n2 = new BigInteger(expected.toString());
      } else {
        n2 = new BigInteger("0");
      }

      result = num1.add(num2);
      expectedResult = n1.add(n2);

      assertEquals(
              "Adding the numbers " + n1.toString() + " and " + n2.toString()
                      + " did not produce the correct result",
              expectedResult.toString(), result.toString());

      assertEquals("Adding 0 to a number does not produce the number itself",
              num1.add(new BigNumberImpl("0")).toString(), num1.toString());

    }

    // trying the case where there is an overflow carry
    StringBuilder string = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      string.append("9");
    }
    num1 = new BigNumberImpl(string.toString());
    num2 = new BigNumberImpl(string.toString());
    result = num1.add(num2);

    n1 = new BigInteger(string.toString());
    n2 = new BigInteger(string.toString());
    expectedResult = n1.add(n2);

    assertEquals("Adding the numbers " + n1.toString() + " and " + n2.toString()
            + " did not produce the correct result", expectedResult.toString(), result.toString());
  }
  @Before
  public void startup(){
    num = new BigNumberImpl("45823");
  }
  @Test
  public void testgetDigitAt() {
    assertEquals(3,num.getDigitAt(0));
    assertEquals(5,num.getDigitAt(3));
    assertEquals(4,num.getDigitAt(4));
  }
  @Test
  public void testlength() {
    assertEquals(5,num.length());
  }
  @Test
  public void testshiftLeft() {
    num.shiftLeft(2);
    assertEquals("4582300",num.toString());
  }
  @Test
  public void testshiftRight() {
    num.shiftRight(2);
    assertEquals("458",num.toString());
  }
  @Test
  public void testaddDigit() {
    num.addDigit(8);
    assertEquals("45831",num.toString());
  }
  @Test
  public void testcopy() {
    BigNumber c = num.copy();
    assertEquals(c.toString(),num.toString());
  }
  @Test
  public void testsort() {
    BigNumber num1 = new BigNumberImpl("45823");
    BigNumber num2 = new BigNumberImpl("4533");
    BigNumber num3 = new BigNumberImpl("25531");
    BigNumber num4 = new BigNumberImpl("43");
    BigNumber num5 = new BigNumberImpl("813");
    ArrayList<BigNumber> list = new ArrayList<>();
    ArrayList<BigNumber> list2 = new ArrayList<>();
    list.add(num1);
    list.add(num2);
    list.add(num3);
    list.add(num4);
    list.add(num5);
    list.add(num);

    list2.add(num4);
    list2.add(num5);
    list2.add(num2);
    list2.add(num3);
    list2.add(num1);
    list2.add(num);
    list.sort(BigNumber::compareTo);
    assertEquals(list,list2);
  }
}