package bignumber;

public interface BigNumber {
  int length();
  void shiftLeft(int shift);
  void shiftRight(int shift);
  void addDigit(int digit) throws IllegalArgumentException ;
  int getDigitAt(int index);
  BigNumber copy();
  BigNumber add(BigNumber bignumber);
  int compareTo(BigNumber bignumber);
  public Node getHead();
  public Node getTail();

}
