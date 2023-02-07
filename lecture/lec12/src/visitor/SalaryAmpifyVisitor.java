package visitor;

import visitor.Manager;
import visitor.PersonVisitor;

import java.util.List;

public class SalaryAmpifyVisitor implements PersonVisitor<Integer> {
    @Override
    public Integer visit(Engineer e) {
        return 2 * e.getSalary();
    }

    @Override
    public Integer visit(Manager m) {
        // visit myself
        Integer sum = 10 * m.getSalary();

        // visit all of my subordinates
        List<Person> sub = m.getSubordinates();
        for (int i = 0; i < sub.size(); i++) {
            Person p = sub.get(i);
            sum += p.accept(this);
        }

        return sum;
    }
}
