package visitor;

import visitor.Manager;

public class SalaryAmplifier {
    public int amplifySalary(Engineer e) {
        return 2 * e.getSalary();
    }

    public int amplifySalary(Manager e) {
        return 10 * e.getSalary();
    }
}
