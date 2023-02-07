package visitor;

public class Engineer extends Person{
    public Engineer(int salary) {
        super(salary);
    }

    @Override
    public int accept(PersonVisitor pv) {
        return pv.visit(this);
    }
}
