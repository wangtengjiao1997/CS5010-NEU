package command;

public class JumpDecorator implements Command {
    private Command internalCmd;

    public JumpDecorator(Command c) {
        internalCmd = c;
    }

    @Override
    public void exec() {
        internalCmd.exec();
        System.out.println("jump");
    }
}
