package command;

import gameElements.GameCharacter;
import gui.GamePanel;

public class DownCommand extends Command{

	public DownCommand() {
		setKey(40);
	}
	
	@Override
	public void execute(GamePanel gp) {
		gp.walk(GameCharacter.DOWN);
		
	}

}
