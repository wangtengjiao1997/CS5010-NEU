package visitor;

public interface PersonVisitor<T> {
    T visit(Engineer e);
    T visit(Manager m);
}
