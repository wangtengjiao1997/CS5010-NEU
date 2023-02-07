package lookandsay;

import java.math.BigInteger;

public class LookAndSayIterator implements RIterator<BigInteger> {
  private BigInteger seed;
  private BigInteger end;
  private BigInteger current;

  public LookAndSayIterator(BigInteger seed, BigInteger end){
    BigInteger zero = new BigInteger("0");
    if (seed.compareTo(zero)<0){
      throw new IllegalArgumentException("");
    }
    if (seed.compareTo(end)>0){
      throw new IllegalArgumentException("");
    }
    String s = seed.toString();
    if (s.contains("0")){
      throw new IllegalArgumentException("");
    }
    this.seed=seed;
    this.end = end;
    this.current=seed;

  }
  public LookAndSayIterator(BigInteger seed){
    this.end = new BigInteger("9".repeat(100));
    BigInteger zero = new BigInteger("0");
    if (seed.compareTo(zero)<0){
      throw new IllegalArgumentException("");
    }
    if (seed.compareTo(end)>0){
      throw new IllegalArgumentException("");
    }
    String s = seed.toString();
    if (s.contains("0")){
      throw new IllegalArgumentException("");
    }
    this.seed=seed;
    this.current=seed;

  }
  public LookAndSayIterator(){
    this.end = new BigInteger("9".repeat(100));
    this.seed = new BigInteger("1");
    this.current=this.seed;
    BigInteger zero = new BigInteger("0");
    if (seed.compareTo(zero)<0){
      throw new IllegalArgumentException("");
    }
    if (seed.compareTo(end)>0){
      throw new IllegalArgumentException("");
    }
    String s = seed.toString();
    if (s.contains("0")){
      throw new IllegalArgumentException("");
    }
  }
  @Override
  public BigInteger prev() {
    if(!hasPrevious()){
      return this.current;
    }
    String tmpNumber = this.current.toString();
    String res = "";
    for (int i =0; i< tmpNumber.length();i+=2) {
      int count = tmpNumber.charAt(i) - '0';
      StringBuilder tempstr = new StringBuilder();
      for (int x = 0; x<count;x++) {
        tempstr.append(tmpNumber.charAt(i + 1));
      }
      res += tempstr;
    }
    BigInteger reval = this.current;
    this.current = new BigInteger(res);
    return reval;
  }

  @Override
  public boolean hasPrevious() {
    return this.current.toString().length()%2==0;
  }

  @Override
  public boolean hasNext() {
    return this.current.compareTo(this.end)<=0;
  }

  @Override
  public BigInteger next() {
    String tmpNumber = this.current.toString();
    StringBuilder res = new StringBuilder();
    char c = tmpNumber.charAt(0);
    int count = 0;

    for (int i =0; i< tmpNumber.length();i++){
      if (tmpNumber.charAt(i)==c){
        count+=1;
      }else{
        res.append(count).append(c);
        c=tmpNumber.charAt(i);
        count=1;
      }
    }
    res.append(count).append(c);
    BigInteger reval = this.current;
    this.current = new BigInteger(res.toString());
    return reval;
  }
}
