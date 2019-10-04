package command;

import gameElements.GameCharacter;
import gui.GamePanel;

public class RightCommand extends Command{

	public RightCommand() {
		setKey(39);
	}
	@Override
	public void execute(GamePanel gp) {
		gp.walk(GameCharacter.RIGHT);
		
	}

}
