package priority;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {

  MinMaxPriorityQueue<String> queue;
  @Test
  public void test1(){
    MinMaxPriorityQueue<String> t = new MinMaxPriorityQueueImpl<>();
    t.add("1",1);
    t.add("2",2);
    t.add("3",3);
    t.add("22",2);
    assertEquals("dd","1",t.minPriorityItem());
    assertEquals("dd","2",t.minPriorityItem());
  }


}
