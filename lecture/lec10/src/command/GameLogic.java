package command;

public class GameLogic {
    public void doSomething(CMDTYPE cmd) {
        switch (cmd) {
            case JUMP:
                System.out.println("jump");
                break;
            case MOVE:
                System.out.println("move");
                break;
            case SHOOT:
                System.out.println("shoot");
                break;
            default:
                System.out.println("wrong cmd");
        }
    }

    public void doSomethingOOD(Command cmd) {
        cmd.exec();
    }

    public static void main(String[] args) {
        Keyboard k = new Keyboard();
        GameLogic gl = new GameLogic();
        gl.doSomethingOOD(k.getCommand(2));
    }
}
