package command;

import gui.GamePanel;

public class ShootCommand extends Command{

	public ShootCommand() {
		setKey(32);
	}
	@Override
	public void execute(GamePanel gp) {
		gp.shoot();
		
	}

}
