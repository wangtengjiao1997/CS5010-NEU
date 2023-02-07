package command;

public class JumpShootCmd implements Command {
    @Override
    public void exec() {
        JumpCmd jcmd = new JumpCmd();
        ShootCmd scmd = new ShootCmd();
        jcmd.exec();
        scmd.exec();
    }
}
