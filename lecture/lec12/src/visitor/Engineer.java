package visitor;

public class Engineer extends Person{
    public Engineer(int salary) {
        super(salary);
    }

    @Override
    public <T> T accept(PersonVisitor<T> pv) {
        return pv.visit(this);
    }
}
