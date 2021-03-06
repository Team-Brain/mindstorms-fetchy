package dk.aau.teambrain.mindstormfetchy.behavior;

import dk.aau.teambrain.mindstormfetchy.State;
import dk.aau.teambrain.mindstormfetchy.robot.BaseRobot;
import dk.aau.teambrain.mindstormfetchy.test.BehaviorChangeListener;

/**
 * CarryToUserBehavior becomes active when robot's state changes to State.WAIT_FOR_COMMAND.
 * <p>
 * The robot stays at the starting position until a new command arrives.
 */
public class WaitForCommandBehavior extends BaseBehavior {

    public static final String TAG = "WaitForCommand";

    public WaitForCommandBehavior(BaseRobot robot) {
        super(robot);
    }

    public WaitForCommandBehavior(BaseRobot robot, BehaviorChangeListener listener) {
        super(robot, listener);
    }

    @Override
    protected String getTag() {
        return TAG;
    }

    @Override
    public boolean takeControl() {
        return robot.getCurrentState() == State.WAITING_FOR_COMMAND;
    }

    @Override
    public void action() {
        super.action();

        while (!robot.hasTask()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
