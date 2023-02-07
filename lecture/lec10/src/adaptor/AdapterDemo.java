package adaptor;
import java.util.ArrayList;
import java.util.List;

public class AdapterDemo {
    public static int sum(ReverseIterator reverseIterator) {
        int sum = 0;
        while(reverseIterator.hasPrev()) {
            sum += reverseIterator.prev();
        }
        return sum;
    }

    public static void main(String[] args) {
        // I have existing iterator
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(20);
        // There is an existing function (i.e. sum) I want to call,
        // but it takes a reverse iterator
        //System.out.println(sum(list.iterator()));
        System.out.println(sum(
                new ForwardToReverseIteratorAdaptor(list.iterator())));
    }
}
