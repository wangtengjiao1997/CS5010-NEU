package priority;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class MinMaxPriorityQueueImpl<T> implements MinMaxPriorityQueue<T>{
  private TreeMap<Integer, Queue<T>> PriorityTree;

  public MinMaxPriorityQueueImpl(){
    this.PriorityTree = new TreeMap<>();
  }
  @Override
  public void add(T item, int priority) {
    if (PriorityTree.containsKey(priority)){
      this.PriorityTree.get(priority).add(item);
    }else{
      this.PriorityTree.put(priority,new LinkedList<T>());
      this.PriorityTree.get(priority).add(item);
    }
  }

  @Override
  public T minPriorityItem() {
    if (PriorityTree.isEmpty()){
      return null;
    }else{
      T val = PriorityTree.get(PriorityTree.firstKey()).poll();
      if (PriorityTree.get(PriorityTree.firstKey()).isEmpty()){
        PriorityTree.remove((PriorityTree.firstKey()));
      }
      return val;
    }
  }

  @Override
  public T maxPriorityItem() {
    if (PriorityTree.isEmpty()){
      return null;
    }else{
      T val = PriorityTree.get(PriorityTree.lastKey()).poll();
      if (PriorityTree.get(PriorityTree.lastKey()).isEmpty()){
        PriorityTree.remove((PriorityTree.lastKey()));
      }
      return val;
    }
  }
}
