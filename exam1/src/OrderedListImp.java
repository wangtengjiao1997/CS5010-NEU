import java.util.function.Predicate;

public class OrderedListImp<E extends Comparable<E>> implements OrderedList<E> {
  private Node<E> head;

  public OrderedListImp() {
    head = null;
  }

  public OrderedListImp(Node<E> head) {
    this.head = head;
  }

  public Node<E> getHead(){
    Node<E> tp = head;
    return tp;
  }
  @Override
  public void add(E newval) {
    Node<E> tp = head;
    Node<E> newnode = new Node<E>(newval);
    int counter = 0;
    boolean add = false;
    while(tp.next != null) {
      if(tp.val.compareTo(newnode.val)>0){
        newnode.next=tp.next;
        tp.next=newnode;
        add = true;
        break;
      }
      counter++;
      tp = tp.next;
    }
    if (add != true){
      tp.next=newnode;
    }
  }

  @Override
  public E get(int index) {
    if (index >= this.size()) {
      throw new ArrayIndexOutOfBoundsException();
    }
    Node<E> tp = head;
    int counter = 0;
    while(tp != null) {
      if (counter == index) {
        break;
      }
      counter++;
      tp = tp.next;
    }
    return tp.val;
  }

  @Override
  public int size() {
    Node<E> tp = head;
    int counter = 0;
    while(tp != null) {
      counter++;
      tp = tp.next;
    }
    return counter;
  }

  @Override
  public OrderedList<E> subList(Predicate<E> pred) {
    OrderedList newList = new OrderedListImp();
    for (int i = 0; i < this.size(); i++) {
      if (pred.test(this.get(i))) {
        newList.add(this.get(i));
      }
    }
    return newList;
  }
}
