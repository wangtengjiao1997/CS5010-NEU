package visitor;

public class Manager extends Person {
    public Manager(int salary) {
        super(salary);
    }

    @Override
    public int accept(PersonVisitor pv) {
        return pv.visit(this);
    }
}
