package command;

public class MoveCmd implements Command {
    @Override
    public void exec() {
        System.out.println("move");
    }
}
