package visitor;

import visitor.Manager;
import visitor.PersonVisitor;

public class SalaryAmpifyVisitor implements PersonVisitor {
    @Override
    public int visit(Engineer e) {
        return 2 * e.getSalary();
    }

    @Override
    public int visit(Manager m) {
        return 10 * m.getSalary();
    }
}
