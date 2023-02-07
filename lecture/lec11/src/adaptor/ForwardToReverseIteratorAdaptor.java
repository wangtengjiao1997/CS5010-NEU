package adaptor;

import java.util.Iterator;
import java.util.LinkedList;

public class ForwardToReverseIteratorAdaptor implements ReverseIterator {
    Iterator<Integer> forwardIterator;
    LinkedList<Integer> reversedList;
    Iterator<Integer> it;
    public ForwardToReverseIteratorAdaptor(Iterator<Integer> it) {
        forwardIterator = it;
        // input: 2 -> 3 -> 10
        reversedList = new LinkedList<>();
        while(it.hasNext()) {
            reversedList.addFirst(it.next());
        }
        // reversedList: 10 -> 3 -> 2
        this.it = reversedList.iterator();
    }

    @Override
    public boolean hasPrev() {
        return it.hasNext();
    }

    @Override
    public int prev() {
        return it.next();
    }
}
