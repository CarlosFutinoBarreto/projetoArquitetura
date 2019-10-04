package command;

import gameElements.GameCharacter;
import gui.GamePanel;

public class LeftCommand extends Command{

	public LeftCommand() {
		setKey(37);
	}
	
	@Override
	public void execute(GamePanel gp) {
		gp.walk(GameCharacter.LEFT);
		
	}

}
