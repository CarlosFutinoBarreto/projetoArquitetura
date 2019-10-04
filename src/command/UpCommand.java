package command;

import gameElements.GameCharacter;
import gui.GamePanel;

public class UpCommand extends Command{

	public UpCommand() {
		setKey(38);
	}
	@Override
	public void execute(GamePanel gp) {
		gp.walk(GameCharacter.UP);
		
	}

}
