import java.util.ArrayList;
import java.util.Iterator;
public class EngineerIterator<Engineer extends Comparable<Engineer>> implements Iterator<Engineer>{

  private OrderedList<Engineer> team1;
  private OrderedList<Engineer> team2;
  private OrderedList<Engineer> team3;
  private OrderedList<Engineer> team4;
  private ArrayList<Engineer> lst;
  Engineer head;
  Engineer tp;
  int c = 0;

  int s1;
  int s2;
  int s3;
  int s4;

  
  public EngineerIterator(OrderedList<Engineer> team1,OrderedList<Engineer> team2,OrderedList<Engineer> team3,OrderedList<Engineer> team4) {
    head=team1.get(0);
    this.team1=team1;
    this.team2=team2;
    this.team3=team3;
    this.team4=team4;
    this.s1 = this.team1.size();
    this.s2 = this.team2.size();
    this.s3 = this.team3.size();
    this.s4 = this.team4.size();
  }
  @Override
  public boolean hasNext() {
    int total = s1+s2+s3+s4;
    return this.c < total;
  }

  @Override
  public Engineer next() {
    this.c+=1;
    Engineer val = head;
    if (c<s1) {
      val = team1.get(c);
    } else if (s1<c && c<(s1+s2)) {
      val = team2.get(c-s1);
    } else if ((s1+s2)<c && c<(s1+s2+s3)){
      val = team3.get(c-(s1+s2));
    } else if ((s1+s2+s3)<c && c<(s1+s2+s3+s4)){
      val = team3.get(c-(s1+s2+s3));
    }
    return val;
  }
}
