package bignumber;
import bignumber.Node;

public class BigNumberImpl implements BigNumber{
  private Node head;
  private Node tail;

  public BigNumberImpl(){
    this.head = new Node();
    this.tail = head;
  }
  public BigNumberImpl(String number){
    this.head = new Node();
    this.tail = head;
    for (int i =0; i<number.length(); i++){
      char num = number.charAt(i);
      if(!Character.isDigit(num)){
        throw new IllegalArgumentException();
      }
      this.addDigit(num-'0');
      this.shiftLeft(1);
    }
    this.shiftRight(1);
  }
  @Override
  public int length() {
    int count = 0;
    Node tp = this.head;
    while(tp!=null){
      count+=1;
      tp=tp.next;
    }
    return count;

  }

  @Override
  public void shiftLeft(int shift) {
    Node tp = this.tail;
    if(shift>=0){
      if (this.tail.pre == null && this.tail.value == 0) {
        return;
      }
      for(int i = 0; i < shift; i++) {
        Node n = new Node();
        tp.next = n;
        n.pre=tp;
        tp = tp.next;
      }
      this.tail = tp;
    }else{
      shiftRight(shift*-1);
    }
  }

  @Override
  public void shiftRight(int shift) {
    if(shift>=0) {
      for (int i = 0; i < shift; i++) {
        if (tail.pre == null) {
          head = new Node();
          tail = head;
          break;
        }
        this.tail = tail.pre;
        this.tail.next = null;
      }
    }else{
      shiftLeft(shift*-1);
    }
  }

  @Override
  public void addDigit(int digit) throws IllegalArgumentException {
    if(digit<0 ||digit>9){
      throw new IllegalArgumentException();
    }else{
      int num = this.tail.value+digit;
      if(num<10){
        this.tail.value=num;
      }else{
        Node ptr = this.tail;
        while (num >= 10) {
          int remain = num % 10;
          ptr.value = remain;
          if (ptr.pre == null){
            Node newnode = new Node();
            ptr.pre=newnode;
            newnode.next=ptr;
            this.head=newnode;
          }
          ptr = ptr.pre;
          ptr.value += 1;
          num = ptr.value;
        }
      }
    }
  }

  @Override
  public int getDigitAt(int index) {
    if (index >= this.length() || index<0) {
      throw new IllegalArgumentException();
    }else{
      int count = 0;
      Node tp = this.tail;
      while(count<index){
        count+=1;
        tp=tp.pre;
      }
      return tp.value;

    }
  }

  @Override
  public BigNumber copy() {
    BigNumber newBigNumber = new BigNumberImpl();
    int count = 0;
    Node headptr = this.getHead();
    while(count<this.length()-1){
      newBigNumber.addDigit(headptr.value);
      newBigNumber.shiftLeft(1);
      headptr=headptr.next;
      count+=1;
    }
    newBigNumber.addDigit(headptr.value);
    return newBigNumber;
  }

  @Override
  public BigNumber add(BigNumber bignumber) {
    BigNumber newBigNumber = new BigNumberImpl();
    int len1 = this.length();
    int len2 = bignumber.length();
    int next_start=len1;
    if(len1 > len2){
      int difference = len1-len2;
      for (int i = len1-1; i >=len1-difference ; i--) {
        newBigNumber.shiftLeft(1);
        newBigNumber.addDigit(this.getDigitAt(i));

      }
      next_start = len1-difference;
    }else if(len1 < len2) {
      int difference = len2-len1;
      for (int i = len2-1; i >=len2-difference ; i--) {
        newBigNumber.shiftLeft(1);
        newBigNumber.addDigit(bignumber.getDigitAt(i));

      }
      next_start = len2-difference;
    }
    for (int i = next_start-1; i >=0 ; i--){
      newBigNumber.shiftLeft(1);
      newBigNumber.addDigit(this.getDigitAt(i));
      newBigNumber.addDigit(bignumber.getDigitAt(i));
    }
    return newBigNumber;
  }
  @Override
  public int compareTo(BigNumber bignumber){
    Node tp = this.head;
    Node tp_compare = bignumber.getHead();
    int len1 = this.length();
    int len2 = bignumber.length();
    if(len1>len2){
      return 1;
    }else if(len1<len2){
      return -1;
    }else{
      while (tp!=null){
        if (tp.value > tp_compare.value){
          return 1;
        }
        else if (tp.value < tp_compare.value){
          return -1;
        }else{
          tp=tp.next;
          tp_compare=tp_compare.next;
        }
      }
      return 0;
    }
  }

  @Override
  public String toString() {
    String str = "";
    int count = 0;
    Node tp = this.head;
    while(tp!=null){
      str+=tp.value;
      count+=1;
      tp=tp.next;
    }
    return str;
  }

  @Override
  public Node getHead(){
    return this.head;
  }
  @Override
  public Node getTail(){
    return this.tail;
  }
}
