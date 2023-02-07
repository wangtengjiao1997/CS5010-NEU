package command;

public class Keyboard {
    /*
    public command.CMDTYPE getCommand(int keyCode) {
        if (keyCode == 1) {
            return command.CMDTYPE.MOVE;
        } else if (keyCode == 2) {
            return command.CMDTYPE.SHOOT;
        } else {
            return command.CMDTYPE.JUMP;
        }
    }

     */
    public Command getCommand(int keyCode) {
        if (keyCode == 1) {
            return new MoveCmd();
        } else if (keyCode == 2) {
            return new ShootCmd();
        } else {
            return new JumpCmd();
        }
    }
}
