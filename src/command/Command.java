package command;

import gui.GamePanel;

public abstract class Command {

	private int key;
	
	
	public int getKey() {
		return key;
	}


	public void setKey(int key) {
		this.key = key;
	}


	public void execute(GamePanel gp) {
		
	}
}
