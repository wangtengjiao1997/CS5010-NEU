package visitor;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Person {
    private List<Person> subordinates = new ArrayList<>();

    public void addSub(Person p) {
        subordinates.add(p);
    }

    public List<Person> getSubordinates() {
        return subordinates;
    }

    public Manager(int salary) {
        super(salary);
    }

    @Override
    public <T> T accept(PersonVisitor<T> pv) {
        return pv.visit(this);
    }
}
