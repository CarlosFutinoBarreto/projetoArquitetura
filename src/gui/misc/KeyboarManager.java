package gui.misc;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import gameElements.GameCharacter;
import gui.GamePanel;

public class KeyboarManager {
	
	private static final int KEY_LEFT=37;
	private static final int KEY_UP=38;
	private static final int KEY_RIGHT=39;
	private static final int KEY_DOWN=40;
	private static final int KEY_SPACE=32;

	public static void setKeys(GamePanel gp) {
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent e) {
		        if (e.getID()==KeyEvent.KEY_PRESSED) {
		        		switch(e.getKeyCode()) {
		        		case KEY_UP:gp.walk(GameCharacter.UP);break;
		        		case KEY_DOWN:gp.walk(GameCharacter.DOWN);break;
		        		case KEY_LEFT:gp.walk(GameCharacter.LEFT);break;
		        		case KEY_RIGHT:gp.walk(GameCharacter.RIGHT);break;
		        		case KEY_SPACE:gp.shoot();break;
		        		}
		        	}
		        return false;
		      }
		});
	}
	
}
