package visitor;

public abstract class Person {
    private int salary;

    public Person(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    abstract public int accept(PersonVisitor pv);

}
