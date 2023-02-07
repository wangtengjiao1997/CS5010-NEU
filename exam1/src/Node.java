public class Node<E> {
  E val;
  Node next;


  public Node(E val, Node next) {
    this.val = val;
    this.next = next;
  }

  public Node(E val) {
    this.val = val;
    this.next = null;
  }
}