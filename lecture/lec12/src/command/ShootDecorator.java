package command;

public class ShootDecorator implements Command {
    private Command internalCmd;

    public ShootDecorator(Command c) {
        internalCmd = c;
    }

    @Override
    public void exec() {
        internalCmd.exec();
        System.out.println("shoot");
    }
}
