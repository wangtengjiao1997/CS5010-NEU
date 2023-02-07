package visitor;

public interface PersonVisitor {
    int visit(Engineer e);
    int visit(Manager m);
}
